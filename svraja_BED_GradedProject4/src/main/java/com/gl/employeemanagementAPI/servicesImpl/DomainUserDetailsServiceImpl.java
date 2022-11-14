/**
 * 
 */
package com.gl.employeemanagementAPI.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.employeemanagementAPI.entity.DomainUserDetails;
import com.gl.employeemanagementAPI.entity.User;
import com.gl.employeemanagementAPI.repo.UsersRepository;


/**
 * @author svraja
 *
 */
@Service
public class DomainUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.usersRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid User"));
		System.out.println("User from the repository ");
		System.out.println(user);
		// convert into UserDetails object which Spring Security can understand
		return new DomainUserDetails(user);

	}

}
