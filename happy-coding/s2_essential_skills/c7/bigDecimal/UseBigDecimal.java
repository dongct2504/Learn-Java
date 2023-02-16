package c7.bigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class UseBigDecimal {

	public static void main(String[] args) {
		//		codeCauseProblem();
		codeFixProblem();
	}
	
	private static void codeCauseProblem() {
		/* -- Code that uses double values to store monetary values -- */
		double subtotal = 100.05; // 100.050
		double discountPercent = .1;
		double discountAmount = subtotal * discountPercent; // 10.005
		double totalBeforeTax = subtotal - discountAmount; // 90.045

		String message = "subtotal: " + subtotal + "\n" +
				"discount percent: " + discountPercent + "\n" +
				"discount amount: " + discountAmount + "\n" +
				"total before tax: " + totalBeforeTax;
		System.out.println(message + "\n");

		/* -- Code that causes a rounding error -- */
		// If the discount amount is $10.01, the total before tax should be $90.04. However, it’s $90.05.
		// get the objects for currency and percent formatting
		DecimalFormat currency = new DecimalFormat("###,###,###,###.00");
		NumberFormat percent = NumberFormat.getPercentInstance();

		// format the message and print it to the console
		String formattedMessage = "Subtotal: " + currency.format(subtotal) + " VNĐ" + "\n" + // 100.05 VND
				"Discount percent: " + percent.format(discountPercent) + "\n" + // 10%
				"Discount amount: " + currency.format(discountAmount) + " VNĐ" + "\n" + // 10.01 VND 
				"Total before tax: " + currency.format(totalBeforeTax) + " VNĐ" + "\n"; // 90.05 VND --> should be 90.04
		System.out.println(formattedMessage);
	}
	
	private static void codeFixProblem() {
		/* -- Code that use BigDecimal to fix rounding error -- */
		BigDecimal subtotal = new BigDecimal("100.05"); // 100.05
		BigDecimal discountPercent = new BigDecimal(".1");
		BigDecimal discountAmount = subtotal.multiply(discountPercent); // 10.005
		discountAmount = discountAmount.setScale(2, RoundingMode.HALF_UP); // 10.01 -- set scale
		BigDecimal totalBeforeTax = subtotal.subtract(discountAmount); // 90.04

		String message = "subtotal: " + subtotal + "\n" +
				"discount percent: " + discountPercent + "\n" +
				"discount amount: " + discountAmount + "\n" +
				"total before tax: " + totalBeforeTax;
		System.out.println(message + "\n");
		
		// get the objects for currency and percent formatting
		DecimalFormat currency = new DecimalFormat("###,###,###,###.00");
		NumberFormat percent = NumberFormat.getPercentInstance();

		// format the message and print it to the console
		String formattedMessage = "Subtotal: " + currency.format(subtotal) + " VNĐ" + "\n" + // 100.05 VND
				"Discount percent: " + percent.format(discountPercent) + "\n" + // 10%
				"Discount amount: " + currency.format(discountAmount) + " VNĐ" + "\n" + // 10.01 VND 
				"Total before tax: " + currency.format(totalBeforeTax) + " VNĐ" + "\n"; // 90.04 VND --> should be 90.04
		System.out.println(formattedMessage);
	}

}













