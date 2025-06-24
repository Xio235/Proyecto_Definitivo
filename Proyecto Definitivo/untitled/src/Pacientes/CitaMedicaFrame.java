package Pacientes;

import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CitaMedicaFrame extends JFrame {
    private JFrame previousFrame; // Store the reference to the previous frame


    public CitaMedicaFrame(int etapa, int edad, String medicoAsignado, JFrame previousFrame) {
        this.previousFrame = previousFrame; // Assign the previous frame

        setTitle("CITA MEDICA");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Title label
        JLabel titleLabel = new JLabel("CITA MEDICA", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        centerPanel.add(titleLabel);

        // Image below the title
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Images/ImagenCita.png"));
        Image scaledImageIcon = imageIcon.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImageIcon));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Reduced spacing between title and image
        centerPanel.add(imageLabel);

        // Calculate the next appointment date
        int daysToAdd;
        if (edad < 18) {
            daysToAdd = 12;
        } else {
            switch (etapa) {
                case 5 -> daysToAdd = 10;
                case 4 -> daysToAdd = 15;
                case 3 -> daysToAdd = 20;
                case 2 -> daysToAdd = 30;
                case 1 -> daysToAdd = 60;
                default -> throw new IllegalArgumentException("Etapa inválida");
            }
        }
        LocalDate nextAppointmentDate = LocalDate.now().plusDays(daysToAdd);
        String formattedDate = nextAppointmentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Add the next appointment date label
        JLabel nextAppointmentLabel = new JLabel("Fecha de la próxima cita:", SwingConstants.CENTER);
        nextAppointmentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nextAppointmentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        centerPanel.add(nextAppointmentLabel);

        JLabel dateLabel = new JLabel(formattedDate, SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        centerPanel.add(dateLabel);

        // Doctor assigned label
        JLabel doctorAssignedLabel = new JLabel("Médico Asignado:", SwingConstants.CENTER);
        doctorAssignedLabel.setFont(new Font("Arial", Font.BOLD, 18));
        doctorAssignedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        centerPanel.add(doctorAssignedLabel);

        JLabel doctorNameLabel = new JLabel(medicoAsignado, SwingConstants.CENTER);
        doctorNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        doctorNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        centerPanel.add(doctorNameLabel);


        backgroundPanel.add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
        // Add the "ATRÁS" button
        JButton backButton = new JButton("ATRÁS");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setBackground(new Color(244, 191, 198)); // Button color
        backButton.setForeground(Color.BLACK); // Text color
        backButton.setFocusPainted(false);
        backButton.setPreferredSize(new Dimension(300, 50)); // Button size
        backButton.setBorder(new RoundedBorder(20)); // Rounded corners

        // Add an ActionListener to handle the button click
        backButton.addActionListener(e -> {
            dispose(); // Close the current frame
            previousFrame.setVisible(true); // Reopen the previous frame
        });

        // Add the button to the centerPanel
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        centerPanel.add(backButton);

        backgroundPanel.add(centerPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}