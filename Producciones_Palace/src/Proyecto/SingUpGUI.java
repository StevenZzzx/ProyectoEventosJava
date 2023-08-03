package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SingUpGUI extends JPanel implements ActionListener {

    private JLabel nameLabel, lastnameLabel, usernameLabel, passwordLabel, mailLabel;
    private JTextField nameField, lastnameField, usernameField, passwordField, passwordCheckField, mailField;
    private JButton createAccountBtn, back2LoginBtn;

    public SingUpGUI() {

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        nameLabel = new JLabel("Name:");
        lastnameLabel = new JLabel("Last name:");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        mailLabel = new JLabel("E-mail:");

        nameField = new JTextField(20);
        lastnameField = new JTextField(20);
        usernameField = new JTextField(20);
        passwordField = new JTextField(20);
        passwordCheckField = new JTextField(20);
        mailField = new JTextField(20);

        createAccountBtn = new JButton("Create account");
        back2LoginBtn = new JButton("Back");

        GridBagConstraints gridPosition = new GridBagConstraints();
        gridPosition.gridx = 0;
        gridPosition.gridy = 0;
        gridPosition.anchor = GridBagConstraints.WEST;
        gridPosition.insets = new Insets(5, 5, 5, 5);
        add(nameLabel, gridPosition);

        gridPosition.gridy = 1;
        add(nameField, gridPosition);

        gridPosition.gridy = 2;
        add(lastnameLabel, gridPosition);

        gridPosition.gridy = 3;
        add(lastnameField, gridPosition);

        gridPosition.gridy = 4;
        add(usernameLabel, gridPosition);

        gridPosition.gridy = 5;
        add(usernameField, gridPosition);

        gridPosition.gridy = 6;
        add(passwordLabel, gridPosition);

        gridPosition.gridy = 7;
        add(passwordField, gridPosition);

        gridPosition.gridy = 8;
        add(passwordCheckField, gridPosition);

        gridPosition.gridy = 9;
        add(mailLabel, gridPosition);

        gridPosition.gridy = 10;
        add(mailField, gridPosition);

        gridPosition.gridy = 11;
        add(createAccountBtn, gridPosition);

        gridPosition.gridx = 1;
        add(back2LoginBtn, gridPosition);

        createAccountBtn.addActionListener(this);
        back2LoginBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String lastname = lastnameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String password2 = passwordCheckField.getText();
        String mail = mailField.getText();

        if (e.getSource() == createAccountBtn){
            if (Users.userCheck(username)) {
                JOptionPane.showMessageDialog(this, "User alredy exist ❌");
                usernameField.setText("");
            } else if (!Objects.equals(password, password2)) {
                JOptionPane.showMessageDialog(this, "Diferent password ❌");
                passwordCheckField.setText("");
            } else if (!ValidateUtil.checkNoEmpty(new String[]{name, lastname, username, password, mail})) {
                JOptionPane.showMessageDialog(this, "All the spaces need to be filled ❌");
            } else {
                JOptionPane.showMessageDialog(this, "Sign Up successfuly ✔");
                new Cliente(name, lastname, username, password, mail);
                cleanAll();

            }
        } else if (e.getSource() == back2LoginBtn){
            Application principalApp = (Application) SwingUtilities.getWindowAncestor(this);
            principalApp.changeToLoginGUI();
        }

    }

    private void cleanAll(){
        nameField.setText("");
        lastnameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        passwordCheckField.setText("");
        mailField.setText("");
    }
}
