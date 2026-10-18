
package proyectomarvel;

import logica.ControlUsuarios;
import ventanas.MenuInicial;


public class ProyectoMarvel {

   
    public static void main(String[] args) {
       ControlUsuarios control = new ControlUsuarios ();
    MenuInicial menu = new MenuInicial(control);
    menu.setVisible(true);
      
    }
    
}
