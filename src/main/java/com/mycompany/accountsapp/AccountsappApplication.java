package com.mycompany.accountsapp;

import java.util.ArrayList;
import java.util.List;
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
	            	userController.insertUser(user1);
	            	User user3 = new User("vigneshviki1005@gmail.com" ,"vignesh","raina","8248276330");
	                userController.insertUser(user3);
	        		Group group = new Group("vvs","active");
	        		group.getUsers().add(user1);
	        		group.getUsers().add(user2);
	        		group.getUsers().add(user3);
	        		
	        	    user1.getGroups().add(group);
	        	    user2.getGroups().add(group);
	        	    user3.getGroups().add(group);
//	        		
//	        		groupController.createGroup(group);
//	        		User user4=new User("ramesh@gmail.com","ramesh","ram123","6789546743");
//	        		userController.insertUser(user4);
//	        		User user5=new User("suresh@gmail.com","suresh","sur123","5467789324");
//     		        userController.insertUser(user5);
//	        		User user6=new User("rajesh@gmail.com","rajesh","raj123","6789546987");
//	        		userController.insertUser(user6);
//	        		User user7=new User("rohan@gmail.com","rohan","ro123","6789554328");
//	        		userController.insertUser(user7);
	        		User user8=new User("jagan@gmail.com","jagan","jag123","8765778632");
	        		userController.insertUser(user8);
	        		User user9=new User("jack@gmail.com","jack","jack123","9967885432");
	        		userController.insertUser(user9);
	        		User user10=new User("jill@gmail.com","jill","jill123","9090879962");
	        		userController.insertUser(user10);
	        		User user11=new User("niranjan@gmail.com","niranjan","nir123","8677154321");
	        		userController.insertUser(user11);
	        		User user12=new User("samantha@gmail.com","sammu","sam123","6969696960");
	        		userController.insertUser(user12);
	        		
//	        		Group group1 = new Group("barchester","active");
//	        		
//	        		List<User> userlist = new ArrayList<User>();
//	        		userlist.add(new User("ramesh@gmail.com","ramesh","ram123","6789546743"));
//	        		userlist.add(new User("suresh@gmail.com","suresh","sur123","5467789324"));
//	        		userlist.add(new User("rajesh@gmail.com","rajesh","raj123","6789546987"));
//	        		userlist.add(new User("rohan@gmail.com","rohan","ro123","6789554328"));
//	        		
//	        		groupController.createGroup(group1, userlist);
	        		
	        	}
	        	else if(ch == 2) {
	        		List<User> userlist = new ArrayList<User>();
	        		userlist = userController.searchBar("vaseekaran");
	        	}
	        	else if(ch == 3) {
	                String temp = "vaseekaran";
	        		
	        		
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
