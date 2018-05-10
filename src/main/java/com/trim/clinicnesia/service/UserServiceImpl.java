package com.trim.clinicnesia.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trim.clinicnesia.model.Role;
import com.trim.clinicnesia.model.User;
import com.trim.clinicnesia.repository.RoleRepository;
import com.trim.clinicnesia.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		List<Role> persistRoles = new ArrayList<>();
		Collection<Role> userRoles = user.getRoles();
		if (userRoles != null) {
			for (Role role : userRoles) {
				Optional<Role> optionalRole = roleRepository
						.findById(role.getUuid());
				if (optionalRole.isPresent()) {
					persistRoles.add(optionalRole.get());
				}

			}
		}
		user.setRoles(persistRoles);
		userRepository.save(user);
	}

	@Override
	public User findUserByUsernameAndStatus(String username, int status) {
		return userRepository.findByUsernameAndStatus(username, status);
	}

	public Iterable<User> getAllUsers(Pageable page) {
		return userRepository.findAll(page);
	}

}
