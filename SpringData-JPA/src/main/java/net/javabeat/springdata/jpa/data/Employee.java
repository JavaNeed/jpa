package net.javabeat.springdata.jpa.data;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	private Integer employeeId;

	@Basic(optional = false)
	private String employeeName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AddressId")
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public boolean equals(Object obj){
		if(obj instanceof Employee){
			Employee emp = (Employee)obj;
			if(this.employeeId == emp.employeeId){
				return true;
			}
		}
		return false;
	}

	public int hashCode(){
		return this.employeeId;
	}
}