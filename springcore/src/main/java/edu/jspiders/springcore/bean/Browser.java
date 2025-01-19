package edu.jspiders.springcore.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Browser {

	{
		System.out.println("Browser is created");
	}

	// @Value("Google Chrome")
	private String name;
	// @Value("132.0.6834.83")
	private String version;
	// @Autowired
	private Internet internet;

	public Browser(@Value("Google Chrome") String name, @Value("132.0.6834.83") String version,
			@Autowired Internet internet) {
		super();
		this.name = name;
		this.version = version;
		this.internet = internet;
	}

//	public String getName() {
//		return name;
//	}
//
//	@Value("Google Chrome")
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getVersion() {
//		return version;
//	}
//
//	@Value("132.0.6834.83")
//	public void setVersion(String version) {
//		this.version = version;
//	}
//
//	public Internet getInternet() {
//		return internet;
//	}
//
//	@Autowired
//	public void setInternet(Internet internet) {
//		this.internet = internet;
//	}

	@Override
	public String toString() {
		return "Browser [name=" + name + ", version=" + version + ", internet=" + internet + "]";
	}

}
