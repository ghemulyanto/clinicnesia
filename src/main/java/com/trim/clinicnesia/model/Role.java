package com.trim.clinicnesia.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "clns_role")
@Data
public class Role {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "role_id")
	private String uuid;

	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_description")
	private String roleDescription;

	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;

}
