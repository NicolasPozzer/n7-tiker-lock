package org.example.gui;

import org.example.controller.Logica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JButton button1;
    private JLabel label1;
    public JPanel panel;

    public Principal() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logica logic = new Logica();
                logic.logica(label1.getText());
            }
        });
    }
}
