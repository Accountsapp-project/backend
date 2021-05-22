/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.accountsapp.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

/**
 *
 * @author vasee
 */
@Entity
@Table(name = "userdetails")
@Transactional
public class User {
	@Id
	private String email;
    private String username;
    private String password;
    private String phone;
    
    public User() {
    	
    }
    
	public User(String email, String username, String password, String phone) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    
   
 
    
}
