
package logica;

import modelo.*;
import java.util.ArrayList;
import java.util.Random ;
public class Tablero {
    
private Random r = new Random(); 
  private Pieza [][] casillas ;
  public Tablero () {
      casillas = new Pieza[10][10] ;
  }
  public Pieza getPieza(int fila , int columna) {
      return casillas[fila][columna] ;
  }
  public void colocarPieza(Pieza pieza , int fila , int columna) {
    casillas[fila][columna] = pieza;
  
}
public void quitarPieza(int fila , int columna) {
  casillas[fila][columna] = null ;
}
public boolean estaVacia(int fila , int columna) {
  if(casillas[fila][columna]== null) {
      return true ;
  }
  return false ;
}
public boolean esZonaProhibida (int fila , int columna) {
   if ( fila ==4 || fila == 5  )  { 
   if( columna == 2  || columna == 3 || columna == 6  || columna == 7) {
         return true ;  
       }
     
   }
 return false ;
}
  // metodo para crear los personajes
  public ArrayList<Pieza> crearPiezasHeroes() {  
     ArrayList<Pieza> lista = new ArrayList<>();  
    Bando b = Bando.Heroes;  
    // Rango 10 al 4 (PiezaMovil) Heroes
     lista.add(new PiezaMovil("Mr. Fantastic", 10, b, "mrfantastic.png"));
    lista.add(new PiezaMovil("Captain America", 9, b, "captainamerica.png"));
    lista.add(new PiezaMovil("Professor X", 8, b, "professorx.png"));
    lista.add(new PiezaMovil("Nick Fury", 8, b, "nickfury.png"));
     lista.add(new PiezaMovil("Spider-Man", 7, b, "spiderman.png"));
    lista.add(new PiezaMovil("Wolverine", 7, b, "wolverine.png"));
    lista.add(new PiezaMovil("Namor", 7, b, "namor.png"));
    lista.add(new PiezaMovil("Daredevil", 6, b, "daredevil.png"));
    lista.add(new PiezaMovil("Silver Surfer", 6, b, "silversurfer.png"));
    lista.add(new PiezaMovil("Hulk", 6, b, "hulk.png"));
    lista.add(new PiezaMovil("Iron Man", 6, b, "ironman.png"));
    lista.add(new PiezaMovil("Thor", 5, b, "thor.png"));
    lista.add(new PiezaMovil("Human Torch", 5, b, "humantorch.png"));
    lista.add(new PiezaMovil("Cyclops", 5, b, "cyclops.png"));
    lista.add(new PiezaMovil("Invisible Woman", 5, b, "invisiblewoman.png"));
    lista.add(new PiezaMovil("Ghost Rider", 4, b, "ghostrider.png"));
    lista.add(new PiezaMovil("Punisher", 4, b, "punisher.png"));
    lista.add(new PiezaMovil("Blade", 4, b, "blade.png"));
    lista.add(new PiezaMovil("Thing", 4, b, "thing.png"));
    
    // Rango 3 (Scout)
    lista.add(new Scout("Emma Frost", b, "emmafrost.png"));
    lista.add(new Scout("She-Hulk", b, "shehulk.png"));
    lista.add(new Scout("Giant Man", b, "giantman.png"));
    lista.add(new Scout("Beast", b, "beast.png"));
    lista.add(new Scout("Colossus", b, "colossus.png"));
    
    // Rango 2 (Mistica)
    lista.add(new Mistica("Gambit", b, "gambit.png"));
    lista.add(new Mistica("Spider-Girl", b, "spidergirl.png"));
    lista.add(new Mistica("Ice Man", b, "iceman.png"));
    lista.add(new Mistica("Storm", b, "storm.png"));
    lista.add(new Mistica("Phoenix", b, "phoenix.png"));
    lista.add(new Mistica("Dr. Strange", b, "drstrange.png"));
    lista.add(new Mistica("Elektra", b, "elektra.png"));
    lista.add(new Mistica("Nightcrawler", b, "nightcrawler.png"));
    
    
         // Rango 1 (Agente)
    lista.add(new Agente("Black Widow", b, "blackwidow.png"));

    // 6 bombas
    for (int i = 0; i < 6; i++) {
        lista.add(new Bomba(b, "novablast.png"));
    }

    // Tierra
    lista.add(new Tierra(b, "tierra_heroes.png"));

    return lista;
}
  public ArrayList<Pieza> crearPiezasVillanos() {
    ArrayList<Pieza> lista = new ArrayList<>();
    Bando b = Bando.Villanos;

    // Rango 10 al 4 (PiezaMovil)
    lista.add(new PiezaMovil("Dr. Doom", 10, b, "drdoom.png"));
    lista.add(new PiezaMovil("Galactus", 9, b, "galactus.png"));
    lista.add(new PiezaMovil("Kingpin", 8, b, "kingpin.png"));
    lista.add(new PiezaMovil("Magneto", 8, b, "magneto.png"));
    lista.add(new PiezaMovil("Apocalypse", 7, b, "apocalypse.png"));
    lista.add(new PiezaMovil("Green Goblin", 7, b, "greengoblin.png"));
    lista.add(new PiezaMovil("Venom", 7, b, "venom.png"));
    lista.add(new PiezaMovil("Bullseye", 6, b, "bullseye.png"));
    lista.add(new PiezaMovil("Omega Red", 6, b, "omegared.png"));
    lista.add(new PiezaMovil("Onslaught", 6, b, "onslaught.png"));
    lista.add(new PiezaMovil("Red Skull", 6, b, "redskull.png"));
    lista.add(new PiezaMovil("Mystique", 5, b, "mystique.png"));
    lista.add(new PiezaMovil("Mysterio", 5, b, "mysterio.png"));
    lista.add(new PiezaMovil("Dr. Octopus", 5, b, "droctopus.png"));
    lista.add(new PiezaMovil("Deadpool", 5, b, "deadpool.png"));
    lista.add(new PiezaMovil("Abomination", 4, b, "abomination.png"));
    lista.add(new PiezaMovil("Thanos", 4, b, "thanos.png"));
    lista.add(new PiezaMovil("Black Cat", 4, b, "blackcat.png"));
    lista.add(new PiezaMovil("Sabretooth", 4, b, "sabretooth.png"));
    
    // Rango 3 (Scout)
    lista.add(new Scout("Juggernaut", b, "juggernaut.png"));
    lista.add(new Scout("Rhino", b, "rhino.png"));
    lista.add(new Scout("Carnage", b, "carnage.png"));
    lista.add(new Scout("Mole Man", b, "moleman.png"));
    lista.add(new Scout("Lizard", b, "lizard.png"));

    // Rango 2 (Mistica)
    lista.add(new Mistica("Mr. Sinister", b, "mrsinister.png"));
    lista.add(new Mistica("Sentinel 1", b, "sentinel1.png"));
    lista.add(new Mistica("Ultron", b, "ultron.png"));
    lista.add(new Mistica("Sandman", b, "sandman.png"));
    lista.add(new Mistica("Leader", b, "leader.png"));
    lista.add(new Mistica("Viper", b, "viper.png"));
    lista.add(new Mistica("Sentinel 2", b, "sentinel2.png"));
    lista.add(new Mistica("Electro", b, "electro.png"));

    // Rango 1 (Agente)
    lista.add(new Agente("Black Widow", b, "blackwidow_villanos.png"));

    // 6 bombas
    for (int i = 0; i < 6; i++) {
        lista.add(new Bomba(b, "pumpkinbomb.png"));
    }

    // Tierra
    lista.add(new Tierra(b, "tierra_villanos.png"));

    return lista ;
    
  }
   private int colocarTierra(Pieza tierra , int filaultima) {
       int columna ;
       //  columna al azar del 1 al 8 
      columna = r.nextInt(8)+1 ;
      colocarPieza(tierra , filaultima ,  columna) ;
       return columna;
       
   }
   // metodo para que se coloquen las bombas
    private void colocarBombasAlrededor (ArrayList<Pieza> bombas, int filaUltima, int filaFrente, int columna) {
        int[] filas    = {filaUltima, filaUltima, filaFrente};
    int[] columnas = {columna - 1, columna + 1, columna};
        for (int i = 0; i < filas.length; i++) {
         Pieza bomba =   bombas.remove(0) ;
          colocarPieza(bomba ,filas[i] , columnas [i])  ;
        }
}
    // metodo para colocar las fichas
    private void colocarAlAzar(ArrayList<Pieza> piezas, int filaInicio, int cantidadFilas) {        
        int fila ;
        int columna ;
       
        while(piezas.size()>0) {
          fila = filaInicio + r.nextInt(cantidadFilas) ;
          columna = r.nextInt(10) ;
          if(estaVacia(fila , columna) ==true) {
              Pieza pieza = piezas.remove(0) ;
              colocarPieza(pieza , fila , columna) ;
          }
        }
    }
    // merodo que nos ayuda a separar tipo y colocar en sus filas
    public void armarBando(ArrayList<Pieza> todas ,Bando bando) {
        // separar fichas
         ArrayList<Pieza> bombas   = new ArrayList<>();
    ArrayList<Pieza> misticas = new ArrayList<>();
    ArrayList<Pieza> resto    = new ArrayList<>();
    Pieza tierra = null;

    for (int i = 0; i < todas.size(); i++) {
        Pieza p = todas.get(i);
        if( p  instanceof Tierra) {
        tierra = p ;
        }
        
        else if ( p instanceof Bomba) {
          bombas.add(p) ;
                
        }    
        else if ( p instanceof Mistica) {
            misticas.add(p) ;
        }
        else {
            resto.add(p) ;
        }
        
    
    }
    // colocar cada grupo 
    int filaUltima;
    int filaFrente;
    int filaBombas;
    int filaMisticas;
    int filaResto;

if (bando == Bando.Heroes) {
    // asigná los 5 valores de Héroes
    filaUltima = 9 ;
    filaFrente = 8 ;
    filaBombas = 8 ;
    filaMisticas = 6 ;
    filaResto = 6 ;
    
}        
    // asigná los 5 valores de Villanos
else {
    filaUltima =0 ;
    filaFrente = 1 ;
    filaBombas = 0 ;
    filaMisticas = 2 ;
    filaResto = 0 ;
    
}
  //  ponen las fichas en el tablero
 int columna = colocarTierra(tierra, filaUltima);
  colocarBombasAlrededor ( bombas, filaUltima, filaFrente, columna) ;
  colocarAlAzar(bombas ,filaBombas ,2) ;
  colocarAlAzar (misticas , filaMisticas ,2) ;
  colocarAlAzar ( resto , filaResto ,4 ) ;
  
  

}
}
    





