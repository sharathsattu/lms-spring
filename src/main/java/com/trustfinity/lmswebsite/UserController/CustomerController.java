package com.trustfinity.lmswebsite.UserController;

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

import com.trustfinity.lmswebsite.Model.Customers;
import com.trustfinity.lmswebsite.Model.UserDto;
import com.trustfinity.lmswebsite.Service.CustomerService;
import com.trustfinity.lmswebsite.Service.UserService;

@RestController
@RequestMapping(value="/trustfinitylms")
@CrossOrigin("http://localhost:4200")
public class CustomerController {
	
//	@Autowired
//	private UserService userService;
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="/{email}")
	public ResponseEntity<List<Customers>> saveCustomer(@RequestBody Customers customers,@PathVariable String email) {
		
		
		List<Customers> listOfCustomers=customerService.save(customers, email);	
		return new ResponseEntity<List<Customers>>(listOfCustomers,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{email}")
	public ResponseEntity<List<Customers>> getAllCustomersData(@PathVariable String email){
		
		List<Customers> listOfCustomers=customerService.getAllCustomers(email);
		return new ResponseEntity<List<Customers>>(listOfCustomers,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<List<Customers>> deleteCustomers(@PathVariable int id,@RequestParam("email") String email){
		
		List<Customers> listOfCustomers=customerService.deleteCustomers(id, email);
		return new ResponseEntity<List<Customers>>(listOfCustomers,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<List<Customers>> editCustomers(@RequestBody Customers customers,@PathVariable int id,@RequestParam("email") String email){
		
		List<Customers> listOfCustomers=customerService.editCustomers(customers, email,id);
		return new ResponseEntity<List<Customers>>(listOfCustomers,HttpStatus.OK);
		
	}
	
	}


