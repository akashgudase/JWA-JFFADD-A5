package edu.jspiders.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/my-servlet-5")
public class MyServlet5 implements Servlet {

	static {
		System.out.println("Servlet is loaded");
	}

	{
		System.out.println("Servlet is instantiated");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet is initialized");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet has provided the service");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet is destroyed");
	}

}
