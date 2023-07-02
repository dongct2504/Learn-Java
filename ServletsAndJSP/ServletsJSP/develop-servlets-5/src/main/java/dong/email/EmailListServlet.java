package dong.email;

import java.io.*;

import dong.business.User;
import dong.data.UserDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String url = "/validateTest.jsp";

		String action = request.getParameter("action");
		if (action == null) {
			action = "join";
		}

		if (action.equals("join")) {
			url = "/validateTest.jsp";
		} else if (action.equals("add")) {
			String email = request.getParameter("email");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");

			User user = new User(firstName, lastName, email);

			String message;
			if (firstName == null || lastName == null || email == null ||
					firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
				message = "Please fill out all three boxes.";
			} else {
				message = "";
				url = "/thanks.jsp";
				UserDB.insert(user);
			}

			request.setAttribute("user", user);
			request.setAttribute("message", message);
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		doPost(request, response);
	}
}