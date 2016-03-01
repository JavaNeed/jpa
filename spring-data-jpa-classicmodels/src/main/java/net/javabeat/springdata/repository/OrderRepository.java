package net.javabeat.springdata.repository;

import net.javabeat.springdata.jpa.data.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OrderRepository extends JpaRepository<Order, Integer>,
	QueryDslPredicateExecutor<Order>{

}
