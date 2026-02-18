package org.example;

import org.example.gui.Principal;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Principal principal = new Principal();
            principal.setContentPane(principal.panel);
            principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            principal.pack();
            principal.setLocationRelativeTo(null);
            principal.setTitle("N7 Ticker lock");
            principal.setVisible(true);
        });
    }
}
