package tema5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.ConexionBD;

public class JugadorDAO {

	/**
	 * Recibe un JugadorVO y actualiza solo los campos no nulos
	 * 
	 * @param jugador
	 * @return 0 si hubo algun fallo y 1 si se modifico correctamente
	 */
	public static int actualizarJugador(JugadorVO jugador) {
		int resultado = 0;
		int posicion = 1;

		String query = "UPDATE jugador SET ";

		// Comprobamos que no nos hayan metido un jugador nulo
		if (jugador == null)
			return 0;

		// Comprobamos si el nombre se ha introducido para modificar
		// En cuyo caso lo a�adimos a la query
		if (jugador.getNombre() != null && !jugador.getNombre().equals("")) {
			query = query + "nombre=?";
			posicion++;
		}

		// Para los siguientes campos, hay que poner la "," si ya hab�a antes
		// un campo previo en el set, lo sabemos porque la posicion
		// ya se habra incrementado y no sera 1
		if (jugador.getEdad() >= 0) {
			if (posicion == 1)
				query = query + "edad=?";
			else
				query = query + ",edad=?";

			posicion++;
		}

		if (jugador.getAltura() >= 0) {
			if (posicion == 1)
				query = query + "altura=?";
			else
				query = query + ",altura=?";

			posicion++;
		}

		if (jugador.getSexo() != null && !jugador.getSexo().equals("")) {
			if (posicion == 1)
				query = query + "sexo=?";
			else
				query = query + ",sexo=?";

			posicion++;
		}

		// A�adimos el where al final para que modifique solo el jugador
		query = query.concat(" WHERE idjugador=?");
		System.out.println(query);

		// Si no hay ningun campo a modificar nos salimos
		if (posicion == 1)
			return 0;

		// Nos conectamos a la BD
		Connection con = ConexionBD.conectarBD();

		try {
			// Creamos el preparedstaement
			PreparedStatement pStmt = con.prepareStatement(query);

			// Reseteamos la posicion
			posicion = 1;

			if (jugador.getNombre() != null && !jugador.getNombre().equals("")) {
				pStmt.setString(posicion, jugador.getNombre());
				posicion++;
			}

			if (jugador.getEdad() >= 0) {
				pStmt.setInt(posicion, jugador.getEdad());
				posicion++;
			}

			if (jugador.getAltura() >= 0) {
				pStmt.setInt(posicion, jugador.getAltura());
				posicion++;
			}

			if (jugador.getSexo() != null && !jugador.getSexo().equals("")) {
				pStmt.setString(posicion, jugador.getSexo());
				posicion++;
			}

			// Ponemos el id del jugador
			pStmt.setInt(posicion, jugador.getId());

			// Ejecutamos la instruccion
			resultado = pStmt.executeUpdate();

			pStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultado;

	}

	public static int actualizarJugador2(JugadorVO jugador) {
		int resultado = 0;

		String query = "UPDATE jugador SET nombre=?,edad=?,altura=?,sexo=? WHERE idjugador=?";

		// Nos conectamos a la BD
		Connection con = ConexionBD.conectarBD();

		try {
			// Creamos el preparedstaement
			PreparedStatement pStmt = con.prepareStatement(query);

			// Ponemos los parametros en las ?
			pStmt.setString(1, jugador.getNombre());
			pStmt.setInt(2, jugador.getEdad());
			pStmt.setInt(3, jugador.getAltura());
			pStmt.setString(4, jugador.getSexo());
			pStmt.setInt(5, jugador.getId());

			// Ejecutamos la instruccion
			resultado = pStmt.executeUpdate();

			pStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultado;

	}

	/**
	 * Nos introduce en la BD los datos del jugador
	 * 
	 * @param id
	 * @param nombre
	 * @param edad
	 * @param altura
	 * @param sexo
	 * @return 1 si se insert� el registro en BD, 0 si no se pudo
	 */
	public static int insertarJugador(int id, String nombre, int edad, int altura, String sexo) {
		// Variable para retornar si se pudo insertar
		int resultado = 0;

		// Conexion para acceder a BD
		Connection con = null;

		try {

			// Nos conectamos a la BD
			con = ConexionBD.conectarBD();

			// Consulta a ejecutar
			String query = "insert into jugador values (?,?,?,?,?)";

			// El preparedStatement lo genera la conexion utilizando
			// la consulta/query a ejecutar
			PreparedStatement pStmt = con.prepareStatement(query);

			pStmt.setInt(1, id);
			pStmt.setString(2, nombre);
			pStmt.setInt(3, edad);
			pStmt.setInt(4, altura);
			pStmt.setString(5, sexo);

			// Ejecutamos la query
			resultado = pStmt.executeUpdate();

			// Cerramos el statement
			pStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Cerramos la conexion
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// devolvemos el resultado
		return resultado;

	}

	/**
	 * Nos introduce en la BD los datos del jugador
	 * 
	 * @param jugador
	 * @return 1 si se insert� el registro en BD, 0 si no se pudo
	 */
	public static int insertarJugador(JugadorVO jugador) {
		// Variable para retornar si se pudo insertar
		int resultado = 0;

		// Conexion para acceder a BD
		Connection con = null;

		try {

			// Nos conectamos a la BD
			con = ConexionBD.conectarBD();

			// Consulta a ejecutar
			String query = "insert into jugador values (?,?,?,?,?)";

			// El preparedStatement lo genera la conexion utilizando
			// la consulta/query a ejecutar
			PreparedStatement pStmt = con.prepareStatement(query);

			pStmt.setInt(1, jugador.getId());
			pStmt.setString(2, jugador.getNombre());
			pStmt.setInt(3, jugador.getEdad());
			pStmt.setInt(4, jugador.getAltura());
			pStmt.setString(5, jugador.getSexo());

			// Ejecutamos la query
			resultado = pStmt.executeUpdate();

			// Cerramos el statement
			pStmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Cerramos la conexion
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// devolvemos el resultado
		return resultado;

	}

	/**
	 * Por hacer Recibe el id del jugador y lo elimina de BD
	 * 
	 * @param idJugador identificador del jugador a borrar
	 * @return 1 si se pudo eliminar y 0 en caso contrario
	 */
	public static int eliminarJugador(int idJugador) {
		return 0;
	}

	public static void mostrarJugadores(int pagina, int numElementos) {

		// Nos conectamos a la BD
		Connection con = ConexionBD.conectarBD();

		String query = "SELECT * FROM jugador LIMIT ? offset ?";

		try {
			// Generamos el preparedStatement a partir de la query sql
			PreparedStatement pStmt = con.prepareStatement(query);

			pStmt.setInt(1, numElementos);
			pStmt.setInt(2, (pagina - 1) * numElementos);

			// Ejecutamos la query y nos devuelve los datos
			// En una estructura resultset
			ResultSet res = pStmt.executeQuery();

			// Boolean que nos comprueba si es el ultimo elemento
			boolean ultimo = true;
			int id = 0, altura = 0, edad = 0;
			String sexo = "", nombre = "";

			System.out.println("********************************");
			System.out.println("**********JUGADORES*************");

			System.out.println("********************************");

			// Mientras haya un siguiente elemento seguimos leyendo
			// Registros, next nos pasa al siguiente registro y nos devuelve
			// true si hay mas registros por leer
			while (res.next()) {
				// Pasamos al siguiente elemento

				id = res.getInt("idjugador");
				nombre = res.getString("nombre");
				edad = res.getInt("edad");
				altura = res.getInt("altura");
				sexo = res.getString("sexo");

				System.out.println("Id: " + id);
				System.out.println("nombre: " + nombre);
				System.out.println("edad: " + edad);
				System.out.println("altura: " + altura);
				System.out.println("sexo: " + sexo);

			}

			System.out.println("********************************");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mostrarJugadores() {

		// Nos conectamos a la BD
		Connection con = ConexionBD.conectarBD();

		String query = "SELECT * FROM jugador";

		try {
			// Generamos el preparedStatement a partir de la query sql
			PreparedStatement pStmt = con.prepareStatement(query);

			// Ejecutamos la query y nos devuelve los datos
			// En una estructura resultset
			ResultSet res = pStmt.executeQuery();

			// Boolean que nos comprueba si es el ultimo elemento
			boolean ultimo = true;
			int id = 0, altura = 0, edad = 0;
			String sexo = "", nombre = "";

			System.out.println("********************************");
			System.out.println("**********JUGADORES*************");

			System.out.println("********************************");

			// Mientras haya un siguiente elemento seguimos leyendo
			// Registros, next nos pasa al siguiente registro y nos devuelve
			// true si hay mas registros por leer
			while (res.next()) {
				// Pasamos al siguiente elemento

				id = res.getInt("idjugador");
				nombre = res.getString("nombre");
				edad = res.getInt("edad");
				altura = res.getInt("altura");
				sexo = res.getString("sexo");

				System.out.println("Id: " + id);
				System.out.println("nombre: " + nombre);
				System.out.println("edad: " + edad);
				System.out.println("altura: " + altura);
				System.out.println("sexo: " + sexo);

			}

			System.out.println("********************************");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<JugadorVO> mostrarJugadoresLista() {

		ArrayList<JugadorVO> listaJugadores = new ArrayList<JugadorVO>();

		// Nos conectamos a la BD
		Connection con = ConexionBD.conectarBD();

		String query = "SELECT * FROM jugador";

		try {
			// Generamos el preparedStatement a partir de la query sql
			PreparedStatement pStmt = con.prepareStatement(query);

			// Ejecutamos la query y nos devuelve los datos
			// En una estructura resultset
			ResultSet res = pStmt.executeQuery();

			// Boolean que nos comprueba si es el ultimo elemento
			boolean ultimo = true;
			int id = 0, altura = 0, edad = 0;
			String sexo = "", nombre = "";

			// Mientras haya un siguiente elemento seguimos leyendo
			// Registros, next nos pasa al siguiente registro y nos devuelve
			// true si hay mas registros por leer
			while (res.next()) {
				// Pasamos al siguiente elemento

				// Creamos el jugadorVO dentro del bucle para que
				// Cada registro tenga su propio objeto
				JugadorVO jugador = new JugadorVO();

				jugador.setId(res.getInt("idjugador"));
				jugador.setNombre(res.getString("nombre"));
				jugador.setEdad(res.getInt("edad"));
				jugador.setAltura(res.getInt("altura"));
				jugador.setSexo(res.getString("sexo"));

				// El jugador que acabamos de cargar desde BD
				// Lo metemos en la lista
				listaJugadores.add(jugador);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Devolvemos la lista cargada con los jugadores
		return listaJugadores;

	}

}
