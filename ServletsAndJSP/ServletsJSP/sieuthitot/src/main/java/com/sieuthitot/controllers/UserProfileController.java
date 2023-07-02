package com.sieuthitot.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sieuthitot.business.Cart;
import com.sieuthitot.business.UserInfo;
import com.sieuthitot.data.UserInfoDB;

@SuppressWarnings("serial")
@WebServlet("/userProfileController")
public class UserProfileController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action == null) {
			action = "viewHomePage";
		}

		String url = "/index.jsp";
		if (action.equals("viewHomePage")) {
			url = "/index.jsp";
		} else if (action.equals("logout")) {
			url = logout(request, response);
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action == null) {
			action = "viewHomePage";
		}
		
		String url = "/index.jsp";
		if (action.equals("viewHomePage")) {
			url = "/index.jsp";
		} else if (action.equals("register")) {
			url = register(request, response);
		} else if (action.equals("login")) {
			url = login(request, response);
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * remove user cookies and session
	 * @param request
	 * @param response
	 * @return the index page
	 */
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		session.removeAttribute("cart");
		
		String cookieEmailName = "email";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieEmailName)) {
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		
		return "/index.jsp";
	}
	
	/**
	 * Register user and check if email has been registered
	 * @param request
	 * @param response
	 * @return the login page URL
	 */
	private String register(HttpServletRequest request, HttpServletResponse response) {
		String url = "/index.jsp";

		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(request.getParameter("userName"));
		userInfo.setEmail(request.getParameter("email"));
		userInfo.setPassword(request.getParameter("password"));
		userInfo.setCompanyName(request.getParameter("companyName"));
		userInfo.setAddress(request.getParameter("address"));
		userInfo.setCity(request.getParameter("city"));
		userInfo.setCountry(request.getParameter("country"));
		userInfo.setCreditCardType(request.getParameter("creditCardType"));
		userInfo.setCreditCardNumber(request.getParameter("creditCardNumber"));
		userInfo.setCreditCardExpirationDate(request.getParameter("creditCardExpirationDate"));
		
		try {
			if (UserInfoDB.isEmailExist(userInfo.getEmail())) {
				String message = "Email này đã đăng ký, vui lòng chọn email khác!!";
				request.setAttribute("userInfo", userInfo);
				request.setAttribute("message", message);
				url = "/user_profile/register_user.jsp";
			} else {
				UserInfoDB.insert(userInfo);
				url = "/user_profile/login_user.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	/**
	 * Check database and set cookie, session
	 * @param request
	 * @param response
	 * @return the page URL that trigger login, if it from register then return to index page
	 */
	private String login(HttpServletRequest request, HttpServletResponse response) {
		String url = "/index.jsp";

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			if (UserInfoDB.isHasUser(email, password)) {
				UserInfo userInfo = UserInfoDB.get(email);

				HttpSession session = request.getSession();
				session.setAttribute("userInfo", userInfo);

				Cookie cookie = new Cookie("email", email);
				cookie.setMaxAge(300); // set max age to 5 minutes
				cookie.setPath("/");
				response.addCookie(cookie); // add cookie to the response object
				
				url = "/index.jsp";
			} else {
				String message = "Sai email hoặc mật khẩu!!";

				request.setAttribute("email", email);
				request.setAttribute("password", password);
				request.setAttribute("message", message);

				url = "/user_profile/login_user.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}

}









