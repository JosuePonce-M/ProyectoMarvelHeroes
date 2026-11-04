
package interfaces;

import modelo.Pieza;
import modelo.ResultadoCombate;


public interface Atacante {
     ResultadoCombate atacar(Pieza defensor);

    public void setRevelada(boolean b);
}
