package com.mycompany.accountsapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.accountsapp.repository.UserRepository;
import com.mycompany.accountsapp.user.User;




@Service
public class UserService {
    
	@Autowired
	private UserRepository userRepository;
	
	public User insertUser(User user) {
		 return userRepository.save(user);
	}
	
	public User fetchUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User fetchUserByUsernameAndPassword(String username,String password) {
		return userRepository.findByUsernameAndPassword(username,password);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> fetchAllRows(String username){
		if(username != null) {
			return userRepository.findAll(username);
		}
		return userRepository.findAll();
	}
}
