package com.umg.vistaverde.ui;

import com.umg.vistaverde.service.CondominioService;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginFrame extends JFrame {

    private static final String USUARIO_VALIDO = "iusr_vistaverde";
    private static final String PASSWORD_VALIDA = "R3sidencial2026%";

    private CondominioService service;

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JLabel lblMensaje;

    public LoginFrame(CondominioService service) {
        this.service = service;
        initComponents();
        setLocationRelativeTo(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                service.guardarDatos();
            }
        });
    }

    private void initComponents() {
        setTitle("Vista Verde — Iniciar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panelRaiz = new JPanel(new BorderLayout());
        panelRaiz.setBackground(new Color(245, 247, 250));
        setContentPane(panelRaiz);

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));
        panelTop.setBackground(new Color(27, 94, 32));
        panelTop.setBorder(new EmptyBorder(24, 40, 24, 40));

        JLabel lblTitulo = new JLabel("CONDOMINIO VISTA VERDE");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSub = new JLabel("Sistema de Administración");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lblSub.setForeground(new Color(200, 230, 201));
        lblSub.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelTop.add(lblTitulo);
        panelTop.add(Box.createVerticalStrut(4));
        panelTop.add(lblSub);
        panelRaiz.add(panelTop, BorderLayout.NORTH);

        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBackground(new Color(245, 247, 250));
        panelForm.setBorder(new EmptyBorder(32, 50, 24, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(6, 8, 6, 8);

        JLabel lblAcceso = new JLabel("Acceso al Sistema");
        lblAcceso.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblAcceso.setForeground(new Color(27, 94, 32));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 8, 18, 8);
        panelForm.add(lblAcceso, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(6, 8, 6, 8);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("SansSerif", Font.PLAIN, 13));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelForm.add(lblUsuario, gbc);

        txtUsuario = new JTextField(20);
        txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 189, 189)),
                new EmptyBorder(6, 8, 6, 8)));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelForm.add(txtUsuario, gbc);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setFont(new Font("SansSerif", Font.PLAIN, 13));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelForm.add(lblPass, gbc);

        txtPassword = new JPasswordField(20);
        txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 189, 189)),
                new EmptyBorder(6, 8, 6, 8)));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelForm.add(txtPassword, gbc);

        lblMensaje = new JLabel(" ");
        lblMensaje.setFont(new Font("SansSerif", Font.ITALIC, 12));
        lblMensaje.setForeground(new Color(198, 40, 40));
        lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(4, 8, 4, 8);
        panelForm.add(lblMensaje, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 14, 0));
        panelBotones.setOpaque(false);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("SansSerif", Font.BOLD, 13));
        btnIngresar.setBackground(new Color(27, 94, 32));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorder(new EmptyBorder(9, 28, 9, 28));
        btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btnLimpiar.setBackground(new Color(224, 224, 224));
        btnLimpiar.setForeground(new Color(66, 66, 66));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setBorder(new EmptyBorder(9, 28, 9, 28));
        btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panelBotones.add(btnIngresar);
        panelBotones.add(btnLimpiar);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(12, 8, 8, 8);
        panelForm.add(panelBotones, gbc);

        panelRaiz.add(panelForm, BorderLayout.CENTER);

        JLabel lblPie = new JLabel("© 2026 Universidad Mariano Gálvez de Guatemala");
        lblPie.setFont(new Font("SansSerif", Font.PLAIN, 10));
        lblPie.setForeground(new Color(150, 150, 150));
        lblPie.setHorizontalAlignment(SwingConstants.CENTER);
        lblPie.setBorder(new EmptyBorder(6, 10, 10, 10));
        panelRaiz.add(lblPie, BorderLayout.SOUTH);

        btnIngresar.addActionListener(e -> validarCredenciales());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        txtUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtPassword.requestFocus();
                }
            }
        });

        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    validarCredenciales();
                }
            }
        });

        pack();
    }

    private void validarCredenciales() {
        String usuario = txtUsuario.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (usuario.isEmpty() || password.isEmpty()) {
            lblMensaje.setText("Ingrese usuario y contraseña.");
            return;
        }

        if (usuario.equals(USUARIO_VALIDO) && password.equals(PASSWORD_VALIDA)) {
            new InicioFrame(service).setVisible(true);
            dispose();
        } else {
            lblMensaje.setText("Usuario o contraseña incorrectos.");
            txtPassword.setText("");
            txtPassword.requestFocus();
        }
    }

    private void limpiarCampos() {
        txtUsuario.setText("");
        txtPassword.setText("");
        lblMensaje.setText(" ");
        txtUsuario.requestFocus();
    }
}
