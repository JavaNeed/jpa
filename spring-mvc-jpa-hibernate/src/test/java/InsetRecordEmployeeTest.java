import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.spring.model.Employee;
import com.journaldev.spring.repository.EmployeeRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:servlet-context.xml")
public class InsetRecordEmployeeTest {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Test
	public void test() throws ParseException {
		Employee employee = new Employee();
		employee.setFirstName("Andrew");
		employee.setMiddleName("David");
		employee.setLastName("Johnston");
		employee.setDob(sdf.parse("08-03-1967"));
		employee.setEmailId("andrew.johnston@tcs.com");
		employee.setJobFunction("BUS");
		employee.setBuName("IT Services");
		employee.setGrade("E65");
		employee.setDepartmentName("Life Sciences");
		employee.setDesignation("Architect");
		employee.setOfficeAddress("Reston, USA");
		employee.setProjectId("10004");
		employee.setIsOffshore("N");
		employee.setEducation("Bachelor Of Engineering");
		employee.setHireDate(sdf.parse("02-08-1998"));
		employee.setYearExperince(19L);
		employee.setIsTraningDone("Y");
		employee.setPlaceOfBirth("Reston");
		
		employeeRepo.save(employee);
	}

}
