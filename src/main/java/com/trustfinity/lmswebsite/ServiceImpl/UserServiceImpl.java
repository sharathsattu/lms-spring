package com.trustfinity.lmswebsite.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.emitter.EmitterException;

import com.trustfinity.lmswebsite.Model.User;
import com.trustfinity.lmswebsite.Model.UserDto;
import com.trustfinity.lmswebsite.Repository.UserRepository;
import com.trustfinity.lmswebsite.Service.UserService;
import com.trustfinity.lmswebsite.globalExceptionHandler.EmailFound;
import com.trustfinity.lmswebsite.globalExceptionHandler.EmailNotFound;
import com.trustfinity.lmswebsite.globalExceptionHandler.PasswordNotMatch;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	private int a=0;
	@Override
	public void save(User user) throws EmailFound {
		Optional<User> userExists= userRepository.findById(user.getEmail());
		if(userExists.isPresent()) {
		throw new EmailFound("email found");
		}
		else {
			userRepository.save(user);
	
		}
		
	
	}

	@Override
	public UserDto login(String email, String password) throws EmailNotFound, PasswordNotMatch {
		Optional<User> userExists= userRepository.findById(email);
		UserDto userDto = new UserDto();
		if(userExists.isPresent()) {
			User user=userRepository.findByEmail(email);
			if(user.getPassword().equals(password)) {
				userDto.setEmail(user.getEmail());
				userDto.setFullName(user.getFullName());
				userDto.setValidate(true);
				userDto.setMessage("Login Successfull");
			}else {

				throw new PasswordNotMatch("Entered Wrong Password");
			}
			
			
		}else {

			throw new EmailNotFound("Your not registered please! login");
		}
		
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsersData() {
	
		
		List<UserDto> dtoList=new ArrayList<UserDto>();
		List<User> users=userRepository.getAllUser();
		for(User userr:users) {
			UserDto userDto = new UserDto();
			userDto.setFullName(userr.getFullName());
			userDto.setEmail(userr.getEmail());
			a++;
			userDto.setCount(a);
			dtoList.add(userDto);
		}
		a=0;
		return dtoList;
	}

	@Override
	public List<UserDto> deleteUser(String email) {
		User user=userRepository.findByEmail(email);
		userRepository.delete(user);
		return getAllUsersData();
	}

	@Override
	public List<UserDto> editUser(User user, String email) {
		
		User userr=userRepository.findByEmail(email);
		

		userr.setFullName(user.getFullName());
		
		userRepository.save(userr);
		return getAllUsersData();
		
	}



}
