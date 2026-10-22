
package modelo;

public class Agente extends PiezaMovil {
    public Agente(String nombre, Bando bando, String imagen) {
      super( nombre , 1 , bando , imagen) ;
    }

@Override
  public ResultadoCombate atacar(Pieza defensor) {
      
      if( defensor.getRango()==10) {
          return ResultadoCombate.GANA ;
      }
      else {
          return super.atacar(defensor) ;
      }
  }
}
