package c1.product;

import java.text.NumberFormat;

public class Product {

	// instance variables
	private String code;
	private String description;
	private double price;
	
	// constructors
	public Product() {
		this("", "", 0.0);
	}
	
	public Product(String code, String description, double price) {
		this.code = code;
		this.description = description;
		this.price = price;
	}

	// the set and get methods for the code variable
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
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		currency.setMaximumFractionDigits(1); // default is 2

		return currency.format(price);
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	// methods
	public void printToConsole() {
		
	}
	
	public void printToConsole(String separator) {
		System.out.println(code + separator + description + separator + price);
	}
	
	public void printToConsole(String separator, String label) {
		System.out.print(label);
		printToConsole(separator);
	}

	// Testing
	public static void main(String[] args) {
		new Product().printToConsole("/", "Dong");
	}
}









