package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String url = "jdbc:mysql://localhost:3306/cursojsp?autoReconnect=true";
	private static String password = "admin";
	private static String user = "admin";
	private static Connection connection = null;

	static {

		conectar();
	}

	public SingleConnection() {

		conectar();
	}

	private static void conectar() {

		try {
			
			if(connection == null) {
				
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, password, user);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			
			throw new RuntimeException("Erro ao conectar com banco de dados");
		}
	}
	
	public static Connection getConnection() {
		
		return connection;
	}

}
