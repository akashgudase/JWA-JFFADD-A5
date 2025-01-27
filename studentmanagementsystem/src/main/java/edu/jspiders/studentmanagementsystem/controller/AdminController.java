package edu.jspiders.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jspiders.studentmanagementsystem.entity.Admin;
import edu.jspiders.studentmanagementsystem.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/admins")
	protected Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}

	@GetMapping(path = "/admins-email")
	protected String findAdminByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
		boolean adminIsPresent = adminService.findAdminByEmailAndPassword(email, password);
		if (adminIsPresent)
			return "Admin authenticated";
		else
			return "Invalid email or password";
	}

	@GetMapping(path = "/admins-mobile")
	protected String findAdminByMobileAndPassword(@RequestParam long mobile, @RequestParam String password) {
		boolean adminIsPresent = adminService.findAdminByMobileAndPassword(mobile, password);
		if (adminIsPresent)
			return "Admin authenticated";
		else
			return "Invalid mobile number or password";
	}

	@DeleteMapping(path = "/admins")
	protected String deleteAdmin(@RequestParam int id) {
		adminService.deleteAdmin(id);
		return "Admin deleted";
	}

	@PutMapping(path = "/admins")
	protected Admin updateAdmin(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}

}
