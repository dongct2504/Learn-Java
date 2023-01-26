package c19.mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import learn.business.Product;

public class JDBCTestDrive {

	public static void main(String[] args) {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/mma";
			String username = "mma_user";
			String password = "12345";

			String query = "SELECT product_id, code, description, list_price " +
					"FROM product " +
					"WHERE product_id > 2";

			// How to connect to a MySQL database with automatic driver loading
			Connection connection = DriverManager.getConnection(dbURL, username, password); // getConnection method throws a SQLException

			//			// How to create a result set that contains multiple columns and rows
			//			Statement ps = connection.createStatement();
			//			ResultSet products = ps.executeQuery(query);
			
			// Prepare statement that return a result set
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet products = ps.executeQuery();

			//			// How to move the cursor to the first row in the result set
			//			boolean productExists = products.next();

			// How to move the cursor to the first, second,... row in the result set (loop through the result set)
			while (products.next()) {
				// Code that uses names/labels to return the same columns
				int productID = products.getInt("product_id");
				String code = products.getString("code");
				String description = products.getString("description");
				double price = products.getDouble("list_price");

				System.out.println("ProductID: " + productID + "\n" +
						"Code: " + code + "\n" +
						"Description: " + description + "\n" +
						"Price: " + price + "\n");
			}

			//			addRow1(new Product("hi", "hahaha", 19.5), connection);
			//			updateRow1(new Product("hoho", "just hoho", 119.5), "hi", connection);
			//			deleteRow1("hoho", connection);

			//			addRow2(new Product("c#", "c# book", 55.59), connection);
			//			updateRow2(new Product("javaxx", "javaxx book", 99.55), "c#", connection);
			//			deleteRow2("javaxx", connection);
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.out.println(t.toString());
			}
		}
	}

	public static boolean addRow1(Product product, Connection connection) {
		try {
			String query = "INSERT INTO product (code, description, list_price) " +
					"VALUES " +
					"('" + product.getCode() + "', " +
					"'" + product.getDescription() + "', " +
					"'" + product.getPrice() + "')";
			Statement statement = connection.createStatement();
			int rowCount = statement.executeUpdate(query);
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.out.println(t);
			}
			return false;
		}

		return true;
	}

	public static boolean addRow2(Product product, Connection connection) {
		String query = "INSERT INTO product (code, description, list_price) " +
				"VALUES (?, ?, ?)";

		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, product.getCode());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			int rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.out.println(t);
			}
		}

		return true;
	}

	public static boolean updateRow1(Product product, String code, Connection connection) {
		try {
			String query = "UPDATE product SET " +
					"code = '" + product.getCode() + "', " +
					"description = '" + product.getDescription() + "', " +
					"list_price = '" + product.getPrice() + "' " +
					"WHERE code = '" + code + "'";
			Statement statement = connection.createStatement();
			int rowCount = statement.executeUpdate(query);
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.out.println(t);
			}
			return false;
		}

		return true;
	}

	public static boolean updateRow2(Product product, String code, Connection connection) {
		String query = "UPDATE product " +
				"SET " +
				"  code = ?, description = ?, list_price = ? " +
				"WHERE code = ?";

		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, product.getCode());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, code);
			int rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.out.println(t);
			}
		}

		return true;
	}

	public static boolean deleteRow1(String productCode, Connection connection) {
		try {
			String query = "DELETE FROM product " +
					"WHERE code = '" + productCode + "'";
			Statement statement = connection.createStatement();
			int rowCount = statement.executeUpdate(query);
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.out.println(t);
			}
			return false;
		}

		return true;
	}

	public static boolean deleteRow2(String code, Connection connection) {
		String query = "DELETE FROM product " +
				"WHERE code = ?";

		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, code);
			int rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.out.println(t);
			}
		}

		return true;
	}

}
