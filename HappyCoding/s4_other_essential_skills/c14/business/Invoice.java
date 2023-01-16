package c14.business;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Invoice {
	
	private ArrayList<LineItem> lineItems;
	
	public Invoice() {
		lineItems = new ArrayList<>();
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
}





