package ventanas;

import excepciones.MovimientoInvalidoException;
import java.awt.Color;
import modelo.*;
import logica.Partida;
import java.awt.GridLayout;
import javax.swing.JButton;
import logica.Tablero;
import javax.swing.JOptionPane;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.Timer;

public class VentanaJuego extends javax.swing.JFrame {
   private JPanel panelHeroesEliminados = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 4));
   private JPanel panelVillanosEliminados = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 4));
    private Tablero tablero;
    private Partida partida;
    private JButton[][] botones = new JButton[10][10];
    private int filaSeleccionada = -1;
    private int columnaSeleccionada = -1;
    private JLabel etiquetaTurno = new JLabel("", JLabel.CENTER);
   private JButton botonRetiro = new JButton("RETIRO");

    public VentanaJuego(Partida partida) {
        initComponents();
        this.partida = partida;
        this.tablero = partida.getTablero();
        crearBotones();
        armarVentana();
        actualizarBotones();
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void actualizarBotones() {
    for (int fila = 0; fila < 10; fila++) {
        for (int columna = 0; columna < 10; columna++) {
            JButton boton = botones[fila][columna];
            Pieza p = tablero.getPieza(fila, columna);

            if (tablero.esZonaProhibida(fila, columna) == true) {
                boton.setContentAreaFilled(false);
                boton.setEnabled(false);
                boton.setIcon(null);
            } else if (p == null) {
                boton.setText("");
                boton.setContentAreaFilled(false);
                boton.setIcon(null);
            } else {
                boton.setContentAreaFilled(true);

                if (p.getBando() == partida.getTurno() || p.isRevelada() == true) {
                    // FICHA VISIBLE → imagen del personaje
                    ImageIcon icono = cargarIcono(p.getImagen() ,55);
                    if (icono == null) {
                        // si la imagen no existe, se muestra el texto como antes
                        boton.setIcon(null);
                        if (p instanceof Tierra) {
                            boton.setText("T");
                        } else if (p instanceof Bomba) {
                            boton.setText("B");
                        } else {
                            boton.setText("" + p.getRango());
                        }
                    } else {
                        boton.setIcon(icono);
                        boton.setText("");
                    }
                } else {
                    // FICHA TAPADA → imagen oculta
                    if (p.getBando() == Bando.Heroes) {
                        boton.setIcon(cargarIcono("fichas/oculta_heroes.png" ,55));
                    } else {
                        boton.setIcon(cargarIcono("fichas/oculta_villanos.png" ,55));
                    }
                    boton.setText("");
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
    actualizarEliminados();  
    actualizarTurno();
}
    
   private ImageIcon cargarIcono(String archivo, int tamano) {
    java.net.URL ruta = getClass().getResource("/Imagenes/" + archivo);
    if (ruta == null) {
        return null;
    }
    Image img = new ImageIcon(ruta).getImage().getScaledInstance(tamano, tamano, Image.SCALE_SMOOTH);
    return new ImageIcon(img);
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

    private void crearBotones() {
        jPanel1.setLayout(new GridLayout(10, 10));
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {
                // crear boton
                JButton boton = new JButton();
                botones[fila][columna] = boton;
                jPanel1.add(boton);

                int f = fila;
                int c = columna;
                boton.addActionListener(e -> clicCasilla(f, c));

            }
        }

    }

    private void clicCasilla(int fila, int columna) {
        if (filaSeleccionada != -1) {
            try {
                partida.moverPieza(filaSeleccionada, columnaSeleccionada, fila, columna);
                if (partida.huboCombate() == true) {
                    Timer espera = new Timer(500, e -> {
                        partida.ocultarCombate();
                        actualizarBotones();
                    });
                    espera.setRepeats(false);
                    espera.start();
                    if (partida.getGanador() != null) {
                             actualizarBotones();
                    if (partida.getGanador() == Bando.Heroes) {
                     JOptionPane.showMessageDialog(this, "¡Ganan los HÉROES!");
           } else {
                    JOptionPane.showMessageDialog(this, "¡Ganan los VILLANOS!");
        }
                     dispose();
                return; }
                }
            } catch (MovimientoInvalidoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            filaSeleccionada = -1;
            columnaSeleccionada = -1;
            actualizarBotones();
            return;
        }
        Pieza p = tablero.getPieza(fila, columna);

        //  si p es null 
        if (p == null) {
            JOptionPane.showMessageDialog(this, "Ahí no hay ninguna ficha");
            return;
        }
        //  si p NO es del bando del turno 
        if (p.getBando() != partida.getTurno()) {
            JOptionPane.showMessageDialog(this, "Esa ficha no es tuya");
            return;
        }
        // TODO 3: si p NO puede moverse → mensaje "Esa ficha no se puede mover"
        if (p.puedeMoverse() == false) {
            JOptionPane.showMessageDialog(this, "Esa ficha no se puede mover");
            return;
        } // si pasó todo lo anterior:
        else {

            filaSeleccionada = fila;
            columnaSeleccionada = columna;
            botones[fila][columna].setBackground(Color.YELLOW);
        }

        //   - guardá fila y columna en filaSeleccionada y columnaSeleccionada
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
            @Override
            public void run() {
                Tablero t = new Tablero();
                t.armarBando(t.crearPiezasHeroes(), Bando.Heroes);
                t.armarBando(t.crearPiezasVillanos(), Bando.Villanos);
                Partida partida = new Partida(t);
                new VentanaJuego(partida).setVisible(true);

            }
        });
    }
    // panel laterales
    private void armarVentana() {
    panelHeroesEliminados.setPreferredSize(new Dimension(180, 600));
    panelVillanosEliminados.setPreferredSize(new Dimension(180, 600));
    panelHeroesEliminados.setBackground(new Color(20, 30, 80));
    panelVillanosEliminados.setBackground(new Color(80, 20, 20));

    getContentPane().removeAll();
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(panelHeroesEliminados, BorderLayout.WEST);
    getContentPane().add(jPanel1, BorderLayout.CENTER);
    getContentPane().add(panelVillanosEliminados, BorderLayout.EAST);
    
    JPanel barra = new JPanel(new BorderLayout());
    barra.setBackground(Color.BLACK);
    etiquetaTurno.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
    barra.add(etiquetaTurno, BorderLayout.CENTER);
    barra.add(botonRetiro, BorderLayout.EAST);
    getContentPane().add(barra, BorderLayout.NORTH);

    botonRetiro.addActionListener(e -> retirarse());
}
    
    private void actualizarEliminados() {
    panelHeroesEliminados.removeAll();
    panelVillanosEliminados.removeAll();

   
        for (int i = 0; i < partida.getEliminadosHeroes().size() ; i++) {
        Pieza p = partida.getEliminadosHeroes().get(i);         
        panelHeroesEliminados.add(new JLabel(cargarIcono(p.getImagen(), 50)));
            
        }
   

   
        for (int i = 0; i < partida.getEliminadosVillanos().size(); i++) {
            Pieza p = partida.getEliminadosVillanos().get(i);
         panelVillanosEliminados.add(new JLabel(cargarIcono(p.getImagen(), 40)));
            
        }
    panelHeroesEliminados.revalidate();
    panelHeroesEliminados.repaint();
    panelVillanosEliminados.revalidate();
    panelVillanosEliminados.repaint();
}
    private void actualizarTurno() {
        
    // TODO: si el turno es Héroes:
    if( partida.getTurno() == Bando.Heroes) {
        etiquetaTurno.setText("Turno: HÉROES");
        etiquetaTurno.setForeground(new Color(80, 150, 255));   // azul claro
    } else {
           etiquetaTurno.setText("Turno: VILLANOS");
           etiquetaTurno.setForeground(new Color(255, 80, 80));
       }
   
        
   
    }
    // mertodo retirarse
    private void retirarse() {
    int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que querés retirarte?",
            "Retiro", JOptionPane.YES_NO_OPTION);

    if (respuesta == JOptionPane.YES_OPTION) {
        if (partida.getTurno() == Bando.Heroes) {
            JOptionPane.showMessageDialog(this, "Los HÉROES se retiraron. ¡Ganan los VILLANOS!");
        } else {
            JOptionPane.showMessageDialog(this, "Los VILLANOS se retiraron. ¡Ganan los HÉROES!");
        }
        dispose();
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
