package dong.learn;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

import dong.business.Cart;

@SuppressWarnings("serial")
public class SessionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productCode = request.getParameter("productCode");

		Cart cart = new Cart(productCode);

		String message = "Hello guys and gals";

		HttpSession session = request.getSession();
		session.setAttribute("cart", cart);
		session.setAttribute("message", message);

		String userId = "1234567890";
		Cookie cookie = new Cookie("userIdCookie", userId);
		cookie.setMaxAge(2 * 365 * 24 * 60 * 60); // set age to 2 years
		cookie.setPath("/"); // allow access by entire application
		
		response.addCookie(cookie);
		
		getServletContext().getRequestDispatcher("/GetSessionServlet").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}
