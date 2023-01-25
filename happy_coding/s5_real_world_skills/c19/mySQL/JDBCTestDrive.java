package c19.mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

			// How to create a result set that contains multiple columns and rows
			Statement statement = connection.createStatement();
			ResultSet products = statement.executeQuery(query);

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
		} catch (SQLException e) {
			for (Throwable t : e) {
				System.out.println(t.toString());
			}
		}
	}

}







