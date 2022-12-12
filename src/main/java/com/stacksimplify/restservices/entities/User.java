package com.stacksimplify.restservices.entities;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
//Entity
// and
@ApiModel(description = "This model is to create a user")
@Entity
@Table(name = "user")
//@JsonIgnoreProperties({"firstname", "lastname"}) -- Static Filtering JsonIgnore
//@JsonFilter(value = "userFilter") -+ Used for MappingJacksonValue filtering section
public class User extends RepresentationModel {
	
	@ApiModelProperty(notes = "Auto generated unique id", required = true, position = 1)
	@Id
	@GeneratedValue
	@JsonView(Views.External.class)
	private Long userid;
	
	@ApiModelProperty(notes = "username sholud be in format flname", example = "andy", required = true, position = 2)
	@Size(min = 2, max = 50)
	@NotEmpty(message = "Username is Mandatory field. Please Provide username")
	@Column(name = "USER_NAME", length=50, nullable=false, unique=true)
	@JsonView(Views.External.class)
	private String username;
	@Size(min=2, max = 50, message="FirstName should have at least 2 characters")
	@Column(name = "FIRST_NAME", length=50, nullable=false)
	@JsonView(Views.External.class)
	private String firstname;
	@Column(name = "EMAIL", length=50, nullable=false)
	@JsonView(Views.External.class)
	private String email;
	@Column(name = "ROLE", length=50, nullable=false)
	@JsonView(Views.Internal.class)
	private String role;
	@Column(name = "SSN", length=50, nullable= false, unique=true)
	//@JsonIgnore -- Static Filtering JsonIgnore
	@JsonView(Views.Internal.class)
	private String ssn;
	
	@OneToMany(mappedBy="user")
	@JsonView(Views.Internal.class)
	private List<Order> orders;
	
	@Column(name = "ADDRESS")	
	private String address;
	
	// No Arguments Constructor
	public User() {
	}

	// Fields Constructor

	public User(Long userid,
			@NotEmpty(message = "Username is Mandatory field. Please Provide username") String username,
			@Size(min = 2, message = "FirstName should have at least 2 characters") String firstname, String email,
			String role, String ssn, List<Order> orders, String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.firstname = firstname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
		this.orders = orders;
		this.address = address;
	}

	// Getters and Setters
	public String getUsername() {
		return username;
	}
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	// To String
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", firstname=" + firstname + ", email=" + email
				+ ", role=" + role + ", ssn=" + ssn + ", orders=" + orders + ", address=" + address + "]";
	}
	

	
	
	

	
	
}
