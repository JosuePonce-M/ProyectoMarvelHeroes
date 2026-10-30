
package logica;

import modelo.*;
import java.util.ArrayList ;
import excepciones.MovimientoInvalidoException;



public class Partida {
  // atributos
    private Tablero tablero ;
    private Bando turno ;
    private ArrayList<Pieza> eliminadosHeroes = new ArrayList<>();
    private ArrayList<Pieza> eliminadosVillanos = new ArrayList<>();
    private Pieza ultimoAtacante;
    private Pieza ultimoDefensor;

    public Partida(Tablero tablero) {
        
        
        this.tablero = tablero ;
      
        turno = Bando.Heroes ;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Bando getTurno() {
        return turno;
    }

  
    public void cambiarTurno() {
        //  si el turno es Héroes, pasa a Villanos; si no, pasa a Héroes
        if( turno == Bando.Heroes) {
           turno = Bando.Villanos ;
        }
        else {
            turno = Bando.Heroes ;
        }
    }
    public void moverPieza(int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino)
        throws MovimientoInvalidoException {

    Pieza pieza = tablero.getPieza(filaOrigen, columnaOrigen);
    ultimoAtacante = null ;
    ultimoDefensor = null ;
    
    // si el destino es zona prohibida
    
        if(  tablero.esZonaProhibida(filaDestino, columnaDestino) == true) {
        throw new MovimientoInvalidoException("No podés moverte a una zona prohibida");
    }
     int distancia = Math.abs(filaDestino - filaOrigen) + Math.abs(columnaDestino - columnaOrigen);
    //  si distancia no es 1
    if(distancia !=1) {
          throw new MovimientoInvalidoException("Solo podés moverte una casilla");
        
    }
 
          // si el destino está vacío → solo mover
        if (tablero.estaVacia(filaDestino, columnaDestino) == true) {
        tablero.quitarPieza(filaOrigen, columnaOrigen);
         tablero.colocarPieza(pieza, filaDestino, columnaDestino);
      }
      else {
        Pieza defensor = tablero.getPieza(filaDestino, columnaDestino);

        //  si defensor es del mismo bando que pieza 
       
        if(defensor.getBando() == pieza.getBando()) {
          throw new MovimientoInvalidoException("Ahí ya tenés una ficha tuya");
        }

        PiezaMovil atacante = (PiezaMovil) pieza;
        ResultadoCombate resultado = atacante.atacar(defensor);

        //  revelá las dos (
        atacante.setRevelada(true) ;
        defensor.setRevelada(true);
        ultimoAtacante = pieza ;
         ultimoDefensor = defensor ;
                
        // resultado combate
          //   GANA
        if (resultado == ResultadoCombate.GANA) {
         eliminar(defensor) ; tablero.quitarPieza(filaOrigen, columnaOrigen);
        tablero.colocarPieza(pieza, filaDestino, columnaDestino); 
        }
         //   PIERDE
        else if ( resultado == ResultadoCombate.PIERDE) {
           eliminar(pieza)  ; tablero.quitarPieza(filaOrigen, columnaOrigen);
        }
         //   EMPATE 
        else {
            eliminar(defensor) ; 
            eliminar(atacante) ; 
            tablero.quitarPieza(filaOrigen, columnaOrigen);  
            tablero.quitarPieza(filaDestino, columnaDestino);  
        }
     
      }
  
    // cambiá el turno
    cambiarTurno () ;
    
}
    // metodo que elimina las piezas
    private void eliminar(Pieza p) {
  
  if(p.getBando() == Bando.Heroes) {
      
      eliminadosHeroes.add(p) ;   
  }
  else {
       eliminadosVillanos.add(p) ;
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
   
     if(ultimoAtacante != null) {
         return true ;
     }
     else {
         return false ;
     }
}

public void ocultarCombate() {
    // TODO: setRevelada(false) a ultimoAtacante y a ultimoDefensor
    ultimoAtacante.setRevelada(false);
     ultimoDefensor.setRevelada(false);
    }
    
}

    
