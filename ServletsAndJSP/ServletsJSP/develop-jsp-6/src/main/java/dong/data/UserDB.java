package dong.data;

import java.sql.*;

// import dong.business.User;

public class UserDB {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "01646245557";

		String query = "SELECT * FROM login";

		Connection con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery(query);

		result.next();

		String name = result.getString("uName");

		System.out.println(name);
	}
}
