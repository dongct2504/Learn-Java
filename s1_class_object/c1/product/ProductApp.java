package c1.product;

import java.util.Scanner;

public class ProductApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Product Viewer");
		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter product code: ");
			String productCode = scanner.nextLine();
			
			Product product = ProductDB.getProduct(productCode);
			
			String message = "\nPRODUCT\n" + 
					"Code:        " + product.getCode() + "\n" +
					"Description: " + product.getDescription() + "\n" +
					"Price:       " + product.getPrice() + "\n";
			System.out.println(message);
			
			System.out.print("Want to continue? (y/n): ");
			choice = scanner.nextLine();
			System.out.println();
		}
		
		scanner.close();
		System.out.println("Bye!");
	}
}









