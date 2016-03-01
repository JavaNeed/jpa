package net.javabeat.springdata.repository;

import net.javabeat.springdata.jpa.data.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface PaymentRepository extends JpaRepository<Payment, Integer>,
	QueryDslPredicateExecutor<Payment>{

}
