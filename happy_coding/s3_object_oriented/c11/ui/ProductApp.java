package c11.ui;

import java.util.Scanner;

import c11.business.Product;
import c11.db.ProductDB;
import c11.business.Printable;

public class ProductApp {

	public static void main(String[] args) {
		// display a welcome message
		System.out.println("Welcome to the Product Viewer");
		System.out.println();

		// Printable p = ProductDB.getProduct("java");
		// p.print();

		// perform 1 or more selections
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter product code: ");
			String productCode = sc.nextLine();

			Product product = ProductDB.getProduct(productCode);

			System.out.println();
			if (product != null) {
				System.out.println("Description: " + product.toString());
				System.out.println("Price: " + product.getPrice());
			} else {
				System.out.println("No product matches this product code.\n");
			}

			System.out.println();
			System.out.println("Product count: " + Product.getCount() + "\n");

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.nextLine();
			System.out.println();
		}

		sc.close();
		System.out.println("Bye!");
	}
}
