/**
 * 
 */
package com.gl.employeemanagementAPI.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employeemanagementAPI.entity.User;

/**
 * @author svraja
 *
 */
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
