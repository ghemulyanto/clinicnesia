package com.trim.clinicnesia.service;

import org.springframework.data.domain.Pageable;

import com.trim.clinicnesia.model.User;

public interface UserService {

	public User findUserByEmail(String email);

	public User findUserByUsername(String username);

	public User findUserByUsernameAndStatus(String username, int status);

	public void saveUser(User user);
	
	public Iterable<User> getAllUsers(Pageable page);

}
