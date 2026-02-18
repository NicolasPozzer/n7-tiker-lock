package org.example.gui;

import org.example.controller.Logica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Principal extends JFrame {
    public JPanel panel;
    public JPanel panel_con_botones;

    public Principal() {

        List<String> nombres = List.of("Aceptar", "Cancelar", "Salir");

        for (String nombre : nombres) {
            panel_con_botones.add(new JButton(nombre));
        }
    }
}




