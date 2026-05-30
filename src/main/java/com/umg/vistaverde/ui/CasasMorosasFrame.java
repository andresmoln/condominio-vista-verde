package com.umg.vistaverde.ui;

import com.umg.vistaverde.model.Casa;
import com.umg.vistaverde.service.CondominioService;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CasasMorosasFrame extends JFrame {

    private CondominioService service;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private JLabel lblConteo;

    public CasasMorosasFrame(CondominioService service) {
        this.service = service;
        initComponents();
        cargarMorosas();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Vista Verde — Casas Morosas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel panelRaiz = new JPanel(new BorderLayout());
        panelRaiz.setBackground(new Color(245, 247, 250));
        setContentPane(panelRaiz);

        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(new Color(183, 28, 28));
        panelTop.setBorder(new EmptyBorder(16, 30, 16, 30));

        JPanel panelTitulos = new JPanel();
        panelTitulos.setLayout(new BoxLayout(panelTitulos, BoxLayout.Y_AXIS));
        panelTitulos.setOpaque(false);

        JLabel lblTitulo = new JLabel("CASAS MOROSAS");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);

        int mesActual = LocalDate.now().getMonthValue();
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        JLabel lblSub = new JLabel("Casas sin pago en " + meses[mesActual - 1]
                + " " + LocalDate.now().getYear());
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblSub.setForeground(new Color(255, 205, 205));

        panelTitulos.add(lblTitulo);
        panelTitulos.add(Box.createVerticalStrut(4));
        panelTitulos.add(lblSub);

        panelTop.add(panelTitulos, BorderLayout.WEST);
        panelRaiz.add(panelTop, BorderLayout.NORTH);

        String[] columnas = {"# Casa", "Propietario", "Teléfono"};

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
        tabla.getTableHeader().setBackground(new Color(183, 28, 28));
        tabla.getTableHeader().setForeground(Color.WHITE);
        tabla.setSelectionBackground(new Color(255, 205, 205));
        tabla.setGridColor(new Color(220, 220, 220));
        tabla.setShowGrid(true);

        javax.swing.table.DefaultTableCellRenderer centrado
                = new javax.swing.table.DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(centrado);
        tabla.getColumnModel().getColumn(2).setCellRenderer(centrado);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(150);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(new EmptyBorder(10, 20, 10, 20));
        panelRaiz.add(scroll, BorderLayout.CENTER);

        JPanel panelPie = new JPanel(new BorderLayout());
        panelPie.setBackground(new Color(238, 238, 238));
        panelPie.setBorder(new EmptyBorder(12, 20, 12, 20));

        lblConteo = new JLabel("Casas morosas este mes: 0");
        lblConteo.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblConteo.setForeground(new Color(183, 28, 28));

        JButton btnVolver = new JButton("← Volver al Menú");
        btnVolver.setFont(new Font("SansSerif", Font.PLAIN, 12));
        btnVolver.setForeground(new Color(183, 28, 28));
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnVolver.addActionListener(e -> {
            new InicioFrame(service).setVisible(true);
            dispose();
        });

        panelPie.add(lblConteo, BorderLayout.WEST);
        panelPie.add(btnVolver, BorderLayout.EAST);
        panelRaiz.add(panelPie, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(520, 450));
        pack();
    }

    private void cargarMorosas() {
        modeloTabla.setRowCount(0);

        int mesActual = LocalDate.now().getMonthValue();
        int anioActual = LocalDate.now().getYear();

        ArrayList<Casa> morosas = service.listarCasasMorosas(mesActual, anioActual);

        for (Casa casa : morosas) {
            modeloTabla.addRow(new Object[]{
                casa.getNumeroCasa(),
                casa.getPropietario().getNombre(),
                casa.getPropietario().getTelefono()
            });
        }

        lblConteo.setText("Casas morosas este mes: " + morosas.size());
    }
}
