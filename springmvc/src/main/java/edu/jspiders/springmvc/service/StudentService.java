package edu.jspiders.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.jspiders.springmvc.dao.StudentDAO;

@Component
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

}
