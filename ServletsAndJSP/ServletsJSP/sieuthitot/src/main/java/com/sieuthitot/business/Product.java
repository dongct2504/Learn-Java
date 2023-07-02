package com.sieuthitot.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class Product implements Serializable {

	private Long productId;
	private String code;
	private String title;
	private String description;
	private String type;
	private BigDecimal price;

	public Product() {
		code = "";
		title = "";
		description = "";
		type = "";
		price = new BigDecimal("0.00");
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public String getPriceFormatted() {
		DecimalFormat df = new DecimalFormat("###,###,###,###.00");
		String priceFormatted = df.format(price) + " đ";
		return priceFormatted;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getImageURL() {
		String imageURL = "/images/" + code + ".jpg";
		return imageURL;
	}
	

	public static void main(String[] args) {
		Product product = new Product();
		product.setPrice(new BigDecimal("45000"));

		System.out.println(product.getPriceFormatted());
	}

}









