package com.mycompany.accountsapp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mycompany.accountsapp.controller.UserController;
import com.mycompany.accountsapp.user.User;


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
		   
			while(true) {
				System.out.print("\tMenu \n1.insert \n2.delete \n3.update\n4.display \n0.exit"); 
				System.out.print("\nEnter your choice :");
	        	int ch = sc.nextInt();	 	
	        	if(ch == 1) {
	      
	            	User user = new User("vasee002@gmail.com","vaseekaran","vasee@vtr","8610063079");
	            	userController.insertUser(user);
	            
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
	        		User user=new User("vasee002@gmail.com","vaseekaran","vasee@vtr","8610063079");
	        		
	        		String newpassword="shakku";
	        		userController.changePassword(user, newpassword);
	        	}
	        	else if(ch == 0) {
	        		System.out.println("Exited");
	        		break;
	        	}
			}
		}

}
