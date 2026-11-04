
package modelo;
import interfaces.Atacante;

public class PiezaMovil extends Pieza implements Atacante {
  public PiezaMovil(String nombre , int rango , Bando bando , String imagen){
     super (nombre , rango , bando , imagen) ;
    } 
  @Override
  public boolean puedeMoverse () {
    return true ;  
  }
  public boolean puedeMoverVariasCasillas () {
      return false ;
  }
  @Override
  public ResultadoCombate atacar(Pieza defensor) {
      // caso #1 si ataca una bomba , pierde
      if(defensor instanceof Bomba) {
          return ResultadoCombate.PIERDE ;
      }
      // caso 2 : si actaca la tierra , gana
      if (defensor instanceof Tierra) {
          return ResultadoCombate.GANA ;
      }
      // caso 3 : comparar rangos
      if( getRango() > defensor.getRango()) {
          return ResultadoCombate.GANA ;
      }
      else if ( getRango() < defensor.getRango() ) {
          return ResultadoCombate.PIERDE ;
      }
      else {
          return ResultadoCombate.EMPATE ;
      }
  }
}
