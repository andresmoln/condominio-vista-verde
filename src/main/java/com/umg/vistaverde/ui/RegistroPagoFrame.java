package com.umg.vistaverde.ui;

import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import com.umg.vistaverde.service.CondominioService;

public class RegistroPagoFrame extends javax.swing.JFrame {

    private CondominioService service;

    public RegistroPagoFrame(CondominioService service) {
        this.service = service;
        initComponents();
        cargarCasas();
        txtMonto.setText(String.format("Q%.2f", service.obtenerCuotaActual()));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void cargarCasas() {
        DefaultComboBoxModel<Integer> modelo = new DefaultComboBoxModel<>();
        for (int i = 1; i <= 30; i++) {
            modelo.addElement(i);
        }
        cbCasa.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrarPago = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cbCasa = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAnio = new javax.swing.JComboBox<>();
        txtMonto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Número de Casa");

        jLabel3.setText("Mes");

        jLabel4.setText("Año");

        jLabel5.setText("Monto");

        btnRegistrarPago.setText("Registrar Pago");
        btnRegistrarPago.addActionListener(this::btnRegistrarPagoActionPerformed);

        btnVolver.setText("Volver al Menú");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        cbAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2026", "2027", "2028" }));

        txtMonto.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Registro de Pago de Cuota");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnRegistrarPago))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVolver)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbMes, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbCasa, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbAnio, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMonto, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addComponent(jLabel6)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarPago)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPagoActionPerformed
        Integer casa = (Integer) cbCasa.getSelectedItem();
        String mes = cbMes.getSelectedItem().toString();
        int numeroMes = cbMes.getSelectedIndex() + 1;
        int anioSeleccionado = Integer.parseInt(cbAnio.getSelectedItem().toString());
        int anioActual = LocalDate.now().getYear();

        if (anioSeleccionado > anioActual) {
            JOptionPane.showMessageDialog(this, "No se permiten pagos de años futuros.");
            return;
        }

        int mesActual = LocalDate.now().getMonthValue();

        if (anioSeleccionado == anioActual && numeroMes > mesActual) {
            JOptionPane.showMessageDialog(this, "No se permiten pagos de meses futuros.");
            return;
        }

        boolean exito = service.registrarPago(casa, numeroMes, anioSeleccionado);

        if (exito) {
            JOptionPane.showMessageDialog(this,
                    "Pago registrado correctamente.\n\n"
                    + "Casa: " + casa + "\n"
                    + "Mes: " + mes + " " + anioSeleccionado + "\n"
                    + String.format("Monto: Q%.2f", service.obtenerCuotaActual())
            );
            cbCasa.setSelectedIndex(0);
            cbMes.setSelectedIndex(0);
            cbAnio.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Error: no se pudo registrar el pago.\n"
                    + "Puede ser por:\n"
                    + "- Pago duplicado\n"
                    + "- Meses anteriores sin pagar\n"
                    + "- Casa sin propietario"
            );
        }
    }//GEN-LAST:event_btnRegistrarPagoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        new InicioFrame(service).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarPago;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbAnio;
    private javax.swing.JComboBox<Integer> cbCasa;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
