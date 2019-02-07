package com.candidjava.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.candidjava.spring.bean.Department;
import com.candidjava.spring.bean.Employee;
import com.candidjava.spring.repository.DepartmentRepository;
import com.candidjava.spring.repository.EmployeeRepository;

@Service
@Transactional
public class DepartmentServiceImp implements DepartmentService{

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void createDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentRepository.save(department);
	}

	@Override
	public Department findById(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findOne(id);
	}

	@Override
	public List<Object> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.getAllDepartment();
	}

	@Override
	public List<Object> getEmployeeListById(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.getEmployeeListById(id);
	}

	@Override
	public List<Object> getDepartmentWithMaxEmployee() {
		// TODO Auto-generated method stub
		return departmentRepository.getDepartmentWithMaxEmployee();
	}

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public Employee findByIdEmployee(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void deleteDepartment(long id) {
		departmentRepository.delete(id);
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.delete(id);;
	}

	@Override
	public List<Object> getEmployeeHigherSalary() {
		// TODO Auto-generated method stub
		return departmentRepository.getEmployeeHigherSalary();
	}

	@Override
	public List<Object> getEmployeeHigherSalaryDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.getEmployeeHigherSalaryDepartment();
	}

	
	
}
