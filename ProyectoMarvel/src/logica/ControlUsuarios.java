
package logica;
import java.util.ArrayList ;
import modelo.Jugador ;
import excepciones.PasswordInvalidoException ;
import excepciones.UsuarioDuplicadoException ;
import excepciones.CredencialesInvalidosException ;
public class ControlUsuarios {
   private ArrayList <Jugador> listaJugadores ;
   private int usuariosHistoricos = 0 ;
   // constructor
  public ControlUsuarios () {
       listaJugadores = new ArrayList<> () ;
       
   }
   // metodo buscar jugasdor
   private Jugador buscarjugador (String username) {
       for (int i = 0; i < listaJugadores.size(); i++) {
      Jugador  Actual = listaJugadores.get(i) ;
         // comparacion si es igual
          if (Actual.getUsername().equalsIgnoreCase(username)) {  
              return Actual ;
       }
  
   }
        return null ;
   }
   // procedimiento crear jugador
    public void crearJugador (String username , String password)
 throws PasswordInvalidoException, UsuarioDuplicadoException {

    if (password.length() != 5) {
        throw new PasswordInvalidoException("El password debe tener exactamente 5 caracteres");
    }

    if (buscarjugador(username) != null) {
        throw new UsuarioDuplicadoException("Ese username ya existe");
    }

    Jugador nuevo = new Jugador(username, password);
    listaJugadores.add(nuevo);
    usuariosHistoricos =  usuariosHistoricos +1 ;
}
 // metodo 
public Jugador login(String username, String password)
        throws CredencialesInvalidosException {

    Jugador jugador = buscarjugador(username);

  if (jugador == null) {
    throw new CredencialesInvalidosException("Username o password incorrectos");
}

if (jugador.getContrasena().equals(password) == false)  {
    throw new CredencialesInvalidosException("Username o password incorrectos");
}

return jugador;
}
 // metodo cambiar contraseña
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
   // metodo eliminar jugador
 public void eliminarJugador(Jugador jugador, String password)
        throws CredencialesInvalidosException {
    if (jugador.getContrasena().equals(password)) {
        listaJugadores.remove(jugador);
    } else {
        throw new CredencialesInvalidosException("Password incorrecto");
    }
}         
// getter and setters
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
}
