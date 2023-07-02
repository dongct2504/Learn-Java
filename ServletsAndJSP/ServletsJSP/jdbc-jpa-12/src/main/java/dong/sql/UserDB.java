package dong.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dong.business.User;

public class UserDB {
	
	public static List<User> getAll() throws SQLException {
		String query = "SELECT * FROM user_info";
		List<User> users = new ArrayList<>();
		
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				User user = new User();
				user.setName(name);
				user.setEmail(email);
				users.add(user);
			}
			
			return users;
		} catch (SQLException e) {
			throw e;
		}
	}

	public static User get(String email) throws SQLException {
		String query = "SELECT * FROM user_info " +
				"WHERE email = ?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");

				User user = new User();
				user.setName(name);
				user.setEmail(email);

				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public static int insert(User user) throws SQLException {
		String query = "INSERT INTO user_info (name, email) " +
				"VALUES (?, ?)";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

	public static int update(User user) throws SQLException {
		String query = "UPDATE user_info " +
				"SET name = ? " +
				"WHERE email = ?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} 
	}

	public static int delete(User user) throws SQLException {
		String query = "DELETE FROM user_info " +
				"WHERE email = ?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, user.getEmail());
			return ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} 
	}

}
