package com.journaldev.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.journaldev.spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, QueryDslPredicateExecutor<Employee>{
	
	@Query("select e from Employee e where e.firstName='Andrew' and e.designation='Architect'")
	List<Employee> findByFirstNameAndDesignation();
	
	
	@Query("select e from Employee e where e.firstName= :firstName and e.grade=:grade")
	List<Employee> findByFirstNameAndGrade(@Param("firstName") String firstName, @Param("grade") String grade);
}
