import Pacientes.PacienteFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InicioFrame extends JFrame {
    private JButton pacienteButton; // Declare the button

    public InicioFrame() {
        setTitle("INICIO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 800);
        setLayout(new BorderLayout());

        // Initialize the button
        pacienteButton = new JButton("Ir a PACIENTE");

        // Add ActionListener to the button
        pacienteButton.addActionListener((ActionEvent e) -> {
            try {
                SwingUtilities.invokeLater(() -> {
                    new PacienteFrame().setVisible(true); // Open Pacientes.PacienteFrame
                });
                dispose(); // Close the current frame
            } catch (Exception ex) {
                ex.printStackTrace(); // Log any exceptions
            }
        });

        // Configure the content
        JLabel label = new JLabel("BIENVENIDO A INICIO", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);
        add(pacienteButton, BorderLayout.SOUTH); // Add the button to the frame
    }
}