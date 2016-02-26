package com.journaldev.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMPLOYEE_ID")
	private Integer employeeId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String MiddleName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="EMPLOYEE_DOB")
	private Date dob;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="JOB_FUNCTION")
	private String jobFunction;
	
	@Column(name="BU_NAME")
	private String buName;
	
	@Column(name="GRADE")
	private String grade;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="OFFICE_ADDRESS")
	private String officeAddress;
	
	@Column(name="PROJECT_ID")
	private String projectId;
	
	@Column(name="IS_OFFSHORE")
	private String isOffshore;
	
	@Column(name="EDUCATION")
	private String education;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="HIRE_DATE")
	private Date hireDate;
	
	@Column(name="YEAR_EXPERINCE")
	private Long yearExperince;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="IS_TRAINING_DONE")
	private String isTraningDone;
	
	@Column(name="PLACE_OF_BIRTH")
	private String placeOfBirth;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getJobFunction() {
		return jobFunction;
	}
	public void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getIsOffshore() {
		return isOffshore;
	}
	public void setIsOffshore(String isOffshore) {
		this.isOffshore = isOffshore;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Long getYearExperince() {
		return yearExperince;
	}
	public void setYearExperince(Long yearExperince) {
		this.yearExperince = yearExperince;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIsTraningDone() {
		return isTraningDone;
	}
	public void setIsTraningDone(String isTraningDone) {
		this.isTraningDone = isTraningDone;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
}
