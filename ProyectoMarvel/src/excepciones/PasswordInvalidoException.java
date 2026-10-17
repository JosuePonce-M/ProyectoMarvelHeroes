
package excepciones;


public class PasswordInvalidoException extends Exception {
     // excepcion de credenciales ivalidadas
    PasswordInvalidoException (String Mensaje) {
      super(Mensaje)   ;
    }
}
