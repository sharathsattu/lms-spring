package com.trustfinity.lmswebsite.UserController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trustfinity.lmswebsite.Model.User;
import com.trustfinity.lmswebsite.Model.UserDto;
import com.trustfinity.lmswebsite.Service.UserService;
import com.trustfinity.lmswebsite.globalExceptionHandler.EmailFound;
import com.trustfinity.lmswebsite.globalExceptionHandler.EmailNotFound;
import com.trustfinity.lmswebsite.globalExceptionHandler.PasswordNotMatch;

@RestController
@RequestMapping(value="/trustfinity")
@CrossOrigin("http://localhost:4200")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(value="/registration")
	public ResponseEntity<UserDto> save(@RequestBody User user) throws PasswordNotMatch{
		UserDto userDto = new UserDto();
		try {
			if(user.getPassword().equals(user.getReenterPassword())) {
				
				userDto.setMessage("User Successfully registered");
				userService.save(user);
				return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
			}else {
				throw new PasswordNotMatch("Entered password not matched");	
				
			}
			
			
		} catch (EmailFound  e) {
			userDto.setMessage("User Already registered! Please Login");
			
			
			return new ResponseEntity<UserDto>(userDto,HttpStatus.BAD_REQUEST);
		}
		catch (PasswordNotMatch e) {
			userDto.setMessage("Your password is not matched");
			return new ResponseEntity<UserDto>(userDto,HttpStatus.BAD_REQUEST);
	}
		catch (Exception e) {
			userDto.setMessage("Internal server error");
			return new ResponseEntity<UserDto>(userDto,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@GetMapping(value="/{password}")
	public ResponseEntity<UserDto> loginData(@RequestParam("email") String email,@PathVariable("password") String password ){
		
		
		UserDto userDto = new UserDto();
		
		try {
			
			UserDto userData= userService.login(email, password);
			userDto.setMessage("User Successfully Logined");
		
			return new ResponseEntity<UserDto>(userData,HttpStatus.OK);
			
		} catch (EmailNotFound  e) {
			userDto.setValidate(false);
			userDto.setMessage("Your not Registered please! Register");

			return new ResponseEntity<UserDto>(userDto,HttpStatus.BAD_REQUEST);
		}
		catch (PasswordNotMatch e) {
			userDto.setValidate(false);
			userDto.setMessage("Entered Wrong Password");
			return new ResponseEntity<UserDto>(userDto,HttpStatus.BAD_REQUEST);
	}
		
		catch (Exception e) {
			userDto.setValidate(false);
			userDto.setMessage("Internal server error");
			return new ResponseEntity<UserDto>(userDto,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value="/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		try {
			List<UserDto> usersList= userService.getAllUsersData();
			return new ResponseEntity<List<UserDto>>(usersList,HttpStatus.OK);
		} catch (Exception e) {
			UserDto userDto = new UserDto();
			userDto.setMessage("Internal Server Error");
			List<UserDto> dtoList=new ArrayList<UserDto>();
			dtoList.add(userDto);
			return new ResponseEntity<List<UserDto>>(dtoList,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/deleteUser")
	
	public ResponseEntity<List<UserDto>> deleteUser(@RequestParam("email") String email){
		
		try {
			List<UserDto> x=userService.deleteUser(email);
			return new ResponseEntity<List<UserDto>>(x,HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(e);
			UserDto userDto = new UserDto();
			userDto.setMessage("Internal Server Error");
			List<UserDto> dtoList=new ArrayList<UserDto>();
			dtoList.add(userDto);
			return new ResponseEntity<List<UserDto>>(dtoList,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping(value="/editUser")
	public ResponseEntity<List<UserDto>> editUser(@RequestParam("email") String email,@RequestBody User user){
		
		try {
			List<UserDto> x=userService.editUser(user, email);
			return new ResponseEntity<List<UserDto>>(x,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			UserDto userDto = new UserDto();
			userDto.setMessage("Internal Server Error");
			List<UserDto> dtoList=new ArrayList<UserDto>();
			dtoList.add(userDto);
			return new ResponseEntity<List<UserDto>>(dtoList,HttpStatus.BAD_REQUEST);

		}
		
	}
	
	}

	

