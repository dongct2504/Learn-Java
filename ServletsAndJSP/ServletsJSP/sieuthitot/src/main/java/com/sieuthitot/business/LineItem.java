package com.sieuthitot.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class LineItem implements Serializable {

	private Long lineItemId;
	private Product product;
	private int quantity;
	
	public LineItem() {
		quantity = 1;
	}
	
	public Long getLineItemId() {
		return lineItemId;
	}
	
	public void setLineItemId(Long lineItemId) {
		this.lineItemId = lineItemId;
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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getTotal() {
		BigDecimal price = product.getPrice();
		BigDecimal quantityBigDecimal = new BigDecimal(quantity);
		BigDecimal total = price.multiply(quantityBigDecimal).setScale(2, RoundingMode.HALF_UP);
		
		return total;
	}
	
	public String getTotalFormatted() {
		DecimalFormat df = new DecimalFormat("###,###,###,###.00");
		String totalFormatted = df.format(getTotal()) + " đ";
		
		return totalFormatted;
	}
	
	public static void main(String[] args) {
		Product p = new Product();
		p.setPrice(new BigDecimal("35000"));

		LineItem li = new LineItem();
		li.setProduct(p);
		li.setQuantity(3);
		
		System.out.println(li.getTotalFormatted());
	}
	
}






