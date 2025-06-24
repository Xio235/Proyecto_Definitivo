package Medicos;

import utils.BackgroundPanel;
import utils.UserStorage;


import javax.swing.*;
import java.awt.*;

public class MedicoRegistroFrame extends JFrame {

    // Campos necesarios para recuperar los datos ingresados
    private JTextField nombresField;
    private JTextField apellidosField;
    private JTextField usuarioField;
    private JPasswordField contrasenaField;
    private JPasswordField confirmarContrasenaField;

    public MedicoRegistroFrame() {
        setTitle("REGISTRO MÉDICO");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 800);

        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/FondoRegistro.jpg");
        backgroundPanel.setLayout(new GridBagLayout());
        setContentPane(backgroundPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("REGISTRARSE", SwingConstants.CENTER);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
        contentPanel.add(titleLabel);

        String[] labels = {
                "Nombres:", "Apellidos:", "Cédula:", "Correo:",
                "Usuario:", "Contraseña:", "Confirmar Contraseña:"
        };

        for (String labelText : labels) {
            JLabel label = new JLabel(labelText);
            label.setFont(new Font("Arial", Font.BOLD, 16));

            JComponent field;
            if (labelText.equalsIgnoreCase("Contraseña:")) {
                contrasenaField = new JPasswordField(15);
                field = contrasenaField;
            } else if (labelText.equalsIgnoreCase("Confirmar Contraseña:")) {
                confirmarContrasenaField = new JPasswordField(15);
                field = confirmarContrasenaField;
            } else {
                JTextField textField = new JTextField(15);
                if (labelText.equals("Nombres:")) nombresField = textField;
                if (labelText.equals("Apellidos:")) apellidosField = textField;
                if (labelText.equals("Usuario:")) usuarioField = textField;
                field = textField;
            }

            JPanel rowPanel = new JPanel();
            rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.X_AXIS));
            rowPanel.setOpaque(false);

            label.setPreferredSize(new Dimension(160, 25));
            field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

            rowPanel.add(label);
            rowPanel.add(Box.createHorizontalStrut(10));
            rowPanel.add(field);

            contentPanel.add(rowPanel);
            contentPanel.add(Box.createVerticalStrut(30));
        }

        contentPanel.add(Box.createVerticalStrut(40));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);

        JButton cancelarButton = new JButton("CANCELAR");
        cancelarButton.addActionListener(e -> {
            new MedicoFrame();
            dispose();
        });
        cancelarButton.setBackground(new Color(244, 191, 198));
        cancelarButton.setForeground(Color.BLACK);

        JButton siguienteButton = new JButton("SIGUIENTE");
        siguienteButton.addActionListener(e -> {
            String nombres = nombresField.getText().trim();
            String apellidos = apellidosField.getText().trim();
            String usuario = usuarioField.getText().trim();
            String contrasena = new String(contrasenaField.getPassword());
            String confirmarContrasena = new String(confirmarContrasenaField.getPassword());

            // Validations
            if (usuario.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!contrasena.equals(confirmarContrasena)) {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Save credentials in UserStorage
            UserStorage.addUser(usuario, contrasena);
            UserStorage.addDoctor(nombres + " " + apellidos);

            new MedicoBienvenidoFrame(nombres, apellidos);
            dispose();
        });
        siguienteButton.setBackground(new Color(244, 191, 198));
        siguienteButton.setForeground(Color.BLACK);

        buttonPanel.add(cancelarButton);
        buttonPanel.add(siguienteButton);
        contentPanel.add(buttonPanel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        backgroundPanel.add(contentPanel, gbc);

        setVisible(true);
    }
}
