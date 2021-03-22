package com.trustfinity.lmswebsite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trustfinity.lmswebsite.Model.Customers;
import com.trustfinity.lmswebsite.Model.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer>{
	
	
	public List<Customers> findByUserEmail(String email);
	public Customers findById(int id);
	
//	@Query(value="SET FOREIGN_KEY_CHECKS=0", nativeQuery = true)
//
//	public void setForeignKeyChucksOff();
//	@Query(value="SET FOREIGN_KEY_CHECKS=1", nativeQuery = true)
//
//	public void setForeignKeyChucksOn();

}
