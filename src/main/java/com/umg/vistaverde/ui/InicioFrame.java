package com.umg.vistaverde.ui;

import com.umg.vistaverde.service.CondominioService;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class InicioFrame extends JFrame {

    private CondominioService service;

    public InicioFrame(CondominioService service) {
        this.service = service;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        setTitle("Vista Verde — Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panelRaiz = new JPanel(new BorderLayout(0, 0));
        panelRaiz.setBackground(new Color(245, 247, 250));
        setContentPane(panelRaiz);

        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(new Color(27, 94, 32));
        panelTop.setBorder(new EmptyBorder(20, 30, 20, 30));

        JPanel panelIzq = new JPanel();
        panelIzq.setLayout(new BoxLayout(panelIzq, BoxLayout.Y_AXIS));
        panelIzq.setOpaque(false);

        JLabel lblNombre = new JLabel("CONDOMINIO VISTA VERDE");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblNombre.setForeground(Color.WHITE);

        JLabel lblSistema = new JLabel("Sistema de Administración");
        lblSistema.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblSistema.setForeground(new Color(200, 230, 201));

        panelIzq.add(lblNombre);
        panelIzq.add(Box.createVerticalStrut(3));
        panelIzq.add(lblSistema);

        JPanel panelDer = new JPanel();
        panelDer.setLayout(new BoxLayout(panelDer, BoxLayout.Y_AXIS));
        panelDer.setOpaque(false);

        LocalDate hoy = LocalDate.now();
        String mesAnio = hoy.format(DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("es", "GT")));
        mesAnio = Character.toUpperCase(mesAnio.charAt(0)) + mesAnio.substring(1);

        JLabel lblFecha = new JLabel(mesAnio);
        lblFecha.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblFecha.setForeground(Color.WHITE);
        lblFecha.setAlignmentX(Component.RIGHT_ALIGNMENT);

        JLabel lblBienvenida = new JLabel("Bienvenido, Administrador");
        lblBienvenida.setFont(new Font("SansSerif", Font.ITALIC, 12));
        lblBienvenida.setForeground(new Color(200, 230, 201));
        lblBienvenida.setAlignmentX(Component.RIGHT_ALIGNMENT);

        panelDer.add(lblFecha);
        panelDer.add(Box.createVerticalStrut(4));
        panelDer.add(lblBienvenida);

        panelTop.add(panelIzq, BorderLayout.WEST);
        panelTop.add(panelDer, BorderLayout.EAST);
        panelRaiz.add(panelTop, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBackground(new Color(245, 247, 250));
        panelCentral.setBorder(new EmptyBorder(28, 40, 24, 40));

        JLabel lblModulos = new JLabel("Módulos del Sistema");
        lblModulos.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblModulos.setForeground(new Color(60, 60, 60));
        lblModulos.setBorder(new EmptyBorder(0, 0, 14, 0));
        panelCentral.add(lblModulos, BorderLayout.NORTH);

        JPanel panelGrid = new JPanel(new GridLayout(2, 3, 14, 14));
        panelGrid.setOpaque(false);

        panelGrid.add(crearBoton("Registro de\nPropietario", new Color(21, 101, 192), () -> {
            new RegistroPropietarioFrame(service).setVisible(true);
            dispose();
        }));
        panelGrid.add(crearBoton("Registro de\nPago", new Color(106, 27, 154), () -> {
            new RegistroPagoFrame(service).setVisible(true);
            dispose();
        }));
        panelGrid.add(crearBoton("Configuración\nde Cuota", new Color(230, 81, 0), () -> {
            new ConfiguracionCuotaFrame(service).setVisible(true);
            dispose();
        }));
        panelGrid.add(crearBoton("Estado de\nCuenta", new Color(0, 105, 92), () -> {
            new EstadoCuentaFrame(service).setVisible(true);
            dispose();
        }));
        panelGrid.add(crearBoton("Reporte\nGeneral", new Color(136, 14, 79), () -> {
            new ReporteGeneralFrame(service).setVisible(true);
            dispose();
        }));
        panelGrid.add(crearBoton("Casas\nMorosas", new Color(183, 28, 28), () -> {
            new CasasMorosasFrame(service).setVisible(true);
            dispose();
        }));

        panelCentral.add(panelGrid, BorderLayout.CENTER);
        panelRaiz.add(panelCentral, BorderLayout.CENTER);

        JPanel panelPie = new JPanel(new BorderLayout());
        panelPie.setBackground(new Color(238, 238, 238));
        panelPie.setBorder(new EmptyBorder(8, 20, 8, 20));

        JLabel lblPie = new JLabel("© 2026 Universidad Mariano Gálvez de Guatemala — Programación I");
        lblPie.setFont(new Font("SansSerif", Font.PLAIN, 10));
        lblPie.setForeground(new Color(150, 150, 150));

        JButton btnCerrar = new JButton("Cerrar Sesión");
        btnCerrar.setFont(new Font("SansSerif", Font.PLAIN, 11));
        btnCerrar.setForeground(new Color(198, 40, 40));
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(e -> cerrarSesion());

        panelPie.add(lblPie, BorderLayout.WEST);
        panelPie.add(btnCerrar, BorderLayout.EAST);
        panelRaiz.add(panelPie, BorderLayout.SOUTH);

        pack();
    }

    private JButton crearBoton(String texto, Color colorAcento, Runnable accion) {
        String html = "<html><center>" + texto.replace("\n", "<br>") + "</center></html>";

        JButton btn = new JButton(html) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isPressed() ? new Color(240, 240, 240)
                        : getModel().isRollover() ? new Color(250, 250, 250) : Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2.setColor(colorAcento);
                g2.fillRoundRect(0, 0, getWidth(), 5, 4, 4);
                g2.dispose();
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isRollover() ? colorAcento : new Color(220, 220, 220));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                g2.dispose();
            }
        };

        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setForeground(new Color(40, 40, 40));
        btn.setPreferredSize(new Dimension(165, 78));
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setOpaque(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addActionListener(e -> accion.run());

        return btn;
    }

    private void cerrarSesion() {
        int op = JOptionPane.showConfirmDialog(this,
                "¿Desea cerrar la sesión?", "Cerrar Sesión",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            service.guardarDatos();
            new LoginFrame(service).setVisible(true);
            dispose();
        }
    }
}
