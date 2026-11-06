package logica;

import modelo.*;
import java.util.ArrayList;
import excepciones.MovimientoInvalidoException;
import interfaces.Atacante;

public class Partida {
    // atributos

    private Tablero tablero;
    private Bando turno;
    private ArrayList<Pieza> eliminadosHeroes = new ArrayList<>();
    private ArrayList<Pieza> eliminadosVillanos = new ArrayList<>();
    private Pieza ultimoAtacante;
    private Pieza ultimoDefensor;
    private Bando ganador = null;
    private Jugador jugadorHeroes;
    private Jugador jugadorVillanos;
    private ControlUsuarios control;
    
    public Bando getGanador() {
        return ganador;
    }

 
  public Partida(Tablero tablero, Jugador jugadorHeroes, Jugador jugadorVillanos, ControlUsuarios control) {
    this.tablero = tablero;
    this.jugadorHeroes = jugadorHeroes;
    this.jugadorVillanos = jugadorVillanos;
    this.control = control;
    turno = Bando.Heroes;
}

    public Tablero getTablero() {
        return tablero;
    }

    public Bando getTurno() {
        return turno;
    }
    
    private Jugador getJugador(Bando bando) {
    if (bando == Bando.Heroes) {
        return jugadorHeroes;
    }
    return jugadorVillanos;
  }
    private Bando contrario(Bando bando) {
    if (bando == Bando.Heroes) {
        return Bando.Villanos;
    }
    return Bando.Heroes;
  }
    private String nombreBando(Bando bando) {
    if (bando == Bando.Heroes) {
        return "HÉROES";
    }
    return "VILLANOS";
}

    public void cambiarTurno() {
        //  si el turno es Héroes, pasa a Villanos; si no, pasa a Héroes
        if (turno == Bando.Heroes) {
            turno = Bando.Villanos;
        } else {
            turno = Bando.Heroes;
        }
    }

    // metodo para mover la pieza
    public void moverPieza(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino)
            throws MovimientoInvalidoException {

        Pieza pieza = tablero.getPieza(filaOrigen, columnaOrigen);
        ultimoAtacante = null;
        ultimoDefensor = null;

        // si el destino es zona prohibida
        if (tablero.esZonaProhibida(filaDestino, columnaDestino) == true) {
            throw new MovimientoInvalidoException("No podés moverte a una zona prohibida");
        }
        int distancia = Math.abs(filaDestino - filaOrigen) + Math.abs(columnaDestino - columnaOrigen);
        //  si distancia no es 1
        if (distancia != 1) {
            PiezaMovil movil = (PiezaMovil) pieza;

            if (movil.puedeMoverVariasCasillas() == false) {
                throw new MovimientoInvalidoException("Solo podés moverte una casilla");
            }
            if (filaOrigen != filaDestino && columnaOrigen != columnaDestino) {
                throw new MovimientoInvalidoException("La Mística solo se mueve en línea recta");
            }

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

            pieza.setRevelada(true);
             ultimoAtacante = pieza;
        }

        // si el destino está vacío se puede mover
        if (tablero.estaVacia(filaDestino, columnaDestino) == true) {
            tablero.quitarPieza(filaOrigen, columnaOrigen);
            tablero.colocarPieza(pieza, filaDestino, columnaDestino);
        } else {
            Pieza defensor = tablero.getPieza(filaDestino, columnaDestino);

            //  si defensor es del mismo bando que pieza 
            if (defensor.getBando() == pieza.getBando()) {
                throw new MovimientoInvalidoException("Ahí ya tenés una ficha tuya");
            }

            Atacante atacante = (Atacante) pieza;    
            ResultadoCombate resultado = atacante.atacar(defensor);

            //  revelá las dos (
            pieza.setRevelada(true);
            defensor.setRevelada(true);
            ultimoAtacante = pieza;
            ultimoDefensor = defensor;

            // resultado combate
            //   GANA
            if (resultado == ResultadoCombate.GANA) {
                eliminar(defensor);
                tablero.quitarPieza(filaOrigen, columnaOrigen);
                tablero.colocarPieza(pieza, filaDestino, columnaDestino);
                if (defensor instanceof Tierra) {
            finalizar(pieza.getBando(), TipoVictoria.TIERRA);
            }
            } //   PIERDE
            else if (resultado == ResultadoCombate.PIERDE) {
                eliminar(pieza);
                tablero.quitarPieza(filaOrigen, columnaOrigen);
            } //   EMPATE 
            else {
                eliminar(defensor);
                eliminar(pieza);
                tablero.quitarPieza(filaOrigen, columnaOrigen);
                tablero.quitarPieza(filaDestino, columnaDestino);
            }

        }

        // cambiá el turno
        cambiarTurno();

       if (ganador == null && tieneMovimientos(turno, 0) == false) {
    finalizar(contrario(turno), TipoVictoria.SIN_MOVIMIENTOS);
}

    }

    // metodo que elimina las piezas
    private void eliminar(Pieza p) {

        if (p.getBando() == Bando.Heroes) {

            eliminadosHeroes.add(p);
        } else {
            eliminadosVillanos.add(p);
        }
    }

    public ArrayList<Pieza> getEliminadosHeroes() {
        return eliminadosHeroes;
    }

    public ArrayList<Pieza> getEliminadosVillanos() {
        return eliminadosVillanos;
    }

    // para verificar sio hubo combate
    public boolean huboCombate() {

        if (ultimoAtacante != null) {
            return true;
        } else {
            return false;
        }
    }

    public void ocultarCombate() {
        //  se muestra ultimo actacante y ultimo defensor
       ultimoAtacante.setRevelada(false);
    if (ultimoDefensor != null) {
        ultimoDefensor.setRevelada(false);
    }
}
    // metodo revisa si es un destion es valido

    private boolean casillaDisponible(int fila, int columna, Bando bando) {
        if (fila < 0 || fila > 9 || columna < 0 || columna > 9) {
            return false;                          // fuera del tablero
        }
        if (tablero.esZonaProhibida(fila, columna) == true) {
            return false;
        }
        if (tablero.estaVacia(fila, columna) == true) {
            return true;                           // vacía , se puede mover
        }
        if (tablero.getPieza(fila, columna).getBando() == bando) {
            return false;                          // ficha propia 
        }
        return true;                               // ficha rival 
    }
// metodo que revisa si esa ficha tiene un lugar donde moverse

    private boolean puedeMoverDesde(int fila, int columna, Bando bando) {
        if (casillaDisponible(fila - 1, columna, bando) == true) {
            return true;   // arriba
        }
        if (casillaDisponible(fila + 1, columna, bando) == true) {
            return true;   // abajo
        }
        if (casillaDisponible(fila, columna - 1, bando) == true) {
            return true;   // izquierda
        }
        if (casillaDisponible(fila, columna + 1, bando) == true) {
            return true;   // derecha
        }
        return false;
    }

    public boolean tieneMovimientos(Bando bando, int posicion) {
        //  (caso base)
        if (posicion == 100) {
            return false;
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
    // metodo recursivo mistica

    private boolean caminoLibre(int fila, int columna, int filaDestino, int columnaDestino, int pasoFila, int pasoColumna) {
        int siguienteFila = fila + pasoFila;
        int siguienteColumna = columna + pasoColumna;

        // Caso base 
        if (siguienteFila == filaDestino && siguienteColumna == columnaDestino) {
            return true;
        }

        // caso base 2
        if (tablero.esZonaProhibida(siguienteFila, siguienteColumna) == true || tablero.estaVacia(siguienteFila, siguienteColumna) == false) {
            return false;
        }

        return caminoLibre(siguienteFila, siguienteColumna, filaDestino, columnaDestino, pasoFila, pasoColumna);
    }
    public void finalizar(Bando bandoGanador, TipoVictoria tipo) {
    ganador = bandoGanador;
    Bando bandoPerdedor = contrario(bandoGanador);
    Jugador vencedor = getJugador(bandoGanador);
    Jugador perdedor = getJugador(bandoPerdedor);

    //  PUNTOS
    
     vencedor.setPuntos(vencedor.getPuntos()+3);

    //  CONTADORES DE PARTIDAS POR BANDO
     
   
  jugadorHeroes.setPartidasHeroes(jugadorHeroes.getPartidasHeroes() + 1);   
  jugadorVillanos.setPartidasVillanos(jugadorVillanos.getPartidasVillanos() + 1);   
    
   // log
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
    // HISTORIAL GLOBAL 
    control.registrarPartida(bandoGanador);
    
}
    public void retirar() {
     finalizar(contrario(turno), TipoVictoria.RETIRO) ;
        
    
}
    public Jugador getJugadorEnTurno() {
    return getJugador(turno);
}
    
}
