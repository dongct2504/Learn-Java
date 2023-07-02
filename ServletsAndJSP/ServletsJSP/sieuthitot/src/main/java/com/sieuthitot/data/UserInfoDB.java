package com.sieuthitot.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sieuthitot.business.UserInfo;

public class UserInfoDB {

	public static List<UserInfo> getAll() throws SQLException {
		String query = "SELECT * FROM user_info";

		List<UserInfo> userInfos = new ArrayList<>();
		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(rs.getLong("user_id"));
				userInfo.setUserName(rs.getString("user_name"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setPassword(rs.getString("passwd"));
				userInfo.setCompanyName(rs.getString("company_name"));
				userInfo.setAddress(rs.getString("address"));
				userInfo.setCity(rs.getString("city"));
				userInfo.setCountry(rs.getString("country"));
				userInfo.setCreditCardType(rs.getString("credit_card_type"));
				userInfo.setCreditCardNumber(rs.getString("credit_card_number"));
				userInfo.setCreditCardExpirationDate(rs.getString("credit_card_expiration_date"));
				userInfos.add(userInfo);
			}
			return userInfos;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static UserInfo get(String email) throws SQLException {
		String query = "SELECT * FROM user_info "
				+ "WHERE email = ?";
		
		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(rs.getLong("user_id"));
				userInfo.setUserName(rs.getString("user_name"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setPassword(rs.getString("passwd"));
				userInfo.setCompanyName(rs.getString("company_name"));
				userInfo.setAddress(rs.getString("address"));
				userInfo.setCity(rs.getString("city"));
				userInfo.setCountry(rs.getString("country"));
				userInfo.setCreditCardType(rs.getString("credit_card_type"));
				userInfo.setCreditCardNumber(rs.getString("credit_card_number"));
				userInfo.setCreditCardExpirationDate(rs.getString("credit_card_expiration_date"));

				return userInfo;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static int insert(UserInfo userInfo) throws SQLException {
		String query = "INSERT INTO user_info "
				+ "  (user_name, email, passwd, company_name, address, city, country, "
				+ "    credit_card_type, credit_card_number, credit_card_expiration_date) "
				+ "VALUES "
				+ "  (?, ?, ?, ?, ?, ?, ?, "
				+ "    ?, ?, ?)";

		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, userInfo.getUserName());
			ps.setString(2, userInfo.getEmail());
			ps.setString(3, userInfo.getPassword());
			ps.setString(4, userInfo.getCompanyName());
			ps.setString(5, userInfo.getAddress());
			ps.setString(6, userInfo.getCity());
			ps.setString(7, userInfo.getCountry());
			ps.setString(8, userInfo.getCreditCardType());
			ps.setString(9, userInfo.getCreditCardNumber());
			ps.setString(10, userInfo.getCreditCardExpirationDate());
			
			int affectedRows = ps.executeUpdate();
			
			// get userId from the last INSERT statement and set it in the UserInfo object
			String lastUserIdQuery = "SELECT MAX(user_id) AS last_user_id "
					+ "FROM user_info";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(lastUserIdQuery);
			rs.next();
			userInfo.setUserId(rs.getLong("last_user_id")); 
			
			return affectedRows;
		} catch (SQLException e) {
			throw e;
		}
	}

	public static boolean isEmailExist(String email) throws SQLException {
		String query = "SELECT email FROM user_info "
				+ "WHERE email = ?";
		
		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public static boolean isHasUser(String email, String password) throws SQLException {
			String query = "SELECT email FROM user_info "
				+ "WHERE email = ? AND passwd = ?";
		
		ConnectionPool pool = ConnectionPool.getInstance();
		try (Connection connection = pool.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			throw e;
		}	
	}

}









