package com.assignments.day2.dao;

import com.assignments.day2.EmployeeBean.Employee;
import com.assignments.day2.Exceptions.EmployeeException;
import java.util.*;

public interface EmployeeDao {
	public Employee getEmployeeById(int empId)throws EmployeeException;

	public List<Employee> getAllEmployee();

	public String saveEmployeeDetails(Employee employee);

	public boolean deleteEmployeeById(int empId)throws EmployeeException;

	public String giveBonusToEmployee(int empId, int amount)throws EmployeeException;
}
