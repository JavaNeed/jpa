package net.javabeat.springdata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.javabeat.springdata.jpa.data.Customer;
import net.javabeat.springdata.jpa.data.Order;
import net.javabeat.springdata.jpa.data.Payment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringContext.xml")
public class OrderJPQLTest {
	private static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	@PersistenceContext
	private EntityManager em;

	@Test
	public void testOrderTypeQuery() {
		TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
		List<Order> orders = query.getResultList();
		if (orders != null) {
			System.out.println("SIZE : " + orders.size());
		}
	}

	@Test
	public void testOrderAdvance1() {
		String sql = "SELECT od.order FROM Orderdetail od WHERE od.order.orderNumber = :orderNumber";
		TypedQuery<Order> query = em.createQuery(sql, Order.class);
		query.setParameter("orderNumber", 10100);

		List<Order> orders = query.getResultList();
		if (orders != null) {
			for (Order order : orders) {
				System.out.println("-----------------------------------");
				System.out.println("Order Number : " + order.getOrderNumber());
				System.out.println("Order Date   : " + order.getOrderDate());
				System.out.println("Required Date: " + order.getRequiredDate());
				System.out.println("Shipped Date : " + order.getShippedDate());
			}
		}
	}

	// Only many to one relationship / association would work
	@Test
	public void testCustomerAdvance1() {
		String sql = "SELECT o.customer FROM Order o WHERE o.orderNumber = :orderNumber";
		TypedQuery<Customer> query = em.createQuery(sql, Customer.class);
		query.setParameter("orderNumber", 10100);

		List<Customer> customers = query.getResultList();
		if (customers != null) {
			System.out.println("SIZE : " + customers.size());
			for (Customer customer : customers) {
				System.out.println("----------------------------------");
				System.out.println("AddressLine1     : " + customer.getAddressLine1());
				System.out.println("AddressLine2     :  " + customer.getAddressLine2());
				System.out.println("FirstName        :  " + customer.getContactFirstName());
				System.out.println("LastName		 : " + customer.getContactLastName());
				System.out.println("CustomerName	 : " + customer.getCustomerName());
			}
		}
	}

	@Test
	public void testFilteringResult() {
		String sql = "SELECT o.customer FROM Order o WHERE o.customer.customerName = :customerName AND o.customer.postalCode IN (:postalCodes)";

		List<String> postalCodes = new ArrayList<>();
		postalCodes.add("44000");
		postalCodes.add("83030");

		TypedQuery<Customer> query = em.createQuery(sql, Customer.class);
		query.setParameter("customerName", "Atelier graphique");
		query.setParameter("postalCodes", postalCodes);

		List<Customer> customers = query.getResultList();
		if (customers != null) {
			System.out.println("SIZE : " + customers.size());
			for (Customer customer : customers) {
				System.out.println("----------------------------------");
				System.out.println("AddressLine1     : " + customer.getAddressLine1());
				System.out.println("AddressLine2     :  " + customer.getAddressLine2());
				System.out.println("FirstName        :  " + customer.getContactFirstName());
				System.out.println("LastName		 : " + customer.getContactLastName());
				System.out.println("CustomerName	 : " + customer.getCustomerName());
				System.out.println("PostalCode		 : " + customer.getPostalCode());
				System.out.println("City			 : " + customer.getCity());
			}
		}
	}

	@Test
	public void testJoinsBetweenEntities()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String sql = "SELECT c.contactFirstName FROM Order o, Customer c WHERE o.customer = c AND c.state = :state AND o.status = :status";

		TypedQuery<Object> query = em.createQuery(sql, Object.class);
		query.setParameter("state", "NH");
		query.setParameter("status", "Shipped");

		List<Object> resultList = query.getResultList();

		// check if resultList is null
		if (resultList != null && !resultList.isEmpty()) {

			for (Object object : resultList) {
				System.out.println("-----------------------");
				System.out.println("First Name : " + object);
			}
		}
	}

	// Ordinal Parameters (?index)
	@Test
	public void testOrdinalParametersIndex()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String sql = "SELECT c.contactFirstName FROM Order o, Customer c WHERE o.customer = c AND c.state = ? AND o.status = ?";

		TypedQuery<Object> query = em.createQuery(sql, Object.class);
		query.setParameter(1, "NH");
		query.setParameter(2, "Shipped");

		List<Object> resultList = query.getResultList();

		// check if resultList is null
		if (resultList != null && !resultList.isEmpty()) {

			for (Object object : resultList) {
				System.out.println("-----------------------");
				System.out.println("First Name : " + object);
			}
		}
	}

	// String

	@Test
	public void testString()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String sql = "SELECT c.contactFirstName FROM Order o, Customer c WHERE o.customer = c AND c.state = ? AND o.status = ?";

		TypedQuery<String> query = em.createQuery(sql, String.class);
		query.setParameter(1, "NH");
		query.setParameter(2, "Shipped");

		List<String> resultList = query.getResultList();

		// check if resultList is null
		if (resultList != null && !resultList.isEmpty()) {

			for (String firstName : resultList) {
				System.out.println("FIRST NAME : " + firstName);
			}
		}
	}

	@Test
	public void testPayments() throws ParseException {
		Date start = SDF.parse("2004-10-19");
		Date end = SDF.parse("2004-11-14");

		String sql = "SELECT p FROM Payment p WHERE p.paymentDate BETWEEN ?1 AND ?2";

		TypedQuery<Payment> query = em.createQuery(sql, Payment.class);
		query.setParameter(1, start, TemporalType.DATE);
		query.setParameter(2, end, TemporalType.DATE);

		List<Payment> payments = query.getResultList();
		if (payments != null) {
			System.out.println("SIZE : " + payments.size());
			for (Payment payment : payments) {
				System.out.println("-------------------------------------------");
				System.out.println("Amount          : " + payment.getAmount());
				System.out.println("Payment Date	: " + payment.getPaymentDate());
				System.out.println("CustomerName    : " + payment.getCustomer().getCustomerName());
			}
		}
	}

	@Test
	public void testFindOrder() {
		Order order = em.find(Order.class, 10100);
		System.out.println("---------------------------");
		System.out.println("Order Number : " + order.getOrderNumber());
		System.out.println("Order Date   : " + order.getOrderDate());
		System.out.println("Required Date: " + order.getRequiredDate());
		System.out.println("Shipped Date : " + order.getShippedDate());
	}
}
