
package modelo;


public class Bomba extends Pieza {
    public Bomba(Bando bando , String imagen) {
        super("Bomba" , 0 , bando , imagen) ;
        
    }
    @Override
    public boolean puedeMoverse () {
        return false ;
    }
}
