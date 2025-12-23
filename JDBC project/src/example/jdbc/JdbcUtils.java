package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	public static Connection getConnection() throws SQLException {
		// this method is used to established connection with DB and return the same established Connection.
		String connectionUrl = "jdbc:mysql://localhost:3306/cdac";   
		String userId = "safwan";
		String password = "982247";
		Connection dbConnection = 
		DriverManager.getConnection(connectionUrl, userId, password);
		return dbConnection;
	}
}
