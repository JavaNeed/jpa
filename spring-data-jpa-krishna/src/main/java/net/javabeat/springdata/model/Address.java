package net.javabeat.springdata.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	private int addressId;
	private String addressCountry;
	private String addressCity;

	@OneToOne(cascade=CascadeType.ALL,mappedBy="address")
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
}