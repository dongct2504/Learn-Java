package dong.sql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/sqlGateway" })
public class SqlGatewayServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sqlStatement = request.getParameter("sqlStatement");
		String sqlResult = "";
		
		// load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		String dbURL = "jdbc:mysql://localhost:3306/music";
		String username = "music_user";
		String password = "1234567890";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbURL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try (PreparedStatement ps = connection.prepareStatement(sqlStatement)) {
			sqlStatement = sqlStatement.trim();
			if (sqlStatement.length() >= 6) {
				String sqlType = sqlStatement.substring(0, 6);
				if (sqlType.equalsIgnoreCase("select")) {
					ResultSet rs = ps.executeQuery();
					sqlResult = SQLUtil.getHtmlTable(rs);
				} else {
					int rowCount = ps.executeUpdate();
					if (rowCount == 0) { // a DDL statement
						sqlResult = "<p>The statement executed successfully.</p>";
					} else { // a DML statement
						sqlResult = "<p>The statement executed successfully.<br>" +
								rowCount + "row(s) affected</p>";
					}
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("sqlResult", sqlResult);
		session.setAttribute("sqlStatement", sqlStatement);

		String url = "/index.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
