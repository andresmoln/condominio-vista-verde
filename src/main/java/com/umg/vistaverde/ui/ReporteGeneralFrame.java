package com.umg.vistaverde.ui;

import com.umg.vistaverde.model.Casa;
import com.umg.vistaverde.model.Pago;
import com.umg.vistaverde.service.CondominioService;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

/**
 * Pantalla de Reporte General
 * Sistema de Administración de Condominio Vista Verde
 * Universidad Mariano Gálvez de Guatemala — Programación I
 *
 * @author Alex Zelada
 */
public class ReporteGeneralFrame extends JFrame {

    private CondominioService service;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JLabel lblTotalRecaudado;
    private JLabel lblTotalEsperado;

    public ReporteGeneralFrame(CondominioService service) {
        this.service = service;
        initComponents();
        cargarReporte();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Vista Verde — Reporte General");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panelRaiz = new JPanel(new BorderLayout());
        panelRaiz.setBackground(new Color(245, 247, 250));
        setContentPane(panelRaiz);

        // ── ENCABEZADO ────────────────────────────────────────────────────
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(new Color(136, 14, 79));
        panelTop.setBorder(new EmptyBorder(16, 30, 16, 30));

        JLabel lblTitulo = new JLabel("REPORTE GENERAL DE PAGOS");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);

        JLabel lblSub = new JLabel("Resumen de las 30 casas del condominio");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblSub.setForeground(new Color(240, 200, 220));

        JPanel panelTitulos = new JPanel();
        panelTitulos.setLayout(new BoxLayout(panelTitulos, BoxLayout.Y_AXIS));
        panelTitulos.setOpaque(false);
        panelTitulos.add(lblTitulo);
        panelTitulos.add(Box.createVerticalStrut(4));
        panelTitulos.add(lblSub);

        panelTop.add(panelTitulos, BorderLayout.WEST);
        panelRaiz.add(panelTop, BorderLayout.NORTH);

        // ── TABLA ─────────────────────────────────────────────────────────
        String[] columnas = {
            "# Casa", "Propietario", "Estado Mes Actual", "Total Pagado en el Año"
        };

        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modeloTabla);
        tabla.setFont(new Font("SansSerif", Font.PLAIN, 13));
        tabla.setRowHeight(28);
        tabla.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        tabla.getTableHeader().setBackground(new Color(136, 14, 79));
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.setSelectionBackground(new Color(248, 187, 208));
        tabla.setGridColor(new Color(220, 220, 220));
        tabla.setShowGrid(true);

        // Centrar columnas
        javax.swing.table.DefaultTableCellRenderer centrado =
            new javax.swing.table.DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(centrado);
        tabla.getColumnModel().getColumn(2).setCellRenderer(centrado);
        tabla.getColumnModel().getColumn(3).setCellRenderer(centrado);

        // Anchos de columna
        tabla.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(180);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(new EmptyBorder(10, 20, 10, 20));
        panelRaiz.add(scroll, BorderLayout.CENTER);

        // ── PIE CON TOTALES ───────────────────────────────────────────────
        JPanel panelPie = new JPanel(new BorderLayout());
        panelPie.setBackground(new Color(238, 238, 238));
        panelPie.setBorder(new EmptyBorder(12, 20, 12, 20));

        JPanel panelTotales = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 0));
        panelTotales.setOpaque(false);

        lblTotalRecaudado = new JLabel("Total recaudado este mes: Q0.00");
        lblTotalRecaudado.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblTotalRecaudado.setForeground(new Color(27, 94, 32));

        lblTotalEsperado = new JLabel("Total esperado: Q0.00");
        lblTotalEsperado.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblTotalEsperado.setForeground(new Color(136, 14, 79));

        panelTotales.add(lblTotalRecaudado);
        panelTotales.add(lblTotalEsperado);

        JButton btnVolver = new JButton("← Volver al Menú");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnVolver.setForeground(new Color(136, 14, 79));
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnVolver.addActionListener(e -> {
            new InicioFrame(service).setVisible(true);
            dispose();
        });

        panelPie.add(panelTotales, BorderLayout.WEST);
        panelPie.add(btnVolver, BorderLayout.EAST);
        panelRaiz.add(panelPie, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(680, 520));
        pack();
    }

    private void cargarReporte() {
        modeloTabla.setRowCount(0);

        int mesActual = LocalDate.now().getMonthValue();
        int anioActual = LocalDate.now().getYear();

        double totalRecaudadoMes = 0;

        for (int i = 1; i <= 30; i++) {
            Casa casa = service.obtenerCasa(i);

            String propietario = casa.tienePropietario()
                    ? casa.getPropietario().getNombre()
                    : "Sin propietario";

            // Estado del mes actual
            boolean pagadoEsteMes = false;
            double totalAnio = 0;

            for (Pago pago : casa.getPagos()) {
                if (pago.getMes() == mesActual && pago.getAnio() == anioActual) {
                    pagadoEsteMes = true;
                }
                if (pago.getAnio() == anioActual) {
                    totalAnio += pago.getMonto();
                }
            }

            if (pagadoEsteMes) {
                totalRecaudadoMes += service.obtenerCuotaActual();
            }

            String estado = pagadoEsteMes ? "✓ Pagado" : "✗ Pendiente";
            String totalStr = "Q" + String.format("%.2f", totalAnio);

            modeloTabla.addRow(new Object[]{
                i, propietario, estado, totalStr
            });
        }

        double totalEsperado = 30 * service.obtenerCuotaActual();

        lblTotalRecaudado.setText("Total recaudado este mes: Q" +
                String.format("%.2f", totalRecaudadoMes));
        lblTotalEsperado.setText("Total esperado: Q" +
                String.format("%.2f", totalEsperado));
    }
}
