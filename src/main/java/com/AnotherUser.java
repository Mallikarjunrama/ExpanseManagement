package com;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class AnotherUser {

	public AnotherUser(String fullName, String email, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String fullName;

	private String email;

	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Expanses> expanses;
	
	public AnotherUser() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Expanses> getExpanses() {
		return expanses;
	}

	public void setExpanses(List<Expanses> expanses) {
		this.expanses = expanses;
	}

	@Override
	public String toString() {
		return "NewUser [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", expanses=" + expanses + "]";
	}

	public AnotherUser(String fullName, String email, String password, List<Expanses> expanses) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.expanses = expanses;
	}
	
	



}
