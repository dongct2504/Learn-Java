package dong.business;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cart implements Serializable {

	private String productCode;
	
	public Cart() {
		productCode = "";
	}
	
	public Cart(String productCode) {
		this.productCode =  productCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
}








