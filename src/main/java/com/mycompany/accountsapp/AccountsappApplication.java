package com.mycompany.accountsapp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mycompany.accountsapp.controller.GroupController;
import com.mycompany.accountsapp.controller.UserController;
import com.mycompany.accountsapp.pojo.Group;
import com.mycompany.accountsapp.pojo.User;


@SpringBootApplication
public class AccountsappApplication implements CommandLineRunner{

	
	
	    @Autowired
	    private ApplicationContext applicationContext;
		
		public static void main(String[] args) {
			SpringApplication.run(AccountsappApplication.class, args);
			
			
		}
		
		@Override
	    public void run(String... args) throws Exception {
			Scanner sc = new Scanner(System.in);
			UserController userController = applicationContext.getBean(UserController.class);
		    GroupController groupController = applicationContext.getBean(GroupController.class);
			while(true) {
				System.out.print("\tMenu \n1.insert \n2.delete \n3.update\n4.display \n0.exit"); 
				System.out.print("\nEnter your choice :");
	        	int ch = sc.nextInt();	 	
	        	if(ch == 1) {
	      
	            	User user1 = new User("Srikanthmessi@gmail.com","Srik","swetha","9677193007");
	            	User user2 = new User("vasee002@gmail.com","vaseekaran","vasee@123","8610063079");
	            	User user3 = new User("vigneshviki1005@gmail.com" ,"vignesh","raina","8248276330");
	            
	        		Group group = new Group("vvs","active");
	        		group.getUsers().add(user1);
	        		group.getUsers().add(user2);
	        		group.getUsers().add(user3);
	        		
	        	    user1.getGroups().add(group);
	        	    user2.getGroups().add(group);
	        	    user3.getGroups().add(group);
	        		
	        		groupController.createGroup(group);
	        	}
	        	else if(ch == 2) {
	        		User user = new User("vasee002@gmail.com","vaseekaran","vasee@vtr","8610063079");
	            	userController.loginUser(user);
	        	}
	        	else if(ch == 3) {
	                String temp = "vaseekaran";
	        		User user = new User();
	        		userController.fetchUserDetails(temp);
	        		
	        	}
	        	else if(ch == 4) {
	        		//userController.searchBar("vas");;
	        		User user=new User("vasee002@gmail.com","vaseekaran02","vasee@vtr","8610063079");
	        		String newUsername = "vaseekaran";
	        		String newpassword="vasee@123";
	        		userController.changePassword(user, newpassword,newUsername);
	        	}
	        	else if(ch == 0) {
	        		System.out.println("Exited");
	        		break;
	        	}
			}
		}

}
