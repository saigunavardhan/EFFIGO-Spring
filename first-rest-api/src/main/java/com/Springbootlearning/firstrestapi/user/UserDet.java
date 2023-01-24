package com.Springbootlearning.firstrestapi.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDet {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String role;

	public UserDet() {
		
	}
	public UserDet(String name, String role) {
		super();
	
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserDet [id=" + id + ", name=" + name + ", role=" + role + "]";
	}

}
