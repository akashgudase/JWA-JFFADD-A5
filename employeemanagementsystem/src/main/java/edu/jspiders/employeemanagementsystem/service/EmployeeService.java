package edu.jspiders.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jspiders.employeemanagementsystem.entity.Employee;
import edu.jspiders.employeemanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee findEmployeeByEmail(String email) {
		Optional<Employee> employee = employeeRepository.findByEmail(email);
		if (employee.isPresent())
			return employee.get();
		else
			return null;
	}

}
