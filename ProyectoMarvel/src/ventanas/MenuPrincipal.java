
package ventanas;
import logica.ControlUsuarios ;
import modelo.Jugador ;
import javax.swing.JOptionPane ;

public class MenuPrincipal extends javax.swing.JFrame {
private ControlUsuarios control ;
private Jugador jugadorActual ;
 
    public MenuPrincipal(ControlUsuarios control ,  Jugador jugador) {
        initComponents();
        this.control = control ;
        this.jugadorActual = jugador ;
    
        lmensaje.setText("Bienvenido, " + jugador.getUsername());
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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Marvel Heroes Stratego");
        jLabel1.setToolTipText("");

        Bperfil.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Bperfil.setText("MI PERFIL");
        Bperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BperfilActionPerformed(evt);
            }
        });

        BpartidaNueva.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BpartidaNueva.setText("PARTIDA NUEVA");

        BCerrarSeccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BCerrarSeccion.setText("CERRAR SESIÓN");
        BCerrarSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCerrarSeccionActionPerformed(evt);
            }
        });

        BUniverso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BUniverso.setText("UNIVERSO MARVEL");

        lmensaje.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BpartidaNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Bperfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BUniverso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BCerrarSeccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(lmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BpartidaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bperfil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BUniverso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BCerrarSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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
     MiPerfil perfil = new MiPerfil(control, jugadorActual, this);
        perfil.setVisible(true);
    }//GEN-LAST:event_BperfilActionPerformed

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCerrarSeccion;
    private javax.swing.JButton BUniverso;
    private javax.swing.JButton BpartidaNueva;
    private javax.swing.JButton Bperfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lmensaje;
    // End of variables declaration//GEN-END:variables
}
