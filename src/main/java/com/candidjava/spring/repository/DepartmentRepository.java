package com.candidjava.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.candidjava.spring.bean.Department;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

	@Query(value = "SELECT COUNT(e.dept_id), d.dept_name, d.deptid FROM department d left join employee e ON e.dept_id = d.deptid GROUP BY d.dept_name,d.deptid ", nativeQuery = true)
	public List<Object> getAllDepartment();

	@Query(value = "select *  from  Employee emp  where  emp.dept_id =?1", nativeQuery = true)
	public List<Object> getEmployeeListById(long id);

	@Query(value = "select dept_name from Employee join Department on Employee.dept_id=Department.deptid group by dept_name order by count(*) desc limit 1;", nativeQuery = true)
	public List<Object> getDepartmentWithMaxEmployee();
	
	@Query(value = "SELECT emp.* FROM employee emp INNER JOIN account ac ON ac.emp_id = emp.emp_id WHERE salary > 5000 AND DATE = '19/jan';", nativeQuery = true)
	public List<Object> getEmployeeHigherSalary();

	@Query(value = "select e1.emp_id, e1.employee_name, a1.salary, d1.dept_name as department FROM  Department d1 INNER JOIN  Employee e1  ON  e1.dept_id=d1.deptid left join account a1 on a1.emp_id = e1.emp_id WHERE a1.salary in (SELECT  max(salary) from Employee e, Department d , account a where  e.dept_id=d.deptid and a.emp_id = e.emp_id group by d.dept_name) order by e1.dept_id ASC;", nativeQuery = true)
	public List<Object> getEmployeeHigherSalaryDepartment();
}
