package org.openfx.PrimeraVentana;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class VentanaVBox extends Application {

	@Override
	public void start(Stage stage) {

		// Definimos los labels (textos)
		Label lblNombre = new Label("Nombre: ");
		Label lblAsunto = new Label("Asunto: ");
		Label lblEmail = new Label("Email: ");
		Label lblTexto = new Label("Comentario: ");

		// Definimos los campos para introducir datos
		TextField txtNombre = new TextField();
		TextField txtAsunto = new TextField();
		TextField txtEmail = new TextField();
		TextArea txtTexto = new TextArea();

		// Definimos el botón
		Button btnAceptar = new Button("Enviar");

		VBox panelVertical = new VBox();

		// Añadimos los nodos/controles a el panel de tipo VBOX
		panelVertical.getChildren().add(lblNombre);
		panelVertical.getChildren().add(txtNombre);
		panelVertical.getChildren().add(lblAsunto);
		panelVertical.getChildren().add(txtAsunto);
		panelVertical.getChildren().add(lblEmail);
		panelVertical.getChildren().add(txtEmail);
		panelVertical.getChildren().add(lblTexto);
		panelVertical.getChildren().add(txtTexto);
		panelVertical.getChildren().add(btnAceptar);

		// La scene contiene los panel
		var scene = new Scene(panelVertical, 400, 380);

		// El stage es el contenido global de la ventana
		stage.setScene(scene);

		// Mostramos la aplicacion visual
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}