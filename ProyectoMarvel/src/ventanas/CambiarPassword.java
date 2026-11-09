
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
        Estilo.fondo(this);
        Estilo.texto(jLabel1);
        Estilo.texto(jLabel2);
       Estilo.texto(LMensaje);
        Estilo.botonPrincipal(BCAMBIAR);
        Estilo.botonSecundario(BCANCELAR);
        chkMostrar.setForeground(java.awt.Color.WHITE);
        chkMostrar.setOpaque(false);
        
        setLocationRelativeTo(null);
            this.control = control;
        this.jugadorActual = jugador ;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BCAMBIAR = new javax.swing.JButton();
        BCANCELAR = new javax.swing.JButton();
        chkMostrar = new javax.swing.JCheckBox();
        txtactual1 = new javax.swing.JPasswordField();
        txtnuevo = new javax.swing.JPasswordField();
        LMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar Password");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("Password nuevo");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("Password actual");

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

        chkMostrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkMostrar.setText("Mostrar contraseña");
        chkMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarActionPerformed(evt);
            }
        });

        txtactual1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtactual1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtactual1FocusLost(evt);
            }
        });
        txtactual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtactual1ActionPerformed(evt);
            }
        });

        txtnuevo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnuevoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnuevoFocusLost(evt);
            }
        });

        LMensaje.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(chkMostrar)
                .addGap(141, 141, 141))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtnuevo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtactual1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BCAMBIAR, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(BCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtactual1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(chkMostrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCAMBIAR, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 // boton cambiar
    private void BCAMBIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCAMBIARActionPerformed
     String actual = new String(txtactual1.getPassword());   
     String nueva = new String(txtnuevo.getPassword());
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
        // boton de cancelar
    private void BCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCANCELARActionPerformed
      
        dispose() ;
    }//GEN-LAST:event_BCANCELARActionPerformed
     // para mostrar la contrasena
    private void chkMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarActionPerformed
        if (chkMostrar.isSelected() == true) {
        txtactual1.setEchoChar((char) 0);
        txtnuevo.setEchoChar((char) 0);
    } else {
        txtactual1.setEchoChar('•');
        txtnuevo.setEchoChar('•');
    }

    }//GEN-LAST:event_chkMostrarActionPerformed

    private void txtactual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtactual1ActionPerformed
        // TODO add your handling code here:
        LMensaje.setText("Escribe exactamente 5 caracteres");
    }//GEN-LAST:event_txtactual1ActionPerformed

    private void txtactual1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtactual1FocusGained
        // TODO add your handling code here:
         LMensaje.setText("Escribe exactamente 5 caracteres");
        
        
    }//GEN-LAST:event_txtactual1FocusGained

    private void txtnuevoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnuevoFocusLost
        // TODO add your handling code here:
         LMensaje.setText("");
        
    }//GEN-LAST:event_txtnuevoFocusLost

    private void txtnuevoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnuevoFocusGained
        // TODO add your handling code here:
        LMensaje.setText("Escribe exactamente 5 caracteres");
    }//GEN-LAST:event_txtnuevoFocusGained

    private void txtactual1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtactual1FocusLost
        // TODO add your handling code here:
         LMensaje.setText("");
    }//GEN-LAST:event_txtactual1FocusLost

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCAMBIAR;
    private javax.swing.JButton BCANCELAR;
    private javax.swing.JLabel LMensaje;
    private javax.swing.JCheckBox chkMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtactual1;
    private javax.swing.JPasswordField txtnuevo;
    // End of variables declaration//GEN-END:variables
}
