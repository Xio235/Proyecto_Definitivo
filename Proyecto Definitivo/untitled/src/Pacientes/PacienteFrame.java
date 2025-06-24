package Pacientes;

import utils.BackgroundPanel;
import utils.UserStorage;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class PacienteFrame extends JFrame {

    public PacienteFrame() {
        try {
            System.out.println("Pacientes.PacienteFrame is being loaded...");

            setTitle("PACIENTE");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 800);

            // Create the background panel
            BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/Anemia.jpg");
            backgroundPanel.setLayout(new BorderLayout());
            setContentPane(backgroundPanel);

            // Create a transparent top panel
            JPanel topPanel = new JPanel();
            topPanel.setOpaque(false);
            topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

            // Header panel
            JPanel headerPanel = new JPanel();
            headerPanel.setOpaque(false);
            headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));

            // Menu button
            JButton menuButton = new JButton("≡");
            menuButton.setFocusPainted(false);
            menuButton.setPreferredSize(new Dimension(60, 60));

            // Separators and "PACIENTE" label
            JSeparator separator1 = new JSeparator(SwingConstants.VERTICAL);
            separator1.setPreferredSize(new Dimension(1, 30));
            JLabel pacienteLabel = new JLabel("PACIENTE", SwingConstants.CENTER);
            pacienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
            Font font = pacienteLabel.getFont().deriveFont(Font.BOLD);
            Map<TextAttribute, Object> attributes = (Map<TextAttribute, Object>) font.getAttributes();
            attributes.put(TextAttribute.TRACKING, 0.7);
            pacienteLabel.setFont(font.deriveFont(attributes));
            JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
            separator2.setPreferredSize(new Dimension(1, 30));

            // User icon
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Images/IconoUsuario.png"));
            Image scaledImage = originalIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
            JLabel userIcon = new JLabel(new ImageIcon(scaledImage));

            // Add components to headerPanel
            headerPanel.add(menuButton);
            headerPanel.add(separator1);
            headerPanel.add(Box.createHorizontalGlue());
            headerPanel.add(pacienteLabel);
            headerPanel.add(Box.createHorizontalGlue());
            headerPanel.add(separator2);
            headerPanel.add(userIcon);

            // Add headerPanel to topPanel
            topPanel.add(headerPanel);

            // Add a horizontal separator
            JSeparator horizontalSeparator = new JSeparator(SwingConstants.HORIZONTAL);
            horizontalSeparator.setPreferredSize(new Dimension(getWidth(), 1));
            topPanel.add(horizontalSeparator);

            // Add topPanel to the frame
            backgroundPanel.add(topPanel, BorderLayout.NORTH);

// Center panel for the patient image, title, and credentials
            JPanel centerPanel = new JPanel();
            centerPanel.setOpaque(false);
            centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

// Patient image
            ImageIcon pacienteImageIcon = new ImageIcon(getClass().getResource("/Images/ImagenPaciente.png"));
            Image scaledPacienteImage = pacienteImageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            JLabel pacienteImageLabel = new JLabel(new ImageIcon(scaledPacienteImage));
            pacienteImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
            centerPanel.add(pacienteImageLabel);

// Title "INICIAR SECCION"
            JLabel iniciarSeccionLabel = new JLabel("INICIAR SECCION");
            Font titleFont = new Font("Arial", Font.BOLD, 20);
            Map<TextAttribute, Object> titleAttributes = (Map<TextAttribute, Object>) titleFont.getAttributes();
            titleAttributes.put(TextAttribute.TRACKING, 0.1);
            iniciarSeccionLabel.setFont(titleFont.deriveFont(titleAttributes));
            iniciarSeccionLabel.setForeground(Color.BLACK);
            iniciarSeccionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
            centerPanel.add(iniciarSeccionLabel);

// Username section
            JPanel usernamePanel = new JPanel();
            usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.X_AXIS));
            usernamePanel.setOpaque(false);

            ImageIcon usernameIcon = new ImageIcon(getClass().getResource("/Images/LogoUsuario.png"));
            Image scaledUserImage = usernameIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            JLabel userIconLabel = new JLabel(new ImageIcon(scaledUserImage));
            JTextField usernameField = new JTextField(15);
            usernameField.setMaximumSize(new Dimension(200, 30));

            usernamePanel.add(userIconLabel);
            usernamePanel.add(Box.createRigidArea(new Dimension(10, 0))); // Spacing
            usernamePanel.add(usernameField);
            centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing between sections
            centerPanel.add(usernamePanel);

// Password section
            JPanel passwordPanel = new JPanel();
            passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
            passwordPanel.setOpaque(false);

            ImageIcon passwordIcon = new ImageIcon(getClass().getResource("/Images/LogoContrasena.png"));
            Image scaledPasswordImage = passwordIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            JLabel passwordIconLabel = new JLabel(new ImageIcon(scaledPasswordImage));
            JPasswordField passwordField = new JPasswordField(15);
            passwordField.setMaximumSize(new Dimension(200, 30));

            passwordPanel.add(passwordIconLabel);
            passwordPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Spacing
            passwordPanel.add(passwordField);
            centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing between sections
            centerPanel.add(passwordPanel);



// Buttons panel
            JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0)); // Center alignment with spacing
            buttonsPanel.setOpaque(false); // Make the panel transparent

// "INICIAR" button
            JButton iniciarButton = new JButton("INICIAR");
            iniciarButton.setFocusPainted(false);
            iniciarButton.setPreferredSize(new Dimension(80, 25)); // Smaller size
            buttonsPanel.add(iniciarButton);

            iniciarButton.addActionListener(e -> {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());

                if (UserStorage.validateUser(username, password)) {
                    String medicoAsignado = "Dr. Default"; // Replace with the actual value or retrieve it dynamically
                    new PacienteBienvenidoFrame(username, "Apellido", medicoAsignado); // Pass all required parameters
                    dispose(); // Close login frame
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

// "REGISTRARSE" button
            JButton registrarseButton = new JButton("REGISTRARSE");
            registrarseButton.setFocusPainted(false);
            registrarseButton.setPreferredSize(new Dimension(120, 25)); // Smaller size
            buttonsPanel.add(registrarseButton);

// Add action listener to "REGISTRARSE" button
            registrarseButton.addActionListener(e -> {
                new RegistroFrame(); // Open the Pacientes.RegistroFrame
                dispose(); // Close the current frame (Pacientes.PacienteFrame)
            });
// Add spacing and then add the buttons panel to the centerPanel
            centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
            centerPanel.add(buttonsPanel);


// Add the center panel to the background
            backgroundPanel.add(centerPanel, BorderLayout.CENTER);

            // Add menu functionality
            JPopupMenu popupMenu = new JPopupMenu();

            // Menu title
            JLabel menuTitle = new JLabel("MENU");
            menuTitle.setFont(new Font("Arial", Font.BOLD, 14));
            menuTitle.setHorizontalAlignment(SwingConstants.CENTER);
            menuTitle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            popupMenu.add(menuTitle);
            popupMenu.addSeparator();

            // Menu items
            JMenuItem inicioItem = new JMenuItem("INICIO");
            JMenuItem pacientesItem = new JMenuItem("PACIENTES");
            JMenuItem medicosItem = new JMenuItem("MEDICOS");
            JMenuItem informacionItem = new JMenuItem("INFORMACION");
            JMenuItem cerrarSesionItem = new JMenuItem("CERRAR SESIÓN");

            popupMenu.add(inicioItem);
            popupMenu.add(pacientesItem);
            popupMenu.add(medicosItem);
            popupMenu.add(informacionItem);
            popupMenu.add(cerrarSesionItem);

            // Show menu on button click
            menuButton.addActionListener(e -> popupMenu.show(menuButton, 0, menuButton.getHeight()));

            // Menu item actions
            inicioItem.addActionListener(e -> {
                new Main().main(null); // Open the main window (Pacientes.Main frame)
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(menuButton); // Get the parent frame
                if (parentFrame != null) {
                    parentFrame.dispose(); // Close the current frame
                }
            });
            pacientesItem.addActionListener(e -> {
                System.out.println("Ya estás en la ventana de PACIENTE.");
            });

            medicosItem.addActionListener(e -> {
                new Medicos.MedicoFrame().setVisible(true); // Abre la ventana de MedicoFrame
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(menuButton); // Obtiene el marco actual
                if (parentFrame != null) {
                    parentFrame.dispose(); // Cierra el marco actual
                }
            });

            informacionItem.addActionListener(e -> {
                System.out.println("Abrir ventana de INFORMACIÓN");
                // Add logic to open the INFORMACIÓN frame
            });

            cerrarSesionItem.addActionListener(e -> {
                System.out.println("Cerrar sesión");
                // Add logic to handle session logout
            });

            // Make the frame visible
            setVisible(true);

            System.out.println("Pacientes.PacienteFrame loaded successfully.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading Pacientes.PacienteFrame: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }
}