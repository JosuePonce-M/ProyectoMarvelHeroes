
package ventanas;
/**
 * Menú principal: aparece después de iniciar sesión.
 * 
 */
import logica.ControlUsuarios ;
import modelo.Jugador ;
import javax.swing.JOptionPane ;

public class MenuPrincipal extends javax.swing.JFrame {
private ControlUsuarios control ;
private Jugador jugadorActual ;         
private javax.swing.JFrame ventanaAbierta; 
    public MenuPrincipal(ControlUsuarios control ,  Jugador jugador) {
        initComponents();
         Estilo.fondo(this);
        Estilo.titulo(jLabel1);   
         Estilo.texto(lmensaje);     
         Estilo.botonPrincipal(BpartidaNueva);
        Estilo.botonPrincipal(Bperfil);
        Estilo.botonPrincipal(BUniverso);
        Estilo.botonSecundario(BCerrarSeccion);
        this.control = control ;
        this.jugadorActual = jugador ;
    
        lmensaje.setText("Bienvenido  " + jugador.getUsername());
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Bperfil = new javax.swing.JButton();
        BpartidaNueva = new javax.swing.JButton();
        BCerrarSeccion = new javax.swing.JButton();
        BUniverso = new javax.swing.JButton();
        lmensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Marvel Heroes Stratego");
        jLabel1.setToolTipText("");

        Bperfil.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Bperfil.setText("MI PERFIL");
        Bperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BperfilActionPerformed(evt);
            }
        });

        BpartidaNueva.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        BpartidaNueva.setText("PARTIDA NUEVA");
        BpartidaNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BpartidaNuevaActionPerformed(evt);
            }
        });

        BCerrarSeccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        BCerrarSeccion.setText("CERRAR SESIÓN");
        BCerrarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCerrarSeccionActionPerformed(evt);
            }
        });

        BUniverso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        BUniverso.setText("UNIVERSO MARVEL");
        BUniverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUniversoActionPerformed(evt);
            }
        });

        lmensaje.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BpartidaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCerrarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BUniverso))
                .addGap(175, 175, 175))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BCerrarSeccion, BUniverso, BpartidaNueva, Bperfil});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(BpartidaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(BUniverso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BCerrarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 // boton cerrar seccion
    private void BCerrarSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCerrarSeccionActionPerformed
        // TODO add your handling code here:
        
        int respuesta = JOptionPane.showConfirmDialog(this,
        "¿Seguro que quieres cerrar sesión?",
        "Cerrar sesión", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
        MenuInicial inicio = new MenuInicial(control);
        inicio.setVisible(true);
        dispose();
}
    }//GEN-LAST:event_BCerrarSeccionActionPerformed
     
    private void BperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BperfilActionPerformed
   if (hayVentanaAbierta() == true) {
            return;
        }
        ventanaAbierta = new MiPerfil(control, jugadorActual, this);
        ventanaAbierta.setVisible(true);
    }//GEN-LAST:event_BperfilActionPerformed

    private void BpartidaNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BpartidaNuevaActionPerformed
    
     if (control.getListaJugadores().size() < 2) {
            JOptionPane.showMessageDialog(this, "Se necesita al menos otro jugador registrado para jugar");
            return;
        }
        if (hayVentanaAbierta() == true) {
            return;
        }
        ventanaAbierta = new PartidaNueva(control, jugadorActual);
        ventanaAbierta.setVisible(true);
    }//GEN-LAST:event_BpartidaNuevaActionPerformed

    private void BUniversoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUniversoActionPerformed
      if (hayVentanaAbierta() == true) {
            return;
        }
        ventanaAbierta = new UniversoMarvel(control);
        ventanaAbierta.setVisible(true);
    }
       private boolean hayVentanaAbierta() {
        if (ventanaAbierta != null && ventanaAbierta.isDisplayable() == true) {
            ventanaAbierta.toFront();
            return true;
        }
        return false;
    
    }//GEN-LAST:event_BUniversoActionPerformed

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCerrarSeccion;
    private javax.swing.JButton BUniverso;
    private javax.swing.JButton BpartidaNueva;
    private javax.swing.JButton Bperfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lmensaje;
    // End of variables declaration//GEN-END:variables
}
