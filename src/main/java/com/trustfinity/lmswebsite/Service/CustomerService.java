package com.trustfinity.lmswebsite.Service;

import java.util.List;

import com.trustfinity.lmswebsite.Model.Customers;

public interface CustomerService {
	
	public List<Customers> save(Customers customers,String email);
	
	public List<Customers> getAllCustomers(String email);
	
	public List<Customers> deleteCustomers(int id,String email);
	
	public List<Customers> editCustomers(Customers customers,String email,int id);

}
