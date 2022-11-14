/**
 * 
 */
package com.gl.employeemanagementAPI.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.employeemanagementAPI.entity.Employee;
import com.gl.employeemanagementAPI.repo.EmployeeRepository;
import com.gl.employeemanagementAPI.services.EmployeeService;

import lombok.RequiredArgsConstructor;

/**
 * @author svraja
 *
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployee() {

		List<Employee> employees = this.employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee fetchEmployeeById(long empId) {
		Optional<Employee> employeeId = this.employeeRepository.findById(empId);
		if (employeeId.isPresent()) {
			return employeeId.get();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Optional<Employee> searchEmployeeUsingfirstName(String empFirstName) {
		Employee searchByfirstName = new Employee();
		searchByfirstName.setFirstName(empFirstName);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher(empFirstName, ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastName", "email");
		Example<Employee> example = Example.of(searchByfirstName, exampleMatcher);
		return this.employeeRepository.findOne(example);
	}

	@Override
	public Employee updateEmployee(Employee employee, long empId) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(long empId) {
		this.employeeRepository.deleteById(empId);

	}

	@Override
	public List<Employee> customOrderByFirstName(String order) {

		if (order.equals("desc")) {
			return employeeRepository.findAll(Sort.by(Direction.DESC, "firstName"));
		} else {
			return employeeRepository.findAll(Sort.by(Direction.ASC, "firstName"));
		}

	}

}
