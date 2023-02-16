package dong.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dong.business.Product;

public class ProductDB {

	public static List<Product> getAll() throws DBException {
		String sql = "SELECT * FROM product ORDER BY product_id";
		List<Product> products = new ArrayList<>();

		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt("product_id");
				String code = rs.getString("code");
				String description = rs.getString("description");
				double price = rs.getDouble("list_price");

				products.add(new Product(id, code, description, price));
			}

			return products;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}
	
	public static Product get(String productCode) throws DBException {
		String sql = "SELECT * FROM product WHERE code = ?";

		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, productCode);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				int id = rs.getInt("product_id");
				String description = rs.getString("description");
				double price = rs.getDouble("list_price");
				rs.close();
				
				Product product = new Product(id, productCode, description, price);
				
				return product;
			} else {
				rs.close();
				return null;
			}
		} catch (SQLException e) {
			throw new DBException(e);
		} // you could code a finally block to close ResultSet but it automatically close when PreparedStatement close
	}

	public static void add(Product product) throws DBException {
		String sql = "INSERT INTO product (code, description, list_price)" +
				"VALUES (?, ?, ?)";

		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, product.getCode());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.executeUpdate(); // return an int value that indicate how many rows have affected
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}
	
	public static void update(Product product) throws DBException {
		String sql = "UPDATE product " + 
				"SET code = ?, description = ?, list_price = ? " +
				"WHERE product_id = ?";
		
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, product.getCode());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getID());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}
	
	public static void delete(Product product) throws DBException {
		String sql = "DELETE FROM product " +
				"WHERE product_id = ?";
		
		Connection connection = DBUtil.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, product.getID());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}
	
}








