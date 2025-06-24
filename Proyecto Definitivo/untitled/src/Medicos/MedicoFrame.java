package Medicos;
import utils.UserStorage;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

import utils.BackgroundPanel;

public class MedicoFrame extends JFrame {
    public MedicoFrame() {
        try {
            setTitle("MÉDICO");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 800);

            // Background panel
            BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/Anemia.jpg");
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

            JLabel medicoLabel = new JLabel("MEDICO", SwingConstants.CENTER);
            Font font = medicoLabel.getFont().deriveFont(Font.BOLD);
            Map<TextAttribute, Object> attributes = (Map<TextAttribute, Object>) font.getAttributes();
            attributes.put(TextAttribute.TRACKING, 0.7);
            medicoLabel.setFont(font.deriveFont(attributes));

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

            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/ImagenInicioMedico.png"));
            Image scaledImageIcon = imageIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImageIcon));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(Box.createRigidArea(new Dimension(0, 40))); // Increased spacing above the image
            centerPanel.add(imageLabel);

            // "INICIAR SECCIÓN" label
            JLabel iniciarSeccionLabel = new JLabel("INICIAR SECCIÓN");
            iniciarSeccionLabel.setFont(new Font("Arial", Font.BOLD, 20));
            iniciarSeccionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Increased spacing below the image
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
            centerPanel.add(Box.createRigidArea(new Dimension(0, 40))); // Increased spacing below "INICIAR SECCIÓN"
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
            centerPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Increased spacing below username section
            centerPanel.add(passwordPanel);

            // Buttons panel
            JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
            buttonsPanel.setOpaque(false);

            JButton iniciarButton = new JButton("INICIAR");
            iniciarButton.setFocusPainted(false);
            iniciarButton.setPreferredSize(new Dimension(80, 25));
            buttonsPanel.add(iniciarButton);

            iniciarButton.addActionListener(e -> {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());

                if (utils.UserStorage.validateUser(username, password)) {
                    JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    new MedicoBienvenidoFrame(username, ""); // Redirect to welcome screen
                    dispose(); // Close the current frame
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            JButton registrarseButton = new JButton("REGISTRARSE");
            registrarseButton.setFocusPainted(false);
            registrarseButton.setPreferredSize(new Dimension(120, 25));
            buttonsPanel.add(registrarseButton);

            registrarseButton.addActionListener(e -> {
                new MedicoRegistroFrame(); // Open the registration window
                dispose(); // Close the current frame
            });

            centerPanel.add(Box.createRigidArea(new Dimension(0, 40))); // Increased spacing below password section
            centerPanel.add(buttonsPanel);

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}