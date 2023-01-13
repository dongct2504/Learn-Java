package c11.db;

import c11.business.Product;

public interface ProductReader {
	Product getProduct(String productCode);
	String getProducts();
}
