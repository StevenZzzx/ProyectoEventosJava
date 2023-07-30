package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SingUpGUI extends JFrame implements ActionListener {
    private final JLabel nameLabel, lastNameLabel, usernameLabel, passwordLabel, mailLabel;
    private final JTextField nameField, lastNameField, usernameField, passwordField, passwordCheckField, mailField;
    private final JButton createAccountBtn, printAllUserBtn;

    Administrador toDB = new Administrador();

    public SingUpGUI() {
        // Set up the JFrame
        setTitle("Sign Up Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));

        // Create a panel to hold the components with margins
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Initialize components
        nameLabel = new JLabel("Name:");
        lastNameLabel = new JLabel("Last name:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        mailLabel = new JLabel("E-mail:");

        nameField = new JTextField(20);
        lastNameField = new JTextField(20);
        usernameField = new JTextField(20);
        passwordField = new JTextField(20);
        passwordCheckField = new JTextField(20);
        mailField = new JTextField(20);

        createAccountBtn = new JButton("Create account");
        printAllUserBtn = new JButton("Print");

        // Add components to the panel using GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(nameLabel, gbc);

        gbc.gridy = 1;
        panel.add(nameField, gbc);

        gbc.gridy = 2;
        panel.add(lastNameLabel, gbc);

        gbc.gridy = 3;
        panel.add(lastNameField, gbc);

        gbc.gridy = 4;
        panel.add(usernameLabel, gbc);

        gbc.gridy = 5;
        panel.add(usernameField, gbc);

        gbc.gridy = 6;
        panel.add(passwordLabel, gbc);

        gbc.gridy = 7;
        panel.add(passwordField, gbc);

        gbc.gridy = 8;
        panel.add(passwordCheckField, gbc);

        gbc.gridy = 9;
        panel.add(mailLabel, gbc);

        gbc.gridy = 10;
        panel.add(mailField, gbc);

        gbc.gridy = 11;
//        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(createAccountBtn, gbc);

        gbc.gridx = 1;
        panel.add(printAllUserBtn, gbc);

        // Add action listeners to buttons
        createAccountBtn.addActionListener(this);
        printAllUserBtn.addActionListener(this);

        // Add the panel to the JFrame
        add(panel);

        // Pack the JFrame and make it visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String lastname = lastNameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String password2 = passwordCheckField.getText();
        String mail = mailField.getText();

        if (e.getSource() == createAccountBtn && validateData(name,lastname, username,password,password2,mail)) {
            if (toDB.userCheck(username)){
                JOptionPane.showMessageDialog(this, "User alredy exist");
                usernameField.setText("");
            } else {
                new Cliente(name,lastname, username,password,mail);
                cleanAll();
            }
        } else if (e.getSource() == printAllUserBtn) {
            toDB.printAllUsers();
        }
    }

    private boolean validateData(String name, String lastname, String username, String password, String checkPassword, String mail){
        if (!Objects.equals(password, checkPassword)){
            JOptionPane.showMessageDialog(this, "Diferent password");
            return false;
        }
        else if (!Objects.equals(name, "") && !Objects.equals(lastname, "") && !Objects.equals(username, "") &&
                !Objects.equals(password, "") && !Objects.equals(mail, "")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "All the spaces need to be not empty");
            return false;

        }
    }

    private void cleanAll(){
        nameField.setText("");
        lastNameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        passwordCheckField.setText("");
        mailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SingUpGUI::new);
    }
}
