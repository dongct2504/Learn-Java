package dong.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection connection;

	private DBUtil() {}

	public static synchronized Connection getConnection() throws DBException {
		// checking whether the connection has already been opened
		if (connection != null) {
			return connection;
		}

		try {
			String dbURL = "jdbc:mysql://localhost:3306/mma";
			String username = "mma_user";
			String password = "12345";

			connection = DriverManager.getConnection(dbURL, username, password);

			return connection;
		} catch (SQLException e) {
			throw new DBException(e);
		}
	}

	public static synchronized void closeConnection() throws DBException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DBException();
			} finally {
				connection = null;
			}
		}
	}

}






