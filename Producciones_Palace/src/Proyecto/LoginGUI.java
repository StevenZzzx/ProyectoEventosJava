package Proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class LoginGUI extends JFrame implements ActionListener {

    private final JLabel usernameLabel, passwordLabel, signUpLabel;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton, signUpButton;

    Administrador toDB = new Administrador();

    public LoginGUI() {
        // Set up the JFrame
        setTitle("Login Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));

        // Create a panel to hold the components with margins
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Initialize components
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        signUpLabel = new JLabel("You dont have a Account?");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");

        // Add components to the panel using GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(usernameLabel, gbc);

        gbc.gridy = 1;
        panel.add(usernameField, gbc);

        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        gbc.gridy = 3;
        panel.add(passwordField, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0.0;
        panel.add(loginButton, gbc);

        gbc.gridy = 5;
        panel.add(signUpLabel, gbc);

        gbc.gridy = 6;
        panel.add(signUpButton, gbc);

        // Add action listeners to buttons
        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);

        // Add the panel to the JFrame
        add(panel);

        // Pack the JFrame and make it visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            System.out.println("entere");

            if (toDB.userCheck(usernameField.getText())){
                if (toDB.userLogin(usernameField.getText(), new String(passwordField.getPassword()))){
                    JOptionPane.showMessageDialog(this, "Succefully Login In");
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong password");
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found");
            }

        } else if (e.getSource() == signUpButton) {
            toDB.printAllUsers();
//            JOptionPane.showMessageDialog(this, "Sign Up clicked!");
        }
    }

    public static void searchInDB(String username){
        
    }

    public static void main(String[] args) {
        Cliente usuario = new Cliente("steven", "rodriguez", "steven12", "refr", "hol@ho");
        Cliente usuario1 = new Cliente("steven1", "rodriguez", "ken", "kkk", "hol@ho");
        Cliente usuario2 = new Cliente("steven2", "rodriguez", "cet", "caca", "hol@ho");
        Cliente usuario3 = new Cliente("steven3", "rodriguez", "ads", "mono", "hol@ho");

        Administrador admin1 = new Administrador("pedro", "rodriguez", "pedro", "mono1", "hol@ho", true);
        Administrador admin2 = new Administrador("pedro", "perez", "pedro", "mono2", "hol@ho", true);
        Administrador admin3 = new Administrador("pedro", "vargas", "pedro", "mono3", "hol@ho", true);

        SwingUtilities.invokeLater(LoginGUI::new);
    }
}

