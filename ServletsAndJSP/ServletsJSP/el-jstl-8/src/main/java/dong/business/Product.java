package dong.business;

import java.io.Serializable;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class Product implements Serializable {

	private String code;
	private String description;
	private double price;
	
	public Product() {
		code = "";
		description = "";
		price = 0;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}
	
	public String getPriceFormatted() {
		DecimalFormat df = new DecimalFormat("###,###,###,###");
		String priceFormatted = df.format(price) + " VNĐ";
		
		return priceFormatted;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public static void main(String[] args) {
		Product p = new Product();
		
		double n = 999_999_999_999.0;
		p.setPrice(n);
		
		System.out.println(p.getPriceFormatted());
	}
	
}










