package com.mycompany.accountsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.accountsapp.pojo.Group;
import com.mycompany.accountsapp.pojo.User;
import com.mycompany.accountsapp.service.GroupService;
import com.mycompany.accountsapp.service.UserService;

@RestController
public class GroupController {
	
	@Autowired
	private GroupService groupService;
 
	@Autowired
	private UserService userService ;
	
	@PostMapping("/group")
	@CrossOrigin(origins = "http://localhost:8100")
	public Group createGroup(@RequestBody Group group,@RequestParam("userlist") List<String> userlist) {
		User tempUser = null;
		for(String i:userlist)
		{
			tempUser = userService.findByUsername(i);
			group.getUsers().add(tempUser);
			tempUser.getGroups().add(group);
		}
		return groupService.createGroup(group);
	}
	
	
	
	
}
