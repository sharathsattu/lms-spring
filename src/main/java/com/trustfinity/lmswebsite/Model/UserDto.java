package com.trustfinity.lmswebsite.Model;

public class UserDto {
	
	private String email;
	private String fullName;
	private boolean validate;
	private String message;
	private int count;
	public UserDto() {
	}
	
	



	public UserDto(String email, String fullName, boolean validate, String message, int count) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.validate = validate;
		this.message = message;
		this.count = count;
	}





	public int getCount() {
		return count;
	}





	public void setCount(int count) {
		this.count = count;
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
	public boolean isValidate() {
		return validate;
	}
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + (validate ? 1231 : 1237);
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
		UserDto other = (UserDto) obj;
		if (count != other.count)
			return false;
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
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (validate != other.validate)
			return false;
		return true;
	}


	


	
	
	
	
	}


