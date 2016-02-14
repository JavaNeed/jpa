package net.javabeat.springdata.main;

import net.javabeat.springdata.beans.RegistrationBean;
import net.javabeat.springdata.model.Address;
import net.javabeat.springdata.model.Employee;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringContext.xml");

		RegistrationBean registrationBean = (RegistrationBean)context.getBean("registrationBean");

		// Create Employee
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("Susa Hurbert");

		// Create Address
		Address address = new Address();
		address.setAddressId(1);
		address.setAddressCountry("United Kingdom");
		address.setAddressCity("London");
		address.setEmployee(employee);
		employee.setAddress(address);

		// Persist Using EmployeeRepository
		registrationBean.getEmployeeRepository().save(employee);
		// Find By Employee Id
		Employee emp = registrationBean.getEmployeeRepository().findByEmployeeId(1);
		System.out.println("----- Find By ID ------");
		System.out.println(emp.getEmployeeId());
		System.out.println(emp.getEmployeeName());
		System.out.println(emp.getAddress());
		
		
		Employee emp2 = registrationBean.getEmployeeRepository().findByEmployeeName("Susa Hurbert");
		System.out.println("----- Find By Employee Name ----");
		System.out.println(emp2.getEmployeeId());
		System.out.println(emp2.getEmployeeName());
		System.out.println(emp2.getAddress());
		
		// Close context
		context.close();
	}
}
