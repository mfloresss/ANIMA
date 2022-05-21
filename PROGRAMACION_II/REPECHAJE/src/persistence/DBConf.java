package persistence;

import java.sql.*;

public class DBConf {
	// Librera de MySQL
	public String driver = "com.mysql.cj.jdbc.Driver";

	// Nombre de la base de datos
	public String database = "Repechaje_ProgII";

	// Host
	public String hostname = "localhost";

	// Puerto
	public String port = "3306";

	// Ruta de nuestra base de datos (desactivamos el uso de SSL con
	// "?useSSL=false")
	public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	// Nombre de usuario
	public String username = "root";

	// Clave de usuario
	public String password = "";

	public Connection connection;

	public Connection connectMySQL() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Fallo la conexion con la base de datos");
		}
		return connection;
	}

	public void disconnectMySQL() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("conexion terminada");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}