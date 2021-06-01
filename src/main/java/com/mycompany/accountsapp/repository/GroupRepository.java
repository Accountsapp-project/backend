package com.mycompany.accountsapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.accountsapp.pojo.Group;

@Repository
public interface GroupRepository extends CrudRepository<Group,Integer>	 {

}
