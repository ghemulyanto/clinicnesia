package com.trim.clinicnesia.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clns_user")
public class User {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "user_id")
	private String uuid;

	@Column(name = "username")
	@Length(min = 3, max = 100)
	private String username;

	@Column(name = "password")
	@Length(min = 5, message = "Your password must have at least 5 characters")
	private String password;

	@Column(name = "fullname")
	@Length(max = 200, message = "Maximum character for fullname is 200")
	private String fullname;

	@Column(name = "email")
	@Email(message = "Please provide a valid email address")
	@NotEmpty(message = "Email cannot be empty")
	private String email;

	@Column(name = "status")
	private int status;

	@Column(name = "description")
	@Length(max = 300, message = "Maximum character for Description is 300")
	private String description;

	@Column(name = "is_employee", columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean employee;

	public Boolean getEmployee() {
		return employee;
	}

	public void setEmployee(Boolean employee) {
		this.employee = employee;
	}

	@Column(name = "employee_no")
	@Length(max = 100, message = "Maximum employee nuber is 100 character")
	private String employeeNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_expired")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date userExpired;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "password_expired")
	private Date passwordExpired;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login")
	private Date lastLogin;

	@Column(name = "password_failed")
	private int passwordFailed;

	@Column(name = "ip_address")
	private String ipAddress;

	@Column(name = "is_new_user", columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isNewUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "created_by")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "updated_by")
	private String updatedBy;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "clns_users_roles",
			joinColumns = @JoinColumn(name = "user_id",
					referencedColumnName = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id",
					referencedColumnName = "role_id"))
	private List<Role> roles;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Date getUserExpired() {
		return userExpired;
	}

	public void setUserExpired(Date userExpired) {
		this.userExpired = userExpired;
	}

	public Date getPasswordExpired() {
		return passwordExpired;
	}

	public void setPasswordExpired(Date passwordExpired) {
		this.passwordExpired = passwordExpired;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getPasswordFailed() {
		return passwordFailed;
	}

	public void setPasswordFailed(int passwordFailed) {
		this.passwordFailed = passwordFailed;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public boolean isNewUser() {
		return isNewUser;
	}

	public void setNewUser(boolean isNewUser) {
		this.isNewUser = isNewUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

}
