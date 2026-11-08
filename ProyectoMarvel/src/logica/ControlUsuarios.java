
package logica;

import excepciones.CredencialesInvalidosException;
import excepciones.PasswordInvalidoException;
import excepciones.UsuarioDuplicadoException;
import java.util.ArrayList;
import modelo.Bando;
import modelo.Jugador;

/**
 * Administra a todos los jugadores del sistema (crear, login, cambiar password, eliminar)
 * y guarda el historial global de partidas para las estadísticas de Universo Marvel.
 */
public class ControlUsuarios {

    //  ATRIBUTOS 
    private ArrayList<Jugador> listaJugadores;
    private int usuariosHistoricos = 0;                              
    private ArrayList<Bando> historialPartidas = new ArrayList<>(); 

  
    public ControlUsuarios() {
        listaJugadores = new ArrayList<>();
    }

    //  JUGADORES 

    // Busca un jugador por su username  
    public Jugador buscarjugador(String username) {
        for (int i = 0; i < listaJugadores.size(); i++) {
            Jugador actual = listaJugadores.get(i);
            if (actual.getUsername().equalsIgnoreCase(username)) {
                return actual;
            }
        }
        return null;
    }

    // Crea un jugador nuevo.
    public void crearJugador(String username, String password)
            throws PasswordInvalidoException, UsuarioDuplicadoException {

        if (password.length() != 5) {
            throw new PasswordInvalidoException("El password debe tener exactamente 5 caracteres");
        }
        if (buscarjugador(username) != null) {
            throw new UsuarioDuplicadoException("Ese username ya existe");
        }

        Jugador nuevo = new Jugador(username, password);
        listaJugadores.add(nuevo);
        usuariosHistoricos = usuariosHistoricos + 1;
    }

    // Verifica username y password
    public Jugador login(String username, String password) throws CredencialesInvalidosException {
        Jugador jugador = buscarjugador(username);

        if (jugador == null) {
            throw new CredencialesInvalidosException("Username o password incorrectos");
        }
        if (jugador.getContrasena().equals(password) == false) {
            throw new CredencialesInvalidosException("Username o password incorrectos");
        }
        return jugador;
    }

    // Cambia el password 
    public void cambiarPassword(Jugador jugador, String actual, String nueva)
            throws PasswordInvalidoException, CredencialesInvalidosException {

        if (jugador.getContrasena().equals(actual)) {
            if (nueva.length() == 5) {
                jugador.setContrasena(nueva);
            } else {
                throw new PasswordInvalidoException("El password debe tener exactamente 5 caracteres");
            }
        } else {
            throw new CredencialesInvalidosException("El password actual es incorrecto");
        }
    }

    // Elimina al jugador si confirma con su password
    public void eliminarJugador(Jugador jugador, String password) throws CredencialesInvalidosException {
        if (jugador.getContrasena().equals(password)) {
            listaJugadores.remove(jugador);
        } else {
            throw new CredencialesInvalidosException("Password incorrecto");
        }
    }

    // HISTORIAL DE PARTIDAS 

    // Guarda el bando ganador de una partida terminada 
    public void registrarPartida(Bando ganador) {
        historialPartidas.add(ganador);
    }

    // Metodo Recu cuenta cuántas partidas ganó un bando recorriendo el historial.
    public int contarVictorias(Bando bando, int indice) {
        if (indice == historialPartidas.size()) { // caso base
            return 0;
        }
        if (historialPartidas.get(indice) == bando) {
            return 1 + contarVictorias(bando, indice + 1);
        }
        return contarVictorias(bando, indice + 1);
    }

    // GETTERS Y SETTERS 
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public int getUsuariosHistoricos() {
        return usuariosHistoricos;
    }

    public void setUsuariosHistoricos(int usuariosHistoricos) {
        this.usuariosHistoricos = usuariosHistoricos;
    }

    public ArrayList<Bando> getHistorialPartidas() {
        return historialPartidas;
    }
}