package dong.email;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import dong.business.User;
import dong.sql.UserDB;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/emailList"})
public class EmailListServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// get current action
		String action = request.getParameter("action");
		if (action == null) {
			action = "join"; // default action
		}
		
		String url = "/index.html";
		if (action.equals("join")) {
			url = "/index.jsp";
		} else if (action.equals("add")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			User user = new User();
			user.setName(name);
			user.setEmail(email);
			
			String message = "";
			try {
				UserDB.insert(user);
				message = "";
				url = "/thanks.jsp";
			} catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				message = "This email address already exists<br>" +
						"Please enter another email address";
				url = "/index.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("user", user);
			request.setAttribute("message", message);
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}










