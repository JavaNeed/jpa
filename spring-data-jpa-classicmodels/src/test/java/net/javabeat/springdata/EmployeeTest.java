package net.javabeat.springdata;

import java.util.List;

import net.javabeat.springdata.jpa.data.Employee;
import net.javabeat.springdata.repository.EmployeeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringContext.xml")
public class EmployeeTest {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void testEmployee() {
		List<Employee> employees =employeeRepository.findAll();
		System.out.println(employees.size());
	}

}
