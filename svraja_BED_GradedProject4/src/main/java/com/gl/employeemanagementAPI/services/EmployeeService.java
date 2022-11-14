/**
 * 
 */
package com.gl.employeemanagementAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gl.employeemanagementAPI.entity.Employee;

/**
 * @author svraja
 *
 */
@Service
public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> fetchAllEmployee();

	public Employee fetchEmployeeById(long empId);

	public Optional<Employee> searchEmployeeUsingfirstName(String empFirstName);

	public List<Employee> customOrderByFirstName(String order);

	public Employee updateEmployee(Employee employee, long empId);

	public void deleteEmployeeById(long empId);

}
