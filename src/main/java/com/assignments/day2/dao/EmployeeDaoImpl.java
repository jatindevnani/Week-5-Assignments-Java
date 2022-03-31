package com.assignments.day2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.assignments.day2.EmployeeBean.Employee;
import com.assignments.day2.Exceptions.EmployeeException;
import com.assignments.day2.Utilities.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		
		//Initializing an Employee object with null value
		Employee employee = new Employee();
		
		try(Connection conn = DBConnection.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Employee where eid=?");
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
			int id = rs.getInt("eid");
			String name = rs.getString("name");
			String address = rs.getString("address");
			int salary = rs.getInt("salary");
			
			employee.setEmpID(id);
			employee.setName(name);
			employee.setAddress(address);
			employee.setSalary(salary);
			} else {
				throw new EmployeeException("No employee with ID " + empId + " in the records.");
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = new ArrayList<>();
		// TODO Auto-generated method stub
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("eid");
				String name= rs.getString("name");
				String address = rs.getString("address");
				int salary = rs.getInt("salary");
				
				employees.add(new Employee(id, name, address, salary));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public String saveEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		String message = "Record not inserted...";
		
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Employee values(?, ?, ?, ?)");
			
			ps.setInt(1, employee.getEmpID());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getAddress());
			ps.setInt(4, employee.getSalary());
			
			int changes = ps.executeUpdate();
			
			if(changes > 0) {
				message = "Record inserted successfully!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public boolean deleteEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from employee where eid=?");
			ps.setInt(1, empId);
			
			int result = ps.executeUpdate();
			
			if(result > 0) {
				System.out.println("Record deleted successfully...");
				return true;
			} else {
				throw new EmployeeException("Employee with " + empId + " doesn't exist...");
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
	}

	@Override
	public String giveBonusToEmployee(int empId, int amount) throws EmployeeException {
		// TODO Auto-generated method stub
		String message = "Bonus not paid";
		try(Connection conn = DBConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update employee set salary = salary + ? WHERE eid=?");
			
			ps.setInt(1, amount);
			ps.setInt(2, empId);
			
			int result = ps.executeUpdate();
			
			if(result > 0) {
				message = "Bonus paid to Employee with ID - " + empId + " of Rs." + amount;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeeException("No Employee found with the ID " + empId);
		}
		return message;
	}
	
}
