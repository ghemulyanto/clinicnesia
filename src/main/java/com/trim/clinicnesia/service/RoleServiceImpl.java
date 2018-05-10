package com.trim.clinicnesia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trim.clinicnesia.model.Role;
import com.trim.clinicnesia.repository.RoleRepository;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role findByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public Iterable<Role> findAll(Pageable page) {
		return roleRepository.findAll(page);
	}

	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

}
