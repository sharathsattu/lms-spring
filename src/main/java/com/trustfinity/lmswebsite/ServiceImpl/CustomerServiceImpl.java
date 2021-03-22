package com.trustfinity.lmswebsite.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustfinity.lmswebsite.Model.Customers;
import com.trustfinity.lmswebsite.Model.User;
import com.trustfinity.lmswebsite.Repository.CustomerRepository;
import com.trustfinity.lmswebsite.Repository.UserRepository;
import com.trustfinity.lmswebsite.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	private int a=0;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public List<Customers> save(Customers customers, String email) {
		User user=userRepository.findByEmail(email);
		customers.setUser(user);
		customerRepository.save(customers);
		return getAllCustomers(email);
		
	}
	@Override
	public List<Customers> getAllCustomers(String email) {
		List<Customers> customerList = new ArrayList<Customers>();
		List<Customers> cusList=customerRepository.findByUserEmail(email);
		
		for(Customers customers :cusList) {
			Customers cus = new Customers();
			cus.setSerialNo(a);
			cus.setUserName(customers.getFirstName()+" "+customers.getLastName());
			cus.setFirstName(customers.getFirstName());
			cus.setLastName(customers.getLastName());
			cus.setHallTicketno(customers.getHallTicketno());
			cus.setCollege(customers.getCollege());
			cus.setDegree(customers.getDegree());
			cus.setMobileNo(customers.getMobileNo());
			cus.setCity(customers.getCity());
			cus.setState(customers.getState());
			cus.setPincode(customers.getPincode());
			cus.setId(customers.getId());
			customerList.add(cus);
			a++;
		}
		a=0;
		return customerList;
	}
	@Override
	public List<Customers> deleteCustomers(int id,String email) {
		Customers customers=customerRepository.findById(id);
		
	
		customerRepository.delete(customers);

		return getAllCustomers(email);
	}
	@Override
	public List<Customers> editCustomers(Customers customers, String email,int id) {
		
		Customers customerobj=customerRepository.findById(id);
		customerobj.setFirstName(customers.getFirstName());
		customerobj.setLastName(customers.getLastName());
		customerobj.setHallTicketno(customers.getHallTicketno());
		customerobj.setDegree(customers.getDegree());
		customerobj.setCollege(customers.getCollege());
		customerobj.setMobileNo(customers.getMobileNo());
		customerobj.setCity(customers.getCity());
		customerobj.setState(customers.getState());
		customerobj.setPincode(customers.getPincode());
		customerRepository.save(customerobj);

		return getAllCustomers(email);
	}
	
	

}
