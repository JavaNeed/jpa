package net.javabeat.springdata.repository;

import net.javabeat.springdata.jpa.data.Productline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ProductlineRepository extends JpaRepository<Productline, String>,
	QueryDslPredicateExecutor<Productline>{

}
