package Proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {

    private final JLabel usernameLabel, passwordLabel, signUpLabel;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton, signUpButton;

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
            // Handle login button click event
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            // Add your login logic here
            // For now, let's just print the credentials to the console:
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        } else if (e.getSource() == signUpButton) {
            // Handle sign-up button click event
            // Add your sign-up logic here
            // For now, let's just display a message box:
            JOptionPane.showMessageDialog(this, "Sign Up clicked!");
        }
    }

    public static void searchInDB(String username){
        
    }

    public static void main(String[] args) {
        Administrador usuario = new Administrador("steven", "rodriguez", "steven12", "steven1213", "hol@ho", 2000);
        Cliente usuario2 = new Cliente("yo", "yo", "yo", "yo", "yo");
        AlmacenamientoAdministradores Admins = new AlmacenamientoAdministradores();
        AlmacenamientoClientes clientes = new AlmacenamientoClientes();
        Admins.registrarAdministrador(usuario);
        clientes.registrarCliente(usuario2);

        SwingUtilities.invokeLater(LoginGUI::new);
    }
}

