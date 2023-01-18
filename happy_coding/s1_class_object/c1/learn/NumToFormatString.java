package c1.learn;

import java.text.NumberFormat;

public class NumToFormatString {

	public static void main(String[] args) {
		/* How to format a number as currency */
		double price = 49.5;

		// // without method chaining
		// NumberFormat currency = NumberFormat.getCurrencyInstance();
		// String priceFormatted = currency.format(price);

		// with method chaining
		String priceFormatted = NumberFormat.getCurrencyInstance().format(price);
		System.out.println("price that has been formatted: " + priceFormatted);

		/* How to format a number as a percent */
		double discountPercent = 0.2;
		String discountPercentFormatted = NumberFormat.getPercentInstance().format(discountPercent);
		System.out.println("percent that has been formatted: " + discountPercentFormatted);
		
		/* How to format a number with one decimal place */
		double miles = 15341.253;
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMaximumFractionDigits(1);
		String milesFormatted = number.format(miles);
		System.out.println("number that has been formatted: " + milesFormatted);
	}
}









