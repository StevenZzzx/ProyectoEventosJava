package Proyecto;

import javax.swing.*;
import java.awt.*;

public class tryPrincipalMenu {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Side Menu Panel Example");
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Cliente clie = new Cliente("Kenneth", "Fuentes", "Kenfu", "123", "kenfu@mail.com");

        PrincipalMenu sideMenuPanel = new PrincipalMenu(clie);

        frame.add(sideMenuPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
