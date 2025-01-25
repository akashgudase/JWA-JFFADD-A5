package edu.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

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
			@RequestParam(name = "password") String password, ModelMap modelMap, HttpSession httpSession) {
		Admin authenticatedAdmin = adminService.authenticateAdmin(email, password);
		if (authenticatedAdmin != null) {
			httpSession.setAttribute("authenticated_admin", authenticatedAdmin);
			return "home";
		} else {
			modelMap.addAttribute("message", "Invalid email or password");
			return "login";
		}
	}

	@RequestMapping(path = "/delete-admin")
	protected String deleteAdmin(@RequestParam(name = "id") int id, ModelMap modelMap) {
		boolean adminDeleted = adminService.deleteAdmin(id);
		if (adminDeleted) {
			modelMap.addAttribute("message", "Admin deleted");
			return "login";
		} else {
			modelMap.addAttribute("message", "Something went wrong");
			return "home";
		}
	}

	@RequestMapping(path = "/edit-admin")
	protected String editAdmin(@RequestParam(name = "id") int id, ModelMap modelMap) {
		Admin admin = adminService.findAdminById(id);
		modelMap.addAttribute("admin", admin);
		return "edit_admin";
	}

	@RequestMapping(path = "/update-admin")
	protected String updateAdmin(@RequestParam(name = "id") int id, @RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, ModelMap modelMap) {
		boolean adminUpdated = adminService.updateAdmin(id, email, password);
		if (adminUpdated)
			modelMap.addAttribute("message", "Admin updated");
		else
			modelMap.addAttribute("message", "Something went wrong");
		return "home";
	}

	@RequestMapping(path = "/logout")
	protected String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "login";
	}

}
