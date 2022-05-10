package tema5;

import java.util.Scanner;

public class PrincipalBD {

	/*
	 * Siempre que utilizamos un servicio necesitamos Conectarnos al servicio, para
	 * eso es esta clase
	 * 
	 * Se necesitan siempre 4 parametros para conectarnos a un servicio ip o nombre
	 * de dominio: localhost en nuestro caso que es nuestra maquina usuario:root
	 * password:toor (en vuestro caso ""); puerto de comunicaciones del
	 * servicio:3306 para mysql Base de datos o esquema a utilizar
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		Scanner teclado = new Scanner(System.in);

		// Pedimos los datos del jugador
		System.out.println("Introduce el id:");
		int id = teclado.nextInt();

		System.out.println("Nombre:");
		String nombre = teclado.next();

		System.out.println("Introduce la edad:");
		int edad = teclado.nextInt();

		System.out.println("Introduce la altura:");
		int altura = teclado.nextInt();

		System.out.println("Sexo:");
		String sexo = teclado.next();

		// Insertamos los datos en BD
		JugadorDAO.insertarJugador(id, nombre, edad, altura, sexo);

		teclado.close();
*/
		
		JugadorDAO.mostrarJugadores();
		
		for (int i=12;i<=40;i++)
		{
			JugadorVO changFeng = new JugadorVO(i,"ChangFeng",18,178,"M");
			
			JugadorDAO.insertarJugador(changFeng);

		}
		
		JugadorVO yuria = new JugadorVO(9,"Yuria",6,115,"F");
		
		JugadorDAO.actualizarJugador2(yuria);
		
		JugadorVO raulm = new JugadorVO(10,"Manuel",-1,173,"");
		
		JugadorDAO.actualizarJugador(raulm);
		
		JugadorDAO.mostrarJugadores(3,10);

	}
}
