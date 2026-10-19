
package ventanas;
import logica.ControlUsuarios ;
import modelo.Jugador ;
import excepciones.PasswordInvalidoException ;
import javax.swing.JOptionPane ;
public class MiPerfil extends javax.swing.JFrame {
private ControlUsuarios control;
private Jugador jugadorActual;
private MenuPrincipal menu;
    
    public MiPerfil(ControlUsuarios control , Jugador jugador , MenuPrincipal menu) {
        initComponents();
        this.control = control ;
        this.jugadorActual = jugador ;
        this.menu = menu ;
        Lmensaje.setText("Jugador:" +jugador.getUsername());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Lmensaje = new javax.swing.JLabel();
        BLOGJUEGOS = new javax.swing.JButton();
        BVOLVER = new javax.swing.JButton();
        BCAMBIARPASWORD = new javax.swing.JButton();
        BELIMINAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mi Perfil");

        Lmensaje.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        BLOGJUEGOS.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BLOGJUEGOS.setText("LOG DE JUEGOS");
        BLOGJUEGOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLOGJUEGOSActionPerformed(evt);
            }
        });

        BVOLVER.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BVOLVER.setText("VOLVER");
        BVOLVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVOLVERActionPerformed(evt);
            }
        });

        BCAMBIARPASWORD.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BCAMBIARPASWORD.setText("CAMBIAR PASSWORD");
        BCAMBIARPASWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCAMBIARPASWORDActionPerformed(evt);
            }
        });

        BELIMINAR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        BELIMINAR.setText("ELIMINAR CUENTA");
        BELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BELIMINARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BVOLVER, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCAMBIARPASWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(BLOGJUEGOS, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(143, 143, 143)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BLOGJUEGOS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BCAMBIARPASWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BVOLVER, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 // boton cambiar contraseña
    private void BCAMBIARPASWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCAMBIARPASWORDActionPerformed
String nueva = JOptionPane.showInputDialog(this, "Escribe tu nuevo password (5 caracteres)");
if (nueva == null) {
    return;
}
try {
    control.cambiarPassword(jugadorActual, nueva);
    JOptionPane.showMessageDialog(this, "Password cambiado");
} catch (PasswordInvalidoException e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
}
    }//GEN-LAST:event_BCAMBIARPASWORDActionPerformed
 // boton eliminar cuenta
    private void BELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BELIMINARActionPerformed
      int respuesta = JOptionPane.showConfirmDialog(this,
        "¿Seguro que quieres eliminar tu cuenta?",
        "Eliminar cuenta", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
        control.eliminarJugador(jugadorActual);
         JOptionPane.showMessageDialog(this, "Tu cuenta fue eliminada");
        MenuInicial inicio = new MenuInicial(control);
        inicio.setVisible(true);
        menu.dispose();
        dispose();
} 
    }//GEN-LAST:event_BELIMINARActionPerformed
 // boton volver
    private void BVOLVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVOLVERActionPerformed
       dispose () ;
    }//GEN-LAST:event_BVOLVERActionPerformed

    private void BLOGJUEGOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLOGJUEGOSActionPerformed
      JOptionPane.showMessageDialog(this, "Todavía no hay partidas jugadas");
    }//GEN-LAST:event_BLOGJUEGOSActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCAMBIARPASWORD;
    private javax.swing.JButton BELIMINAR;
    private javax.swing.JButton BLOGJUEGOS;
    private javax.swing.JButton BVOLVER;
    private javax.swing.JLabel Lmensaje;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
