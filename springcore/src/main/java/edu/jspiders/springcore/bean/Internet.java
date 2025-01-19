package edu.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Internet {

	{
		System.out.println("Internet is created");
	}

	@Value("100 mbps")
	private String speed;

}
