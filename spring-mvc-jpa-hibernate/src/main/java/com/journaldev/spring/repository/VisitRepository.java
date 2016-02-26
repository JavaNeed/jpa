package com.journaldev.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer>,
		QueryDslPredicateExecutor<Visit>{
	List<Visit> findByVisitType(String visitType);
	
	@Query("SELECT v FROM Visit v WHERE v.visitType='Physician'")
	List<Visit> findByVisitType();
}
