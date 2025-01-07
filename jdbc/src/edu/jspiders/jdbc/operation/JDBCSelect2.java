package edu.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect2 {

	private static Driver driver;
	private static Connection connection;
	private static Statement statement;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		openConnection();
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString("name"));
			System.out.println(resultSet.getString("email"));
			System.out.println(resultSet.getLong("mobile"));
			System.out.println(resultSet.getString("password"));
		}
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
