package org.openfx.PrimeraVentana;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class FormularioJugador extends GridPane {

	Label lblNombre = new Label("Nombre:");
	Label lblSexo = new Label("Sexo:");
	Label lblEdad = new Label("Edad:");
	Label lblBoletin = new Label("Acepto las condiciones,\n os pago lo que sea");

	TextField txtNombre = new TextField();
	CheckBox chkBoletin = new CheckBox();
	// Dejamos marcado por defecto el checkbox del boletin

	// Creamos los radiobutton
	RadioButton radHombre = new RadioButton("Hombre");
	RadioButton radMujer = new RadioButton("Mujer");

	ToggleGroup grpSexo = new ToggleGroup();

	ChoiceBox chEdad = new ChoiceBox();

	// Creamos un boton
	Button btnAceptar = new Button("Aceptar");

	public FormularioJugador() {

		// Asignamos los radiobutton al toggleGroup
		radHombre.setToggleGroup(grpSexo);
		radMujer.setToggleGroup(grpSexo);

		for (int i = 0; i < 121; i++)
			chEdad.getItems().add(i);

		// Primera fila
		this.add(lblNombre, 0, 0);
		this.add(txtNombre, 1, 0, 2, 1);

		// Segunda Fila
		this.add(lblSexo, 0, 1);
		this.add(radMujer, 1, 1);
		this.add(radHombre, 2, 1);

		// Tercera Fila
		this.add(lblEdad, 0, 2);
		this.add(chEdad, 1, 2);

		// Cuarta Fila
		this.add(lblBoletin, 0, 3);
		this.add(chkBoletin, 1, 3);

		// Quinta fila
		this.add(btnAceptar, 0, 4, 4, 1);

		// TODO Auto-generated constructor stub
	}

}
