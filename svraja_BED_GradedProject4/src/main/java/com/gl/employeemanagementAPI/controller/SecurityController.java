/**
 * 
 */
package com.gl.employeemanagementAPI.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employeemanagementAPI.entity.Role;
import com.gl.employeemanagementAPI.entity.User;
import com.gl.employeemanagementAPI.services.UserService;

import lombok.RequiredArgsConstructor;

/**
 * @author svraja
 *
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class SecurityController {

	private final UserService userService;

	@PostMapping
	public User addUser(@RequestBody User user) {
		return this.userService.saveUser(user);
	}

	@GetMapping
	public List<User> fetchAllUser() {
		return this.userService.fetchAll();
	}

}
