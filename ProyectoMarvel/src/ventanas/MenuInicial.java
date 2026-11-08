
package ventanas;

import logica.ControlUsuarios ;

public class MenuInicial extends javax.swing.JFrame {
  private ControlUsuarios control ;
  private javax.swing.JFrame ventanaAbierta;
   public MenuInicial(ControlUsuarios control) {
    initComponents();
     Estilo.fondo(this);
    Estilo.botonPrincipal(BtnLogin);
    Estilo.botonPrincipal(BtnCrearPlayer1);
    Estilo.titulo(titulo) ;
    this.control = control;
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnLogin = new javax.swing.JButton();
        BtnCrearPlayer1 = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Marvel Heroes Stratego");
        setPreferredSize(new java.awt.Dimension(500, 400));

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

        titulo.setText("MARVEL HEROES STRATEGO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnCrearPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(BtnCrearPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        BtnLogin.getAccessibleContext().setAccessibleName("BtnLogIn");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
      if (hayVentanaAbierta() == true) {
    return;
    }
    ventanaAbierta = new Login(control, this);
    ventanaAbierta.setVisible(true);
    }//GEN-LAST:event_BtnLoginActionPerformed

    private void BtnCrearPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearPlayer1ActionPerformed
     if (hayVentanaAbierta() == true) {
    return;
    }
    ventanaAbierta = new CrearPlayer(control);
    ventanaAbierta.setVisible(true);
    }
     private boolean hayVentanaAbierta() {
    if (ventanaAbierta != null && ventanaAbierta.isDisplayable() == true) {
        ventanaAbierta.toFront();
        return true;
    }
    return false;

    }//GEN-LAST:event_BtnCrearPlayer1ActionPerformed

    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCrearPlayer1;
    private javax.swing.JButton BtnLogin;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

}