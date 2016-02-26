package com.journaldev.spring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.spring.model.Employee;
import com.journaldev.spring.repository.EmployeeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:servlet-context.xml")
public class EmployeeTest {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void testEmployees() {
		List<Employee> employees = employeeRepository.findByFirstNameAndDesignation();
		System.out.println(employees.size());
		for (Employee employee : employees) {
			System.out.println("---------------------------------------");
			System.out.println("First Name : "+employee.getFirstName());
			System.out.println("Middle Name :"+employee.getMiddleName());
			System.out.println("Last Name  : "+employee.getLastName());
		}
	}
	
	@Test
	public void testEmployees1() {
		List<Employee> employees = employeeRepository.findByFirstNameAndGrade("Andrew", "E65");
		System.out.println(employees.size());
		for (Employee employee : employees) {
			System.out.println("---------------------------------------");
			System.out.println("First Name : "+employee.getFirstName());
			System.out.println("Middle Name :"+employee.getMiddleName());
			System.out.println("Last Name  : "+employee.getLastName());
		}
	}

}
