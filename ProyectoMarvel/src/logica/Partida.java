package logica;
 
import excepciones.MovimientoInvalidoException;
import interfaces.Atacante;
import java.util.ArrayList;
import modelo.*;
 
/**
 * Maneja las reglas de una partida: turnos, movimientos, combates,
 * fichas eliminadas y el fin del juego (puntos, contadores y logs).
 * 
 */
public class Partida {
 
    //  ATRIBUTOS 
    private Tablero tablero;
    private Bando turno;
    private Bando ganador = null;                  
 
    private Jugador jugadorHeroes;
    private Jugador jugadorVillanos;
    private ControlUsuarios control;
 
    private ArrayList<Pieza> eliminadosHeroes = new ArrayList<>();
    private ArrayList<Pieza> eliminadosVillanos = new ArrayList<>();
 
    private Pieza ultimoAtacante;                 
    private Pieza ultimoDefensor;                 
 
    // CONSTRUCTOR 
    public Partida(Tablero tablero, Jugador jugadorHeroes, Jugador jugadorVillanos, ControlUsuarios control) {
        this.tablero = tablero;
        this.jugadorHeroes = jugadorHeroes;
        this.jugadorVillanos = jugadorVillanos;
        this.control = control;
        turno = Bando.Heroes;                      
    }
 
    // TURNOS 
 
   
    public void cambiarTurno() {
        if (turno == Bando.Heroes) {
            turno = Bando.Villanos;
        } else {
            turno = Bando.Heroes;
        }
    }
 
    //  MOVIMIENTO Y COMBATE
 
    // Mueve una ficha o ataca.
    public void moverPieza(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino)
            throws MovimientoInvalidoException {
 
        Pieza pieza = tablero.getPieza(filaOrigen, columnaOrigen);
        ultimoAtacante = null;
        ultimoDefensor = null;
 
        //  No se puede ir a una zona prohibida
        if (tablero.esZonaProhibida(filaDestino, columnaDestino) == true) {
            throw new MovimientoInvalidoException("No podés moverte a una zona prohibida");
        }
 
        //  Distancia: solo 1 casilla, excepto la Mística
        int distancia = Math.abs(filaDestino - filaOrigen) + Math.abs(columnaDestino - columnaOrigen);
        if (distancia != 1) {
            PiezaMovil movil = (PiezaMovil) pieza;
 
            
            if (movil.puedeMoverVariasCasillas() == false) {
                throw new MovimientoInvalidoException("Solo podés moverte una casilla");
            }
            if (filaOrigen != filaDestino && columnaOrigen != columnaDestino) {
                throw new MovimientoInvalidoException("La Mística solo se mueve en línea recta");
            }
 
            // Dirección del movimiento
            int pasoFila = 0;
            int pasoColumna = 0;
            if (filaDestino > filaOrigen) {
                pasoFila = 1;
            }
            if (filaDestino < filaOrigen) {
                pasoFila = -1;
            }
            if (columnaDestino > columnaOrigen) {
                pasoColumna = 1;
            }
            if (columnaDestino < columnaOrigen) {
                pasoColumna = -1;
            }
 
            if (caminoLibre(filaOrigen, columnaOrigen, filaDestino, columnaDestino, pasoFila, pasoColumna) == false) {
                throw new MovimientoInvalidoException("El camino no está libre");
            }
 
            // La Mística se revela un momento al moverse varias casillas
            pieza.setRevelada(true);
            ultimoAtacante = pieza;
        }
 
        // Casilla vacía: solo se mueve
        if (tablero.estaVacia(filaDestino, columnaDestino) == true) {
            tablero.quitarPieza(filaOrigen, columnaOrigen);
            tablero.colocarPieza(pieza, filaDestino, columnaDestino);
        } else {
            //  Casilla ocupada: combate
            Pieza defensor = tablero.getPieza(filaDestino, columnaDestino);
 
            if (defensor.getBando() == pieza.getBando()) {
                throw new MovimientoInvalidoException("Ahí ya tenés una ficha tuya");
            }
 
            
          
            Atacante atacante = (Atacante) pieza;
            ResultadoCombate resultado = atacante.atacar(defensor);
 
            // Las dos fichas se revelan un momento
            pieza.setRevelada(true);
            defensor.setRevelada(true);
            ultimoAtacante = pieza;
            ultimoDefensor = defensor;
               // Gana
            if (resultado == ResultadoCombate.GANA) {
                eliminar(defensor);
                tablero.quitarPieza(filaOrigen, columnaOrigen);
                tablero.colocarPieza(pieza, filaDestino, columnaDestino);
                if (defensor instanceof Tierra) {
                    finalizar(pieza.getBando(), TipoVictoria.TIERRA);
                }
                // Pierde
            } else if (resultado == ResultadoCombate.PIERDE) {
                eliminar(pieza);
                tablero.quitarPieza(filaOrigen, columnaOrigen);
                // Empate
            } else {                              
                eliminar(defensor);
                eliminar(pieza);
                tablero.quitarPieza(filaOrigen, columnaOrigen);
                tablero.quitarPieza(filaDestino, columnaDestino);
            }
        }
 
       
        cambiarTurno();
 
        // sin movimientos
        if (ganador == null && tieneMovimientos(turno, 0) == false) {
            finalizar(contrario(turno), TipoVictoria.SIN_MOVIMIENTOS);
        }
        // si no tiene mas ficbas movibles
        else if (ganador == null && tieneMovimientos(contrario(turno), 0) == false) {
            finalizar(turno, TipoVictoria.SIN_MOVIMIENTOS);
        }
    }
 
    // lisra de elimnados
    private void eliminar(Pieza p) {
        if (p.getBando() == Bando.Heroes) {
            eliminadosHeroes.add(p);
        } else {
            eliminadosVillanos.add(p);
        }
    }
 
    // Indica si en el último movimiento se reveló alguna ficha (combate o Mística).
    public boolean huboCombate() {
        if (ultimoAtacante != null) {
            return true;
        } else {
            return false;
        }
    }
 
    // Vuelve a tapar las fichas que se revelaron en el último movimiento.
    public void ocultarCombate() {
        ultimoAtacante.setRevelada(false);
        if (ultimoDefensor != null) {
            ultimoDefensor.setRevelada(false);
        }
    }
 
   
 
    // Metodo Recu
    
    private boolean caminoLibre(int fila, int columna, int filaDestino, int columnaDestino, int pasoFila, int pasoColumna) {
        int siguienteFila = fila + pasoFila;
        int siguienteColumna = columna + pasoColumna;
 
        if (siguienteFila == filaDestino && siguienteColumna == columnaDestino) {
            return true;  // Caso base 1
        }
        if (tablero.esZonaProhibida(siguienteFila, siguienteColumna) == true
                || tablero.estaVacia(siguienteFila, siguienteColumna) == false) {
            return false; // caso base 2
        }
        return caminoLibre(siguienteFila, siguienteColumna, filaDestino, columnaDestino, pasoFila, pasoColumna);
    }
 
    //  metodo recu 
    
    
    public boolean tieneMovimientos(Bando bando, int posicion) {
        if (posicion == 100) {
            return false;   // Caso base: 
        }
 
        int fila = posicion / 10;
        int columna = posicion % 10;
        Pieza p = tablero.getPieza(fila, columna);
 
        if (p != null && p.getBando() == bando && p.puedeMoverse() == true
                && puedeMoverDesde(fila, columna, bando) == true) {
            return true;
        }
        return tieneMovimientos(bando, posicion + 1);
    }
 
    // Revisa si alguna de las 4 casillas vecinas  está disponible.
    private boolean puedeMoverDesde(int fila, int columna, Bando bando) {
        if (casillaDisponible(fila - 1, columna, bando) == true) {
            return true;
        }
        if (casillaDisponible(fila + 1, columna, bando) == true) {
            return true;
        }
        if (casillaDisponible(fila, columna - 1, bando) == true) {
            return true;
        }
        if (casillaDisponible(fila, columna + 1, bando) == true) {
            return true;
        }
        return false;
    }
 
    // Una casilla está disponible si está dentro del tablero, no es prohibida
    // y está vacía o tiene una ficha rival.
    private boolean casillaDisponible(int fila, int columna, Bando bando) {
        if (fila < 0 || fila > 9 || columna < 0 || columna > 9) {
            return false;                         
        }
        if (tablero.esZonaProhibida(fila, columna) == true) {
            return false;
        }
        if (tablero.estaVacia(fila, columna) == true) {
            return true;                         
        }
        if (tablero.getPieza(fila, columna).getBando() == bando) {
            return false;                         
        }
        return true;                              
    }
 
    //  FIN DE PARTIDA 
 
    // Termina la partida: suma puntos, cuenta partidas por bando, guarda el log y el historial.
    public void finalizar(Bando bandoGanador, TipoVictoria tipo) {
        ganador = bandoGanador;
        Bando bandoPerdedor = contrario(bandoGanador);
        Jugador vencedor = getJugador(bandoGanador);
        Jugador perdedor = getJugador(bandoPerdedor);
 
        // Puntos
        vencedor.setPuntos(vencedor.getPuntos() + 3);
 
        // Contadores de partidas por bando
        jugadorHeroes.setPartidasHeroes(jugadorHeroes.getPartidasHeroes() + 1);
        jugadorVillanos.setPartidasVillanos(jugadorVillanos.getPartidasVillanos() + 1);
 
        
        String fecha = java.time.LocalDate.now().toString();
        String log;
        if (tipo == TipoVictoria.TIERRA) {
            String accion = "CAPTURADO";
            if (bandoGanador == Bando.Heroes) {
                accion = "SALVADO";
            }
            log = vencedor.getUsername() + " usando " + nombreBando(bandoGanador) + " ha " + accion
                    + " la TIERRA! Venciendo a " + perdedor.getUsername() + " — " + fecha;
        } else if (tipo == TipoVictoria.SIN_MOVIMIENTOS) {
            log = perdedor.getUsername() + " usando " + nombreBando(bandoPerdedor)
                    + " ha perdido por no tener movimientos válidos disponibles ante "
                    + vencedor.getUsername() + " — " + fecha;
        } else {
            log = vencedor.getUsername() + " usando " + nombreBando(bandoGanador) + " ha ganado ya que "
                    + perdedor.getUsername() + " usando " + nombreBando(bandoPerdedor)
                    + " se ha retirado del juego — " + fecha;
        }
 
        vencedor.agregarLog(log);
        perdedor.agregarLog(log);
 
        
        control.registrarPartida(bandoGanador);
    }
 
    
    public void retirar() {
        finalizar(contrario(turno), TipoVictoria.RETIRO);
    }
 
    //  MÉTODOS
 
    // Devuelve el jugador que usa ese bando.
    private Jugador getJugador(Bando bando) {
        if (bando == Bando.Heroes) {
            return jugadorHeroes;
        }
        return jugadorVillanos;
    }
 
    // Devuelve el bando contrario.
    private Bando contrario(Bando bando) {
        if (bando == Bando.Heroes) {
            return Bando.Villanos;
        }
        return Bando.Heroes;
    }
 
    // Nombre del bando en mayúsculas para los logs.
    private String nombreBando(Bando bando) {
        if (bando == Bando.Heroes) {
            return "HÉROES";
        }
        return "VILLANOS";
    }
 
    // GETTERS 
    public Tablero getTablero() {
        return tablero;
    }
 
    public Bando getTurno() {
        return turno;
    }
 
    public Bando getGanador() {
        return ganador;
    }
 
    public Jugador getJugadorEnTurno() {
        return getJugador(turno);
    }
 
    public ArrayList<Pieza> getEliminadosHeroes() {
        return eliminadosHeroes;
    }
 
    public ArrayList<Pieza> getEliminadosVillanos() {
        return eliminadosVillanos;
    }
}
 