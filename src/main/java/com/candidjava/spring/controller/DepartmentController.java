package com.candidjava.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.candidjava.spring.bean.Department;
import com.candidjava.spring.bean.Employee;
import com.candidjava.spring.bean.User;
import com.candidjava.spring.service.DepartmentService;
import com.candidjava.spring.service.UserService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = { "/department" })
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	
	@PostMapping(value = "/create", headers = "Accept=application/json")
	public ResponseEntity<Void> createUser(@RequestBody Department department, UriComponentsBuilder ucBuilder) {
		departmentService.createDepartment(department);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/department/{id}").buildAndExpand(department.getDeptID()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Department> getUserById(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		Department department = departmentService.findById(id);
		if (department == null) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}
	
	@GetMapping(value = "/get", headers = "Accept=application/json")
	public List<Object> getAllDepartment() {
		List<Object> department = departmentService.getAllDepartment();
		return department;

	}
	
	@GetMapping(value = "/getEmployeeList/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getEmployeeList(@PathVariable("id") long id) {
		List<Object> department = departmentService.getEmployeeListById(id);
	if (department == null) {
		return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<Object>(department, HttpStatus.OK);

	}

	@GetMapping(value = "/getDepartmentWithMaxEmployee", headers = "Accept=application/json")
	public List<Object> getDepartmentWithMaxEmployee() {
		List<Object> department = departmentService.getDepartmentWithMaxEmployee();
		return department;
	}

	
	
	
	@PostMapping(value = "/createEmployee", headers = "Accept=application/json")
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
		departmentService.createEmployee(employee);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/department/employee/{id}").buildAndExpand(employee.getEmpId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		Employee employee = departmentService.findByIdEmployee(id);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEmployee", headers = "Accept=application/json")
	public List<Employee> getEmployee() {
		List<Employee> employee = departmentService.getAllEmployee();
		return employee;

	}
	
	@GetMapping(value = "/deleteDepartment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		 departmentService.deleteDepartment(id);
		 return new ResponseEntity<String>("Department deleted", HttpStatus.OK);
	}
	
	@GetMapping(value = "/deleteEmployee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		 departmentService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEmployeeHigherSalary", headers = "Accept=application/json")
	public List<Object> getEmployeeHigherSalary() {
		List<Object> employee = departmentService.getEmployeeHigherSalary();
		return employee;

	}
	
	@GetMapping(value = "/getEmployeeHigherSalaryDepartment", headers = "Accept=application/json")
	public List<Object> getEmployeeHigherSalaryDepartment() {
		List<Object> employee = departmentService.getEmployeeHigherSalaryDepartment();
		return employee;

	}
}
