package c5_3Tier.ui;

import java.util.Scanner;

import c5_3Tier.business.Product;
import c5_3Tier.business.LineItem;
import c5_3Tier.db.ProductDB;

public class LineItemApp {
	
	public static void main(String[] args) {
		// display a welcome message
		System.out.println("Welcome to the Line Item Calculator");
		System.out.println();
		
		// create 1 or more line items
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get input from user
			System.out.print("Enter product code: ");
			String productCode = sc.nextLine();
			
			System.out.print("Enter quantity: ");
			int quantity = Integer.parseInt(sc.nextLine());
			
			// get the Product object
			Product product = ProductDB.getProduct(productCode);
			
			// create the LineItem object
			LineItem lineItem = new LineItem(product, quantity);
			
			// display the output
			String message = "\nLINE ITEM\n" + 
					"Code:     " + product.getCode() + "\n" +
					"Price:    " + product.getPrice() + "\n" +
					"quantity: " + lineItem.getQuantity() + "\n" +
					"Total:    " + lineItem.getTotalFormatted() + "\n";
			System.out.println(message);
			
			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.nextLine();
			System.out.println();
		}
		
		sc.close();
		System.out.println("Bye");
	}
}