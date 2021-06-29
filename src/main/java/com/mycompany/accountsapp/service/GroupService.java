package com.mycompany.accountsapp.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.accountsapp.pojo.Group;
import com.mycompany.accountsapp.pojo.User;
import com.mycompany.accountsapp.repository.GroupRepository;

@Service
public class GroupService {
	@Autowired
	private GroupRepository groupRepository;
	
	
	public Group createGroup(Group group) {
		return groupRepository.save(group);
	}
    
	public boolean isUserPresent(Group group,Long userId) {
		 Iterator<User> iter = group.getUsers().iterator();
		 while (iter.hasNext()) {
	            if(iter.next().getId() == userId) {
	            	return true;
	            }
	            
	        }
		 return false;
	}

		
}
