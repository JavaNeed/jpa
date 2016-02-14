package com.byteslounge.spring.tx;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.byteslounge.spring.tx.model.User;
import com.byteslounge.spring.tx.user.UserManager;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");

		List<User> list = userManager.findAllUsers();
		System.out.println("User count: " + list.size());

		
		System.out.println("------ Save a new User -----");
		User user = new User();
		user.setUsername("johndoe");
		user.setName("John Doe");
		userManager.insertUser(user);
		
		
		User user2 = new User();
		user2.setName("Deepak");
		user2.setUsername("deepakk");
		userManager.insertUser(user2);
		
		User user3 = new User();
		user3.setName("Raj");
		user3.setUsername("Koman");
		userManager.insertUser(user3);
		
		System.out.println("User inserted!");

		list = userManager.findAllUsers();
		System.out.println("User count: " + list.size());

	}
}
