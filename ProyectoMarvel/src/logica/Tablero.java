
package logica;
 
import java.util.ArrayList;
import java.util.Random;
import modelo.*;
 
/**
 * Representa el tablero de 10x10. Guarda en qué casilla está cada ficha,
 * crea las 40 fichas de cada bando y las acomoda con la formación aleatoria del PDF.
 * Las fichas no saben su posición: solo el tablero la guarda.
 */
public class Tablero {
 
    //  ATRIBUTOS 
    private Pieza[][] casillas;
    private Random r = new Random();
 
   
    public Tablero() {
        casillas = new Pieza[10][10];
    }
 
    
 
    public Pieza getPieza(int fila, int columna) {
        return casillas[fila][columna];
    }
 
    public void colocarPieza(Pieza pieza, int fila, int columna) {
        casillas[fila][columna] = pieza;
    }
 
    public void quitarPieza(int fila, int columna) {
        casillas[fila][columna] = null;
    }
 
    public boolean estaVacia(int fila, int columna) {
        if (casillas[fila][columna] == null) {
            return true;
        }
        return false;
    }
 
    // zonas prohibidas
    public boolean esZonaProhibida(int fila, int columna) {
        if (fila == 4 || fila == 5) {
            if (columna == 2 || columna == 3 || columna == 6 || columna == 7) {
                return true;
            }
        }
        return false;
    }
 
    // CREACIÓN DE LAS FICHAS 
   
 
    // Crea las 40 fichas de los Héroes.
    public ArrayList<Pieza> crearPiezasHeroes() {
        ArrayList<Pieza> lista = new ArrayList<>();
        String c = "fichas/heroes_azul/";
        Bando b = Bando.Heroes;
 
        // Rango 10 al 4 (PiezaMovil)
        lista.add(new PiezaMovil("Mr. Fantastic", 10, b, c + "mr_fantastic.png"));
        lista.add(new PiezaMovil("Captain America", 9, b, c + "captain_america.png"));
        lista.add(new PiezaMovil("Professor X", 8, b, c + "professor_x.png"));
        lista.add(new PiezaMovil("Nick Fury", 8, b, c + "nick_fury.png"));
        lista.add(new PiezaMovil("Spider-Man", 7, b, c + "spider_man.png"));
        lista.add(new PiezaMovil("Wolverine", 7, b, c + "wolverine.png"));
        lista.add(new PiezaMovil("Namor", 7, b, c + "namor.png"));
        lista.add(new PiezaMovil("Daredevil", 6, b, c + "daredevil.png"));
        lista.add(new PiezaMovil("Silver Surfer", 6, b, c + "silver_surfer.png"));
        lista.add(new PiezaMovil("Hulk", 6, b, c + "hulk.png"));
        lista.add(new PiezaMovil("Iron Man", 6, b, c + "iron_man.png"));
        lista.add(new PiezaMovil("Thor", 5, b, c + "thor.png"));
        lista.add(new PiezaMovil("Human Torch", 5, b, c + "human_torch.png"));
        lista.add(new PiezaMovil("Cyclops", 5, b, c + "cyclops.png"));
        lista.add(new PiezaMovil("Invisible Woman", 5, b, c + "invisible_woman.png"));
        lista.add(new PiezaMovil("Ghost Rider", 4, b, c + "ghost_rider.png"));
        lista.add(new PiezaMovil("Punisher", 4, b, c + "punisher.png"));
        lista.add(new PiezaMovil("Blade", 4, b, c + "blade.png"));
        lista.add(new PiezaMovil("Thing", 4, b, c + "thing.png"));
 
        // Rango 3 (Scout)
        lista.add(new Scout("Emma Frost", b, c + "emma_frost.png"));
        lista.add(new Scout("She-Hulk", b, c + "she_hulk.png"));
        lista.add(new Scout("Giant Man", b, c + "giant_man.png"));
        lista.add(new Scout("Beast", b, c + "beast.png"));
        lista.add(new Scout("Colossus", b, c + "colossus.png"));
 
        // Rango 2 
        lista.add(new Mistica("Gambit", b, c + "gambit.png"));
        lista.add(new Mistica("Spider-Girl", b, c + "spider_girl.png"));
        lista.add(new Mistica("Ice Man", b, c + "ice_man.png"));
        lista.add(new Mistica("Storm", b, c + "storm.png"));
        lista.add(new Mistica("Phoenix", b, c + "phoenix.png"));
        lista.add(new Mistica("Dr. Strange", b, c + "dr_strange.png"));
        lista.add(new Mistica("Elektra", b, c + "elektra.png"));
        lista.add(new Mistica("Nightcrawler", b, c + "nightcrawler.png"));
 
        // Rango 1 (Agente)
        lista.add(new Agente("Black Widow", b, c + "black_widow.png"));
 
        // 6 bombas
        for (int i = 1; i <= 6; i++) {
            lista.add(new Bomba(b, c + "nova_blast_" + i + ".png"));
        }
 
        // Tierra
        lista.add(new Tierra(b, c + "planet_earth.png"));
 
        return lista;
    }
 
    // Crea las 40 fichas de los Villanos.
    public ArrayList<Pieza> crearPiezasVillanos() {
        ArrayList<Pieza> lista = new ArrayList<>();
        String c = "fichas/villanos_rojo/";
        Bando b = Bando.Villanos;
 
        // Rango 10 al 4 (PiezaMovil)
        lista.add(new PiezaMovil("Dr. Doom", 10, b, c + "dr_doom.png"));
        lista.add(new PiezaMovil("Galactus", 9, b, c + "galactus.png"));
        lista.add(new PiezaMovil("Kingpin", 8, b, c + "kingpin.png"));
        lista.add(new PiezaMovil("Magneto", 8, b, c + "magneto.png"));
        lista.add(new PiezaMovil("Apocalypse", 7, b, c + "apocalypse.png"));
        lista.add(new PiezaMovil("Green Goblin", 7, b, c + "green_goblin.png"));
        lista.add(new PiezaMovil("Venom", 7, b, c + "venom.png"));
        lista.add(new PiezaMovil("Bullseye", 6, b, c + "bullseye.png"));
        lista.add(new PiezaMovil("Omega Red", 6, b, c + "omega_red.png"));
        lista.add(new PiezaMovil("Onslaught", 6, b, c + "onslaught.png"));
        lista.add(new PiezaMovil("Red Skull", 6, b, c + "red_skull.png"));
        lista.add(new PiezaMovil("Mystique", 5, b, c + "mystique.png"));
        lista.add(new PiezaMovil("Mysterio", 5, b, c + "mysterio.png"));
        lista.add(new PiezaMovil("Dr. Octopus", 5, b, c + "dr_octopus.png"));
        lista.add(new PiezaMovil("Deadpool", 5, b, c + "deadpool.png"));
        lista.add(new PiezaMovil("Abomination", 4, b, c + "abomination.png"));
        lista.add(new PiezaMovil("Thanos", 4, b, c + "thanos.png"));
        lista.add(new PiezaMovil("Black Cat", 4, b, c + "black_cat.png"));
        lista.add(new PiezaMovil("Sabretooth", 4, b, c + "sabretooth.png"));
 
        // Rango 3 (Scout)
        lista.add(new Scout("Juggernaut", b, c + "juggernaut.png"));
        lista.add(new Scout("Rhino", b, c + "rhino.png"));
        lista.add(new Scout("Carnage", b, c + "carnage.png"));
        lista.add(new Scout("Mole Man", b, c + "mole_man.png"));
        lista.add(new Scout("Lizard", b, c + "lizard.png"));
 
        // Rango 2 (Mistica)
        lista.add(new Mistica("Mr. Sinister", b, c + "mr_sinister.png"));
        lista.add(new Mistica("Sentinel 1", b, c + "sentinel_1.png"));
        lista.add(new Mistica("Ultron", b, c + "ultron.png"));
        lista.add(new Mistica("Sandman", b, c + "sandman.png"));
        lista.add(new Mistica("Leader", b, c + "leader.png"));
        lista.add(new Mistica("Viper", b, c + "viper.png"));
        lista.add(new Mistica("Sentinel 2", b, c + "sentinel_2.png"));
        lista.add(new Mistica("Electro", b, c + "electro.png"));
 
        // Rango 1 (Agente)
        lista.add(new Agente("Black Widow", b, c + "black_widow.png"));
 
        // 6 bombas
        for (int i = 1; i <= 6; i++) {
            lista.add(new Bomba(b, c + "pumpkin_bomb_" + i + ".png"));
        }
 
        // Tierra
        lista.add(new Tierra(b, c + "planet_earth.png"));
 
        return lista;
    }
 
    
 
    // Separa las 40 fichas de un bando por tipo
 
    public void armarBando(ArrayList<Pieza> todas, Bando bando) {
 
        
        ArrayList<Pieza> bombas = new ArrayList<>();
        ArrayList<Pieza> misticas = new ArrayList<>();
        ArrayList<Pieza> resto = new ArrayList<>();
        Pieza tierra = null;
 
        for (int i = 0; i < todas.size(); i++) {
            Pieza p = todas.get(i);
            if (p instanceof Tierra) {
                tierra = p;
            } else if (p instanceof Bomba) {
                bombas.add(p);
            } else if (p instanceof Mistica) {
                misticas.add(p);
            } else {
                resto.add(p);
            }
        }
 
        // 2. Filas según el bando 
        int filaUltima;
        int filaFrente;
        int filaBombas;
        int filaMisticas;
        int filaResto;
 
        if (bando == Bando.Heroes) {
            filaUltima = 9;
            filaFrente = 8;
            filaBombas = 8;
            filaMisticas = 6;
            filaResto = 6;
        } else {
            filaUltima = 0;
            filaFrente = 1;
            filaBombas = 0;
            filaMisticas = 2;
            filaResto = 0;
        }
 
        // Colocar cada grupo en el tablero
        int columna = colocarTierra(tierra, filaUltima);
        colocarBombasAlrededor(bombas, filaUltima, filaFrente, columna);
        colocarAlAzar(bombas, filaBombas, 2);
        colocarAlAzar(misticas, filaMisticas, 2);
        colocarAlAzar(resto, filaResto, 4);
    }
 
    // Coloca la Tierra en la última fila
  
    private int colocarTierra(Pieza tierra, int filaUltima) {
        int columna = r.nextInt(8) + 1;
        colocarPieza(tierra, filaUltima, columna);
        return columna;
    }
 
    // Pone 3 bombas alrededor 
    private void colocarBombasAlrededor(ArrayList<Pieza> bombas, int filaUltima, int filaFrente, int columna) {
        int[] filas = {filaUltima, filaUltima, filaFrente};
        int[] columnas = {columna - 1, columna + 1, columna};
 
        for (int i = 0; i < filas.length; i++) {
            Pieza bomba = bombas.remove(0);
            colocarPieza(bomba, filas[i], columnas[i]);
        }
    }
 
    // Coloca cada pieza 
  
    private void colocarAlAzar(ArrayList<Pieza> piezas, int filaInicio, int cantidadFilas) {
        int fila;
        int columna;
 
        while (piezas.size() > 0) {
            fila = filaInicio + r.nextInt(cantidadFilas);
            columna = r.nextInt(10);
            if (estaVacia(fila, columna) == true) {
                Pieza pieza = piezas.remove(0);
                colocarPieza(pieza, fila, columna);
            }
        }
    }
}
 