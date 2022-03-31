package com.assignments.day2.UseCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.assignments.day2.Exceptions.EmployeeException;
import com.assignments.day2.dao.EmployeeDao;
import com.assignments.day2.dao.EmployeeDaoImpl;

public class giveBonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int id = 0;
		int bonus = 0;
		
		try {
			System.out.println("Enter the ID of the employee to whom you want to pay the bonus: ");
			id = Integer.valueOf(scanner.nextLine());
			
			System.out.println("Ente the amount of bonus to be paid: ");
			bonus = Integer.valueOf(scanner.nextLine());
		} catch (NumberFormatException ime) {
			System.out.println("Please enter the required details in valid format");
			return;
		}
		
		try {
			EmployeeDao dao = new EmployeeDaoImpl();
			String status = dao.giveBonusToEmployee(id, bonus);
			System.out.println(status);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}

}
