package edu.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Load the Driver Class
		Class.forName("com.mysql.cj.jdbc.Driver");

		Driver driver = new com.mysql.cj.jdbc.Driver();

		// Register the driver
		DriverManager.registerDriver(driver);

		// Open connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");

		// Create statement
		Statement statement = connection.createStatement();

		// Execute statement
		boolean res = statement.execute("CREATE TABLE users(id int primary key, name varchar(20) not null, email varchar(20) not null unique, mobile bigint not null unique, password varchar(20) not null)");

		// Process the result
		System.out.println(res);
		System.out.println("Table is created");

		// Close connection
		statement.close();
		connection.close();

		// De-register the Driver
		DriverManager.deregisterDriver(driver);

	}

}
