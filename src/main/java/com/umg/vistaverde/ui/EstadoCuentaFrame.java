package com.umg.vistaverde.ui;

import com.umg.vistaverde.service.CondominioService;
import com.umg.vistaverde.model.Casa;
import java.time.LocalDate;

public class EstadoCuentaFrame extends javax.swing.JFrame {

    private CondominioService service;

    public EstadoCuentaFrame(CondominioService service) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.service = service;
        cargarCasas();
    }

    private void cargarCasas() {
        for (int i = 1; i <= 30; i++) {
            cmbCasa.addItem(String.valueOf(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCasa = new javax.swing.JComboBox<>();
        btnConsultar = new javax.swing.JButton();
        lblPropietario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPagados = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPendientes = new javax.swing.JTextArea();
        lblTotalPagado = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setText("ESTADO DE CUENTA POR CASA");

        jLabel2.setText("Número de casa:");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        lblPropietario.setText("Propietario:");

        txtPagados.setColumns(20);
        txtPagados.setRows(5);
        jScrollPane1.setViewportView(txtPagados);

        txtPendientes.setColumns(20);
        txtPendientes.setRows(5);
        jScrollPane2.setViewportView(txtPendientes);

        lblTotalPagado.setText("Total pagados: Q0.00");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel3.setText("Meses pagados:");

        jLabel4.setText("Meses pendientes:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(lblPropietario))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblTotalPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnVolver)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(27, 27, 27)
                .addComponent(lblPropietario)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30)
                .addComponent(lblTotalPagado)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String[] nombresMeses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        int numeroCasa = Integer.parseInt(cmbCasa.getSelectedItem().toString());
        Casa casa = service.obtenerCasa(numeroCasa);
        int anioActual = LocalDate.now().getYear();

        if (casa.tienePropietario()) {
            lblPropietario.setText(
                    "Propietario: "
                    + casa.getPropietario().getNombre()
            );
        } else {
            lblPropietario.setText(
                    "Propietario: Sin propietario"
            );
        }

        String mesesPagados = "No hay pagos registrados";
        if (!casa.getPagos().isEmpty()) {
            mesesPagados = "";
            for (int mes = 1; mes <= 12; mes++) {
                if (casa.yaPago(mes, anioActual)) {
                    mesesPagados += nombresMeses[mes - 1] + "\n";
                }
            }
        }
        txtPagados.setText(mesesPagados);

        String mesesPendientes = "";
        for (int mes = 1; mes <= 12; mes++) {
            if (!casa.yaPago(mes, anioActual)) {
                mesesPendientes += nombresMeses[mes - 1] + "\n";
            }
        }
        txtPendientes.setText(mesesPendientes);

        lblTotalPagado.setText(String.format("Total pagado: Q%.2f", casa.getTotalPagado()));
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        new InicioFrame(service).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbCasa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPropietario;
    private javax.swing.JLabel lblTotalPagado;
    private javax.swing.JTextArea txtPagados;
    private javax.swing.JTextArea txtPendientes;
    // End of variables declaration//GEN-END:variables
}
