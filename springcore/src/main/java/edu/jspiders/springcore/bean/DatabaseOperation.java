package edu.jspiders.springcore.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseOperation {

	{
		System.out.println("DatabaseOperation is created");
	}

	private String query;

}
