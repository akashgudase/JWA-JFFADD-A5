package edu.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jspiders.springmvc.dto.Student;
import edu.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/add-student", method = RequestMethod.POST)
	protected String addStudent(@RequestParam(name = "name") String name, @RequestParam(name = "email") String email,
			@RequestParam(name = "mobile") long mobile, @RequestParam(name = "course") String course,
			ModelMap modelMap) {
		boolean studentAdded = studentService.addStudent(name, email, mobile, course);
		List<Student> students = studentService.findAllStudents();
		if (studentAdded) {
			modelMap.addAttribute("students", students);
			modelMap.addAttribute("message", "Student added");
		} else {
			if (students != null)
				modelMap.addAttribute("students", students);
			modelMap.addAttribute("message", "Something went wrong");
		}
		return "students";
	}

	@RequestMapping(path = "/students")
	protected String findAllStudents(ModelMap modelMap) {
		List<Student> students = studentService.findAllStudents();
		if (students != null)
			modelMap.addAttribute("students", students);
		else
			modelMap.addAttribute("message", "No data available");
		return "students";
	}

}
