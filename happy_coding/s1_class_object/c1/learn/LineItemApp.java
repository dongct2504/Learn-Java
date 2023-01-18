package c1.learn;

import java.text.NumberFormat;
import java.util.Scanner;

public class LineItemApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Line Item Calculator");
		System.out.println();
		
		// hard code three values and calculation a value 
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter product code: ");
			String productCode = sc.nextLine();
			
			System.out.print("Enter quantity: ");
			int quantity = Integer.parseInt(sc.nextLine());
			
			double price;
			if (productCode.equalsIgnoreCase("java")) {
				price = 57.5;
			} else if (productCode.equalsIgnoreCase("jsp")) {
				price = 57.5;
			} else if (productCode.equalsIgnoreCase("mysql")) {
				price = 54.5;
			} else {
				price = 0;
			}
			
			double total = price * quantity;
			
			// format and display output
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			String priceFormatted = currency.format(price);
			String totalFormatted = currency.format(total);
			
			// display the output
			String message = "\nLINE ITEM\n" + 
					"Code:     " + productCode + "\n" +
					"Price:    " + priceFormatted + "\n" +
					"quantity: " + quantity + "\n" +
					"Total:    " + totalFormatted + "\n";
			System.out.println(message);
		}
		
		sc.close();
		System.out.println("Bye");
	}
}







