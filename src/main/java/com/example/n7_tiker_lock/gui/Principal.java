package com.example.n7_tiker_lock.gui;

import com.example.n7_tiker_lock.model.Tiker;
import com.example.n7_tiker_lock.services.TikerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Principal extends JFrame {
    public JPanel panel;
    public JPanel panel_con_botones;
    public JTextArea textAreaLogs;
    private JButton btnReload;
    private JPanel panel_logs;
    private JScrollPane scrollLogs;


    private final TikerService tikerServ;

    public Principal(TikerService tikerServ) {
        this.tikerServ = tikerServ;

        setContentPane(panel);
        listarBotones();
        btnReload.addActionListener(e -> {
            log("🔄 Recargando lista...");
            listarBotones();
        });
    }

    public void listarBotones(){
        List<Tiker> tikers = new ArrayList<>();
        try {
            panel_con_botones.removeAll(); // limpiar antes de recargar
            tikers = tikerServ.getTikers();

            log("Cargando botones...");
        }catch (Exception exception){
            tikers = new ArrayList<>();
            log("Tiro una Exepcion al intentar buscar tikers");
            log(exception.getMessage());
        }


        if (!tikers.isEmpty()){
            for (Tiker tiker : tikers) {
                JButton boton = new JButton(tiker.getSymbol());

                // quitar barras '/' en el simbolo
                String symbol = tiker.getSymbol();
                int slashIndex = symbol.indexOf("/");

                if (slashIndex != -1) {
                    boton.setText(symbol.substring(0, slashIndex));
                } else {
                    boton.setText(symbol);
                }
                // fin quitar barras

                // configs para BOTON, quitar contorno, focus, etc.
                boton.setFocusPainted(false);
                boton.setFocusable(false);
                boton.setBorderPainted(false);

                // Seter colores primeramente a la hora de cargar tikers, antes de interactuarlos
                if (tiker.getActive() == 0){
                    boton.setBackground(new Color(186, 186, 186));
                }else{
                    boton.setBackground(new Color(132, 208, 55));
                }

                boton.addActionListener(e -> {
                    try {
                        log("Presionaste: " + tiker.getSymbol());
                        if (tiker.getActive() == 1){
                            boton.setBackground(new Color(186, 186, 186));
                            tiker.setActive(0);
                        }else{
                            boton.setBackground(new Color(132, 208, 55));
                            tiker.setActive(1);
                        }
                        // Comitear cambios
                        this.tikerServ.saveTiker(tiker);
                    }catch (Exception exception){

                        log("Tiro una Exepcion al intentar cambiar estado del boton");
                        log(exception.getMessage());
                    }
                });

                panel_con_botones.add(boton);
            }

            panel_con_botones.revalidate();
            panel_con_botones.repaint();

            log("Botones cargados correctamente.");
        }else {
            log("No existen Tikers para crear botones!");
        }
    }


    //log
    public void log(String mensaje) {
        SwingUtilities.invokeLater(() -> {
            textAreaLogs.append(mensaje + "\n");
            textAreaLogs.setCaretPosition(textAreaLogs.getDocument().getLength());
        });
    }
}
