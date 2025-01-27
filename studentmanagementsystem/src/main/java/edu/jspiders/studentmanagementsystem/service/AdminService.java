package edu.jspiders.studentmanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jspiders.studentmanagementsystem.entity.Admin;
import edu.jspiders.studentmanagementsystem.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public boolean findAdminByEmailAndPassword(String email, String password) {
		Optional<Admin> admin = adminRepository.findByEmailAndPassword(email, password);
		if (admin.isPresent()) {
			if (admin.get().getEmail().equals(email) && admin.get().getPassword().equals(password))
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean findAdminByMobileAndPassword(long mobile, String password) {
		Optional<Admin> admin = adminRepository.findByMobileAndPassword(mobile, password);
		if (admin.isPresent()) {
			if (admin.get().getMobile() == mobile && admin.get().getPassword().equals(password))
				return true;
			else
				return false;
		} else
			return false;
	}

	public void deleteAdmin(int id) {
		adminRepository.deleteById(id);
	}

	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

}
