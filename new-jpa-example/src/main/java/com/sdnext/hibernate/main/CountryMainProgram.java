package com.sdnext.hibernate.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sdnext.hibernate.model.Country;
import com.sdnext.hibernate.model.Department;
import com.sdnext.hibernate.model.Employee;
import com.sdnext.hibernate.model.JobHistory;

public class CountryMainProgram {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("new-jpa-example");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		// Find Country
		Country country = entitymanager.find(Country.class, "AR");
		System.out.println("------- COUNTRY DETAILS -----------");
		System.out.println(country.getCountryId());
		System.out.println(country.getCountryName());
		System.out.println(country.getRegionId());
		
		// Find Employee
		Employee employee = entitymanager.find(Employee.class, 100L);
		System.out.println("------- EMPLOYEE DETAILS  ----------");
		System.out.println(employee.getEmail());
		System.out.println(employee.getEmployeeId());
		System.out.println(employee.getFirstName());
		System.out.println(employee.getJobId());
		System.out.println(employee.getLastName());
		System.out.println(employee.getPhoneNumber());
		System.out.println(employee.getCommissionPct());
		System.out.println(employee.getDepartmentId());
		System.out.println(employee.getHireDate());
		System.out.println(employee.getManagerId());
		System.out.println(employee.getSalary());
		
		// Find Department
		Department department = entitymanager.find(Department.class, 10L);
		System.out.println("---------- DEPARTMENT---------------");
		System.out.println(department.getDepartmentName());
		System.out.println(department.getDepartmentId());
		System.out.println(department.getManagerId());
		System.out.println(department.getManagerId());
	}
}
