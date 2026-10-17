
package excepciones;


public class UsuarioDuplicadoException extends Exception {
  // excepcion de credenciales ivalidadas  
   UsuarioDuplicadoException (String Mensaje)   {
       super(Mensaje) ;
   } 
}
