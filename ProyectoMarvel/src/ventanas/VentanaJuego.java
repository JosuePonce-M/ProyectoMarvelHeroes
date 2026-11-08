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
import interfaces.Refrescar;
import javax.swing.Timer;

public class VentanaJuego extends javax.swing.JFrame implements Refrescar {

    private JPanel panelHeroesEliminados = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
    private JPanel panelVillanosEliminados = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
    private Tablero tablero;
    private Partida partida;
    private JButton[][] botones = new JButton[10][10];
    private int filaSeleccionada = -1;
    private int columnaSeleccionada = -1;
    private JLabel etiquetaTurno = new JLabel("", JLabel.CENTER);
    private JButton botonRetiro = new JButton("RETIRO");
    private JLabel etiquetaHeroes = new JLabel("", JLabel.CENTER);
    private JLabel etiquetaVillanos = new JLabel("", JLabel.CENTER);
    private boolean cambiandoTurno = false;
    public VentanaJuego(Partida partida) {
        initComponents();
        this.partida = partida;
        this.tablero = partida.getTablero();
        crearBotones();
        armarVentana();
        actualizarBotones();
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 700));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        // Si cierran con la X, cuenta como RETIRO 
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            retirarse();
    }
});
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

                if (p.isRevelada() == true || (cambiandoTurno == false && p.getBando() == partida.getTurno())) {
                        // FICHA VISIBLE
                        ImageIcon icono = cargarIcono(p.getImagen(), 55);
                        if (icono == null) {
                            
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
                        // FICHA TAPADA
                        if (p.getBando() == Bando.Heroes) {
                            boton.setIcon(cargarIcono("fichas/oculta_heroes.png", 55));
                        } else {
                            boton.setIcon(cargarIcono("fichas/oculta_villanos.png", 55));
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

    @Override
    public void refrescar() {
        actualizarBotones();
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

        
        if (cambiandoTurno == true) {
            return;
        }

      
        if (filaSeleccionada != -1) {
            try {
                partida.moverPieza(filaSeleccionada, columnaSeleccionada, fila, columna);

                // Si se revelaron fichas, se vuelven a tapar después de medio segundo
                if (partida.huboCombate() == true) {
                    Timer espera = new Timer(500, e -> {
                        partida.ocultarCombate();
                        refrescar();
                    });
                    espera.setRepeats(false);
                    espera.start();
                }

                // Pausa entre turnos
                cambiandoTurno = true;
                Timer cambio = new Timer(1500, e -> {
                    cambiandoTurno = false;
                    refrescar();
                });
                cambio.setRepeats(false);
                cambio.start();

                // Si termino la partida
                if (partida.getGanador() != null) {
                    refrescar();
                    if (partida.getGanador() == Bando.Heroes) {
                        JOptionPane.showMessageDialog(this, "¡Ganan los HÉROES!");
                    } else {
                        JOptionPane.showMessageDialog(this, "¡Ganan los VILLANOS!");
                    }
                    dispose();
                    return;
                }

            } catch (MovimientoInvalidoException ex) {
                
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

            filaSeleccionada = -1;
            columnaSeleccionada = -1;
            refrescar();
            return;
        }

       // seleccionar ficha
        Pieza p = tablero.getPieza(fila, columna);

        if (p == null) {
            JOptionPane.showMessageDialog(this, "Ahí no hay ninguna ficha");
            return;
        }
        if (p.getBando() != partida.getTurno()) {
            JOptionPane.showMessageDialog(this, "Esa ficha no es tuya");
            return;
        }
        if (p.puedeMoverse() == false) {
            JOptionPane.showMessageDialog(this, "Esa ficha no se puede mover");
            return;
        }

       
        filaSeleccionada = fila;
        columnaSeleccionada = columna;
        botones[fila][columna].setBackground(Color.YELLOW);
    
    }

    

    // panel laterales
    private void armarVentana() {
       panelHeroesEliminados.setPreferredSize(new Dimension(300, 700));
        panelVillanosEliminados.setPreferredSize(new Dimension(300, 700));
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
        JPanel centro = new JPanel(new GridLayout(1, 3));
        centro.setOpaque(false);

        etiquetaHeroes.setForeground(new Color(80, 150, 255));
        etiquetaHeroes.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        etiquetaVillanos.setForeground(new Color(255, 80, 80));
        etiquetaVillanos.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));

        centro.add(etiquetaHeroes);
        centro.add(etiquetaTurno);
        centro.add(etiquetaVillanos);
        barra.add(centro, BorderLayout.CENTER);
        barra.add(botonRetiro, BorderLayout.EAST);
        getContentPane().add(barra, BorderLayout.NORTH);

        botonRetiro.addActionListener(e -> retirarse());
    }

    private void actualizarEliminados() {
        panelHeroesEliminados.removeAll();
        panelVillanosEliminados.removeAll();

        for (int i = 0; i < partida.getEliminadosHeroes().size(); i++) {
            Pieza p = partida.getEliminadosHeroes().get(i);
            panelHeroesEliminados.add(new JLabel(cargarIcono(p.getImagen(), 60)));

        }

        for (int i = 0; i < partida.getEliminadosVillanos().size(); i++) {
            Pieza p = partida.getEliminadosVillanos().get(i);
            panelVillanosEliminados.add(new JLabel(cargarIcono(p.getImagen(), 60)));

        }
        panelHeroesEliminados.revalidate();
        panelHeroesEliminados.repaint();
        panelVillanosEliminados.revalidate();
        panelVillanosEliminados.repaint();
    }

    private void actualizarTurno() {

        
        if (partida.getTurno() == Bando.Heroes) {
           etiquetaTurno.setText("Turno: HÉROES (" + partida.getJugadorEnTurno().getUsername() + ")");
            etiquetaTurno.setForeground(new Color(80, 150, 255));   
        } else {
            etiquetaTurno.setText("Turno: VILLANOS (" + partida.getJugadorEnTurno().getUsername() + ")") ;
            etiquetaTurno.setForeground(new Color(255, 80, 80));
        }
    int quedanHeroes = 40 - partida.getEliminadosHeroes().size();
    int quedanVillanos = 40 - partida.getEliminadosVillanos().size();

    String palabraHeroes = "fichas";
    if (quedanHeroes == 1) {
        palabraHeroes = "ficha";
    }
    String palabraVillanos = "fichas";
    if (quedanVillanos == 1) {
        palabraVillanos = "ficha";
    }

    etiquetaHeroes.setText("HÉROES: " + quedanHeroes + " " + palabraHeroes);
    etiquetaVillanos.setText("VILLANOS: " + quedanVillanos + " " + palabraVillanos);
    }

    // mertodo retirarse
    private void retirarse() {
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que querés retirarte?",
                "Retiro", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            partida.retirar();
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
