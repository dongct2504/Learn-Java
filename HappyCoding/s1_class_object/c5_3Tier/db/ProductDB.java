package c5_3Tier.db;

import c5_3Tier.business.Product;

public class ProductDB {
	
	public static Product getProduct(String productCode) {
		Product product = new Product();
		
		product.setCode(productCode);
		if (productCode.equalsIgnoreCase("java")) {
			product.setDescription("Murach's Java Programming");
			product.setPrice(57.50);
		} else if (productCode.equalsIgnoreCase("jsp")) {
			product.setDescription("Murach's Java Servlets and JSP");
			product.setPrice(57.50);
		} else if (productCode.equalsIgnoreCase("mysql")) {
			product.setDescription("Murach's MySQL");
			product.setPrice(54.50);
		} else {
			product.setDescription("Unknown");
		}
		
		return product;
	}
}
