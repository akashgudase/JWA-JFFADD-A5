package edu.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.jspiders.springmvc.dto.Admin;

@Controller
public class PageController {

	@RequestMapping(path = "/sign-up-page")
	protected String getSignUpPage() {
		return "sign_up";
	}

	@RequestMapping(path = "/login-page")
	protected String getLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/home")
	protected String getHomePage(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("authenticated_admin");
		if (admin != null)
			return "home";
		else
			return "login";
	}

	@RequestMapping(path = "/add-student-page")
	protected String getAddStudentPage(HttpSession httpSession) {
		Admin admin = (Admin) httpSession.getAttribute("authenticated_admin");
		if (admin != null)
			return "add_student";
		else
			return "login";
	}

}
