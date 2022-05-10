package tema5;

import java.util.Scanner;


public class ExamenGestionTerminales {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Opcion selecionada
		int opcion = -1;

		// Mientras no se seleccione salir seguirmos ejecutando el programa
		while (opcion != 5) {
			System.out.println("**** Bienvenido a PhoneStorage ****\r\n" + "**** Administración *******\r\n"
					+ "1. Introducir Datos de Terminales\r\n" + "2. Modificar Terminal\r\n"
					+ "3. Mostrar Terminales\r\n" + "4. Eliminar Terminal\r\n" + "5. Salir\r\n" + "Opción (1-5):");

			opcion = teclado.nextInt();

			switch (opcion) {
			case 1:
				TerminalDAO.insertarTerminal();
				break;
			case 2:
				TerminalDAO.modificarTerminal();
				break;
			case 3:
				TerminalDAO.mostrarTerminal();
				break;
			case 4:
				TerminalDAO.eliminarTerminal();
				break;

			}
			
		}
		
		teclado.close();

	}
	
	



}
