package com.gl.employeemanagementAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemanagementAPI.entity.Employee;
import com.gl.employeemanagementAPI.services.EmployeeService;

import lombok.RequiredArgsConstructor;

/**
 * @author svraja
 *
 */
@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.employeeService.saveEmployee(employee);
	}

	@GetMapping
	public List<Employee> fetchAllEmployee() {
		return this.employeeService.fetchAllEmployee();
	}

	@GetMapping("/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") Long empId) {
		return this.employeeService.fetchEmployeeById(empId);
	}

//	it only returns one unique record! waiting for Spring JPA feature for resolve this!
	@GetMapping("/search/{empfirstName}")
	public Optional<Employee> searchEmployeeUsingfirstName(@PathVariable("empfirstName") String empFirstName) {
		return this.employeeService.searchEmployeeUsingfirstName(empFirstName);
	}

	@GetMapping("/sort")
	public List<Employee> customOrderByFirstName(@RequestParam(required = true) String order) {
		return this.employeeService.customOrderByFirstName(order);

	}

	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return this.employeeService.saveEmployee(employee);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long empId) {
		this.employeeService.deleteEmployeeById(empId);
		return "Employee Id: " + empId + " deleted Successfully";
	}
}
