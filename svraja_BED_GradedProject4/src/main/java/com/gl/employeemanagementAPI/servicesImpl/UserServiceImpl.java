/**
 * 
 */
package com.gl.employeemanagementAPI.servicesImpl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.employeemanagementAPI.entity.User;
import com.gl.employeemanagementAPI.repo.UsersRepository;
import com.gl.employeemanagementAPI.services.UserService;

import lombok.RequiredArgsConstructor;

/**
 * @author svraja
 *
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UsersRepository usersRepository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		usersRepository.save(user);
		return user;
	}

	@Override
	public List<User> fetchAll() {
		List<User> user = usersRepository.findAll();
		return user;
	}

}
