package com.candidjava.spring.service;

import java.util.List;

import com.candidjava.spring.bean.Department;
import com.candidjava.spring.bean.Employee;

public interface DepartmentService {

	void createDepartment(Department department);

	Department findById(long id);

	List<Object> getAllDepartment();

	List<Object> getEmployeeListById(long id);

	List<Object> getDepartmentWithMaxEmployee();

	void createEmployee(Employee employee);

	Employee findByIdEmployee(long id);

	List<Employee> getAllEmployee();

	void deleteDepartment(long id);

	void deleteEmployee(long id);

	List<Object> getEmployeeHigherSalary();

	List<Object> getEmployeeHigherSalaryDepartment();

}
