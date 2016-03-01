package net.javabeat.springdata.executable;

import java.util.List;

import net.javabeat.springdata.jpa.data.Customer;
import net.javabeat.springdata.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Executable {
	public static ClassPathXmlApplicationContext context;

	@Autowired
	private static CustomerRepository customerRepository;
	
	static {
		// Acquire Context
		context = new ClassPathXmlApplicationContext("SpringContext.xml");
	}

	public static void main(String [] args){
		List<Customer> customers = customerRepository.findAll();
		System.out.println(customers.size());
	}
}