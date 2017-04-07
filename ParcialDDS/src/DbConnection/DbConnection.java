package DbConnection;

import java.sql.*;

public class DbConnection {
	
	/** Parametros de conexion */
	private static String bd = "Banco";
	private static String login = "root";
	private static String password = "1234";
	private static String url = "jdbc:mysql://localhost/" + bd;

	private Connection connection = null;

	/** Constructor de DbConnection */
	public DbConnection() {
		try {
			// obtenemos el driver de para mysql
			Class.forName("com.mysql.jdbc.Driver");
			// obtenemos la conexi�n
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				System.out.println("Conexi�n a base de datos " + bd + " OK\n");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Permite retornar la conexi�n */
	public Connection getConnection() {
		return connection;
	}


}
