
package logica;
import java.util.ArrayList ;
import modelo.Jugador ;
import excepciones.PasswordInvalidoException ;
import excepciones.UsuarioDuplicadoException ;
import excepciones.CredencialesInvalidosException ;
public class ControlUsuarios {
   private ArrayList <Jugador> listaJugadores ;
   private int UsuariosH = 0 ;
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
    UsuariosH =  UsuariosH +1 ;
}
 // metodo 
public Jugador login(String username, String password)
        throws CredencialesInvalidosException {

    Jugador jugador = buscarjugador(username);

  if (jugador == null) {
    throw new CredencialesInvalidosException("Username o password incorrectos");
}

if (!jugador.getContrasena().equals(password)) {
    throw new CredencialesInvalidosException("Username o password incorrectos");
}

return jugador;
}
// getter and setters
    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public int getUsuariosH() {
        return UsuariosH;
    }

    public void setUsuariosH(int UsuariosH) {
        this.UsuariosH = UsuariosH;
    }
}
