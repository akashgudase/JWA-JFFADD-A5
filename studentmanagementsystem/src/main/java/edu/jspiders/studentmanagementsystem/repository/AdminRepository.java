package edu.jspiders.studentmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jspiders.studentmanagementsystem.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Optional<Admin> findByEmailAndPassword(String email, String password);

	Optional<Admin> findByMobileAndPassword(long mobile, String password);

}
