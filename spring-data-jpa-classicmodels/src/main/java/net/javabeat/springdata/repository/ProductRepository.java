package net.javabeat.springdata.repository;

import net.javabeat.springdata.jpa.data.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ProductRepository extends JpaRepository<Product, String>,
	QueryDslPredicateExecutor<Product>{

}
