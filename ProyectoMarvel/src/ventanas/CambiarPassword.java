
package ventanas;
import logica.ControlUsuarios ;
 import modelo.Jugador ;
import javax.swing.JOptionPane ;
import excepciones.CredencialesInvalidosException ;
import excepciones.PasswordInvalidoException ;
public class CambiarPassword extends javax.swing.JFrame {
private ControlUsuarios control;
private Jugador jugadorActual;

   
    public CambiarPassword(ControlUsuarios control, Jugador jugador) {
        initComponents();
            this.control = control;
        this.jugadorActual = jugador ;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnuevo = new javax.swing.JTextField();
        txtactual1 = new javax.swing.JTextField();
        BCAMBIAR = new javax.swing.JButton();
        BCANCELAR = new javax.swing.JButton();
        lmensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar Password");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Password nuevo");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Password actual");

        txtnuevo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnuevoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnuevoFocusLost(evt);
            }
        });

        BCAMBIAR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BCAMBIAR.setText("CAMBIAR");
        BCAMBIAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCAMBIARActionPerformed(evt);
            }
        });

        BCANCELAR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BCANCELAR.setText("CANCELAR");
        BCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCANCELARActionPerformed(evt);
            }
        });

        lmensaje.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lmensaje.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lmensajeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lmensajeFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtactual1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BCANCELAR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lmensaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(BCAMBIAR, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(213, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtactual1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(BCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(217, Short.MAX_VALUE)
                    .addComponent(BCAMBIAR, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 // boton cambiar
    private void BCAMBIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCAMBIARActionPerformed
     String actual = txtactual1.getText();
     String nueva = txtnuevo.getText();
try {
    control.cambiarPassword(jugadorActual, actual , nueva);
    JOptionPane.showMessageDialog(this, "Password cambiado");
    dispose();
} catch (PasswordInvalidoException e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
} catch (CredencialesInvalidosException e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
}
    }//GEN-LAST:event_BCAMBIARActionPerformed

    private void BCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCANCELARActionPerformed
      
        dispose() ;
    }//GEN-LAST:event_BCANCELARActionPerformed

    private void lmensajeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lmensajeFocusGained
        // TODO add your handling code here:
        lmensaje.setText("Escribe exactamente 5 caracteres");
    }//GEN-LAST:event_lmensajeFocusGained

    private void lmensajeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lmensajeFocusLost
        // TODO add your handling code here:
        lmensaje.setText("");
    }//GEN-LAST:event_lmensajeFocusLost

    private void txtnuevoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnuevoFocusGained
        // TODO add your handling code here:
         lmensaje.setText("Escribe exactamente 5 caracteres");
    }//GEN-LAST:event_txtnuevoFocusGained

    private void txtnuevoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnuevoFocusLost
        // TODO add your handling code here:
         lmensaje.setText("");
    }//GEN-LAST:event_txtnuevoFocusLost

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCAMBIAR;
    private javax.swing.JButton BCANCELAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lmensaje;
    private javax.swing.JTextField txtactual1;
    private javax.swing.JTextField txtnuevo;
    // End of variables declaration//GEN-END:variables
}
