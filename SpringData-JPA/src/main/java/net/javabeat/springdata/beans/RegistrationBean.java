package net.javabeat.springdata.beans;

import net.javabeat.springdata.repo.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationBean {
	@Autowired
	private EmployeeRepository employeeReposigtory;

	public RegistrationBean(){ 	}

	public EmployeeRepository getEmployeeReposigtory() {
		return employeeReposigtory;
	}

	public void setEmployeeReposigtory(EmployeeRepository employeeReposigtory) {
		this.employeeReposigtory = employeeReposigtory;
	}
}
