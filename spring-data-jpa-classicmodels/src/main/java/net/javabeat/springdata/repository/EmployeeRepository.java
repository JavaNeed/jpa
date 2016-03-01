package net.javabeat.springdata.repository;

import java.util.List;

import net.javabeat.springdata.jpa.data.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>,
	QueryDslPredicateExecutor<Employee>{

	@Query("select c from Customer c where c.country='USA'")
	List<Employee> findByCountry();
}
