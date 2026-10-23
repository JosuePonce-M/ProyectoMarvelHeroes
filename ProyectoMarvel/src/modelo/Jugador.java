
package modelo;
import java.util.ArrayList ;

public class Jugador {
    // atributos
    private String username ;
    private String  contrasena ;
    private int puntos = 0 ;
    private int PartidasHeroes  = 0;
    private int PartidasVillanos  = 0;
     private ArrayList <String> log = new ArrayList <> () ;
  public Jugador ( String username , String contrasena ) {
     this.username = username ; 
     this.contrasena = contrasena ;
     
  }

    public String getUsername() {
        return username;
    }

  

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String  contrasena) {
        this.contrasena = contrasena;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidasHeroes() {
        return PartidasHeroes;
    }

    public void setPartidasHeroes(int PartidasHeroes) {
        this.PartidasHeroes = PartidasHeroes;
    }

    public int getPartidasVillanos() {
        return PartidasVillanos;
    }

    public void setPartidasVillanos(int PartidasVillanos) {
        this.PartidasVillanos = PartidasVillanos;
    }

    public ArrayList<String> getLog() {
        return log;
    }
    public void agregarLog(String texto) {
        log.add(0, texto) ;
    }
}

 
