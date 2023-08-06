package Proyecto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Application extends JFrame implements ActionListener {
    private final JPanel cards;
    private final CardLayout cardLayout;
    private int counter;
    private JLabel counterLabel;
    private Timer timer;

    private Application(){
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setMinimumSize(new Dimension(500, 500));


        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel principalPanel = createApplication();
        JPanel loginPanel = new LoginGUI();
        JPanel signUpPanel = new SingUpGUI();

        cards.add(principalPanel, "app");
        cards.add(loginPanel, "login");
        cards.add(signUpPanel, "signUp");

        cardLayout.show(cards, "app");

        add(cards);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createApplication() {

        JPanel principalPanel = new JPanel(new GridBagLayout());
        principalPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel tittleLabel = new JLabel("Bienvenido a Producciones Palace");
        tittleLabel.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("C:\\Users\\Kennito\\Documents\\Proyecto_Steven\\ProyectoEventosJava" +
                "\\Producciones_Palace\\src\\img\\ticketsIcon.png"));

        counterLabel = new JLabel("Cargando: " + counter + "%");
        counterLabel.setFont(new Font("Verdana", Font.BOLD, 16));

        GridBagConstraints gridLocations = new GridBagConstraints();
        gridLocations.gridx = 0;
        gridLocations.gridy = 0;
        gridLocations.anchor = GridBagConstraints.CENTER;
        gridLocations.insets = new Insets(5, 5, 5, 5);
        principalPanel.add(tittleLabel, gridLocations);
        gridLocations.gridy = 1;
        principalPanel.add(imageLabel, gridLocations);
        gridLocations.gridy = 2;
        principalPanel.add(counterLabel, gridLocations);

        timer = new Timer(200, e -> {

            counter += 5;
            if (counter > 100) {
                counter = 100;
                timer.stop();
                changeToLoginGUI();
            }
            counterLabel.setText("Cargando: " + counter + "%");
        });

        timer.start();

        return principalPanel;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
    public void changeToLoginGUI(){
        cardLayout.show(cards, "login");
    }

    public void changeToSignUpGUI(){
        cardLayout.show(cards, "signUp");
    }

    public void changeToPrincipalMenu(Users user){
        JPanel principalMenuPanel = new PrincipalMenu(user);
        cards.add(principalMenuPanel, "principal");
        cardLayout.show(cards, "principal");
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Kenneth", "Fuentes", "kenfu", "123", "kenfu@mail.com");
        Administrador admin2 = new Administrador("Kenneth", "Fuentes", "kenfu1", "1234", "kenfu@mail.com");

        SwingUtilities.invokeLater(Application::new);

    }
}
