package com.example.n7_tiker_lock;

import com.example.n7_tiker_lock.gui.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;


@SpringBootApplication
public class N7TikerLockApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(N7TikerLockApplication.class);
		app.setHeadless(false);

		ConfigurableApplicationContext context = app.run(args);

		SwingUtilities.invokeLater(() -> {
			Principal principal = context.getBean(Principal.class);
			principal.setContentPane(principal.panel);
			principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			principal.pack();
			principal.setLocationRelativeTo(null);
			principal.setTitle("N7 Ticker lock");
			principal.setVisible(true);
		});
	}
}


