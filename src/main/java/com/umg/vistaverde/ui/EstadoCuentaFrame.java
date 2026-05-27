
package com.umg.vistaverde.ui;
import com.umg.vistaverde.model.Condominio;
import com.umg.vistaverde.service.CondominioService;
import com.umg.vistaverde.model.Casa;



public class EstadoCuentaFrame extends javax.swing.JFrame {
private Condominio condominio;
private CondominioService service;
   


    public EstadoCuentaFrame() {
        initComponents();
        
    condominio = new Condominio();
    service = new CondominioService(condominio);

    cargarCasas();
        
    }

   private void cargarCasas (){
       
       for (int i=1; i <= 30; i++){
           
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

        jLabel3.setText("Meses pagados:");

        jLabel4.setText("Meses pendientes:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(lblTotalPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(lblPropietario)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(18, 18, 18)
                .addComponent(lblPropietario)
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalPagado)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
      
      String casaSeleccionada = cmbCasa.getSelectedItem().toString();
      int numeroCasa = Integer.parseInt(casaSeleccionada);
      Casa casa = service.obtenerCasa(numeroCasa);
      
  if (casa.tienePropietario()) {

    lblPropietario.setText(
            "Propietario: " +
            casa.getPropietario().getNombre()
    );

} else {

    lblPropietario.setText(
            "Propietario: Sin propietario"
       );

     }
      
    }//GEN-LAST:event_btnConsultarActionPerformed

   
    public static void main(String args[]) {


 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadoCuentaFrame().setVisible(true);
            }
        });
    }

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
