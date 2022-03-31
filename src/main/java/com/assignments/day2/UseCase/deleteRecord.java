package com.assignments.day2.UseCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.assignments.day2.Exceptions.EmployeeException;
import com.assignments.day2.dao.EmployeeDao;
import com.assignments.day2.dao.EmployeeDaoImpl;

public class deleteRecord {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the ID: ");
		int id = 0;
		try {
		id= sc.nextInt();
		EmployeeDao dao = new EmployeeDaoImpl();
		
		dao.deleteEmployeeById(id);
		
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException ime) {
			System.out.println("Please enter a valid ID");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
