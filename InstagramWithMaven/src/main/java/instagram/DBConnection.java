package instagram;

import java.sql.*;

public class DBConnection {

	private static DBConnection connectionInstance = null;
	private static Connection connection = null;

	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection
					("jdbc:mysql://localhost3306/instagram", "root", "Imamuspeshenbiznes1$");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

	public static DBConnection getInstance() {
		synchronized (DBConnection.class) {
			if (connectionInstance == null) {
				connectionInstance = new DBConnection();
			}
		}

		return connectionInstance;
	}


}
