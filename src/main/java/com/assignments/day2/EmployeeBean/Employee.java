package com.assignments.day2.EmployeeBean;

public class Employee {
	private int empID;
	private String name;
	private String address;
	private int salary;
	
	public Employee(int empID, String name, String address, int salary) {
		this.empID = empID;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "________________________________________\n\n" +
				"Employee ID: " + this.empID + "\n" +
				"Employee Name: " + this.name + "\n" + 
				"Employee Address: " + this.address + "\n" + 
				"Employee Salary: " + this.salary + "\n" +
				"________________________________________\n";
	}
}
