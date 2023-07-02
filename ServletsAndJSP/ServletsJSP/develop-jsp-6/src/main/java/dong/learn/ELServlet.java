package dong.learn;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.time.LocalDate;

import dong.business.User;

@SuppressWarnings("serial")
@WebServlet("/elTest")
public class ELServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		// display attribute (after pass to a JSP)
		//		GregorianCalendar currentDate = new GregorianCalendar();
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();

		request.setAttribute("currentYear", currentYear);
		// display the property of an attribute (after pass to a JSP)
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		User user = new User(email, firstName, lastName);
		request.setAttribute("user", user);

		String message = "this is a message";
		request.setAttribute("message", message);

		// forward the request, response to display_EL.jsp
		getServletContext().getRequestDispatcher("/display_EL.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}
