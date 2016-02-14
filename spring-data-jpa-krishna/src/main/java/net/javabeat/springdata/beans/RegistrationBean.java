package net.javabeat.springdata.beans;

import net.javabeat.springdata.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationBean {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public RegistrationBean() {}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
}
