package org.openfx.PrimeraVentana;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VentanaGrid extends Application {

	@Override
	public void start(Stage stage) {

		// Creamos un panel de grid
		// Este panel es como una tabla
		GridPane panelGrid = new GridPane();

		Label lblNombre = new Label("Nombre:");
		Label lblSexo = new Label("Sexo:");
		Label lblEdad = new Label("Edad:");
		Label lblBoletin = new Label("Acepto las condiciones,\n os pago lo que sea");

		TextField txtNombre = new TextField();
		CheckBox chkBoletin = new CheckBox();
		// Dejamos marcado por defecto el checkbox del boletin
		chkBoletin.setSelected(true);

		// Creamos los radiobutton
		RadioButton radHombre = new RadioButton("Hombre");
		RadioButton radMujer = new RadioButton("Mujer");

		ToggleGroup grpSexo = new ToggleGroup();
		// Asignamos los radiobutton al toggleGroup
		radHombre.setToggleGroup(grpSexo);
		radMujer.setToggleGroup(grpSexo);

		// Creamos el Select (ChoiceBox) y lo llenamos de valores
		ChoiceBox chEdad = new ChoiceBox();
		for (int i = 0; i < 121; i++)
			chEdad.getItems().add(i);

		// Creamos un boton
		Button btnAceptar = new Button("Aceptar");

		// Alineamos el boton al centro
		btnAceptar.setAlignment(Pos.CENTER);

		// Añadimos los controles al grid

		// Primera fila
		panelGrid.add(lblNombre, 0, 0);
		panelGrid.add(txtNombre, 1, 0, 2, 1);

		// Segunda Fila
		panelGrid.add(lblSexo, 0, 1);
		panelGrid.add(radMujer, 1, 1);
		panelGrid.add(radHombre, 2, 1);

		// Tercera Fila
		panelGrid.add(lblEdad, 0, 2);
		panelGrid.add(chEdad, 1, 2);

		// Cuarta Fila
		panelGrid.add(lblBoletin, 0, 3);
		panelGrid.add(chkBoletin, 1, 3);

		// Quinta fila
		panelGrid.add(btnAceptar, 0, 4, 4, 1);

		// La scene contiene los panel
		var scene = new Scene(panelGrid, 400, 300);

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
