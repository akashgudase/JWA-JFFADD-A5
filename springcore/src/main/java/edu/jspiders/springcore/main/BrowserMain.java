package edu.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.jspiders.springcore.bean.Browser;
import edu.jspiders.springcore.config.ApplicationConfiguration;

public class BrowserMain {

	public static void main(String[] args) {

//		 ApplicationContext applicationContext = new
//		 AnnotationConfigApplicationContext("edu.jspiders.springcore.bean");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		Browser browser = applicationContext.getBean(Browser.class);
		System.out.println(browser);
		((AnnotationConfigApplicationContext) applicationContext).close();
	}

}
