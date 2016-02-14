package net.javabeat.springdata.repository;

import net.javabeat.springdata.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findByEmployeeId(Integer id);
	Employee findByEmployeeName(String name);
	
}
