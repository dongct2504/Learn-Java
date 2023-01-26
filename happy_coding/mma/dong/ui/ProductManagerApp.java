package dong.ui;

import java.util.List;

import dong.business.Product;
import dong.db.DBException;
import dong.db.DBUtil;
import dong.db.ProductDB;

public class ProductManagerApp {

	public static void main(String[] args) {
		// Display welcome message
		System.out.println("Welcome to the Product Manager that use database");

		getCommand();
	}

	public static void displayMenu() {
		String message = "\nCOMMAND MENU\n" +
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

		try {
			List<Product> products = ProductDB.getAll();

			for (Product p : products) {
				StringBuilder sb = new StringBuilder();
				sb.append(StringUtil.pad(Integer.toString(p.getID()), 5));
				sb.append(StringUtil.pad(p.getCode(), 15));
				sb.append(StringUtil.pad(p.getDescription(), 40));
				sb.append(StringUtil.pad(p.getPriceFormatted(), 10));

				System.out.println(sb.toString());
			}
		} catch (DBException e) {
			System.out.println("Error! Unable to get products");
			System.out.println(e + "\n");
		}
	}

	public static void addProduct() {
		String code = Console.getString("Enter product code: ");
		String description = Console.getString("Enter product description: ");
		double price = Console.getDouble("Enter product price: ");

		Product product = new Product(code, description, price);

	}

	public static void deleteProduct() {
		String code = Console.getString("Enter product code to remove: ");

	}

}
