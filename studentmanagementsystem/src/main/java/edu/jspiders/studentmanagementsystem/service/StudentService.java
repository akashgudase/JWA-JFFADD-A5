package edu.jspiders.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jspiders.studentmanagementsystem.entity.Student;
import edu.jspiders.studentmanagementsystem.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

	public List<Student> findStudentsByName(String name) {
		return studentRepository.findByName(name);
	}

	public Student findStudentByEmail(String email) {
		Optional<Student> student = studentRepository.findByEmail(email);
		if (student.isPresent())
			return student.get();
		else
			return null;
	}

}
