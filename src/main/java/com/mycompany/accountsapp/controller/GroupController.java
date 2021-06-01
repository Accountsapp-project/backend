package com.mycompany.accountsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.accountsapp.pojo.Group;
import com.mycompany.accountsapp.service.GroupService;

@RestController
public class GroupController {
	
	@Autowired
	private GroupService groupService;

	public Group createGroup(Group group) {
		return groupService.createGroup(group);
	}
}
