package edu.jspiders.springmvc.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.jspiders.springmvc.dao.AdminDAO;
import edu.jspiders.springmvc.dto.Admin;

@Component
public class AdminService {

	@Autowired
	private AdminDAO adminDAO;

	public boolean addAdmin(String email, String password) {
		Admin admin = new Admin();
		admin.setEmail(email);
		admin.setPassword(password);
		try {
			adminDAO.addAdmin(admin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Admin authenticateAdmin(String email, String password) {
		try {
			Admin admin = adminDAO.authenticateAdmin(email, password);
			if (admin.getEmail().equals(email) && admin.getPassword().equals(password))
				return admin;
			else
				return null;
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteAdmin(int id) {
		try {
			adminDAO.deleteAdmin(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Admin findAdminById(int id) {
		return adminDAO.findAdminById(id);
	}

	public boolean updateAdmin(int id, String email, String password) {
		try {
			adminDAO.updateAdmin(id, email, password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
