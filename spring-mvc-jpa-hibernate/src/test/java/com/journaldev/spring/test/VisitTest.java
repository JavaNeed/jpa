package com.journaldev.spring.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.spring.model.Visit;
import com.journaldev.spring.repository.VisitRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:servlet-context.xml")
public class VisitTest {
	@Autowired
	private VisitRepository visitRepository;
	
	@Test
	public void testCreateVisits() {
		Visit visit = new Visit();
		visit.setPaidAmount("100");
		visit.setPatientName("John Cena");
		visit.setVisitOn(new Date());
		visit.setVisitType("Physician");
		
		Visit visit1 = new Visit();
		visit1.setPaidAmount("230");
		visit1.setPatientName("Savani Sen");
		visit1.setVisitOn(new Date());
		visit1.setVisitType("Physician");
		
		
		Visit visit2 = new Visit();
		visit2.setPaidAmount("780");
		visit2.setPatientName("Deepa Saxena");
		visit2.setVisitOn(new Date());
		visit2.setVisitType("Physician");
		
		Visit visit3 = new Visit();
		visit3.setPaidAmount("550");
		visit3.setPatientName("John Cena");
		visit3.setVisitOn(new Date());
		visit3.setVisitType("Emergency Room");
		
		visitRepository.save(visit);
		visitRepository.save(visit1);
		visitRepository.save(visit2);
		visitRepository.save(visit3);
	}
	
	@Test
	public void testFindByPatientId(){
		List<Visit> visits = visitRepository.findByVisitType("Physician");
		
		System.out.println("Visits Size : "+visits.size());
		
		for (Visit visit : visits) {
			System.out.println("------------------");
			System.out.println(visit.getPaidAmount());
			System.out.println(visit.getPatientName());
			System.out.println(visit.getPatientId());
			System.out.println(visit.getVisitOn());
		}
	}
	
	
	@Test
	public void testFindByVisitTypeQueryDSL(){
		List<Visit> visits = visitRepository.findByVisitType();
		
		System.out.println("Visits Size : "+visits.size());
		
		for (Visit visit : visits) {
			System.out.println("------------------");
			System.out.println("Paid Amount : "+ visit.getPaidAmount());
			System.out.println("Patient Name : "+visit.getPatientName());
			System.out.println("Patient ID : "+visit.getPatientId());
			System.out.println("Visit On :"+visit.getVisitOn());
		}
	}

}
