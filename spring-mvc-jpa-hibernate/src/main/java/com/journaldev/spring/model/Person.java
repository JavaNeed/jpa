package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

import com.journaldev.spring.constant.Constant;

@Entity
@Table(name="PERSON")
public class Person {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	/*@SafeHtml(whitelistType=WhiteListType.NONE, message="Invalid First Name")
	@Length(max=Constant.MAX_FIRSTNAME,min=Constant.MIN_FIRSTNAME,message="First Name should be 2 to 50 lenght in characters")
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@SafeHtml(whitelistType=WhiteListType.NONE, message="Invalid Last Name")
	@Length(max=Constant.MAX_LASTNAME,min=Constant.MIN_LASTTNAME,message="Last Name should be 2 to 50 lenght in characters")
	@Column(name="LAST_NAME")
	private String lastname;
	
	@SafeHtml(whitelistType=WhiteListType.NONE, message="Invalid Country Name")
	@Length(max=Constant.MAX_COUNTRY,min=Constant.MIN_COUNTRY,message="Country Name should be 2 to 50 lenght in characters")
	@Column(name="COUNTRY")
	private String country;
	
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.NONE, message="Invalid Email ID")
    @Length(max=Constant.MAX_EMAILID,min=Constant.MIN_EMAILID, message="Email ID length should not be more than 11 characters")
	@Pattern(regexp = "^(.+)@(.+)$")
	@Column(name="EMAIL_ID")
	private String emailId;*/

	@SafeHtml(whitelistType=WhiteListType.NONE, message="{html.validation.firstname}")
	@Length(max=Constant.MAX_FIRSTNAME,min=Constant.MIN_FIRSTNAME,message="{length.validation.firstname}")
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@SafeHtml(whitelistType=WhiteListType.NONE, message="{html.validation.lastname}")
	@Length(max=Constant.MAX_LASTNAME,min=Constant.MIN_LASTTNAME,message="{length.validation.lastname}")
	@Column(name="LAST_NAME")
	private String lastname;
	
	@SafeHtml(whitelistType=WhiteListType.NONE, message="{html.validation.country}")
	@Length(max=Constant.MAX_COUNTRY,min=Constant.MIN_COUNTRY,message="{length.validation.country}")
	@Column(name="COUNTRY")
	private String country;
	
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.NONE, message = "{html.validation.emailId}")
    @Length(max=Constant.MAX_EMAILID,min=Constant.MIN_EMAILID, message = "{length.validation.emailId}")
	@Pattern(regexp = "^(.+)@(.+)$")
	@Column(name="EMAIL_ID")
	private String emailId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
