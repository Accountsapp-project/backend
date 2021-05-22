package com.mycompany.accountsapp.service;

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
	
	public void deleteUser(String username) {
		userRepository.deleteAllByUsername(username);
	}
	
	public User resetPassword(User user) {
		String tempUsername = user.getUsername();
		deleteUser(tempUsername);
		return userRepository.save(user);
	}
}
