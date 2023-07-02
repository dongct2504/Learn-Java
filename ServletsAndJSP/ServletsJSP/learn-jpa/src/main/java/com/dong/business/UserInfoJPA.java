package com.dong.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "user_info_jpa")
public class UserInfoJPA implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	@Column(name = "user_id", nullable = false)
	@Column(name = "user_id")
	private long userId;

	private String name;

	private String email;

	@Column(name = "company_name")
	private String companyName;

	private String address;

	private String city;

	private String country;

	@Column(name = "credit_card_type")
	private String creditCardType;

	@Column(name = "credit_card_number")
	private String creditCardNumber;
	
	public UserInfoJPA() {
		name = "";
		email = "";
	}

	//	@Id
	//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getUserID() {
		return userId;
	}

	public void setUserID(long userID) {
		this.userId = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

}
