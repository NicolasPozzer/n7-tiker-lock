package org.example.gui;

import org.example.model.Tiker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

    public void listarBotones(){

        panel_con_botones.removeAll(); // limpiar antes de recargar

        List<Tiker> tikers = new ArrayList<>();

        tikers.add(new Tiker(1,"BTC/USDT:","BTC",true));
        tikers.add(new Tiker(2,"BNB/USDT:","BNB",true));
        tikers.add(new Tiker(3,"ETH/USDT:","ETH",true));

        log("Cargando botones...");

        for (Tiker tiker : tikers) {
            JButton boton = new JButton(tiker.getNombre());

            boton.addActionListener(e -> {
                log("Presionaste: " + tiker.getNombre());
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
