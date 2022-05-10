package tema5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utils.ConexionBD;

public class TerminalDAO {
	
	public static final String CAMPO_ID = "idphones";
	public static final String CAMPO_MODELO = "model";
	public static final String CAMPO_MARCA = "brand";
	public static final String CAMPO_RAM = "ram";
	public static final String CAMPO_ROM = "rom";
	public static final String CAMPO_PULGADAS = "inches";
	public static final String CAMPO_OS = "os";
	public static final String CAMPO_PRECIO = "price";
	public static final String CAMPO_5G = "5g";


	private static Scanner teclado = new Scanner(System.in);
	
	public static void insertarTerminal() {
		
		TerminalVO movil = new TerminalVO();
		
		System.out.println("Introduce el id:");
		movil.setId(teclado.nextInt());

		System.out.println("Introduce la marca:");
		movil.setBrand(teclado.next());
		
		System.out.println("Introduce el modelo:");
		movil.setModel(teclado.next());
		
		System.out.println("Introduce la ram:");
		movil.setRam(teclado.nextInt());

		System.out.println("Introduce la rom:");
		movil.setRom(teclado.nextInt());
	
		System.out.println("Introduce el sistema operativo:");
		movil.setSo(teclado.next());
		
		System.out.println("Introduce el precio:");
		movil.setPrice(teclado.nextDouble());
		
		System.out.println("Introduce las pulgadas:");
		movil.setInches(teclado.next());
		
		System.out.println("Es 5g(S/N)");
		movil.setIs5g((teclado.next().equalsIgnoreCase("S")?true:false));
		
		//Insertamos el terminal en bd
		// Variable para retornar si se pudo insertar
		int resultado = 0;

		// Conexion para acceder a BD
		Connection con = null;
		
		try {

	
			// Nos conectamos a la BD
			con = ConexionBD.conectarBD("tiendamoviles");

			// Consulta a ejecutar
			String query = "insert into phones values (?,?,?,?,?,?,?,?,?)";

			// El preparedStatement lo genera la conexion utilizando
			// la consulta/query a ejecutar
			PreparedStatement pStmt = con.prepareStatement(query);

			pStmt.setInt(1, movil.getId());
			pStmt.setString(2, movil.getBrand());
			pStmt.setString(3, movil.getModel());
			pStmt.setInt(4, movil.getRam());
			pStmt.setInt(5, movil.getRom());
			pStmt.setString(6, movil.getSo());
			pStmt.setString(7, movil.getInches());
			pStmt.setDouble(8, movil.getPrice());
			pStmt.setBoolean(9, movil.isIs5g());


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
		
				
	}
	
	public static void modificarTerminal() {
		
		int idTerminal = -1;
		TerminalVO movil = new TerminalVO();
		String nombreCampo="", valor="";
		
		//Leemos el id del terminal a modificar
		System.out.println("Introduce el Id del movil a modificar:");
		idTerminal= teclado.nextInt();
		
		//Cargamos el movil desde BD y lo mostramos
		movil = cargarTerminal(idTerminal);
		movil.toString();
		
		//Leemos el nombre del campo a modificar
		System.out.println("Introduce el nombre del campo a modificar:");
		nombreCampo= teclado.next();

		//Leemos el valor a modificar
		System.out.println("Introduce el valor que quiere poner:");
		valor= teclado.next();

		modificarCampoTerminal(idTerminal, nombreCampo, valor);
		
	}
	
	public static int modificarCampoTerminal(int idTerminal, String nombreCampo,String valor)
	{
	int resultado=0;
		
		String query = "UPDATE phones set ";
		
		//Nos conectamos a la BD
		Connection con = ConexionBD.conectarBD();	
		
		try {
			//Creamos el preparedstaement
			PreparedStatement pStmt = con.prepareStatement(""); 

		
		switch (nombreCampo)
		{
		case TerminalDAO.CAMPO_MARCA:
			query = query.concat(TerminalDAO.CAMPO_MARCA + "=? WHERE idphones =?");
			pStmt = con.prepareStatement(query);
			pStmt.setString(1, valor);
			break;

		case TerminalDAO.CAMPO_MODELO:
			query = query.concat(TerminalDAO.CAMPO_MODELO + "=? WHERE idphones =?");
			pStmt = con.prepareStatement(query);
			pStmt.setString(1, valor);
			break;

		case TerminalDAO.CAMPO_PULGADAS:
			query = query.concat(TerminalDAO.CAMPO_PULGADAS + "=? WHERE idphones =?");
			pStmt = con.prepareStatement(query);
			pStmt.setString(1, valor);
			break;
			
		case TerminalDAO.CAMPO_RAM:
			query = query.concat(TerminalDAO.CAMPO_RAM + "=? WHERE idphones =?");
			pStmt = con.prepareStatement(query);
			pStmt.setInt(1, Integer.valueOf(valor));
			break;
		
		case TerminalDAO.CAMPO_ROM:
			query = query.concat(TerminalDAO.CAMPO_ROM + "=? WHERE idphones =?");
			pStmt = con.prepareStatement(query);
			pStmt.setInt(1, Integer.valueOf(valor));
			break;
			
		case TerminalDAO.CAMPO_5G:
			query = query.concat(TerminalDAO.CAMPO_5G + "=? WHERE idphones =?");
			pStmt = con.prepareStatement(query);
			pStmt.setBoolean(1, (valor.equals("S")?true:false));
			break;

		case TerminalDAO.CAMPO_PRECIO:
			query = query.concat(TerminalDAO.CAMPO_PRECIO + "=? WHERE idphones =?");
			pStmt = con.prepareStatement(query);
			pStmt.setDouble(1, Double.valueOf(valor));
			break;
			
			
		}
		
			//Ponemos el segundo parametro
			pStmt.setInt(2, idTerminal);
		
			//Ejecutamos la instruccion
			resultado = pStmt.executeUpdate();
			
			pStmt.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		return resultado;
		

	}
	
	public static TerminalVO cargarTerminal(int idTerminal)
	{
		//TerminalVO que va a recoger el registro
		TerminalVO movil = new TerminalVO();
		
		//Nos conectamos a la BD
		Connection con = ConexionBD.conectarBD();
		
		String query = "SELECT * FROM phones WHERE idphones = ?";
		
		
		try {
			//Generamos el preparedStatement a partir de la query sql
			PreparedStatement pStmt = con.prepareStatement(query);
			//En la ? de la primera posicion se pone el valor del terminal a cargar
			pStmt.setInt(1, idTerminal);
			
			//Ejecutamos la query y nos devuelve los datos 
			//En una estructura resultset
			ResultSet res = pStmt.executeQuery();

			//Mientras haya un siguiente elemento seguimos leyendo 
			//Registros, next nos pasa al siguiente registro y nos devuelve
			//true si hay mas registros por leer
			if (res.next())
			{
			
			
				movil.setId(res.getInt("idphones"));
				movil.setBrand(res.getString("brand"));
				movil.setModel(res.getString("model"));
				movil.setRam(res.getInt("ram"));
				movil.setRom(res.getInt("rom"));
				movil.setInches(res.getString("inches"));
				movil.setSo(res.getString("os"));
				movil.setPrice(res.getDouble("price"));
				movil.setIs5g((res.getInt("5g")==1?true:false));
			
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movil;
	}

	
	public static void mostrarTerminal() {
		
		// Opcion selecionada
		int opcion = -1;
		
		System.out.println("1. Mostrar todos ordenados por modelo desc\r\n"
				+ "2. Mostrar todos ordenados por precio desc\r\n"
				+ "3. Mostrar los de Marca…\r\n"
				+ "4. Salir\r\n"
				+ "Opción(1-4):");
		
		switch (opcion)
		{
		case 1:mostrarTerminales("model");
		break;
		case 2:mostrarTerminales("price");
		break;
		case 3:
			//Primero pedir la marca
			String marca ="";
			System.out.println("Cual es la marca:");
			marca = teclado.next();
			//Mostramos los terminales de dicha marca
			mostrarTerminalesCampo("brand",marca);
		break;

		}
		
	}

	
	public static void eliminarTerminal() {
		
	}
	

	
	public static void mostrarTerminales(String campoOrden)
	{
		
		//Nos conectamos a la BD
		Connection con = ConexionBD.conectarBD();
		
		String query = "SELECT * FROM phones ORDER BY " + campoOrden + "DESC";
		
		
		try {
			//Generamos el preparedStatement a partir de la query sql
			PreparedStatement pStmt = con.prepareStatement(query);
			
			//Ejecutamos la query y nos devuelve los datos 
			//En una estructura resultset
			ResultSet res = pStmt.executeQuery();
			
			//Boolean que nos comprueba si es el ultimo elemento
			boolean ultimo = true;
			
			System.out.println("********************************");
			System.out.println("**********MOVILES*************");
			
			System.out.println("********************************");
			
			
			//Mientras haya un siguiente elemento seguimos leyendo 
			//Registros, next nos pasa al siguiente registro y nos devuelve
			//true si hay mas registros por leer
			while (res.next())
			{
			//Pasamos al siguiente elemento
			
				System.out.print(res.getInt("idphones"));
				System.out.print(" - " +res.getString("brand"));
				System.out.print(" - " +res.getString("model"));
				System.out.print(" - " +res.getInt("ram"));
				System.out.print(" - " +res.getInt("rom"));
				System.out.print(" - " +res.getString("inches"));
				System.out.print(" - " +res.getString("os"));
				System.out.print(" - " +res.getDouble("price"));
				System.out.print(" - " + (res.getInt("5g")==1?"Tiene 5g":"No tiene 5g"));




			
			}
			
			System.out.println("********************************");


			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void mostrarTerminalesCampo(String campo,String valor)
	{
		
		//Nos conectamos a la BD
		Connection con = ConexionBD.conectarBD();
		
		String query = "SELECT * FROM phones WHERE " + campo + "='" +valor+"'";;
		
		
		try {
			//Generamos el preparedStatement a partir de la query sql
			PreparedStatement pStmt = con.prepareStatement(query);
			
			//Ejecutamos la query y nos devuelve los datos 
			//En una estructura resultset
			ResultSet res = pStmt.executeQuery();
			
			//Boolean que nos comprueba si es el ultimo elemento
			boolean ultimo = true;
			
			System.out.println("********************************");
			System.out.println("**********MOVILES*************");
			
			System.out.println("********************************");
			
			
			//Mientras haya un siguiente elemento seguimos leyendo 
			//Registros, next nos pasa al siguiente registro y nos devuelve
			//true si hay mas registros por leer
			while (res.next())
			{
			//Pasamos al siguiente elemento
			
				System.out.print(res.getInt("idphones"));
				System.out.print(" - " +res.getString("brand"));
				System.out.print(" - " +res.getString("model"));
				System.out.print(" - " +res.getInt("ram"));
				System.out.print(" - " +res.getInt("rom"));
				System.out.print(" - " +res.getString("inches"));
				System.out.print(" - " +res.getString("os"));
				System.out.print(" - " +res.getDouble("price"));
				System.out.print(" - " + (res.getInt("5g")==1?"Tiene 5g":"No tiene 5g"));




			
			}
			
			System.out.println("********************************");


			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
