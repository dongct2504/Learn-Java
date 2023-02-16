package learn.business;

import java.text.NumberFormat;

/**
 * The <code>Product</code> class defines a product and is used
 * by the <code>LineItem</code> and <code>ProductDB</code> classes.
 * @author keilar
 * @version 0.0.1
 */
public class Product {

	private String code;
	private String description;
	private double price;
	protected static int count = 0;

	/**
	 * Create a <code>Product</code> with default value
	 */
	public Product() {
		code = "";
		description = "";
		price = 0.0;
	}

	public Product(String code, String description, double price) {
		this.code = code;
		this.description = description;
		this.price = price;
	}

	/**
	 * Gets the product code
	 * @return A <code>String</code> for the product code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the product code
	 * @param code A <code>String</code> for the product code.
	 */
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
		return NumberFormat.getCurrencyInstance().format(price);
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return description;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product) {
			Product product = (Product) obj;

			if (code.equals(product.getCode()) && description.equals(product.getDescription())
					&& price == product.getPrice()) {
				return true;
			}
		}

		return false;
	}

	// public abstract String getDisplayText(); // an abstract method

	// @Override
	// public void print() { // implement the Printable interface
	// System.out.println(getDescription() + " | " + getPriceFormatted());
	// }
}
