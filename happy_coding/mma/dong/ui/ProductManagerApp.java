package dong.ui;

import java.util.List;

import dong.business.Product;
import dong.db.ProductDB;
import dong.db.DBException;
import dong.db.DBUtil;

public class ProductManagerApp {

	public static void main(String[] args) {
		// Display welcome message
		System.out.println("Welcome to the Product Manager that use database\n");

		getCommand();
	}

	public static void displayMenu() {
		String message = "COMMAND MENU\n" +
				"list     - List all products\n" +
				"get      - Get a product\n" +
				"add      - Add a product\n" +
				"update   - Update a product\n" +
				"del      - Delete a product\n" +
				"help     - Get some helps\n" +
				"exit     - Exit this application";

		System.out.println(message);
	}

	public static void getCommand() {
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			displayMenu();
			action = Console.getString("\nEnter your command: ");
			System.out.println();

			if (action.equalsIgnoreCase("list")) {
				displayAllProducts();
			} else if (action.equalsIgnoreCase("get")) {
				getProduct();
			} else if (action.equalsIgnoreCase("add")) {
				addProduct();
			} else if (action.equalsIgnoreCase("update")) {
				updateProduct();
			} else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("delete")) {
				deleteProduct();
			} else if (action.equalsIgnoreCase("help")) {
				System.out.println("Imagine you get some helps :))\n");
			} else if (action.equalsIgnoreCase("exit")) {
				closeAndExit();
			} else {
				System.out.println("Invalid command, Try again!!");
			}
		}
	}

	public static void displayAllProducts() {
		System.out.println("PRODUCT LIST");

		StringBuilder sb = new StringBuilder();
		sb.append(StringUtil.padCharacter('-', 65));
		sb.append("\n");
		sb.append(StringUtil.pad("Code", 15));
		sb.append(StringUtil.pad("Description", 40));
		sb.append(StringUtil.pad("Price", 10));
		sb.append("\n");
		sb.append(StringUtil.padCharacter('-', 65));
		sb.append("\n");

		try {
			List<Product> products = ProductDB.getAll();

			for (Product p : products) {
				sb.append(StringUtil.pad(p.getCode(), 15));
				sb.append(StringUtil.pad(p.getDescription(), 40));
				sb.append(StringUtil.pad(p.getPriceFormatted(), 10));
				sb.append("\n");
			}

			System.out.println(sb.toString());
		} catch (DBException e) {
			System.out.println("Error! Unable to list all products");
			System.out.println(e + "\n");
		}
	}

	public static void getProduct() {
		String code = Console.getString("Enter product code: ");

		try {
			Product product = ProductDB.get(code);

			System.out.println("ID: " + product.getID() + "\n" +
					"Code: " + product.getCode() + "\n" +
					"Description: " + product.getDescription() + "\n" +
					"Price: " + product.getPriceFormatted() + "\n");
		} catch (DBException e) {
			System.out.println("Error! Unable to get product");
			System.out.println(e + "\n");
		} catch (NullPointerException e) {
			System.out.println("Error! Can't find your product, try again!");
			System.out.println(e + "\n");
		}
	}

	public static void addProduct() {
		String code = Console.getString("Enter product code: ");
		String description = Console.getString("Enter product description: ");
		double price = Console.getDouble("Enter product price: ");

		Product product = new Product(code, description, price);
		try {
			ProductDB.add(product);
			System.out.println(product.getDescription() + " was added.\n");
		} catch (DBException e) {
			System.out.println("Error! Unable to add product");
			System.out.println(e + "\n");
		}
	}

	public static void updateProduct() {
		int id = Console.getInt("Enter product id you want to update: ");
		String updateCode = Console.getString("Enter the update product code: ");
		String updateDescription = Console.getString("Enter the update product description: ");
		double updatePrice = Console.getDouble("Enter the update product price: ");

		Product product = new Product(id, updateCode, updateDescription, updatePrice);

		try {
			ProductDB.update(product);
			System.out.println(product.getDescription() + " was updated.\n");
		} catch (DBException e) {
			System.out.println("Error! Unable to update product");
			System.out.println(e + "\n");
		}
	}

	public static void deleteProduct() {
		String code = Console.getString("Enter product code to remove: ");

		try {
			Product product = ProductDB.get(code);
			ProductDB.delete(product);
			System.out.println(product.getDescription() + " was deleted.\n");
		} catch (DBException e) {
			System.out.println("Error! Unable to delete product.");
			System.out.println(e + "\n");
		}
	}
	
	public static void closeAndExit() {
		try {
			DBUtil.closeConnection();
			System.out.println("Bye!\n");
		} catch (DBException e) {
			System.out.println("Error! Unable to close connection.");
			System.out.println(e + "\n");
		}
	}

}






