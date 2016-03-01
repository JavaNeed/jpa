package net.javabeat.springdata.repository;

import java.util.List;

import net.javabeat.springdata.jpa.data.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer>,
	QueryDslPredicateExecutor<Customer>{

	@Query("select c from Customer c where c.country='USA'")
	List<Customer> findByCountry();
	
	@Query("select c from Customer c, Order o where o.customer.customerNumber=:customerNumber and c.customerNumber=:customerNumber")
	List<Customer> findByCustomerNumber(@Param("customerNumber") Integer customerNumber);
}
