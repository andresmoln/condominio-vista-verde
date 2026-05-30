package com.umg.vistaverde.ui;

import com.umg.vistaverde.service.CondominioService;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class RegistroPropietarioFrame extends javax.swing.JFrame {

    private CondominioService service;

    private String capitalizarNombre(String nombre) {
        nombre = nombre.trim().replaceAll("\\s+", " ");

        String[] conectores = {"de", "del", "la", "las", "los", "y"};
        String[] palabras = nombre.toLowerCase().split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            boolean esConector = false;
            for (String conector : conectores) {
                if (palabra.equals(conector)) {
                    esConector = true;
                    break;
                }
            }

            if (esConector) {
                resultado.append(palabra);
            } else {
                resultado.append(Character.toUpperCase(palabra.charAt(0)));
                resultado.append(palabra.substring(1));
            }
            resultado.append(" ");
        }

        return resultado.toString().trim();
    }

    public RegistroPropietarioFrame(CondominioService service) {
        this.service = service;
        initComponents();
        cargarCasasDisponibles();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void cargarCasasDisponibles() {
        DefaultComboBoxModel<Integer> modelo = new DefaultComboBoxModel<>();
        for (int i = 1; i <= 30; i++) {
            if (!service.obtenerCasa(i).tienePropietario()) {
                modelo.addElement(i);
            }
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
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cbCasa = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre Completo");

        jLabel2.setText("Número de casa");

        jLabel3.setText("Número de teléfono");

        jLabel4.setText("Correo Electrónico");

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);

        btnVolver.setText("Volver al menú");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Registro de Propietario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnRegistrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(txtCorreo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addGap(8, 8, 8)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String nombre = capitalizarNombre(txtNombre.getText());
        String telefono = txtTelefono.getText().trim();
        String correo = txtCorreo.getText().trim().toLowerCase();

        if (nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        if (nombre.length() < 5 || nombre.length() > 60) {
            JOptionPane.showMessageDialog(this, "El nombre debe tener entre 5 y 60 caracteres.");
            return;
        }

        if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            JOptionPane.showMessageDialog(this, "El nombre solo puede contener letras y espacios.");
            return;
        }

        if (!telefono.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe contener exactamente 8 números.");
            return;
        }

        if (telefono.equals("00000000") || telefono.equals("11111111") || telefono.equals("12345678")) {
            JOptionPane.showMessageDialog(this, "Ingrese un número telefónico válido.");
            return;
        }

        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", correo)) {
            JOptionPane.showMessageDialog(this, "Ingrese un correo electrónico válido.");
            return;
        }

        if (correo.contains(" ") || correo.contains("..")) {
            JOptionPane.showMessageDialog(this, "El correo contiene caracteres inválidos.");
            return;
        }

        Integer casaSeleccionada = (Integer) cbCasa.getSelectedItem();

        if (casaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "No hay casas disponibles.");
            return;
        }

        boolean exito = service.registrarPropietario(casaSeleccionada, nombre, telefono, correo);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Propietario registrado correctamente.");
            cbCasa.removeItem(casaSeleccionada);
            txtNombre.setText("");
            txtTelefono.setText("");
            txtCorreo.setText("");
            if (cbCasa.getItemCount() > 0) {
                cbCasa.setSelectedIndex(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error: la casa ya tiene propietario.");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        new InicioFrame(service).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<Integer> cbCasa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
