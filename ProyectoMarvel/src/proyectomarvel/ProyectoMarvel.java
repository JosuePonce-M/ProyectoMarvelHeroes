
package proyectomarvel;

import logica.ControlUsuarios;
import ventanas.MenuInicial;
import modelo .* ;
import logica. * ;

public class ProyectoMarvel {

   
    public static void main(String[] args) {
       ControlUsuarios control = new ControlUsuarios ();
    MenuInicial menu = new MenuInicial(control);
    menu.setVisible(true);
    Tablero t = new Tablero();
    
    }
    
}
