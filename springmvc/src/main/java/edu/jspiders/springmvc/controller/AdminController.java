package edu.jspiders.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jspiders.springmvc.dto.Admin;
import edu.jspiders.springmvc.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(path = "/add-admin", method = RequestMethod.POST)
	protected String addAdmin(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, ModelMap modelMap) {
		boolean adminAdded = adminService.addAdmin(email, password);
		if (adminAdded) {
			modelMap.addAttribute("message", "Admin added");
			return "login";
		} else {
			modelMap.addAttribute("message", "Something went wrong");
			return "sign_up";
		}
	}

	@RequestMapping(path = "/auth-admin", method = RequestMethod.POST)
	protected String authenticateAdmin(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, ModelMap modelMap) {
		Admin authenticatedAdmin = adminService.authenticateAdmin(email, password);
		if (authenticatedAdmin != null)
			return "home";
		else {
			modelMap.addAttribute("message", "Invalid email or password");
			return "login";
		}
	}

}
