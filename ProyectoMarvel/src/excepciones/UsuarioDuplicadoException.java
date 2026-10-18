
package excepciones;


public class UsuarioDuplicadoException extends Exception {
  // excepcion de credenciales ivalidadas  
  public  UsuarioDuplicadoException (String Mensaje)   {
       super(Mensaje) ;
   } 
}
