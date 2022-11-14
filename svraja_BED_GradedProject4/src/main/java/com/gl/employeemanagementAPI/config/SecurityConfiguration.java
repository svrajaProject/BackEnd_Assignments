package com.gl.employeemanagementAPI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.employeemanagementAPI.servicesImpl.DomainUserDetailsServiceImpl;

/**
 * @author svraja
 *
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

// 	Both authentication and authorization
	@Autowired
	private DomainUserDetailsServiceImpl domainUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(this.domainUserDetailsService)
				.passwordEncoder(bcryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

//		authorization
		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers("/h2-console/**").permitAll()
				.antMatchers(HttpMethod.GET, "/user*", "/user/**", "/api/employee*", "/api/employee/**")
				.hasAnyRole("USER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/user*", "/user/**", "/api/employee*", "/api/employee/**")
				.hasRole("ADMIN").antMatchers(HttpMethod.PUT, "/api/employee*", "/api/employee/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/user*", "/user/**", "/api/employee*", "/api/employee/**")
				.hasRole("ADMIN").anyRequest().authenticated().and().httpBasic();
	}

	@Bean
	public PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
