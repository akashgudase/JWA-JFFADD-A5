package edu.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Load the Driver Class
		Class.forName("com.mysql.cj.jdbc.Driver");

		Driver driver = new com.mysql.cj.jdbc.Driver();

		// Register the driver
		DriverManager.registerDriver(driver);

		// Open connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");

		// Create statement
		Statement statement = connection.createStatement();

		// Execute statement
		boolean res = statement.execute("CREATE DATABASE test");

		// Process the result
		System.out.println(res);
		System.out.println("Database is created");
		
		//Close connection
		statement.close();
		connection.close();
		
		//De-register the Driver
		DriverManager.deregisterDriver(driver);
		

	}

}
