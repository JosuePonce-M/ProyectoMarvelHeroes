
package modelo;

import java.util.ArrayList;


public class Jugador {

    //  ATRIBUTOS 
    private String username;
    private String contrasena;
    private int puntos = 0;
    private int partidasHeroes = 0;
    private int partidasVillanos = 0;
    private ArrayList<String> log = new ArrayList<>();  

   
    public Jugador(String username, String contrasena) {
        this.username = username;
        this.contrasena = contrasena;
    }

    // HISTORIAL 

    // Agrega un log al inicio de la lista
    public void agregarLog(String texto) {
        log.add(0, texto);
    }

    // GETTERS Y SETTERS 
    public String getUsername() {
        return username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidasHeroes() {
        return partidasHeroes;
    }

    public void setPartidasHeroes(int partidasHeroes) {
        this.partidasHeroes = partidasHeroes;
    }

    public int getPartidasVillanos() {
        return partidasVillanos;
    }

    public void setPartidasVillanos(int partidasVillanos) {
        this.partidasVillanos = partidasVillanos;
    }

    public ArrayList<String> getLog() {
        return log;
    }
}