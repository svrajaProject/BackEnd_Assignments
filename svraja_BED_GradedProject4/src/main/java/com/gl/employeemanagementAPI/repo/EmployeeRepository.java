/**
 * 
 */
package com.gl.employeemanagementAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeemanagementAPI.entity.Employee;

/**
 * @author svraja
 *
 */
@Repository
public interface EmployeeRepository extends  JpaRepository<Employee, Long>{

}
