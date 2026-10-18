
package excepciones;


public class PasswordInvalidoException extends Exception {
     // excepcion de credenciales ivalidadas
  public  PasswordInvalidoException (String Mensaje) {
      super(Mensaje)   ;
    }
}
