
package logica;

import modelo.*;
import java.util.ArrayList;
public class Tablero {
    
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
  private ArrayList<Pieza> crearPiezasHeroes() {  
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
  private ArrayList<Pieza> crearPiezasVillanos() {
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
}