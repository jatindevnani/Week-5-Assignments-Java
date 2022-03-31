package com.assignments.day2.UseCase;

import java.util.Scanner;

import com.assignments.day2.EmployeeBean.Employee;
import com.assignments.day2.dao.EmployeeDao;
import com.assignments.day2.dao.EmployeeDaoImpl;

public class insertEmployee {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter details of the new Employee: ");
		
		System.out.print("Employee ID: ");
		int id = Integer.valueOf(scanner.nextLine());
		
		System.out.print("Employee Name: ");
		String name = scanner.nextLine();
		
		System.out.print("Employee Address: ");
		String address = scanner.nextLine();
		
		System.out.print("Employee Salary: ");
		int salary = Integer.valueOf(scanner.nextLine());
		
		scanner.close();
		
		Employee employee = new Employee(id, name, address, salary);
		
		EmployeeDao dao = new EmployeeDaoImpl();
		String status = dao.saveEmployeeDetails(employee);
		
		System.out.println(status);
	}
}
