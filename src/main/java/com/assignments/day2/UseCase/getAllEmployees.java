package com.assignments.day2.UseCase;

import java.util.List;
import java.util.Scanner;

import com.assignments.day2.EmployeeBean.Employee;
import com.assignments.day2.dao.EmployeeDao;
import com.assignments.day2.dao.EmployeeDaoImpl;

public class getAllEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDao dao = new EmployeeDaoImpl();
		List<Employee> employees = dao.getAllEmployee();
		
		for(Employee emp: employees) {
			System.out.println(emp);
		}
	}

}
