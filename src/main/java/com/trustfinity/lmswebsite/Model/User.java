package com.trustfinity.lmswebsite.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	
	
	@Id
	private String email;
	private String fullName;
	private String password;
	private String reenterPassword;
	
	
	public User() {
		
	}


	public User(String email, String fullName, String password, String reenterPassword) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.reenterPassword = reenterPassword;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getReenterPassword() {
		return reenterPassword;
	}


	public void setReenterPassword(String reenterPassword) {
		this.reenterPassword = reenterPassword;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((reenterPassword == null) ? 0 : reenterPassword.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (reenterPassword == null) {
			if (other.reenterPassword != null)
				return false;
		} else if (!reenterPassword.equals(other.reenterPassword))
			return false;
		return true;
	}
	
	
}
