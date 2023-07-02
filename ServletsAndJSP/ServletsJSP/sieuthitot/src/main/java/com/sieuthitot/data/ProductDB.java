package com.sieuthitot.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sieuthitot.business.Product;

public class ProductDB {
	
	public static List<Product> getAll() throws SQLException {
		String query = "SELECT * FROM product";
		List<Product> products = new ArrayList<>();
		
		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getLong("product_id"));
				product.setCode(rs.getString("product_code"));
				product.setTitle(rs.getString("product_title"));
				product.setDescription(rs.getString("product_description"));
				product.setType(rs.getString("product_type"));
				product.setPrice(rs.getBigDecimal("product_price"));
				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static Product get(String productCode) throws SQLException {
		String query = "SELECT * FROM product "
				+ "WHERE product_code = ?";
		
		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, productCode);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getLong("product_id"));
				product.setCode(rs.getString("product_code"));
				product.setTitle(rs.getString("product_title"));
				product.setDescription(rs.getString("product_description"));
				product.setType(rs.getString("product_type"));
				product.setPrice(rs.getBigDecimal("product_price"));

				return product;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw e;
		}
	}

}











