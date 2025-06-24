package Pacientes;

import utils.BackgroundPanel;
import utils.UserStorage;

import javax.swing.*;
import java.awt.*;

public class RegistroEtapaFrame extends JFrame {
    private String nombres;
    private String apellidos;
    private static int renalStage;


    public static int getRenalStage() {
        return renalStage;
    }


    public RegistroEtapaFrame(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;

        setTitle("REGISTRO");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 800);

        // Fondo personalizado
        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/FondoRegistro.jpg");
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        // Panel interno para colocar los elementos arriba
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false); // Fondo transparente para ver imagen
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        int y = 0;

        // Título
        JLabel titleLabel = new JLabel("REGISTRO", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridy = y++;
        gbc.insets = new Insets(30, 10, 30, 10); // espacio desde arriba
        formPanel.add(titleLabel, gbc);

        // Label: Etapa
        JLabel etapaLabel = new JLabel("Etapa de Insuficiencia Renal (1-5):");
        etapaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        etapaLabel.setForeground(Color.BLACK);
        gbc.gridy = y++;
        gbc.insets = new Insets(10, 10, 5, 10);
        formPanel.add(etapaLabel, gbc);

        // ComboBox: Etapa
        String[] options = {"1", "2", "3", "4", "5"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = y++;
        gbc.insets = new Insets(0, 10, 35, 10);
        formPanel.add(comboBox, gbc);

        // Label: Tiempo
        JLabel tiempoLabel = new JLabel("Tiempo Transcurrido desde el Último Tratamiento:");
        tiempoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tiempoLabel.setForeground(Color.BLACK);
        gbc.gridy = y++;
        gbc.insets = new Insets(10, 10, 5, 10);
        formPanel.add(tiempoLabel, gbc);

        // TextField: Tiempo
        JTextField tiempoField = new JTextField(15);
        gbc.gridy = y++;
        gbc.insets = new Insets(0, 10, 35, 10);
        formPanel.add(tiempoField, gbc);

        // Label: Médico
        JLabel medicoLabel = new JLabel("Médico Asignado:");
        medicoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        medicoLabel.setForeground(Color.BLACK);
        gbc.gridy = y++;
        gbc.insets = new Insets(10, 10, 5, 10);
        formPanel.add(medicoLabel, gbc);

        // ComboBox: Médico
        String[] medicos = UserStorage.getRegisteredDoctors().toArray(new String[0]);
        JComboBox<String> medicoComboBox = new JComboBox<>(medicos);
        medicoComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = y++;
        gbc.insets = new Insets(0, 10, 25, 10);
        formPanel.add(medicoComboBox, gbc);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setOpaque(false);

        JButton atrasButton = new JButton("ATRÁS");
        atrasButton.setBackground(new Color(244, 191, 198));
        atrasButton.setForeground(Color.BLACK);
        atrasButton.addActionListener(e -> {
            new RegistroFrame();
            dispose();
        });
        buttonPanel.add(atrasButton);

        JButton continuarButton = new JButton("CONTINUAR");
        continuarButton.setBackground(new Color(244, 191, 198));
        continuarButton.setForeground(Color.BLACK);
        continuarButton.addActionListener(e -> {
            String selectedEtapa = (String) comboBox.getSelectedItem();
            String tiempo = tiempoField.getText().trim();
            String medicoAsignado = (String) medicoComboBox.getSelectedItem();

            try {
                renalStage = Integer.parseInt(selectedEtapa); // Store the stage
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Etapa debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (tiempo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese el tiempo transcurrido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Pass medicoAsignado to Pacientes.PacienteBienvenidoFrame
            new PacienteBienvenidoFrame(nombres, apellidos, medicoAsignado);
            dispose(); // Close current frame
        });
        buttonPanel.add(continuarButton);

        gbc.gridy = y++;
        gbc.insets = new Insets(20, 10, 30, 10);
        formPanel.add(buttonPanel, gbc);

        // Añadir el panel de formulario a la parte superior
        backgroundPanel.add(formPanel, BorderLayout.NORTH);

        setVisible(true);


    }
}
