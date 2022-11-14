/**
 * 
 */
package com.gl.employeemanagementAPI.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.gl.employeemanagementAPI.entity.Role;
import com.gl.employeemanagementAPI.entity.User;
import com.gl.employeemanagementAPI.repo.UsersRepository;

/**
 * @author svraja
 *
 */
@Component
public class BootstrapAppData {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@EventListener(ApplicationReadyEvent.class)
	public void insertUser(ApplicationReadyEvent event) {

		User tinku = new User();
		tinku.setUsername("tinku");
		tinku.setPassword(passwordEncoder.encode("user"));
		
		User raja = new User();
		raja.setUsername("raja");
		raja.setPassword(passwordEncoder.encode("admin"));
	
		Role tinkuUserRole = new Role();
		tinkuUserRole.setName("USER");
		
		Role rajaUserRole = new Role();
		rajaUserRole.setName("USER");
		
		Role rajaAdminRole = new Role();
		rajaAdminRole.setName("ADMIN");
		
		tinku.getRoles().add(tinkuUserRole);
		
		raja.getRoles().add(rajaUserRole);
		raja.getRoles().add(rajaAdminRole);
		
		this.userRepository.save(raja);
		this.userRepository.save(tinku);
	}
}
