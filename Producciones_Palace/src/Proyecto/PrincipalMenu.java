package Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalMenu extends JPanel implements ActionListener{
    private JButton myProfileBtn, myEventsBtn, waitingInvoiceBtn, seeMoreEventsBtn;
    private JPanel cards;
    private CardLayout cardLayout;
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

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel defaultPanel = defaultPanel();
        JPanel myProfileInfo = displayProfileInfo();

        cards.add(defaultPanel, "default");
        cards.add(myProfileInfo, "myProfile");

        cardLayout.show(cards, "default");

        setLayout(new BorderLayout());
        add(sideMenuPanel, BorderLayout.WEST);
        add(cards, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myProfileBtn){
            cardLayout.show(cards, "myProfile");
        }

    }

    private JPanel defaultPanel(){
        JPanel defaultPanel = new JPanel();
        JLabel idk = new JLabel("Me kgo en todo");

        defaultPanel.add(idk);

        return defaultPanel;
    }

    private JPanel displayProfileInfo() {
        JLabel nameLabel = new JLabel(activeUser.getName() + " " + activeUser.getLastName());
        JLabel usernameLabel = new JLabel("Username: " + activeUser.getUsername());
        JLabel mailLabel = new JLabel("Email: " + activeUser.getMail());
        JButton logOutBtn = new JButton("Logout");
        logOutBtn.addActionListener(e -> {
            System.out.println("Sali de session");
        });

        JPanel profileInfoPanel = new JPanel(new GridBagLayout());
        profileInfoPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        GridBagConstraints gridLocations = new GridBagConstraints();

        gridLocations.insets = new Insets(5, 5, 5, 5);
        gridLocations.gridx = 0;
        gridLocations.gridy = 0;
        gridLocations.anchor = GridBagConstraints.CENTER;
        profileInfoPanel.add(nameLabel, gridLocations);

        gridLocations.gridy = 1;
        gridLocations.anchor = GridBagConstraints.WEST;
        profileInfoPanel.add(usernameLabel, gridLocations);

        gridLocations.gridy = 2;
        profileInfoPanel.add(mailLabel, gridLocations);

        gridLocations.gridy = 3;
        gridLocations.anchor = GridBagConstraints.CENTER;
        profileInfoPanel.add(logOutBtn, gridLocations);

        return profileInfoPanel;
    }


}

