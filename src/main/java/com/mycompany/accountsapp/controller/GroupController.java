package com.mycompany.accountsapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mycompany.accountsapp.pojo.Group;
import com.mycompany.accountsapp.pojo.User;
import com.mycompany.accountsapp.repository.GroupRepository;
import com.mycompany.accountsapp.repository.UserRepository;
import com.mycompany.accountsapp.service.GroupService;
import com.mycompany.accountsapp.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/group")
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private GroupRepository groupRepository;
 
	@Autowired
	private UserService userService ;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/create")
	public Group createGroup(@RequestBody Group group) {
		return groupService.createGroup(group);
	}
	
	
	@PostMapping("/update")
	public Group addmembers(@RequestBody Group group,@RequestParam("userlist") List<Long> userlist) {
		Optional<User> tempUser = null;
		Optional<Group> existingGroup = groupRepository.findById(group.getId());
		for(Long i:userlist)
		{
			tempUser = userRepository.findById(i);
			if(groupService.isUserPresent(existingGroup.get(), tempUser.get().getId()) == false) {
				existingGroup.get().getUsers().add(tempUser.get());
			}
			else {
			  System.out.println("member already exist");
			}
		}
		groupService.createGroup(existingGroup.get());
		return group;
	}
	
	
	
	
}
