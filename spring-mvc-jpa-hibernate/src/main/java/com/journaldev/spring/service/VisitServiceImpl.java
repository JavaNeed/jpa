package com.journaldev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.journaldev.spring.model.Visit;
import com.journaldev.spring.repository.VisitRepository;

public class VisitServiceImpl implements VisitService{
	@Autowired
	private VisitRepository visitRepository; 
	
	@Override
	public void addVisit(Visit visit) {
		visitRepository.save(visit);
	}

	@Override
	public void updateVisit(Visit visit) {
		visitRepository.save(visit);
	}

	@Override
	public List<Visit> listVisits() {
		return visitRepository.findAll();
	}

	@Override
	public void removeVisit(Integer patientId) {
		visitRepository.delete(patientId);
	}

	@Override
	public List<Visit> getVisitByVisitType(String visitType) {
		List<Visit> visits = visitRepository.findByVisitType(visitType);
		return visits;
	}
}
