
package ventanas;
import logica.ControlUsuarios ;
import excepciones.PasswordInvalidoException ;
import excepciones.UsuarioDuplicadoException ;
import javax.swing.JOptionPane ;
public class CrearPlayer extends javax.swing.JFrame {
   private ControlUsuarios control ;
   
 
  
    public CrearPlayer(ControlUsuarios control) {
    initComponents();
    Estilo.fondo(this);
    Estilo.texto(jLabel1);
    Estilo.texto(jLabel2);
    Estilo.texto(LMensaje);
    Estilo.botonPrincipal(BCrear);
    Estilo.botonSecundario(BCancelar);
    chkMostrar.setForeground(java.awt.Color.WHITE);
    chkMostrar.setOpaque(false);
    this.control = control;
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        LMensaje = new javax.swing.JLabel();
        BCrear = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();
        chkMostrar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear Player");
        setPreferredSize(new java.awt.Dimension(500, 350));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("Username ");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("Password ");

        LMensaje.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        BCrear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BCrear.setText("CREAR");
        BCrear.setPreferredSize(new java.awt.Dimension(93, 27));
        BCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCrearActionPerformed(evt);
            }
        });

        BCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BCancelar.setText("CANCELAR");
        BCancelar.setPreferredSize(new java.awt.Dimension(93, 27));
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });

        chkMostrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkMostrar.setText("Mostrar contraseña");
        chkMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(LMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(chkMostrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkMostrar)
                .addGap(18, 18, 18)
                .addComponent(LMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
      
        dispose() ;
    }//GEN-LAST:event_BCancelarActionPerformed

    private void BCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCrearActionPerformed
        // TODO add your handling code here:
        String username ;
        String contrasena ;
        
      try {
    //  leer el texto de los dos campos
    username = txtUsername.getText() ;
    contrasena = new String(txtContrasena.getPassword());
    if (username.trim().equals("")) {
    JOptionPane.showMessageDialog(this, "Escribe un username");
    return;
}
  
    
    control.crearJugador(username, contrasena);
   
    JOptionPane.showMessageDialog(this, "Su usuario se creo con exito ") ;
    dispose () ;
} catch (PasswordInvalidoException e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
    
 } catch (UsuarioDuplicadoException e) {
    JOptionPane.showMessageDialog(this, e.getMessage() + " Ingresa uno nuevo.");
    txtUsername.setText("");
    txtUsername.requestFocus(); 
    }//GEN-LAST:event_BCrearActionPerformed
 
    }
    // para mostrar
    private void chkMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarActionPerformed
        if (chkMostrar.isSelected() == true) {
        txtContrasena.setEchoChar((char) 0);
    } else {
        txtContrasena.setEchoChar('•');
    }

    }//GEN-LAST:event_chkMostrarActionPerformed
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BCrear;
    private javax.swing.JLabel LMensaje;
    private javax.swing.JCheckBox chkMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
