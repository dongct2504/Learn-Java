package dong.download;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dong.business.User;
import dong.data.UserIO;
import dong.util.CookieUtil;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// handles requests that use the HTTP GET method
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		// delete cookies
		//		Cookie[] cookies = request.getCookies();
		//		for (Cookie c : cookies) {
		//			c.setMaxAge(0);
		//			c.setPath("/");
		//			response.addCookie(c);
		//		}
		//		
		//		// invalidate session
		//		HttpSession session = request.getSession();
		//		session.invalidate();

		// get current action
		String action = request.getParameter("action");
		if (action == null) {
			action = "viewAlbums"; // default action
		}

		// perform action and set URL to appropriate page
		String url = "/index";
		if (action.equals("viewAlbums")) {
			url = "/index.jsp";
		} else if (action.equals("checkUser")) {
			url = checkUser(request, response);
		} else if (action.equals("viewCookies")) {
			url = "/view_cookies.jsp";
		} else if (action.equals("deleteCookies")) {
			url = deleteCookies(request, response);
		}

		// forward to the view
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	// handles the action for registering users.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		// perform action and set URL to appropriate page
		String url = "/index";
		if (action.equals("registerUser")) {
			url = registerUser(request, response);
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	// Check if the user has already register. If the user has not registered, for 
	// example, this method returns the URL for the Register page. Otherwise, 
	// this method returns the URL for the appropriate Download page.
	private String checkUser(HttpServletRequest request, HttpServletResponse response) {
		// get the product code from the request object that was passed from the Index page.
		String productCode = request.getParameter("productCode");

		HttpSession session = request.getSession();
		session.setAttribute("productCode", productCode);

		User user = (User) session.getAttribute("user");

		String url;
		// if User object doesn't exist then check cookies
		if (user == null) {
			Cookie[] cookies = request.getCookies();
			String emailAddress = CookieUtil.getCookieValue(cookies, "emailCookie"); // get cookie value

			// if cookie doesn't exist, go to Registration page
			if (emailAddress == null || emailAddress.equals("")) {
				url = "/register.jsp";
			} else { // if cookie exists, create User object and go to Downloads page
				ServletContext sc = getServletContext();
				String path = sc.getRealPath("/WEB-INF/EmailList.txt");
				user = UserIO.getUser(emailAddress, path);
				//				System.out.println(user.getName());
				session.setAttribute("user", user);
				url = "/" + productCode + "_download.jsp";
			}
		} else { // if User object exists, go to Downloads page
			url = "/" + productCode + "_download.jsp";
		}

		return url;
	}

	// this method registers the user and returns a URL for the appropriate Download page.
	private String registerUser(HttpServletRequest request, HttpServletResponse response) {
		// get user data
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		// store the data in a User object
		User user = new User(name, email);

		// write the User object to a file
		String path = getServletContext().getRealPath("/WEB-INF/EmailList.txt");
		UserIO.addUser(user, path);

		// store the User object as a session attribute
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		// add a cookie that stores the user's email to browser
		Cookie cookie = new Cookie("emailCookie", email);
		cookie.setMaxAge(365 * 24 * 60 * 60); // set age to 1 year
		cookie.setPath("/"); // allow entire app to access it
		response.addCookie(cookie);

		// create an return a URL for the appropriate Download page
		String productCode = (String) session.getAttribute("productCode");
		String url = "/" + productCode + "_download.jsp";

		return url;
	}
	
	// delete cookies and set the appropriate url
	private String deleteCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		
		String url = "/deleteCookies.jsp";
		return url;
	}

}










