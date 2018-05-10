package com.trim.clinicnesia.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.trim.clinicnesia.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {

	User findByEmail(String email);
	
	User findByUsername(String username);
	
	User findByUsernameAndStatus(String username, int status);
}
