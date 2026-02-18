package org.example.gui;

import org.example.model.Tiker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class Principal extends JFrame {
    public JPanel panel;
    public JPanel panel_con_botones;
    public JTextArea textAreaLogs;
    private JButton btnReload;
    private JPanel panel_logs;
    private JScrollPane scrollLogs;

    public Principal() {

        listarBotones();

        btnReload.addActionListener(e -> {
            log("🔄 Recargando lista...");
            listarBotones();
        });
    }
    int cambio = 1;

    public void listarBotones(){

        panel_con_botones.removeAll(); // limpiar antes de recargar

        List<Tiker> tikers = new ArrayList<>();

        tikers.add(new Tiker(1,"BTC/USDT:","BTC",true));
        tikers.add(new Tiker(2,"BNB/USDT:","BNB",true));
        tikers.add(new Tiker(3,"ETH/USDT:","ETH",true));

        log("Cargando botones...");

        for (Tiker tiker : tikers) {
            JButton boton = new JButton(tiker.getNombre());
            boton.setBackground(new Color(186, 186, 186));

            boton.addActionListener(e -> {

                log("Presionaste: " + tiker.getNombre());


                if (cambio == 1){
                    boton.setBackground(new Color(132, 208, 55));
                }
                cambio = 1;
            });

            panel_con_botones.add(boton);
        }

        panel_con_botones.revalidate();
        panel_con_botones.repaint();

        log("Botones cargados correctamente.");
    }


    //log
    public void log(String mensaje) {
        SwingUtilities.invokeLater(() -> {
            textAreaLogs.append(mensaje + "\n");
            textAreaLogs.setCaretPosition(textAreaLogs.getDocument().getLength());
        });
    }
}
