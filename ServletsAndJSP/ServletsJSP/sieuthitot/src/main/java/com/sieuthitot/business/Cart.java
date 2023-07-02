package com.sieuthitot.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Cart implements Serializable {

	private List<LineItem> items;
	
	public Cart() {
		items = new ArrayList<>();
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}
	
	public int getCount() {
		return items.size();
	}
	
	public boolean addItem(LineItem lineItem) {
    // If the item already exists in the cart, only the quantity is changed.
		String code = lineItem.getProduct().getCode();
		int quantity = lineItem.getQuantity();
		for (LineItem item : items) {
			if (code.equals(item.getProduct().getCode())) {
				item.setQuantity(quantity);
				return true;
			}
		}
		
		// if not then add it
		return items.add(lineItem);
	}
	
	public boolean removeItem(LineItem lineItem) {
		String code = lineItem.getProduct().getCode();
		for (LineItem item : items) {
			if (code.equals(item.getProduct().getCode())) {
				return items.remove(item);
			}
		}
		
		return false;
	}
	
}












