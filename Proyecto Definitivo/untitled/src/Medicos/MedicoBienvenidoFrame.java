package Medicos;

import utils.BackgroundPanel;
import Pacientes.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class MedicoBienvenidoFrame extends JFrame {
    public MedicoBienvenidoFrame(String nombres, String apellidos) {
        setTitle("BIENVENIDO " + nombres.toUpperCase() + " " + apellidos.toUpperCase());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 800);

        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/FondoRegistro.jpg");
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

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

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("BIENVENIDO " + nombres.toUpperCase() + " " + apellidos.toUpperCase(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        centerPanel.add(welcomeLabel);

        // Add the image below the title
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/VentanaMedico.png"));
        Image scaledImageIcon = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImageIcon));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        centerPanel.add(imageLabel);

        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        // Create the popup menu
        JPopupMenu popupMenu = new JPopupMenu();

        // Add menu title
        JLabel menuTitle = new JLabel("MENU");
        menuTitle.setFont(new Font("Arial", Font.BOLD, 14));
        menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
        menuTitle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        popupMenu.add(menuTitle);
        popupMenu.addSeparator();

        // Add buttons below the image
        JButton verPacientesButton = new JButton("VER PACIENTES ASIGNADOS");
        verPacientesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verPacientesButton.setBackground(new Color(244, 191, 198)); // Button color
        verPacientesButton.setForeground(Color.BLACK); // Text color
        verPacientesButton.setFocusPainted(false);
        verPacientesButton.setPreferredSize(new Dimension(200, 50)); // Button size
        verPacientesButton.setBorder(new RoundedBorder(20)); // Rounded corners

        verPacientesButton.addActionListener(e -> {
            new PacientesAsignadosFrame(nombres, apellidos); // Open the new frame
            dispose(); // Close the current frame
        });

        JButton editarDatosButton = new JButton("EDITAR DATOS");
        editarDatosButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editarDatosButton.setBackground(new Color(244, 191, 198)); // Button color
        editarDatosButton.setForeground(Color.BLACK); // Text color
        editarDatosButton.setFocusPainted(false);
        editarDatosButton.setPreferredSize(new Dimension(200, 50)); // Button size
        editarDatosButton.setBorder(new RoundedBorder(20)); // Rounded corners

        editarDatosButton.addActionListener(e -> {
            System.out.println("Abrir ventana para editar datos");
            // Add logic to open the edit data window
        });

// Add buttons to the panel
        centerPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Spacing below the image
        centerPanel.add(verPacientesButton);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Spacing between buttons
        centerPanel.add(editarDatosButton);


        // Add menu items
        JMenuItem inicioItem = new JMenuItem("INICIO");
        JMenuItem pacientesItem = new JMenuItem("PACIENTES");
        JMenuItem medicosItem = new JMenuItem("MÉDICOS");
        JMenuItem informacionItem = new JMenuItem("INFORMACIÓN");
        JMenuItem cerrarSesionItem = new JMenuItem("CERRAR SESIÓN");

        popupMenu.add(inicioItem);
        popupMenu.add(pacientesItem);
        popupMenu.add(medicosItem);
        popupMenu.add(informacionItem);
        popupMenu.add(cerrarSesionItem);

        // Show menu on button click
        menuButton.addActionListener(e -> popupMenu.show(menuButton, 0, menuButton.getHeight()));

        // Define actions for menu items
        inicioItem.addActionListener(e -> {
            new Pacientes.Main().main(null); // Open the main window
            dispose(); // Close the current frame
        });

        pacientesItem.addActionListener(e -> {
            new Pacientes.PacienteFrame().setVisible(true); // Open the Pacientes frame
            dispose(); // Close the current frame
        });

        medicosItem.addActionListener(e -> {
            System.out.println("Ya estás en la ventana de MÉDICO.");
        });

        informacionItem.addActionListener(e -> {
            System.out.println("Abrir ventana de INFORMACIÓN");
            // Add logic to open the INFORMACIÓN frame
        });

        cerrarSesionItem.addActionListener(e -> {
            System.out.println("Cerrar sesión");
            // Add logic to handle session logout
        });

        setVisible(true);
    }


}
