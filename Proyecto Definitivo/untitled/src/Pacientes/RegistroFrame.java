package Pacientes;

import utils.BackgroundPanel;
import utils.UserStorage;

import javax.swing.*;
import java.awt.*;

public class RegistroFrame extends JFrame {
    private static int patientAge;
    private JTextField etapaField;
    private JTextField tiempoField;
    private JComboBox<String> medicoComboBox;

    public static int getPatientAge() {
        return patientAge;
    }

    // Constructor to accept data from Pacientes.RegistroEtapaFrame
    public RegistroFrame(String etapa, String tiempo, String medicoAsignado) {
        this(); // Call the default constructor to initialize the frame

        // Use the passed data to pre-fill the fields
        etapaField.setText(etapa);
        tiempoField.setText(tiempo);
        medicoComboBox.setSelectedItem(medicoAsignado);
    }

    // Default constructor
    public RegistroFrame() {
        setTitle("REGISTRO");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setSize(400, 800);

        // Set the background panel with the image
        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/FondoRegistro.jpg");
        backgroundPanel.setLayout(new GridBagLayout()); // Use GridBagLayout
        setContentPane(backgroundPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1; // Allow horizontal expansion

        // Add the title label
        JLabel titleLabel = new JLabel("REGISTRARSE", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        backgroundPanel.add(titleLabel, gbc);

        // Initialize fields
        etapaField = new JTextField(15);
        tiempoField = new JTextField(15);
        medicoComboBox = new JComboBox<>(new String[]{"Dr. Pérez", "Dr. Gómez", "Dr. Martínez", "Dr. López"});


        // Create a form panel for input fields
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false); // Make the panel transparent
        GridBagConstraints formGbc = new GridBagConstraints();
        formGbc.insets = new Insets(20, 5, 20, 5); // Increase vertical spacing
        formGbc.fill = GridBagConstraints.HORIZONTAL;

        // Add fields to the form
        String[] labels = {"Nombres:", "Apellidos:", "Cédula:", "Edad:", "Usuario:", "Contraseña:", "Confirmar Contraseña:"};
        for (int i = 0; i < labels.length; i++) {
            formGbc.gridx = 0;
            formGbc.gridy = i;
            formGbc.weightx = 0.3; // Label takes less space
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            formPanel.add(label, formGbc);

            formGbc.gridx = 1;
            formGbc.weightx = 0.7; // Input field takes more space
            if (labels[i].toLowerCase().contains("contraseña")) {
                formPanel.add(new JPasswordField(15), formGbc);
            } else {
                formPanel.add(new JTextField(15), formGbc);
            }
        }

        // Add the form panel to the background panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 1; // Allow vertical expansion
        gbc.anchor = GridBagConstraints.NORTH; // Align to the top
        backgroundPanel.add(formPanel, gbc);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);

// Add "SIGUIENTE" button
        JButton siguienteButton = new JButton("SIGUIENTE");
        siguienteButton.addActionListener(e -> {
            // Retrieve input values
            String nombres = ((JTextField) formPanel.getComponent(1)).getText().trim();
            String apellidos = ((JTextField) formPanel.getComponent(3)).getText().trim();
            String cedula = ((JTextField) formPanel.getComponent(5)).getText().trim();
            String edadStr = ((JTextField) formPanel.getComponent(7)).getText().trim();
            String usuario = ((JTextField) formPanel.getComponent(9)).getText().trim();
            String contrasena = new String(((JPasswordField) formPanel.getComponent(11)).getPassword());
            String confirmarContrasena = new String(((JPasswordField) formPanel.getComponent(13)).getPassword());

            // Validations
            if (!nombres.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+\\s[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
                JOptionPane.showMessageDialog(this, "Nombres debe contener dos palabras.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!apellidos.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+\\s[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")) {
                JOptionPane.showMessageDialog(this, "Apellidos debe contener dos palabras.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!cedula.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Cédula debe contener exactamente 10 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                int edad = Integer.parseInt(edadStr);
                if (edad < 5 || edad > 90) {
                    JOptionPane.showMessageDialog(this, "Edad debe estar entre 5 y 90 años.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                patientAge = edad; // Store the age
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Edad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (usuario.length() != 8) {
                JOptionPane.showMessageDialog(this, "Usuario debe tener exactamente 8 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (contrasena.length() != 8) {
                JOptionPane.showMessageDialog(this, "Contraseña debe tener exactamente 8 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!contrasena.equals(confirmarContrasena)) {
                JOptionPane.showMessageDialog(this, "Confirmar Contraseña debe coincidir con la Contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Save the username and password in utils.UserStorage
            UserStorage.addUser(usuario, contrasena);

            // Open the new frame if all validations pass
            new RegistroEtapaFrame(nombres, apellidos);
            dispose(); // Close the current window
        });

        buttonPanel.add(siguienteButton);
        siguienteButton.setBackground(new Color(244, 191, 198)); // #F08784
        siguienteButton.setForeground(Color.BLACK); // Black text

        // Add "CANCELAR" button
        JButton cancelarButton = new JButton("CANCELAR");
        cancelarButton.addActionListener(e -> {
            new PacienteFrame(); // Open the "INICIAR SECCION" window
            dispose(); // Close the current "Pacientes.RegistroFrame"
        });
        buttonPanel.add(cancelarButton);
        cancelarButton.setBackground(new Color(244, 191, 198)); // #F08784
        cancelarButton.setForeground(Color.BLACK); // Black text

        // Add the button panel to the background panel
        gbc.gridx = 0;
        gbc.gridy = 1; // Place below the form panel
        gbc.gridwidth = 1; // Span across two columns
        gbc.weighty = 0; // No vertical expansion
        gbc.insets = new Insets(250, 0, 0, 0); // 2 pixels of top margin
        gbc.anchor = GridBagConstraints.CENTER; // Center the buttons
        backgroundPanel.add(buttonPanel, gbc);

        // Make the frame visible
        setVisible(true);
    }
}