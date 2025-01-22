package edu.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.jspiders.springmvc.dao.StudentDAO;
import edu.jspiders.springmvc.dto.Student;

@Component
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public boolean addStudent(String name, String email, long mobile, String course) {
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setMobile(mobile);
		student.setCourse(course);
		try {
			studentDAO.addStudent(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Student> findAllStudents() {
		List<Student> students = studentDAO.findAllStudents();
		if (students.size() > 0)
			return students;
		else
			return null;
	}

}
