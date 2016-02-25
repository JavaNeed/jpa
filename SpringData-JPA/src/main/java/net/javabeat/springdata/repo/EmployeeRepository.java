package net.javabeat.springdata.repo;

import net.javabeat.springdata.jpa.data.Employee;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>,QueryDslPredicateExecutor<Employee>{
	public Employee findByEmployeeId(Integer id);
}
