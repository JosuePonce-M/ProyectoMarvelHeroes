
package modelo;


public abstract class Pieza {
   // atributos
    protected String nombre;
    protected int rango;
    protected Bando bando;
    protected boolean revelada;
    protected String Imagen;
    
     public Pieza(String nombre , int rango , Bando bando , String Imagen) {
     this.bando = bando ;
     this.rango = rango ;
     this.nombre = nombre ;
     this.Imagen = Imagen ;
     revelada = false ;
     
     }
     // metodo abstrato
     public abstract boolean puedeMoverse() ;

    public String getNombre() {
        return nombre;
    }

    public int getRango() {
        return rango;
    }

    public Bando getBando() {
        return bando;
    }

    public boolean isRevelada() {
        return revelada;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setRevelada(boolean revelada) {
        this.revelada = revelada;
    }

     
}
 