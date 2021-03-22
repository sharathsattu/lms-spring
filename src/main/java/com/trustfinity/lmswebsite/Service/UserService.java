package com.trustfinity.lmswebsite.Service;

import java.util.List;

import com.trustfinity.lmswebsite.Model.User;
import com.trustfinity.lmswebsite.Model.UserDto;
import com.trustfinity.lmswebsite.globalExceptionHandler.EmailFound;
import com.trustfinity.lmswebsite.globalExceptionHandler.EmailNotFound;
import com.trustfinity.lmswebsite.globalExceptionHandler.PasswordNotMatch;

public interface UserService {
	
	public void save(User user) throws EmailFound;
	public UserDto login(String email,String password) throws EmailNotFound,PasswordNotMatch;
	
	public List<UserDto> getAllUsersData();
	
	public List<UserDto> deleteUser(String email);
	public List<UserDto> editUser(User user,String email);

}
