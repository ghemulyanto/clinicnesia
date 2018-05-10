package com.trim.clinicnesia.service;

import org.springframework.data.domain.Pageable;

import com.trim.clinicnesia.model.Role;

public interface RoleService {
	
	public Role findByRoleName(String roleName);
	
	public void save(Role role);
	
	public Iterable<Role> findAll(Pageable page);
	
	public Iterable<Role> findAll();

}
