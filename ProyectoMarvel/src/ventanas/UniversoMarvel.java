
package ventanas;


import java.util.ArrayList;
import logica.ControlUsuarios;
import modelo.Bando;
import modelo.Jugador;
public class UniversoMarvel extends javax.swing.JFrame {

 private ControlUsuarios control;  
  public UniversoMarvel(ControlUsuarios control) {
    initComponents();
    Estilo.fondo(this);
    Estilo.titulo(jLabel1);
    Estilo.botonPrincipal(bRanking);
    Estilo.botonPrincipal(bBatallas);
    Estilo.botonSecundario(bVolver);
    this.control = control;
    txtResultado.setEditable(false);
   }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        bVolver = new javax.swing.JButton();
        bRanking = new javax.swing.JButton();
        bBatallas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("UNIVERSO MARVEL");

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        bVolver.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bVolver.setText("VOLVER");
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });

        bRanking.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bRanking.setText("RANKING");
        bRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRankingActionPerformed(evt);
            }
        });

        bBatallas.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bBatallas.setText("BATALLAS");
        bBatallas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatallasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(bRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(bBatallas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(bVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBatallas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRankingActionPerformed

   
        ArrayList<Jugador> lista = new ArrayList<>(control.getListaJugadores());

        // Ordenar de mayor a menor puntaje 
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1 - i; j++) {
                if (lista.get(j).getPuntos() < lista.get(j + 1).getPuntos()) {
                    Jugador temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }

        // Mostrar 
        txtResultado.setText("RANKING\n\n");
        for (int i = 0; i < lista.size(); i++) {
            Jugador j = lista.get(i);
            txtResultado.append((i + 1) + " — " + j.getUsername() + " — " + j.getPuntos() + "\n");
        }
    }//GEN-LAST:event_bRankingActionPerformed

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
       dispose () ;
    }//GEN-LAST:event_bVolverActionPerformed

    private void bBatallasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatallasActionPerformed
     int activos = control.getListaJugadores().size();
    int historicos = control.getUsuariosHistoricos() ;  
    int partidas = control.getHistorialPartidas().size();
    int ganaHeroes = control.contarVictorias(Bando.Heroes, 0) ;
    int ganaVillanos = control.contarVictorias(Bando.Villanos, 0) ;

    txtResultado.setText("BATALLAS\n\n");
    txtResultado.append("Usuarios activos: " + activos + "\n");
    txtResultado.append("Usuarios históricos: " + historicos + "\n");
    txtResultado.append("Partidas jugadas: " + partidas + "\n");
    txtResultado.append("Ganaron los HÉROES: " + ganaHeroes + "\n");
    txtResultado.append("Ganaron los VILLANOS: " + ganaVillanos + "\n");

    }//GEN-LAST:event_bBatallasActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatallas;
    private javax.swing.JButton bRanking;
    private javax.swing.JButton bVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
