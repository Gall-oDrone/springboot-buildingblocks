package com.stacksimplify.restservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
//Entity
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message = "Username is Mandatory field. Please Provide username")
	@Column(name = "USER_NAME", length=50, nullable=false, unique=true)
	private String username;
	@Size(min=2, message="FirstName should have at least 2 characters")
	@Column(name = "FIRST_NAME", length=50, nullable=false)
	private String firstname;
	@Column(name = "EMAIL", length=50, nullable=false)
	private String email;
	@Column(name = "ROLE", length=50, nullable=false)
	private String role;
	@Column(name = "SSN", length=50, nullable=false, unique=true)
	private String ssn;
	
	// No Arguments Constructor
	public User() {
	}

	// Fields Constructor
	public User(Long id, String username, String firstname, String email, String role, String ssn) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	// To String
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", email=" + email + ", role="
				+ role + ", ssn=" + ssn + "]";
	}
	

	
	
}
