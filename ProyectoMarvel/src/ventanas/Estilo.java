
package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicButtonUI;

public class Estilo {
 
    public static final Color FONDO       = new Color(15, 26, 46);    
    public static final Color ROJO        = new Color(230, 36, 41);   
    public static final Color ROJO_CLARO  = new Color(255, 75, 80);  
    public static final Color SECUNDARIO  = new Color(42, 53, 80);   
    public static final Color SECUNDARIO_CLARO = new Color(62, 76, 110);
    public static final Color DORADO      = new Color(240, 185, 11);  
    public static final Color TEXTO       = Color.WHITE;

    // Fondo ventana
    public static void fondo(JFrame ventana) {
        ventana.getContentPane().setBackground(FONDO);
    }

    // Título 
    public static void titulo(JLabel label) {
        label.setForeground(DORADO);
        label.setFont(new Font("Arial", Font.BOLD, 26));
    }

    // Texto normal en blanco 
    public static void texto(JLabel label) {
        label.setForeground(TEXTO);
    }

    // Botón rojo principal
    public static void botonPrincipal(JButton boton) {
        darEstilo(boton, ROJO, ROJO_CLARO);
    }

    // Botón secundario 
    public static void botonSecundario(JButton boton) {
        darEstilo(boton, SECUNDARIO, SECUNDARIO_CLARO);
    }

    
    private static void darEstilo(JButton boton, Color normal, Color encima) {
        boton.setUI(new BasicButtonUI());
        boton.setBackground(normal);
        boton.setForeground(TEXTO);
        boton.setFont(new Font("Arial", Font.BOLD, 13));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12)); 

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(encima);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(normal);
            }
        });
    }  
}
