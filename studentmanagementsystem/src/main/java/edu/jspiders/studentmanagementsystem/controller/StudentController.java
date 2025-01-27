package edu.jspiders.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jspiders.studentmanagementsystem.entity.Student;
import edu.jspiders.studentmanagementsystem.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(path = "/students")
	protected ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student addedStudent = studentService.addStudent(student);
		return new ResponseEntity<Student>(addedStudent, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/students")
	protected ResponseEntity<String> deleteStudent(@RequestParam int id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted", HttpStatus.OK);
	}

	@PutMapping(path = "/students")
	protected Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@GetMapping(path = "/students")
	protected Object findAllStudents() {
		List<Student> students = studentService.findAllStudents();
		if (students.isEmpty())
			return "No data availabel";
		else
			return students;
	}

	@GetMapping(path = "/students-name")
	protected Object findStudentsByName(@RequestParam String name) {
		List<Student> students = studentService.findStudentsByName(name);
		if (students.isEmpty())
			return "No data availabel";
		else
			return students;
	}

	@GetMapping(path = "/students-email")
	protected ResponseEntity<Object> findStudentByEmail(@RequestParam String email) {
		Student student = studentService.findStudentByEmail(email);
		if (student != null)
			return new ResponseEntity<Object>(student, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Student not found", HttpStatus.NOT_FOUND);
	}

}
