/**
 * 
 */
package com.gl.employeemanagementAPI.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.employeemanagementAPI.entity.User;

/**
 * @author svraja
 *
 */
@Service
public interface UserService {


	public User saveUser(User user);

	public List<User> fetchAll();

}
