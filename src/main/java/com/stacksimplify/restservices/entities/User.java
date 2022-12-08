package com.stacksimplify.restservices.entities;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
//Entity
@Entity
@Table(name = "user")
public class User extends RepresentationModel {
	
	@Id
	@GeneratedValue
	private Long userid;
	
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
	
	@OneToMany(mappedBy="user")
	private List<Order> orders;
	
	// No Arguments Constructor
	public User() {
	}

	public String getUsername() {
		return username;
	}

	// Fields Constructor
	public User(Long userid,
			@NotEmpty(message = "Username is Mandatory field. Please Provide username") String username,
			@Size(min = 2, message = "FirstName should have at least 2 characters") String firstname, String email,
			String role, String ssn, List<Order> orders) {
		super();
		this.userid = userid;
		this.username = username;
		this.firstname = firstname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
	}

	// Getters and Setters
	
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	//To String
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", firstname=" + firstname + ", email=" + email
				+ ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + "]";
	}

	
	
	

	
	
}
