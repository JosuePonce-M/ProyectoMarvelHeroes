
package modelo;

public class Mistica extends PiezaMovil {
  public Mistica(String nombre, Bando bando, String imagen) {
       super( nombre , 2 , bando , imagen  ) ;
    }  
  @Override
  public boolean puedeMoverVariasCasillas() {
      return true ;
  }
}
