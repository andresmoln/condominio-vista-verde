package com.umg.vistaverde.ui;

import com.umg.vistaverde.service.CondominioService;
import javax.swing.JOptionPane;

public class ConfiguracionCuotaFrame extends javax.swing.JFrame {

    private CondominioService service;

    public ConfiguracionCuotaFrame(CondominioService service) {
        this.service = service;
        initComponents();
        this.setLocationRelativeTo(null);
        lblCuotaActual.setText(
                String.format("Cuota actual: Q%.2f", service.obtenerCuotaActual())
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
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Configuración de Cuota");

        lblCuotaActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCuotaActual.setText("Cuota Actual: Q1500.00");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nueva Cuota");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCuotaActual)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNuevaCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

        if (!textoCuota.matches("^\\d+(\\.\\d{1,2})?$")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese una cantidad válida con máximo 2 decimales"
            );
            return;
        }

        try {
            double nuevaCuota = Double.parseDouble(textoCuota);

            if (nuevaCuota < 100 || nuevaCuota > 100000) {
                JOptionPane.showMessageDialog(
                        this,
                        "La cuota debe estar entre Q100 y Q100000"
                );
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cambiar la cuota a Q" + nuevaCuota + "?", "Confirmar actualización", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                service.actualizarCuota(nuevaCuota);
                lblCuotaActual.setText(
                        String.format("Cuota actual: Q%.2f", service.obtenerCuotaActual())
                );
                JOptionPane.showMessageDialog(this,
                        "Cuota actualizada correctamente");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido");
        }
    }//GEN-LAST:event_btnActualizarCuotaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        new InicioFrame(service).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCuota;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCuotaActual;
    private javax.swing.JTextField txtNuevaCuota;
    // End of variables declaration//GEN-END:variables
}
