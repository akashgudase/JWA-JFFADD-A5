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

	@RequestMapping(path = "/delete-student")
	protected String deleteStudentById(@RequestParam(name = "id") int id, ModelMap modelMap) {
		boolean studentDeleted = studentService.deleteStudentById(id);
		List<Student> students = studentService.findAllStudents();
		if (studentDeleted) {
			modelMap.addAttribute("message", "Student deleted");
			if (students != null)
				modelMap.addAttribute("students", students);
			else
				modelMap.addAttribute("message", "No data available");
		} else {
			modelMap.addAttribute("message", "Something went wrong");
			if (students != null)
				modelMap.addAttribute("students", students);
			else
				modelMap.addAttribute("message", "No data available");
		}
		return "students";
	}

	@RequestMapping(path = "/edit-student")
	protected String editStudent(@RequestParam(name = "id") int id, ModelMap modelMap) {
		Student student = studentService.findStudentById(id);
		modelMap.addAttribute("student", student);
		return "edit_student";
	}

	@RequestMapping(path = "/update-student", method = RequestMethod.POST)
	protected String updateStudent(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email, @RequestParam(name = "mobile") long mobile,
			@RequestParam(name = "course") String course, ModelMap modelMap) {
		boolean studentUpdated = studentService.updateStudent(id, name, email, mobile, course);
		List<Student> students = studentService.findAllStudents();
		if (studentUpdated)
			modelMap.addAttribute("message", "Student updated");
		else
			modelMap.addAttribute("message", "Something went wrong");
		modelMap.addAttribute("students", students);
		return "students";
	}

	@RequestMapping(path = "/student/mobile")
	protected String findStudentByMobile(@RequestParam(name = "mobile") long mobile, ModelMap modelMap) {
		Student student = studentService.findStudentByMobile(mobile);
		if (student != null)
			modelMap.addAttribute("student", student);
		else
			modelMap.addAttribute("message", "Student not found");
		return "student_mobile";
	}

}
