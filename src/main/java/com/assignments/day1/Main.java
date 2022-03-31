package com.assignments.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//import com.mysql.cj.jdbc.Driver;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/db1";
		
		try(Connection conn =  DriverManager.getConnection(url, "root","jatin")) {
	
			System.out.println("Connection established");	
			employeesLessThan(conn); 
			/* printAll(conn); */
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		
	}
	
	static void insert(Connection conn) throws Exception {
		//Inserting
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Employee ID: ");
		int id = Integer.valueOf(scanner.nextLine());
		System.out.println("");
		
		System.out.print("Enter the Employee Name: ");
		String name = scanner.nextLine();
		System.out.println("");
		
		System.out.print("Enter the Employee Address: ");
		String address = scanner.nextLine();
		System.out.println("");
		
		System.out.print("Enter the Employee Salary: ");
		int salary = Integer.valueOf(scanner.nextLine());
		System.out.println("");
		
		scanner.close();
		
		
		
		PreparedStatement ps = conn.prepareStatement("insert into employee values(?, ?, ?, ?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setInt(4, salary);
		
		int feed = ps.executeUpdate();
		
		if(feed > 0) {
			System.out.println("Inserted...");
		} else {
			System.out.println("Not Inserted...");
		}

	}
	
	static void getSalary(Connection conn) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the ID of the Employee whose Marks you want to fetch: ");
		int id = Integer.valueOf(scanner.nextLine());
		
		System.out.println("");
		
		PreparedStatement ps = conn.prepareStatement("select salary from employee WHERE eid=?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			int salaryOfEmployee = rs.getInt("salary");
			System.out.println(salaryOfEmployee);
		}
	}
	
	static void printAll(Connection conn) throws Exception {
		PreparedStatement ps = conn.prepareStatement("select * from employee ORDER BY salary DESC");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("eid");
			String name = rs.getString("name");
			String address = rs.getString("address");
			int salary = rs.getInt("salary");
			
			System.out.print("Employee ID: ");
			System.out.println(id);
			
			System.out.print("Employee Name: ");
			System.out.println(name);
			
			System.out.print("Employee Address: ");
			System.out.println(address);
			
			System.out.print("Employee Salary: ");
			System.out.println(salary);
			
			System.out.println("__________________________________");
		}
	}
	
	static void provideBonusToAll(Connection conn) throws Exception{
		PreparedStatement ps = conn.prepareStatement("update employee set salary = salary + 500");
		int result = ps.executeUpdate();
		
		if(result > 0) {
			System.out.println("Bonus paid! Your employees are now happy! :)");
		} else {
			System.out.println("Something went wrong, Bonus cannot be paid! :(");
		}
	}
	
	static void insertWithoutAddress(Connection conn) throws Exception {
		//Inserting
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Employee ID: ");
		int id = Integer.valueOf(scanner.nextLine());
		System.out.println("");
		
		System.out.print("Enter the Employee Name: ");
		String name = scanner.nextLine();
		System.out.println("");
		
		System.out.print("Enter the Employee Salary: ");
		int salary = Integer.valueOf(scanner.nextLine());
		System.out.println("");
		
		scanner.close();
		
		
		
		PreparedStatement ps = conn.prepareStatement("insert into employee(eid, name, salary) values(?, ?, ?);");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, salary);
		
		int feed = ps.executeUpdate();
		
		if(feed > 0) {
			System.out.println("Inserted...");
		} else {
			System.out.println("Not Inserted...");
		}

	}
	
static void getByID(Connection conn) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the ID of the Employee whose details you want to fetch: ");
		int id = Integer.valueOf(scanner.nextLine());
		
		System.out.println("");
		
		PreparedStatement ps = conn.prepareStatement("select * from employee WHERE eid=?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			System.out.println("__________________________________");
			
			int eid = rs.getInt("eid");
			String name = rs.getString("name");
			String address = rs.getString("address");
			int salary = rs.getInt("salary");
			
			System.out.print("Employee ID: ");
			System.out.println(eid);
			
			System.out.print("Employee Name: ");
			System.out.println(name);
			
			System.out.print("Employee Address: ");
			System.out.println(address);
			
			System.out.print("Employee Salary: ");
			System.out.println(salary);
			
			System.out.println("__________________________________");
		} else {
			System.out.println("Record not found!");
		}
	}

static void employeesLessThan(Connection conn) throws Exception {
	PreparedStatement ps = conn.prepareStatement("select * from employee WHERE salary < ?");
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Please enter the upper bound of your salary based employees search: ");
	int maxSalary = scanner.nextInt();
	ps.setInt(1, maxSalary);
	
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		int eid = rs.getInt("eid");
		String name = rs.getString("name");
		String address = rs.getString("address");
		int salary = rs.getInt("salary");
		
		System.out.print("Employee ID: ");
		System.out.println(eid);
		
		System.out.print("Employee Name: ");
		System.out.println(name);
		
		System.out.print("Employee Address: ");
		System.out.println(address);
		
		System.out.print("Employee Salary: ");
		System.out.println(salary);
		
		System.out.println("__________________________________");
	}
}
}
