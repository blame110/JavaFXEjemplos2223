package org.openfx.PrimeraVentana;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class TabPaneEjemplo extends Application {

	@Override
	public void start(Stage stage) {

		// Creamos un panel de pestañas
		TabPane panelPestanas = new TabPane();

		// Creamos 3 pestañas
		Tab pestana1 = new Tab("Pestaña1");
		Tab pestana2 = new Tab("Pestaña2");
		Tab pestana3 = new Tab("Pestaña3");

		// Hacemos que no se puedan cerrar las pestañas
		pestana1.setClosable(false);
		pestana2.setClosable(false);

		FormularioJugador fJugador = new FormularioJugador();

		pestana2.setContent(fJugador);

		// Añadimos las pestañas al panel
		panelPestanas.getTabs().addAll(pestana1, pestana2, pestana3);

		// La scene contiene los panel
		var scene = new Scene(panelPestanas, 400, 300);

		// El stage es el contenido global de la ventana
		stage.setScene(scene);

		// Mostramos la aplicacion visual
		stage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

}
