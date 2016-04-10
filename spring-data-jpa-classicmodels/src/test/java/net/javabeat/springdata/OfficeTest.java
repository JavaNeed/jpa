package net.javabeat.springdata;

import java.util.List;

import net.javabeat.springdata.jpa.data.Customer;
import net.javabeat.springdata.jpa.data.Employee;
import net.javabeat.springdata.jpa.data.Office;
import net.javabeat.springdata.repository.OfficeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringContext.xml")
@Transactional
public class OfficeTest {
	@Autowired
	private OfficeRepository officeRepository;

	

}

