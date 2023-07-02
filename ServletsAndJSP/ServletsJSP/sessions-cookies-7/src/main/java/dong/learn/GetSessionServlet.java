package dong.learn;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import dong.business.Cart;

@SuppressWarnings("serial")
public class GetSessionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			out.println("<h1>Test Session</h1>");

			out.println("<h2>Some informations</h2>");
			out.println("<p>This is a cart: " + cart.getProductCode() + "</p>");

			//			// get all the attribute name in this session object
			//			@SuppressWarnings("rawtypes")
			//			Enumeration names = session.getAttributeNames();
			//			while (names.hasMoreElements()) {
			//				out.println("<p>" + (String) names.nextElement() + "\n</p>");
			//			}

			// get all the cookies
			Cookie[] cookies = request.getCookies();
			String cookieName = "jsessionid";
			String cookieValue = "";
			for (Cookie cookie : cookies) {
				//				if (cookieName.equals(cookie.getName())) {
				//					cookieValue = cookie.getValue();
				//					out.println("<p>" + cookieValue + "\n</p>");
				//				}
				out.println("<p>Name: " + cookie.getName() +
						" -- Value: " + cookie.getValue() + "\n</p>");
			}
		} finally {
			out.close();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

}
