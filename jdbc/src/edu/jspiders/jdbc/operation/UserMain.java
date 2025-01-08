package edu.jspiders.jdbc.operation;

import java.sql.SQLException;

public class UserMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserOperation userOperation = new UserOperation();

//		try {
//			userOperation.signUp();
//		} catch (Exception e) {
//			System.out.println("Something went wrong");
//		}

		userOperation.logIn();

	}

}
