package org.openfx.PrimeraVentana;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tema5.JugadorDAO;
import tema5.JugadorVO;

public class EjemploEventos extends Application {

	@Override
	public void start(Stage stage) {

		// Creamos un panel de grid
		// Este panel es como una tabla
		GridPane panelGrid = new GridPane();

		// Creamos un BorderPane
		BorderPane root = new BorderPane();

		// Creamos un ScrollPane para contener dentro
		// El grid pane
		ScrollPane scroll = new ScrollPane();
		// Metemos dentro del scrollpane el gridpane
		scroll.setContent(panelGrid);

		// Creamos el menu
		MenuBar menuPrincipal = new MenuBar();

		Menu MArchivo = new Menu("Archivo");
		Menu MGuardar = new Menu("Guardar");

		MenuItem MIAbrir = new MenuItem("Abrir");
		MenuItem MIGuardarPdf = new MenuItem("Guardar como PDF");
		MenuItem MIGuardarDocx = new MenuItem("Guardar Como Docx");
		MenuItem MICerrar = new MenuItem("Cerrar");

		// Cualdo pulsamos sobre la opcion cerrar se cierra la aplicacion
		MICerrar.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent ae) {

				stage.close();

			}

		});

		// Asociamos los menuitems al menu archivo
		MArchivo.getItems().addAll(MIAbrir, MGuardar, MICerrar);
		MGuardar.getItems().addAll(MIGuardarPdf, MIGuardarDocx);

		// Asociamos el menu a la barra de menu principal
		menuPrincipal.getMenus().add(MArchivo);

		// Ponemos el menubar en la parte superior del borderpane
		root.setTop(menuPrincipal);
		// Ponemos el ScrollPane en la parte central
		root.setCenter(scroll);

		Label lblId = new Label("Id:");
		Label lblAltura = new Label("Altura:");

		Label lblNombre = new Label("Nombre:");
		Label lblSexo = new Label("Sexo:");
		Label lblEdad = new Label("Edad:");
		Label lblBoletin = new Label("Acepto las condiciones,\n os pago lo que sea");

		TextField txtNombre = new TextField();
		TextField txtId = new TextField();

		TextField txtAltura = new TextField();
		txtAltura.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

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

		// Asignamos a la accion de pulsar el boton
		// Cuando se pulsa el boton insertamos en la BD
		// Los datos
		btnAceptar.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				JugadorVO jugador = new JugadorVO();

				// Recogemos el id
				jugador.setId(Integer.valueOf(txtId.getText()));

				jugador.setNombre(txtNombre.getText());

				jugador.setAltura(Integer.valueOf(txtAltura.getText()));

				jugador.setEdad((int) chEdad.getSelectionModel().getSelectedItem());

				RadioButton temp = (RadioButton) grpSexo.getSelectedToggle();
				if (temp.getText().equals("Mujer"))
					jugador.setSexo("M");
				else
					jugador.setSexo("H");

				JugadorDAO.insertarJugador(jugador);

				System.out.println(jugador.toString());

			}

		});

		// Cuando pasamos por encima cambiamos el color de fondo
		btnAceptar.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent mouseEvent) {

				btnAceptar.setStyle("-fx-background-color:#DDEEAA;");

				// btnAceptar.setBackground(new Background(
				// new BackgroundFill(Color.rgb(0, 0, 80, 0.7), new CornerRadii(5.0), new
				// Insets(-5.0))));
			}

		});

		// Cuando pasamos por encima cambiamos el color de fondo
		btnAceptar.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent mouseEvent) {

				btnAceptar.setStyle("-fx-background-color:#DDDDDD;");

				// btnAceptar.setBackground(new Background(
				// new BackgroundFill(Color.rgb(0, 0, 80, 0.7), new CornerRadii(5.0), new
				// Insets(-5.0))));
			}

		});

		// Alineamos el boton al centro
		btnAceptar.setAlignment(Pos.CENTER);

		// Añadimos los controles al grid

		// Primera fila
		panelGrid.add(lblId, 0, 0);
		panelGrid.add(txtId, 1, 0, 2, 1);

		// Segunda Fila
		panelGrid.add(lblNombre, 0, 1);
		panelGrid.add(txtNombre, 1, 1, 2, 1);

		// Tercera Fila
		panelGrid.add(lblAltura, 0, 2);
		panelGrid.add(txtAltura, 1, 2, 2, 1);

		// Cuarta Fila
		panelGrid.add(lblSexo, 0, 3);
		panelGrid.add(radMujer, 1, 3);
		panelGrid.add(radHombre, 2, 3);
		// Marcamos por defecto el radio de mujer
		radMujer.setSelected(true);

		// Quinta Fila
		panelGrid.add(lblEdad, 0, 4);
		panelGrid.add(chEdad, 1, 4);

		// Sexta Fila
		panelGrid.add(lblBoletin, 0, 5);
		panelGrid.add(chkBoletin, 1, 5);

		// Septima fila
		panelGrid.add(btnAceptar, 0, 6, 4, 1);

		// Ponemos margen en todas las celdas
		panelGrid.setVgap(10);
		panelGrid.setHgap(10);

		// Alineamos arriba al centro todas las celdas
		panelGrid.setAlignment(Pos.TOP_CENTER);

		// La scene contiene los panel
		var scene = new Scene(root, 400, 300);

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
