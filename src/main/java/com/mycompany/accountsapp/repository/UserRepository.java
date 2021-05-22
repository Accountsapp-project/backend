package com.mycompany.accountsapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.accountsapp.user.User;



@Repository
public interface UserRepository extends CrudRepository<User,String> {

	public User findByEmail(String username);
	public User findByUsernameAndPassword(String username,String password);
	public void deleteAllByUsername(String username);
}
