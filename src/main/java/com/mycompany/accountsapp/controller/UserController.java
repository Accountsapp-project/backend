package com.mycompany.accountsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.accountsapp.service.UserService;
import com.mycompany.accountsapp.user.User;


@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService ;
   
	@PostMapping("/signup")
	@CrossOrigin(origins = "http://localhost:8100")
	public User insertUser(@RequestBody User user) throws Exception {
		 String tempEmail = user.getEmail();
		 if(tempEmail != null && !"".equals(tempEmail)) {
			 User tempUser = userService.fetchUserByEmail(tempEmail);
			 if(tempUser != null) {
				 throw new Exception("Username "+tempEmail+"already exists");
			 }
		 }
		 User tempUser = null;
		 tempUser =  userService.insertUser(user);
		 return tempUser;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:8100")
	public User loginUser(@RequestBody User user) throws Exception {
		User tempUser = null;
		String tempUsername = user.getUsername();
		String tempPassword = user.getPassword();
		if(tempUsername != null && tempPassword != null) {
			tempUser = userService.fetchUserByUsernameAndPassword(tempUsername, tempPassword);
		}
		if(tempUser == null) {
			throw new Exception("wrong credentials");
		}
		else {
			System.out.println("Login success");
		}
		return tempUser;
	}
	
	
}
