package dong.ui;

import dong.business.*;
import dong.io.ProductIO;
import java.util.List;

public class UpdateProducts {

	public static void main(String[] args) {
		// Display welcome message
		System.out.println("Welcome to the Product Manager\n");
		
		getCommand();
	}
	
	public static void displayMenu() {
		String message = 
				"\nCOMMAND MENU\n" +
				"list     - List all products\n" +
				"add      - Add a product\n" +
				"del      - Delete a product\n" +
				"help     - Show this menu\n" +
				"exit     - Exit this application";
		
		System.out.println(message);
	}
	
	public static void getCommand() {
		String action = "";
		while (!action.equals("exit")) {
			displayMenu();
			action = Console.getString("\nEnter your command: ");
			System.out.println();
			
			if (action.equalsIgnoreCase("list")) {
				displayAllProducts();
			} else if (action.equalsIgnoreCase("add")) {
				addProduct();
			} else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("delete")) {
				deleteProduct();
			} else if (action.equalsIgnoreCase("help")) {
				System.out.println("Imagine you get some helps :))");
			} else if (action.equalsIgnoreCase("exit")) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid command, Try again!!");
			}

		}
		
	}
	
	public static void displayAllProducts() {
		System.out.println("PRODUCT LIST");
		
		List<Product> products = ProductIO.getAll();
		
		for (Product p : products) {
			System.out.println(p.toString());
		}
	}
	
	public static void addProduct() {
		String code = Console.getString("Enter product code: ");
		String description = Console.getString("Enter product description: ");
		double price = Console.getDouble("Enter product price: ");
		
		Product product = new Product(code, description, price);
		
		ProductIO.add(product);
		
		System.out.println("\n" + product.getDescription() + " was added to the database");
	}
	
	public static void deleteProduct() {
		String code = Console.getString("Enter product code to remove: ");
		
		Product product = ProductIO.get(code);
		if (product != null) {
			ProductIO.delete(product);
			System.out.println("\n" + product.getDescription() + " was delete from the database");
		} else {
			System.out.println("\nCan not remove product");
		}

	}
}













