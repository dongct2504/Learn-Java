package com.dong.business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity()
@Table(name = "invoice_jpa")
public class InvoiceJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_number")
	private Long invoiceNumber;

	@ManyToOne // the default is: fetch = FetchType.LAZY
	@JoinColumn(name = "user_info_jpa") // customize name for Foreign Key
	private UserInfoJPA userInfoJPA;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@Column(name = "line_items")
	private List<LineItemJPA> lineItems;
	
	@Column(name = "invoice_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime invoiceDateTime;
	
	@Column(name = "is_processed")
	private boolean isProcessed;
	
	public InvoiceJPA() {}

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public UserInfoJPA getUserInfoJPA() {
		return userInfoJPA;
	}

	public void setUserInfoJPA(UserInfoJPA userInfoJPA) {
		this.userInfoJPA = userInfoJPA;
	}

	public List<LineItemJPA> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItemJPA> lineItems) {
		this.lineItems = lineItems;
	}

	public LocalDateTime getInvoiceDateTime() {
		return invoiceDateTime;
	}

	public void setInvoiceDate(LocalDateTime invoiceDateTime) {
		this.invoiceDateTime = invoiceDateTime;
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	
}











