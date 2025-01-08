package edu.jspiders.jdbc.operation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserOperation {

	private Driver driver;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	}

	private void closeConnection() throws SQLException {
		if (preparedStatement != null)
			preparedStatement.close();
		if (connection != null)
			connection.close();
		if (driver != null)
			DriverManager.deregisterDriver(driver);
	}

	public void signUp() throws SQLException, ClassNotFoundException {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter user id");
			int id = scanner.nextInt();
			System.out.println("Enter user name");
			String name = scanner.next();
			System.out.println("Enter user email id");
			String email = scanner.next();
			System.out.println("Enter user mobile number");
			long mobile = scanner.nextLong();
			System.out.println("Enter user password");
			String password = scanner.next();
			openConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setLong(4, mobile);
			preparedStatement.setString(5, password);
			preparedStatement.executeUpdate();
			System.out.println("Sign up successfull");

		} finally {
			closeConnection();
		}
	}

	public void logIn() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user email");
		String email = scanner.next();
		System.out.println("Enter user password");
		String password = scanner.next();
		try {
			openConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				if (resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password))
					System.out.println("Login successfull");
				else
					System.out.println("Invalid email or password");
			} else
				System.out.println("Invalid email or password");
		} finally {
			closeConnection();
		}
	}

}
