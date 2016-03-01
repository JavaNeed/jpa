package net.javabeat.springdata.repository;

import net.javabeat.springdata.jpa.data.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface StockRepository extends JpaRepository<Stock, Integer>,
	QueryDslPredicateExecutor<Stock>{

}
