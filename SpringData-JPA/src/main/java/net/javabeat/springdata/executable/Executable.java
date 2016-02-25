package net.javabeat.springdata.executable;

import net.javabeat.springdata.beans.RegistrationBean;
import net.javabeat.springdata.jpa.data.Address;
import net.javabeat.springdata.jpa.data.Employee;
import net.javabeat.springdata.jpa.data.QEmployee;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysema.query.types.Predicate;

public class Executable {
	public static RegistrationBean registrationBean;
	public static ClassPathXmlApplicationContext context;

	static {
		// Acquire Context
		context = new ClassPathXmlApplicationContext("SpringContext.xml");
		// Get RegistrationBean That Defined
		registrationBean = (RegistrationBean)context.getBean("registrationBean");
	}

	public static void main(String [] args){
		//createEmployee();
		
		// Inquiry Employees
		inquiryByEmployeeId(2);
		inquiryByEmployeeName("Susa Geraurd");
		inquiryByNameContaining("Susa");
	}

	// FindByEmployeeId
	public static void inquiryByEmployeeId(Integer id){
		QEmployee employeeEquation = QEmployee.employee;
		Predicate emp = employeeEquation.employeeId.eq(id);
		Employee employee = registrationBean.getEmployeeReposigtory().findOne(emp);
		System.out.println("----------------------------------");
		System.out.println("EmployeeID :: "+employee.getEmployeeId());
		System.out.println("EmployeeNumber : "+employee.getEmployeeName());
		System.out.println("Address City : "+employee.getAddress().getAddressCity());
		System.out.println("Address Country : "+ employee.getAddress().getAddressCountry());
		System.out.println("Address ID :"+employee.getAddress().getAddressId());
	}

	// Find By EmployeeName
	public static void inquiryByEmployeeName(String name){
		QEmployee employeeEquation = QEmployee.employee;
		Predicate emp = employeeEquation.employeeName.eq(name);
		Employee employee = registrationBean.getEmployeeReposigtory().findOne(emp);
		System.out.println("--------------------------------");
		System.out.println("By Employee Name :: Employee Inquired :: "+employee.getEmployeeId()+" :: "+employee.getEmployeeName());
	}

	// Containing String
	public static void inquiryByNameContaining(String name){
		QEmployee employeeEquation = QEmployee.employee;
		Predicate emp = employeeEquation.employeeName.contains(name);
		Iterable<Employee> employees = registrationBean.getEmployeeReposigtory().findAll(emp);
		for(Employee e : employees){
			System.out.println("By Employee Name Containing :: Employee Inquired :: "+e.getEmployeeId()+" :: "+e.getEmployeeName());
		}

	}

	public static void createEmployee(){

		// Create Employee
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		employee.setEmployeeName("Susa Geraurd");
		
		// Create Address
		Address address = new Address();
		address.setAddressId(1);
		address.setAddressCountry("United Kingdom");
		address.setAddressCity("London");
		address.setEmployee(employee);
		
		employee.setAddress(address);
		
		// Persist Using EmployeeRepository
		registrationBean.getEmployeeReposigtory().save(employee);
	}
}