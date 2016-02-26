package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Visit;

public interface VisitService {
	public void addVisit(Visit visit);
	public void updateVisit(Visit visit);
	public List<Visit> listVisits();
	public List<Visit> getVisitByVisitType(String visitType);
	public void removeVisit(Integer patientId);
}
