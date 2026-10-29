
package ventanas;

import java.awt.Color;
import modelo.*;
import logica.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import logica.Tablero;
import static modelo.Bando.Heroes;
public class VentanaJuego extends javax.swing.JFrame {

 private Tablero tablero;
private JButton[][] botones = new JButton[10][10];
    public VentanaJuego(Tablero tablero) {
        initComponents();
    this.tablero = tablero;
    crearBotones();
    actualizarBotones();
    }
 private void actualizarBotones() {
    for (int fila = 0; fila < 10; fila++) {
        for (int columna = 0; columna < 10; columna++) {
            JButton boton = botones[fila][columna];
            Pieza p = tablero.getPieza(fila, columna);

            // TODO 1: si es zona prohibida → color DARK_GRAY y setEnabled(false)
           

            if (tablero.esZonaProhibida(fila, columna) == true) {
                boton.setContentAreaFilled(false);
                boton.setEnabled(false);
            } else if (p == null) {
                boton.setText("");
                boton.setContentAreaFilled(false);
            } else {
                boton.setContentAreaFilled(true);

                // el texto
                if (p instanceof Tierra) {
                    boton.setText("T");
                } else if (p instanceof Bomba) {
                    boton.setText("B");
                } else {
                    boton.setText("" + p.getRango());
                }

                // el color
                if (p.getBando() == Bando.Heroes) {
                    boton.setBackground(Color.BLUE);
                } else {
                    boton.setBackground(Color.RED);
                }
            }
        }
            }
        }
    
        
 
 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 =    new PanelFondo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("panelTablero"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void crearBotones () {
       jPanel1.setLayout(new GridLayout(10, 10));
       for (int fila = 0; fila < 10; fila++) {
        for (int columna = 0; columna < 10; columna++) {
            // crear boton
             JButton boton = new JButton() ;
              botones[fila][columna] = boton ;
             jPanel1.add(boton) ;
            
         
        }
    }

   }
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             Tablero t = new Tablero();
    t.armarBando(t.crearPiezasHeroes(), Bando.Heroes);
    t.armarBando(t.crearPiezasVillanos(), Bando.Villanos);
    new VentanaJuego(t).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
