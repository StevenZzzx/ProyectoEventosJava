package Proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginGUI extends JPanel implements ActionListener{

    private JLabel usernameLabel, passwordLabel, signUpLabel;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton, signUpButton;


    public LoginGUI() {

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        signUpLabel = new JLabel("You dont have a Account?");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");

        // Add components to the panel using GridBagLayout
        GridBagConstraints gridPosition = new GridBagConstraints();
        gridPosition.gridx = 0;
        gridPosition.gridy = 0;
        gridPosition.anchor = GridBagConstraints.WEST;
        gridPosition.insets = new Insets(5, 5, 5, 5);
        add(usernameLabel, gridPosition);

        gridPosition.gridy = 1;
        add(usernameField, gridPosition);

        gridPosition.gridy = 2;
        add(passwordLabel, gridPosition);

        gridPosition.gridy = 3;
        add(passwordField, gridPosition);

        gridPosition.gridy = 4;
        gridPosition.gridwidth = 2;
        gridPosition.fill = GridBagConstraints.NONE;
        gridPosition.anchor = GridBagConstraints.CENTER;
        gridPosition.weightx = 0.0;
        add(loginButton, gridPosition);

        gridPosition.gridy = 5;
        add(signUpLabel, gridPosition);

        gridPosition.gridy = 6;
        add(signUpButton, gridPosition);

        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            int index = Users.userCheck(usernameField.getText());
            if (!Objects.equals(index, -1)){
                if (Users.userLogin(index, usernameField.getText(), new String(passwordField.getPassword()))){
                    JOptionPane.showMessageDialog(this, "Succefully Login In");
                    Users user = Users.returnUser(index);
                    JOptionPane.showMessageDialog(this, "Usuario: " + user.getName() +
                            "\n" + user.returnClass());
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong password");
                    passwordField.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found");
            }

        } else if (e.getSource() == signUpButton) {
            Application principalApp = (Application) SwingUtilities.getWindowAncestor(this);
            principalApp.changeToSignUpGUI();
        }
    }

}

