package com.mycompany.accountsapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.accountsapp.user.User;



@Repository
public interface UserRepository extends CrudRepository<User,String> {
	@Query("select u from User u where u.username like %?1%")
    public List<User> findAll(String Username);
	public List<User> findAll();
	public User findByEmail(String username);
	public User findByUsernameAndPassword(String username,String password);
	public void deleteAllByUsername(String username);
	public User findByUsername(String username);
	
	@Modifying
	@Transactional
	@Query("update User set password=?1 where password=?2")
	public void  updatePassword(String password,String password1);
}
