package edu.jspiders.springcore.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseConnection {

	{
		System.out.println("DatabaseConnection is created");
	}

	private String db_url;
	private String user_name;
	private String password;

}
