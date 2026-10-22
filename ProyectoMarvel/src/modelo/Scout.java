
package modelo;


public class Scout extends PiezaMovil{
   
public Scout(String nombre, Bando bando, String imagen) {
      super( nombre , 3 , bando , imagen) ;
    }

@Override
  public ResultadoCombate atacar(Pieza defensor) {
      // si el defensor es una Bomba → GANA
      if( defensor instanceof Bomba) {
          return ResultadoCombate.GANA ;
      }
      else {
          return super.atacar(defensor) ;
      }
  }
}
