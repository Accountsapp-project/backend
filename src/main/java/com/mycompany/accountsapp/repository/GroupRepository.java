package com.mycompany.accountsapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.accountsapp.pojo.Group;
import com.mycompany.accountsapp.pojo.User;

@Repository
public interface GroupRepository extends CrudRepository<Group,Integer>	 {
	
	
}
