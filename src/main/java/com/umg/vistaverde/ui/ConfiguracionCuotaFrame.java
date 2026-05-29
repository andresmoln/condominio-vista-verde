
package com.umg.vistaverde.ui;
import com.umg.vistaverde.model.Condominio;
import com.umg.vistaverde.service.CondominioService;
import javax.swing.JOptionPane;


public class ConfiguracionCuotaFrame extends javax.swing.JFrame {

   
   private CondominioService service;
    
    
    public ConfiguracionCuotaFrame(CondominioService service) {
      
        
       this.service = service;

       initComponents();
       this.setLocationRelativeTo(null);
       lblCuotaActual.setText(
            "Cuota actual: Q" +
            service.obtenerCuotaActual()
       );

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCuotaActual = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNuevaCuota = new javax.swing.JTextField();
        btnActualizarCuota = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Configuración de Cuota");

        lblCuotaActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCuotaActual.setText("Cuota Actual: Q1500.00");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nueva Cuota");

        txtNuevaCuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevaCuotaActionPerformed(evt);
            }
        });

        btnActualizarCuota.setBackground(new java.awt.Color(0, 153, 102));
        btnActualizarCuota.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCuota.setText("Actualizar Cuota");
        btnActualizarCuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCuotaActionPerformed(evt);
            }
        });

        btnVolver.setForeground(new java.awt.Color(255, 51, 51));
        btnVolver.setText("<-- Volver al menú principal");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCuotaActual)
                        .addContainerGap(232, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNuevaCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(148, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnActualizarCuota)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(lblCuotaActual)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNuevaCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnActualizarCuota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarCuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCuotaActionPerformed
        
        String textoCuota = txtNuevaCuota.getText();
        
        try {
            
        
        double nuevaCuota = Double.parseDouble(textoCuota);
        
        if (nuevaCuota <= 0 ){
            JOptionPane.showMessageDialog(this,"la cuota no puede ser cero o negativa");
            
            return;    
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cambiar la cuota a Q" + nuevaCuota +"?","Confirmar actualización", JOptionPane.YES_NO_OPTION);
           
        if (confirmacion == JOptionPane.YES_OPTION){
            service.actualizarCuota(nuevaCuota);
            lblCuotaActual.setText("Cuota actual: Q" + service.obtenerCuotaActual());
            
            JOptionPane.showMessageDialog(this,
            "Cuota actualizada correctamente");
        }
        }
        
        catch (NumberFormatException e){
            
                JOptionPane.showMessageDialog(this, "Ingrese un número válido");
                }
        
    }//GEN-LAST:event_btnActualizarCuotaActionPerformed

    private void txtNuevaCuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevaCuotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNuevaCuotaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionCuotaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionCuotaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionCuotaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionCuotaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new ConfiguracionCuotaFrame(service).setVisible(true);
              Condominio condominio = new Condominio();
              CondominioService service = new CondominioService(condominio);
              
              new ConfiguracionCuotaFrame(service).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCuota;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCuotaActual;
    private javax.swing.JTextField txtNuevaCuota;
    // End of variables declaration//GEN-END:variables
}
