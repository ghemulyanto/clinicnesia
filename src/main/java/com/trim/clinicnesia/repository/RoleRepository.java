package com.trim.clinicnesia.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.trim.clinicnesia.model.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, String> {

	Role findByRoleName(String roleName);

}
