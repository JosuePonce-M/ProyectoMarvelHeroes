
package modelo;


public class Tierra extends Pieza {
    
  public Tierra (Bando bando , String imagen) {
      
        super("Tierra" , 0 , bando , imagen) ;
        
    }
  @Override
    public boolean puedeMoverse () {
        return false ;
    }  
}
