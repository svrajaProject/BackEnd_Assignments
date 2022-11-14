/**
 * 
 */
package com.gl.employeemanagementAPI.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author svraja
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public String EmployeeException(IllegalArgumentException e) {
		return "Invalid employee Id passed!";
	}
}
