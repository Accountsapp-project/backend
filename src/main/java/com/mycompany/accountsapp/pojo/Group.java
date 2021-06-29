package com.mycompany.accountsapp.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "groups")
public class Group {

	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 private String name;
	 private String status;
	
	 @JsonIgnore
	 @ManyToMany
	 @JoinTable(name = "user_group",
	 		joinColumns = { @JoinColumn(name = "group_id")},
	 		inverseJoinColumns = {@JoinColumn( name = "user_id")}
	 )
	 private Set<User> users = new HashSet<User>();
	 
	 public Group() {
		 
	 }
	
	 
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public Set<User> getUsers() {
			return users;
		}
		public void setUsers(Set<User> users) {
			this.users = users;
		}
	 
	 
}
