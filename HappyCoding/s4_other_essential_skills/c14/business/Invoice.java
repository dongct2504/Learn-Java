package c14.business;

import java.text.NumberFormat;
import java.util.ArrayList;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Invoice {
	
	private ArrayList<LineItem> lineItems;
	private LocalDateTime invoiceDate;
	
	public Invoice() {
		lineItems = new ArrayList<>();
		invoiceDate = LocalDateTime.now();
	}
	
	// a method that add a line item
	public void addItem(LineItem lineItem) {
		lineItems.add(lineItem);
	}
	
	// the get accessor for the line item collection
	public ArrayList<LineItem> getLineItem() {
		return lineItems;
	}
	
	// a method that gets the invoice total
	public double getTotal() {
		double invoiceTotal = 0;
		for (LineItem lineItem : lineItems) {
			invoiceTotal += lineItem.getTotal();
		}
		
		return invoiceTotal;
	}
	
	public String getTotalFormatted() {
		return NumberFormat.getCurrencyInstance().format(getTotal());
	}
	
	public void setInvoiceDate(LocalDateTime invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	public LocalDateTime getInvoiceDate() {
		return invoiceDate;
	}
	
	public String getInvoiceDateFormatted() {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.MEDIUM);
		return dtf.format(invoiceDate);
	}

	public LocalDateTime getDueDate() {
		return invoiceDate.plusDays(30);
	}
	
	public String getDueDateFormatted() {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.MEDIUM);
		return dtf.format(getDueDate());
	}
}












