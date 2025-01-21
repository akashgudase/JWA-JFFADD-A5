package edu.jspiders.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	protected String getHomePage() {
		return "home";
	}

	@RequestMapping(path = "/add-student-page")
	protected String getAddStudentPage() {
		return "add_student";
	}

}
