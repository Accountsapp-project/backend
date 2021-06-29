package com.mycompany.accountsapp.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.accountsapp.pojo.Group;
import com.mycompany.accountsapp.pojo.User;
import com.mycompany.accountsapp.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService ;
   
	@PostMapping("/signup")
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
	public User loginUser(@RequestBody User user) throws Exception {
		User tempUser = null;
		String tempUsername = user.getUsername();
		String tempPassword = user.getPassword();
		System.out.println("username : "+tempUsername + "password : "+tempPassword);
		if(tempUsername != null && tempPassword != null) {
			tempUser = userService.fetchUserByUsernameAndPassword(tempUsername, tempPassword);
		}
		if(tempUser == null) {
			throw new Exception("wrodng credentials");
		}
		else {
			System.out.println("Login success");
		}
		return tempUser;
	}
	
	@GetMapping("/profile")
	public User fetchUserDetails(@RequestParam(value = "username") String tempUsername) {
		User tempUser = null;
		System.out.println("user"+tempUsername);
		if(tempUsername != null) {
			tempUser = userService.findByUsername(tempUsername);
		}
		System.out.println(tempUser.getEmail());
		return tempUser;
	}
	

//	@GetMapping("/mainpage")
//	public List<User> searchBar(@RequestParam(value = "searchbar") String username) {
//		List<User> tempList = userService.fetchAllRows(username);
//		Set<Group> tempgrp = null;
//		for(User user: tempList) {
//			tempgrp = user.getGroups();
//			for (Group value : tempgrp)
//	            System.out.print(value.getGroup_name());
//		}
//		return tempList;
//	}
	
	@PostMapping("/profile/edit")
	public void changePassword(@RequestBody User user,@RequestParam(value = "newpassword") String newpassword,@RequestParam(value = "newusername") String newUsername) throws Exception{
		User tempuser=null;
		System.out.println("logged  "+user.getUsername());
		tempuser=loginUser(user);
		if(tempuser.getPassword().equals(user.getPassword()))
		{
			userService.updatePassword(newpassword,user.getPassword());
		}	
		else
			throw new Exception("Wrong Current Password!");
		if(!tempuser.getUsername().equals(newUsername)){
			userService.updateUsername(newUsername,user.getUsername());
		} 
	}
	
}
