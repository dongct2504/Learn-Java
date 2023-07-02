package com.sieuthitot.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SuppressWarnings("serial")
public class Invoice implements Serializable {
	
	private Long invoiceId;
	private UserInfo userInfo;
	private List<LineItem> items;
	private LocalDate invoiceDate;
	private boolean isProcessed;
	
	public Invoice() {
		
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public UserInfo getUser() {
		return userInfo;
	}

	public void setUser(UserInfo user) {
		this.userInfo = user;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	
	public String getInvoiceDateFormatted() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String invoiceDateFormatted = dtf.format(invoiceDate);
		
		return invoiceDateFormatted;
	}
	
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	public BigDecimal getInvoiceTotal() {
		BigDecimal total = new BigDecimal("0.0");
		for (LineItem item : items) {
			total = total.add(item.getTotal());
		}
		
		return total;
	}
	
	public String getInvoiceTotalFormatted() {
		DecimalFormat df = new DecimalFormat("###,###,###,###.00");
		String totalFormatted = df.format(getInvoiceTotal()) + " đ";
		
		return totalFormatted;
	}
	
	public boolean isIsProcessed() {
		return isProcessed;
	}
	
	public void setIsProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	

	public static void main(String[] args) {
		Product p = new Product();
		p.setPrice(new BigDecimal("34000"));
		Product p1 = new Product();
		p1.setPrice(new BigDecimal("50000"));
		
		LineItem li = new LineItem();
		li.setProduct(p);
		li.setQuantity(3);
		LineItem li1 = new LineItem();
		li1.setProduct(p1);
		li1.setQuantity(2);
		
		Invoice invoice = new Invoice();
		invoice.setItems(List.of(li, li1));
		
		System.out.println(invoice.getInvoiceTotalFormatted());
	}
	
}







