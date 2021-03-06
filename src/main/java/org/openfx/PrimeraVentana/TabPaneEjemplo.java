package org.openfx.PrimeraVentana;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TabPaneEjemplo extends Application {

	@Override
	public void start(Stage stage) {

		// Creamos un panel de pestañas
		TabPane panelPestanas = new TabPane();
		BorderPane panelBotones = new BorderPane();

		// Controladores
		Button btnCentro = new Button("centro");
		Button btnArriba = new Button("arriba");
		Button btnAbajo = new Button("abajo");
		Button btnIzquierda = new Button("izquierda");
		Button btnDerecha = new Button("derecha");

		// Ponemos los botones en las posiciones adecuadas
		panelBotones.setTop(btnArriba);
		panelBotones.setBottom(btnAbajo);
		panelBotones.setLeft(btnIzquierda);
		panelBotones.setRight(btnDerecha);

		panelBotones.setCenter(btnCentro);
		// Alineamos el boton de arriba al centro
		panelBotones.setAlignment(btnArriba, Pos.CENTER);
		// Dejamos espacios por los laterales
		// panelBotones.setPadding(new Insets(20, 30, 40, 34));
		panelBotones.setMargin(btnDerecha, new Insets(20, 30, 40, 34));

		// Creamos 3 pestañas
		Tab pestana1 = new Tab("Pestaña1");
		Tab pestana2 = new Tab("Pestaña2");
		Tab pestana3 = new Tab("Pestaña3");

		// Hacemos que no se puedan cerrar las pestañas
		pestana1.setClosable(false);
		pestana2.setClosable(false);

		// Creamos nuestro panel personalizado con el formulario del jugador
		FormularioJugador fJugador = new FormularioJugador();

		// En la pestaña1 añadimos el contenido
		pestana1.setContent(fJugador);

		// En el contenido de la pestaña 2 ponemos el formulario del jugador
		pestana2.setContent(panelBotones);

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
