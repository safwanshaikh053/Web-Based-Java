package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRetrievalMain {

	public static void main(String[] args) {
		
		// Program to retrieve Data from Database using SELECT query and display it.
		
		// Step-1. Load The Driver
		 // we use class named Class which is already defined in java
		
		String driverClass = "com.mysql.cj.jdbc.Driver";     //package.package.package.package,ClassName   -> all Packages and the Driver is class.
		try {
			Class.forName(driverClass);
			System.out.println("Driver Loaded...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Step-2. Establish Connection
		
		// we needTCP\IP for Type-4 driver so we need connection URl
		
		String connectionUrl = "jdbc:mysql://localhost:3306/cdac";   // if there is SSL exception in the output : String connectionUrl = "jdbc:mysql://localhost:3306/cdac?useSSL=false";  
		String userId = "safwan";
		String password = "982247";
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			dbConnection = DriverManager.getConnection(connectionUrl, userId, password);
			System.out.println("Connection Established... with DataBase");
			
			// Step-3. Obtain some statement
			stmt = dbConnection.createStatement();
			
			// Step-4. Execute SQL query
			String sqlQuery = 
					"select student_name, student_city, student_id from students";
			rs = stmt.executeQuery(sqlQuery);
			
			//Step-5. Perform navigation on ResultSet => rs
			while(rs.next()) {
				String name = rs.getString(1);  // Name
				String city = rs.getString(2);  // City
				int id = rs.getInt(3);  // id
				System.out.println(id + " " + name + " " + city);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
