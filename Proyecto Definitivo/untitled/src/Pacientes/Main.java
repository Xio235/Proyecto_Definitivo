package Pacientes;

import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("Interfaz Gráfica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 800);

        // Crear el panel de fondo
        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/Anemia.jpg");
        backgroundPanel.setLayout(new BorderLayout());
        frame.setContentPane(backgroundPanel); // Establecer el panel de fondo como contenido principal

        // Crear un panel superior y hacerlo transparente
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false); // Hacer transparente
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        // Botón de menú
        JButton menuButton = new JButton("≡");
        menuButton.setFocusPainted(false);
        menuButton.setPreferredSize(new Dimension(60, 60));
        menuButton.setMaximumSize(new Dimension(60, 60));
        menuButton.setMinimumSize(new Dimension(60, 60));

        // Separadores y texto "INICIO"
        JSeparator separator1 = new JSeparator(SwingConstants.VERTICAL);
        separator1.setPreferredSize(new Dimension(1, 30));
        JLabel inicioLabel = new JLabel("INICIO", SwingConstants.CENTER);
        inicioLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = inicioLabel.getFont().deriveFont(Font.BOLD);
        Map<TextAttribute, Object> attributes = (Map<TextAttribute, Object>) font.getAttributes();
        attributes.put(TextAttribute.TRACKING, 0.7);
        inicioLabel.setFont(font.deriveFont(attributes));
        JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
        separator2.setPreferredSize(new Dimension(1, 30));

        // Ícono de usuario
        ImageIcon originalIcon = new ImageIcon(Main.class.getResource("/Images/IconoUsuario.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        JLabel userIcon = new JLabel(new ImageIcon(scaledImage));

        // Agregar componentes al panel superior
        topPanel.add(menuButton);
        topPanel.add(separator1);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(inicioLabel);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(separator2);
        topPanel.add(userIcon);

        // Agregar el panel superior al marco
        backgroundPanel.add(topPanel, BorderLayout.NORTH);

        // Crear un panel central
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setOpaque(false); // Hacer transparente

        // Separador horizontal
        JSeparator horizontalSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        horizontalSeparator.setPreferredSize(new Dimension(frame.getWidth(), 1));
        centerPanel.add(horizontalSeparator, BorderLayout.NORTH);

        // Título y imagen principal
        JLabel titleLabel = new JLabel("<html><center>BIENVENIDO A RENAL<br>CARE ECUADOR</center></html>", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ImageIcon originalImageIcon = new ImageIcon(Main.class.getResource("/Images/ImagenInicio.png"));
        Image scaledInicioImage = originalImageIcon.getImage().getScaledInstance(250, 150, Image.SCALE_SMOOTH);
        JLabel inicioImageLabel = new JLabel(new ImageIcon(scaledInicioImage));

        // Panel para título e imagen
        JPanel titleAndImagePanel = new JPanel();
        titleAndImagePanel.setLayout(new BoxLayout(titleAndImagePanel, BoxLayout.Y_AXIS));
        titleAndImagePanel.setOpaque(false); // Hacer transparente
        titleAndImagePanel.add(Box.createRigidArea(new Dimension(0, 25)));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inicioImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleAndImagePanel.add(titleLabel);
        titleAndImagePanel.add(Box.createRigidArea(new Dimension(0, 30)));
        titleAndImagePanel.add(inicioImageLabel);

        // Agregar el panel de título e imagen al centro
        centerPanel.add(titleAndImagePanel, BorderLayout.CENTER);
        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        // Hacer visible el marco
        frame.setVisible(true);

        // Crear un JLabel para la imagen IconoRiñon.png
        ImageIcon originalKidneyIcon = new ImageIcon(Main.class.getResource("/Images/IconoRiñon.png"));
        Image scaledKidneyImage = originalKidneyIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledKidneyIcon = new ImageIcon(scaledKidneyImage);
        JLabel kidneyIconLabel = new JLabel(scaledKidneyIcon);

// Crear un JLabel para el título "CONTACTANOS:"
        JLabel contactTitleLabel = new JLabel("CONTACTANOS:");
        contactTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        contactTitleLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        contactTitleLabel.setOpaque(false);

// Crear un panel para agrupar la imagen y el título
        JPanel contactPanel = new JPanel();
        contactPanel.setLayout(new BoxLayout(contactPanel, BoxLayout.X_AXIS));
        contactPanel.add(kidneyIconLabel);
        contactPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Espaciado entre la imagen y el título
        contactPanel.add(contactTitleLabel);





// Centrar el panel de contacto
        contactPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

// Agregar el panel de contacto debajo de la imagen principal
        titleAndImagePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre la imagen principal y el panel de contacto
        titleAndImagePanel.add(contactPanel);

        // Agregar un espacio adicional antes del panel de contacto
        titleAndImagePanel.add(Box.createRigidArea(new Dimension(0, 40))); // Ajusta el valor 40 según sea necesario

// Agregar el panel de contacto debajo de la imagen principal
        titleAndImagePanel.add(contactPanel);

        // Crear un JLabel para la imagen LogoFacebook.png
        ImageIcon originalFacebookIcon = new ImageIcon(Main.class.getResource("/Images/LogoFacebook.png"));
        Image scaledFacebookImage = originalFacebookIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledFacebookIcon = new ImageIcon(scaledFacebookImage);
        JLabel facebookIconLabel = new JLabel(scaledFacebookIcon);

// Crear un JLabel para el texto "@renalcareecuador"
        JLabel facebookTextLabel = new JLabel("@renalcareecuador");
        facebookTextLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        facebookTextLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        facebookTextLabel.setOpaque(false);


// Crear un panel para agrupar la imagen de Facebook y el texto
        JPanel facebookPanel = new JPanel();
        facebookPanel.setLayout(new BoxLayout(facebookPanel, BoxLayout.X_AXIS));
        facebookPanel.add(facebookIconLabel);
        facebookPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Espaciado entre la imagen y el texto
        facebookPanel.add(facebookTextLabel);

// Centrar el panel de Facebook
        facebookPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

// Agregar el panel de Facebook debajo del panel de contacto
        titleAndImagePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre el panel de contacto y el panel de Facebook
        titleAndImagePanel.add(facebookPanel);

        // Agregar un margen izquierdo al panel de Facebook
        facebookPanel.setBorder(BorderFactory.createEmptyBorder(10, 70, 0, 0)); // Ajusta el valor 20 según sea necesario

        // Crear un JLabel para la imagen LogoInstagram.png
        ImageIcon originalInstagramIcon = new ImageIcon(Main.class.getResource("/Images/LogoInstagram.png"));
        Image scaledInstagramImage = originalInstagramIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledInstagramIcon = new ImageIcon(scaledInstagramImage);
        JLabel instagramIconLabel = new JLabel(scaledInstagramIcon);

// Crear un JLabel para el texto "@renalcareecuador"
        JLabel instagramTextLabel = new JLabel("@renalcareecuador");
        instagramTextLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        instagramTextLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        instagramTextLabel.setOpaque(false);

// Crear un panel para agrupar la imagen de Instagram y el texto
        JPanel instagramPanel = new JPanel();
        instagramPanel.setLayout(new BoxLayout(instagramPanel, BoxLayout.X_AXIS));
        instagramPanel.add(instagramIconLabel);
        instagramPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Espaciado entre la imagen y el texto
        instagramPanel.add(instagramTextLabel);

// Centrar el panel de Instagram
        instagramPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

// Agregar el panel de Instagram debajo del panel de Facebook
        titleAndImagePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre el panel de Facebook y el panel de Instagram
        titleAndImagePanel.add(instagramPanel);

// Agregar un margen izquierdo al panel de Instagram
        instagramPanel.setBorder(BorderFactory.createEmptyBorder(10, 70, 0, 0)); // Ajusta el valor 70 según sea necesario


        // Crear un JLabel para la imagen LogoWhatsapp.png
        ImageIcon originalWhatsappIcon = new ImageIcon(Main.class.getResource("/Images/LogoWhatsapp.png"));
        Image scaledWhatsappImage = originalWhatsappIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon scaledWhatsappIcon = new ImageIcon(scaledWhatsappImage);
        JLabel whatsappIconLabel = new JLabel(scaledWhatsappIcon);

// Crear un JLabel para el texto "099XXXXXXX"
        JLabel whatsappTextLabel = new JLabel("099XXXXXXX");
        whatsappTextLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        whatsappTextLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        whatsappTextLabel.setOpaque(false);

// Crear un panel para agrupar la imagen de WhatsApp y el texto
        JPanel whatsappPanel = new JPanel();
        whatsappPanel.setLayout(new BoxLayout(whatsappPanel, BoxLayout.X_AXIS));
        whatsappPanel.add(whatsappIconLabel);
        whatsappPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Espaciado entre la imagen y el texto
        whatsappPanel.add(whatsappTextLabel);

// Centrar el panel de WhatsApp
        whatsappPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

// Agregar el panel de WhatsApp debajo del panel de Instagram
        titleAndImagePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado entre el panel de Instagram y el panel de WhatsApp
        titleAndImagePanel.add(whatsappPanel);

// Agregar un margen izquierdo al panel de WhatsApp
        whatsappPanel.setBorder(BorderFactory.createEmptyBorder(10, 27, 0, 0)); // Ajusta el valor 70 según sea necesario



// Crear el menú emergente
        JPopupMenu popupMenu = new JPopupMenu();

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
            new Main().main(null); // Open the main window (Pacientes.Main frame)
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(menuButton); // Get the parent frame
            if (parentFrame != null) {
                parentFrame.dispose(); // Close the current frame
            }
        });

        pacientesItem.addActionListener(e -> {
            System.out.println("Abrir ventana de PACIENTE");
            new PacienteFrame().setVisible(true); // Open the Pacientes.PacienteFrame
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(menuButton); // Get the parent frame
            if (parentFrame != null) {
                parentFrame.dispose(); // Close the current frame
            }
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
            // Aquí puedes agregar la lógica para abrir la ventana de INFORMACIÓN
        });

        cerrarSesionItem.addActionListener(e -> {
            System.out.println("Cerrar sesión");
            // Aquí puedes agregar la lógica para cerrar sesión
        });
    }
}