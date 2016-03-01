package net.javabeat.springdata.repository;

import net.javabeat.springdata.jpa.data.Office;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OfficeRepository extends JpaRepository<Office, String>,
	QueryDslPredicateExecutor<Office>{

}
