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
	 private long group_id;
	 private String group_name;
	 private String status;
	
	 @JsonIgnore
	 @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	 @JoinTable(name = "user_group",
	 		joinColumns = { @JoinColumn(name = "group_id")},
	 		inverseJoinColumns = {@JoinColumn( name = "user_id")}
	 )
	 private Set<User> users = new HashSet<User>();
	 
	 public Group() {
		 
	 }
	 public Group(String group_name, String status) {
		super();
		this.group_name = group_name;
		this.status = status;
	 }
	 
	public long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
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
