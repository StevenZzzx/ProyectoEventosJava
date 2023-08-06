package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JFrame implements ActionListener {
    private final JPanel cards;
    private final CardLayout cardLayout;

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

    private JPanel createApplication(){

        JPanel principalPanel = new JPanel(new GridBagLayout());
        principalPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JButton startBtn = new JButton("Empezar");

        GridBagConstraints gridLocations = new GridBagConstraints();
        gridLocations.gridx = 0;
        gridLocations.gridy = 0;
        gridLocations.anchor = GridBagConstraints.WEST;
        gridLocations.insets = new Insets(5, 5, 5, 5);
        principalPanel.add(startBtn, gridLocations);

        startBtn.addActionListener(e -> changeToLoginGUI());

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
