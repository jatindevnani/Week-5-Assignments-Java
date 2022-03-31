 package com.assignments.day2.UseCase;

import java.util.Scanner;

import com.assignments.day2.EmployeeBean.Employee;
import com.assignments.day2.Exceptions.EmployeeException;
import com.assignments.day2.dao.EmployeeDao;
import com.assignments.day2.dao.EmployeeDaoImpl;


public class getEmployeeById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getting employee 
		

		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the ID: ");
		int id= sc.nextInt();
		
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try{
			Employee emp = dao.getEmployeeById(id);
			System.out.println(emp);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
