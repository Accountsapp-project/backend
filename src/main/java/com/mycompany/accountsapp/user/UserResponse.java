package com.mycompany.accountsapp.user;

import java.util.List;

public class UserResponse {
	private List<User> userDetails;
    
	public UserResponse() {
		
	}
	
	public UserResponse(List<User> userDetails) {
		super();
		this.userDetails = userDetails;
	}

	public List<User> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<User> userDetails) {
		this.userDetails = userDetails;
	}
	
}
