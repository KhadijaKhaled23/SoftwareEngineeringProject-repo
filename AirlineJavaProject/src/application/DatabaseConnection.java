package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public Connection DatabaseLink;
	
	public Connection getConnection() {
		String DatabaseName = "mydatabase";
		String DatabaseUser = "root";
		String DatabasePassword = "Wonderful#45";
		
		String url = "jdbc:mysql://localhost/" + DatabaseName;
		

		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			DatabaseLink = DriverManager.getConnection(url, DatabaseUser, DatabasePassword);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return DatabaseLink;
		
		
	}

	
	
}
