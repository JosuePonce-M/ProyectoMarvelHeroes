
package ventanas;
import logica.ControlUsuarios ;
import modelo.Jugador ;
import excepciones.PasswordInvalidoException ;
import javax.swing.JOptionPane ;
 import excepciones.CredencialesInvalidosException ;
public class MiPerfil extends javax.swing.JFrame {
private ControlUsuarios control;
private Jugador jugadorActual;
private MenuPrincipal menu;
   
    public MiPerfil(ControlUsuarios control , Jugador jugador , MenuPrincipal menu) {
        initComponents();
        this.control = control ;
        this.jugadorActual = jugador ;
        this.menu = menu ;
       
          lusername.setText("Username: " + jugador.getUsername());
    lPuntos.setText("Puntos: " + jugador.getPuntos());
    lHeroes.setText("Partidas con Héroes: " + jugador.getPartidasHeroes());
    lVillanos.setText("Partidas con Villanos: " + jugador.getPartidasVillanos());

    txtHistorial.setText("Todavía no hay partidas jugadas");
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BVOLVER = new javax.swing.JButton();
        BCAMBIARPASWORD = new javax.swing.JButton();
        BELIMINAR = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHistorial = new javax.swing.JTextArea();
        lPuntos = new javax.swing.JLabel();
        lVillanos = new javax.swing.JLabel();
        lHeroes = new javax.swing.JLabel();
        lusername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MI PERFIL");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mi Perfil");

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

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Historial de partidas");

        txtHistorial.setColumns(20);
        txtHistorial.setRows(5);
        jScrollPane2.setViewportView(txtHistorial);

        lPuntos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lPuntos.setText("0");

        lVillanos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lVillanos.setText("0");

        lHeroes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lHeroes.setText("0");

        lusername.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lusername.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lVillanos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(lHeroes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lusername, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BCAMBIARPASWORD)
                        .addGap(30, 30, 30)
                        .addComponent(BELIMINAR)
                        .addGap(39, 39, 39)
                        .addComponent(BVOLVER, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lusername, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lHeroes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lVillanos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCAMBIARPASWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BVOLVER, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 // boton cambiar contraseña
    private void BCAMBIARPASWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCAMBIARPASWORDActionPerformed
       CambiarPassword ventana = new CambiarPassword(control, jugadorActual);
       ventana.setVisible(true);
    }//GEN-LAST:event_BCAMBIARPASWORDActionPerformed
 // boton eliminar cuenta
    private void BELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BELIMINARActionPerformed
     String password = JOptionPane.showInputDialog(this, "Escribe tu password para confirmar");
        if (password == null) {
            return;
            }
        try {
    control.eliminarJugador(jugadorActual, password);
    JOptionPane.showMessageDialog(this, "Tu cuenta fue eliminada");
    MenuInicial inicio = new MenuInicial(control);
    inicio.setVisible(true);
    menu.dispose();
    dispose();
        } catch (CredencialesInvalidosException e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
}
    }//GEN-LAST:event_BELIMINARActionPerformed
 // boton volver
    private void BVOLVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVOLVERActionPerformed
       dispose () ;
    }//GEN-LAST:event_BVOLVERActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCAMBIARPASWORD;
    private javax.swing.JButton BELIMINAR;
    private javax.swing.JButton BVOLVER;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lHeroes;
    private javax.swing.JLabel lPuntos;
    private javax.swing.JLabel lVillanos;
    private javax.swing.JLabel lusername;
    private javax.swing.JTextArea txtHistorial;
    // End of variables declaration//GEN-END:variables
}
