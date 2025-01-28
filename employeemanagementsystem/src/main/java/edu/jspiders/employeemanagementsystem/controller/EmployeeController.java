package edu.jspiders.employeemanagementsystem.controller;

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

import edu.jspiders.employeemanagementsystem.entity.Employee;
import edu.jspiders.employeemanagementsystem.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/employees")
	protected ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee addedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(addedEmployee, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/employees")
	protected ResponseEntity<String> deleteEmployee(@RequestParam int id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
	}

	@PutMapping(path = "/employees")
	protected ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}

	@GetMapping(path = "/employees")
	protected ResponseEntity<Object> findAllEmployees() {
		List<Employee> employees = employeeService.findAllEmployees();
		if (employees.size() > 0)
			return new ResponseEntity<Object>(employees, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("No data availabel", HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/employees-email")
	protected ResponseEntity<Object> findEmployeeByEmail(@RequestParam String email) {
		Employee employee = employeeService.findEmployeeByEmail(email);
		if (employee != null)
			return new ResponseEntity<Object>(employee, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Employee not found", HttpStatus.NOT_FOUND);
	}

}
