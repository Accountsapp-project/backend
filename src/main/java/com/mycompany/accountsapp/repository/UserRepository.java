package com.mycompany.accountsapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.accountsapp.pojo.User;



@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
	@Query("select u from User u where u.username like %?1%"
			+ "or u.phone like %?1%"
			+ "or u.email like %?1%"
			)
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
	
	@Modifying
	@Transactional
	@Query("update User set username=?1 where username=?2")
	public void updateUsername(String username,String username1);
}
