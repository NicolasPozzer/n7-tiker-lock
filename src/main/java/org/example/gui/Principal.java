package org.example.gui;

import org.example.model.Tiker;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Principal extends JFrame {
    public JPanel panel;
    public JPanel panel_con_botones;

    // main del JFrame
    public Principal() {
        listarBotones();
    }


    public void listarBotones(){
        List<Tiker> tikers = new ArrayList<>();

        Tiker tic = new Tiker(1,"BTC/USDT:","BTC",true);
        Tiker tic2 = new Tiker(2,"BNB/USDT:","BNB",true);
        Tiker tic3 = new Tiker(3,"ETH/USDT:","ETH",true);

        tikers.add(tic);
        tikers.add(tic2);
        tikers.add(tic3);

        for (Tiker tiker : tikers) {
            System.out.println("Cargando Botones......");
            JButton boton = new JButton(tiker.getNombre());

            boton.addActionListener(e -> {
                System.out.println("Presionaste: " + tiker.getNombre());
            });

            panel_con_botones.add(boton);
        }

    }
}




