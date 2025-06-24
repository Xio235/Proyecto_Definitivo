package Medicos;

import utils.BackgroundPanel;
import Medicos.RoundedPanel;

import javax.swing.*;
import java.awt.*;

public class PacientesAsignadosFrame extends JFrame {
    public PacientesAsignadosFrame(String nombres, String apellidos) {
        setTitle("PACIENTES ASIGNADOS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 800);

        // Background panel
        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/FondoRegistro.jpg");
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));

        JButton menuButton = new JButton("≡");
        menuButton.setFocusPainted(false);
        menuButton.setPreferredSize(new Dimension(60, 60));

        JSeparator separator1 = new JSeparator(SwingConstants.VERTICAL);
        separator1.setPreferredSize(new Dimension(1, 30));

        JLabel medicoLabel = new JLabel("MÉDICO", SwingConstants.CENTER);
        Font font = medicoLabel.getFont().deriveFont(Font.BOLD);
        medicoLabel.setFont(font);

        JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
        separator2.setPreferredSize(new Dimension(1, 30));

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Images/IconoUsuario.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        JLabel userIcon = new JLabel(new ImageIcon(scaledImage));

        headerPanel.add(menuButton);
        headerPanel.add(separator1);
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.add(medicoLabel);
        headerPanel.add(Box.createHorizontalGlue());
        headerPanel.add(separator2);
        headerPanel.add(userIcon);

        JPanel headerContainer = new JPanel();
        headerContainer.setLayout(new BorderLayout());
        headerContainer.setOpaque(false);
        headerContainer.add(headerPanel, BorderLayout.NORTH);

        JSeparator horizontalSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        headerContainer.add(horizontalSeparator, BorderLayout.SOUTH);

        backgroundPanel.add(headerContainer, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("<html><center>VER PACIENTES<br>ASIGNADOS</center></html>", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(titleLabel);

        // Imagen
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/PacienteAsignado.png"));
        Image scaledImageIcon = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImageIcon));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(imageLabel);

        // Panel con encabezados como en la imagen
        RoundedPanel encabezadoPanel = new RoundedPanel(20);
        encabezadoPanel.setBackground(new Color(216, 174, 179)); // Color rosado
        encabezadoPanel.setLayout(new GridLayout(1, 3, 10, 0));
        encabezadoPanel.setMaximumSize(new Dimension(360, 47));
        encabezadoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        encabezadoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Font encabezadoFont = new Font("Arial", Font.BOLD, 12);
        JLabel cedulaLabel = new JLabel("<html><center>CEDULA DEL<br>PACIENTE:</center></html>", SwingConstants.CENTER);
        cedulaLabel.setFont(encabezadoFont);
        cedulaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel fechaLabel = new JLabel("<html><center>FECHA DE<br>ATENCIÓN:</center></html>", SwingConstants.CENTER);
        fechaLabel.setFont(encabezadoFont);
        fechaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel verLabel = new JLabel("<html><center>VER<br>INFORMACION:</center></html>", SwingConstants.CENTER);
        verLabel.setFont(encabezadoFont);
        verLabel.setHorizontalAlignment(SwingConstants.CENTER);

        encabezadoPanel.add(cedulaLabel);
        encabezadoPanel.add(fechaLabel);
        encabezadoPanel.add(verLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(encabezadoPanel);

        backgroundPanel.add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
