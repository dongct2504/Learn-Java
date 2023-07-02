package com.sieuthitot.business;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserInfo implements Serializable {

	private Long userId;
	private String userName;
	private String email;
	private String password;
	private String companyName;
	private String address;
	private String city;
	private String country;
	private String creditCardType;
	private String creditCardNumber;
	private String creditCardExpirationDate;

	public UserInfo() {
		userName = "";
		email = "";
		password = "";
		companyName = "";
		address = "";
		city = "";
		country = "";
		creditCardType = "";
		creditCardNumber = "";
		creditCardExpirationDate = "";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	// this works, but it mixes the Model and the View
	public String getAddressHTMLFormat() {
		StringBuilder addressStringBuilder = new StringBuilder();
		addressStringBuilder.append(address + "<br>");
		addressStringBuilder.append(city + "<br>");
		
		if (country == null || country.equals("") || country.equals(" ")) {
			addressStringBuilder.append("");
		} else {
			addressStringBuilder.append(country + "<br>");
		}
		
		return addressStringBuilder.toString();
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

	public String getCreditCardExpirationDate() {
		return creditCardExpirationDate;
	}

	public void setCreditCardExpirationDate(String creditCardExpirationDate) {
		this.creditCardExpirationDate = creditCardExpirationDate;
	}

}
