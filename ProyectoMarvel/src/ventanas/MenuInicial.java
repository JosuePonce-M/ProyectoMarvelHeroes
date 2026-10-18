
package ventanas;

import logica.ControlUsuarios ;
public class MenuInicial extends javax.swing.JFrame {
  private ControlUsuarios control ;
   public MenuInicial(ControlUsuarios control) {
    initComponents();
    this.control = control;
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnSalir = new javax.swing.JButton();
        BtnLogin = new javax.swing.JButton();
        BtnCrearPlayer1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Marvel Heroes Stratego");
        setPreferredSize(new java.awt.Dimension(500, 400));

        BtnSalir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        BtnLogin.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BtnLogin.setText("LOG IN");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });

        BtnCrearPlayer1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BtnCrearPlayer1.setText("CREAR PLAYER");
        BtnCrearPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearPlayer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCrearPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(BtnCrearPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        BtnLogin.getAccessibleContext().setAccessibleName("BtnLogIn");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
       Login ventana = new Login (control) ;
       ventana.setVisible(true) ;
    }//GEN-LAST:event_BtnLoginActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
      System.exit(0);
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnCrearPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearPlayer1ActionPerformed
        // TODO add your handling code here:
       CrearPlayer v = new CrearPlayer(control);
        v.setVisible(true); 
    }//GEN-LAST:event_BtnCrearPlayer1ActionPerformed

    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCrearPlayer1;
    private javax.swing.JButton BtnLogin;
    private javax.swing.JButton BtnSalir;
    // End of variables declaration//GEN-END:variables
}
