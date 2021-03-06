package net.javabeat.springdata;

import java.math.BigDecimal;
import java.util.List;

import net.javabeat.springdata.jpa.data.Customer;
import net.javabeat.springdata.jpa.data.Employee;
import net.javabeat.springdata.jpa.data.Order;
import net.javabeat.springdata.repository.CustomerRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringContext.xml")
/*@Transactional*/
public class CustomerTest {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void testUpdateCustomer(){
		customerRepository.updateCustomer("MH", 103);
		System.out.println("Record Update Successfully");
	}
	
	@Test
	public void testUpdateCreditLimitOfCustomer(){
		customerRepository.updateCustomerForCreditLimit("Achalpur", 103);
		System.out.println("Record Update Successfully");
	}
	
	@Test
	public void createCustomer(){
		
		Customer customer = new Customer();
		customer.setCustomerNumber(498);
		customer.setCustomerName("John Kerr");
		customer.setContactLastName("Kerr");
		customer.setContactFirstName("John");
		customer.setPhone("11.22.3333");
		customer.setAddressLine1("500 Street");
		customer.setAddressLine2("Green Tree Hills");
		customer.setCity("London"); 
		customer.setState("United Kingdom");
		customer.setPostalCode("233214");
		customer.setCountry("England");
		customer.setCreditLimit(new BigDecimal("321312"));
		
		Employee e = new Employee();
		e.setEmail("john.kerr@gmail.com");
		e.setEmployeeNumber(1702);
		e.setExtension("x2344");
		e.setFirstName("John");
		e.setLastName("Kerr");
		e.setJobTitle("Software Developer");
		
		customer.setEmployee(e);
		
		customerRepository.save(customer);
	}

	@Test
	public void testCountry() {
		List<Customer> customers = customerRepository.findAll();
		System.out.println(customers.size());
	}
	
	@Test
	public void testCountryDSL(){
		List<Customer> customers = customerRepository.findByCountry();
		System.out.println(customers.size());
		for (Customer customer : customers) {
			System.out.println("-----------------------------");
			System.out.println(customer.getEmployee().getEmail());
			System.out.println(customer.getCountry());
		}
	}
	
	
	@Test
	public void testCustomerOrder(){
		List<Customer> customers = customerRepository.findByCustomerNumber(103);
		System.out.println("CUSTOMETS : "+customers);
		for (Customer customer : customers) {
			System.out.println("================================");
			System.out.println(customer.getCustomerNumber());
			System.out.println(customer.getCustomerName());
			System.out.println(customer.getContactFirstName());
			System.out.println(customer.getContactLastName());
			System.out.println(customer.getPhone());
			System.out.println(customer.getAddressLine1());
			System.out.println(customer.getAddressLine2());
			System.out.println(customer.getCity());
			System.out.println(customer.getState());
			System.out.println(customer.getPostalCode());
			System.out.println(customer.getCountry());
			System.out.println(customer.getCreditLimit());
			
			List<Order> orders = customer.getOrders();
			for (Order order : orders) {
				System.out.println("-------------------------");
				System.out.println(order.getOrderNumber());
				System.out.println(order.getOrderDate());
				System.out.println(order.getRequiredDate());
				System.out.println(order.getShippedDate());
				System.out.println(order.getStatus());
			}
		}
	}

}
