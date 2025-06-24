import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;

public class PacienteInfoFrame extends JFrame {
    public PacienteInfoFrame(String nombrePaciente) {
        setTitle("Información del Paciente: " + nombrePaciente);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 800);

        // Background panel
        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/FondoRegistro.jpg");
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Title label
        JLabel titleLabel = new JLabel("Información de " + nombrePaciente, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        centerPanel.add(titleLabel);

        // Placeholder for patient information
        JLabel infoLabel = new JLabel("<html><center>Aquí se mostrará la información<br>del paciente.</center></html>", SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        centerPanel.add(infoLabel);

        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }
}
