package com.trim.clinicnesia.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trim.clinicnesia.model.User;

@Service("userDetailsService")
@Transactional
public class ClinicnesiaUserDetailsService implements UserDetailsService {
	
	Logger log = LoggerFactory.getLogger(ClinicnesiaUserDetailsService.class);

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		log.info("Find user by username : {}", username);
		User user = userService.findUserByUsername(username);
		log.info("User :{}", user);
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(
				"ROLE_ADMIN");
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(),
				Arrays.asList(grantedAuthority));
		return userDetails;
	}

}
