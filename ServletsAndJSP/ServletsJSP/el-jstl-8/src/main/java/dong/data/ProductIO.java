package dong.data;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;

import dong.business.Product;

public class ProductIO {

	private static final String FIELD_SEP = "\t";
	private static List<Product> products;
	
	public static List<Product> getAll(String path) {
		if (products != null) {
			return products;
		}
		
		Path productsPath = Paths.get(path);
		if (Files.exists(productsPath)) {
			products = new ArrayList<>();

			File productsFile = productsPath.toFile();
			try (BufferedReader in = new BufferedReader(new FileReader(productsFile))) {
				String line;
				while ((line = in.readLine()) != null) {
					String[] columns = line.split(FIELD_SEP);
					String code = columns[0];
					String description = columns[1];
					String priceString = columns[2];
					
					Product product = new Product();
					product.setCode(code);
					product.setDescription(description);
					product.setPrice(Double.parseDouble(priceString));
					products.add(product);
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			System.out.println("Path doesn't exist");
		}
		
		return products;
	}

	public static Product getProduct(String code, String path) {
		products = getAll(path);
		for (Product p : products) {
			if (p.getCode().equals(code)) {
				return p;
			}
		}
		
		return null;
	}
}










