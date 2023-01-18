package c14.business;

import java.text.NumberFormat;

public class LineItem {
	
	private Product product;
	private int quantity;
	
	public LineItem() {
		product = null;
		quantity = 0;
	}
	
	public LineItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String getQuantityFormatted() {
		return NumberFormat.getNumberInstance().format(quantity);
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotal() {
		return (product.getPrice() * quantity);
	}
	
	public String getTotalFormatted() {
		return NumberFormat.getCurrencyInstance().format(getTotal());
	}
}







