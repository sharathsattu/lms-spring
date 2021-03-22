package com.trustfinity.lmswebsite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trustfinity.lmswebsite.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByEmail(String email);
	

	@Query(value="select * from users", nativeQuery = true)

	public List<User> getAllUser();


}
