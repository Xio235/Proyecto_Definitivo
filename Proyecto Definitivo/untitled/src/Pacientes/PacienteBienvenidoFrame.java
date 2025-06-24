package Pacientes;

import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;


public class PacienteBienvenidoFrame extends JFrame {


    public PacienteBienvenidoFrame(String nombre, String apellido, String medicoAsignado) {
        setTitle("BIENVENIDO " + nombre + " " + apellido);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 800);

        // Background panel
        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/FondoRegistro.jpg");
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        // Top panel (header)
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        // Menu button
        JButton menuButton = new JButton("≡");
        menuButton.setFocusPainted(false);
        menuButton.setPreferredSize(new Dimension(60, 60));

        // Separators and "PACIENTE" label
        JSeparator separator1 = new JSeparator(SwingConstants.VERTICAL);
        separator1.setPreferredSize(new Dimension(1, 30));
        JLabel pacienteLabel = new JLabel("PACIENTE", SwingConstants.CENTER);
        pacienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
        separator2.setPreferredSize(new Dimension(1, 30));

        // User icon
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Images/IconoUsuario.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        JLabel userIcon = new JLabel(new ImageIcon(scaledImage));

        // Add components to topPanel
        topPanel.add(menuButton);
        topPanel.add(separator1);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(pacienteLabel);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(separator2);
        topPanel.add(userIcon);

        // Wrap topPanel and separator in another panel to stack them vertically
        JPanel headerContainer = new JPanel();
        headerContainer.setLayout(new BorderLayout());
        headerContainer.setOpaque(false);
        headerContainer.add(topPanel, BorderLayout.NORTH);

        // Horizontal separator just below top content
        JSeparator horizontalSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        headerContainer.add(horizontalSeparator, BorderLayout.SOUTH);

        // Add the whole header (menu + separator) to the top of the background panel
        backgroundPanel.add(headerContainer, BorderLayout.NORTH);

        // Center panel (for future customization)
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("BIENVENIDO " + nombre.toUpperCase() + " " + apellido.toUpperCase(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Spacing
        centerPanel.add(titleLabel);

        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);

        // Crear el menú emergente
        JPopupMenu popupMenu = new JPopupMenu();

        // Image below the title
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/ImagenInicio2.png"));
        Image scaledImageIcon = imageIcon.getImage().getScaledInstance(300, 170, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImageIcon));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        centerPanel.add(imageLabel);

        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        setVisible(true);


// Crear un título para el menú
        JLabel menuTitle = new JLabel("MENU");
        menuTitle.setFont(new Font("Arial", Font.BOLD, 14));
        menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
        menuTitle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Espaciado alrededor del título

// Agregar el título al menú
        popupMenu.add(menuTitle);
        popupMenu.addSeparator(); // Línea separadora debajo del título

// Crear los elementos del menú
        JMenuItem inicioItem = new JMenuItem("INICIO");
        JMenuItem pacientesItem = new JMenuItem("PACIENTES");
        JMenuItem medicosItem = new JMenuItem("MEDICOS");
        JMenuItem informacionItem = new JMenuItem("INFORMACION");
        JMenuItem cerrarSesionItem = new JMenuItem("CERRAR SESIÓN");

// Agregar los elementos al menú
        popupMenu.add(inicioItem);
        popupMenu.add(pacientesItem);
        popupMenu.add(medicosItem);
        popupMenu.add(informacionItem);
        popupMenu.add(cerrarSesionItem);

// Agregar un ActionListener al botón para mostrar el menú
        menuButton.addActionListener(e -> popupMenu.show(menuButton, 0, menuButton.getHeight()));

// Configurar las acciones de los elementos del menú
        inicioItem.addActionListener(e -> {
            new Main().main(null); // Abrir la ventana principal
            dispose(); // Cerrar la ventana actual
        });

        pacientesItem.addActionListener(e -> {
            System.out.println("Ya estás en la ventana de PACIENTE.");
        });

        medicosItem.addActionListener(e -> {
            System.out.println("Abrir ventana de MÉDICOS");
            // Lógica para abrir la ventana de MÉDICOS
        });

        informacionItem.addActionListener(e -> {
            System.out.println("Abrir ventana de INFORMACIÓN");
            // Lógica para abrir la ventana de INFORMACIÓN
        });

        cerrarSesionItem.addActionListener(e -> {
            System.out.println("Cerrar sesión");
            // Lógica para cerrar sesión
        });



// Usage in your frame
        JButton verCitaButton = new JButton("VER CITA MEDICA");
        verCitaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verCitaButton.setBackground(new Color(244, 191, 198)); // Button color
        verCitaButton.setForeground(Color.BLACK); // Text color
        verCitaButton.setFocusPainted(false);
        verCitaButton.setPreferredSize(new Dimension(200, 50)); // Larger size
        verCitaButton.setBorder(new RoundedBorder(20)); // Rounded corners

// Add ActionListener to "VER CITA MEDICA" button
        verCitaButton.addActionListener(e -> {
            dispose(); // Close the current frame (Pacientes.PacienteBienvenidoFrame)
            int edad = RegistroFrame.getPatientAge(); // Get the patient's age
            int etapa = RegistroEtapaFrame.getRenalStage(); // Get the renal stage
            new CitaMedicaFrame(etapa, edad, medicoAsignado, this); // Pass the current frame as a reference
        });


        JButton editarDatosButton = new JButton("EDITAR DATOS");
        editarDatosButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editarDatosButton.setBackground(new Color(244, 191, 198)); // Button color
        editarDatosButton.setForeground(Color.BLACK); // Text color
        editarDatosButton.setFocusPainted(false);
        editarDatosButton.setPreferredSize(new Dimension(200, 50)); // Larger size
        editarDatosButton.setBorder(new RoundedBorder(20)); // Rounded corners

// Add buttons to the panel
        centerPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Spacing below the image
        centerPanel.add(verCitaButton);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Spacing between buttons
        centerPanel.add(editarDatosButton);


    }
}
