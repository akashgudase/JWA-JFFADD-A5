package edu.jspiders.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

}
