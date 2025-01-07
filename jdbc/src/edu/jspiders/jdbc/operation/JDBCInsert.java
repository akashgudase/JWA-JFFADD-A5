package edu.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert {

	private static Driver driver;
	private static Connection connection;
	private static Statement statement;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		openConnection();
		statement = connection.createStatement();
		int rows = statement
				.executeUpdate("INSERT INTO users VALUES(2, 'Suresh', 'suresh@gmail.com', 9876543211, 'Suresh@1234')");
		System.out.println(rows + " row(s) affected");
		closeConnection();
	}

	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");
	}

	private static void closeConnection() throws SQLException {
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		if (driver != null)
			DriverManager.deregisterDriver(driver);
	}

}
