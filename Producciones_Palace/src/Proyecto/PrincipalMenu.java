package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalMenu extends JPanel implements ActionListener{
    private JButton myProfileBtn, myEventsBtn, waitingInvoiceBtn, seeMoreEventsBtn;
    JPanel infoPanel;
    private Users activeUser;

    public PrincipalMenu(Users activeUser) {
        this.activeUser = activeUser;

        JPanel sideMenuPanel = new JPanel();
        sideMenuPanel.setLayout(new GridLayout(8, 1));

        myProfileBtn = new JButton("My Profile");
        myProfileBtn.addActionListener(this);
        sideMenuPanel.add(myProfileBtn);

        myEventsBtn = new JButton("Mis Eventos");
        myEventsBtn.addActionListener(this);
        sideMenuPanel.add(myEventsBtn);

        waitingInvoiceBtn = new JButton("Esperando check");
        waitingInvoiceBtn.addActionListener(this);
        sideMenuPanel.add(waitingInvoiceBtn);

        seeMoreEventsBtn = new JButton("Mas Eventos");
        seeMoreEventsBtn.addActionListener(this);
        sideMenuPanel.add(seeMoreEventsBtn);

        infoPanel = new JPanel();

        setLayout(new BorderLayout());
        add(sideMenuPanel, BorderLayout.WEST);
        add(infoPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myProfileBtn){
            displayProfileInfo();
        }

    }

    // Method to display information in the Linked List
    private void displayProfileInfo() {
        infoPanel.setLayout(new GridLayout(4, 1));
        infoPanel.add(new JLabel(activeUser.getName() + " " + activeUser.getLastName()),BorderLayout.CENTER);
        infoPanel.add(new JLabel("Username: " + activeUser.getUsername()));
        infoPanel.add(new JLabel("Email: " + activeUser.getMail()));
        JButton logOutBtn = new JButton("Logout");
        logOutBtn.addActionListener(e -> {
            System.out.println("Sali de session");
        });
        infoPanel.add(logOutBtn, BorderLayout.CENTER);
    }


}

