package org.example;

import org.example.gui.Principal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Principal principal = new Principal();

        principal.setContentPane(new Principal().panel);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setVisible(true);
        principal.pack();
    }
}