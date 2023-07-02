package com.sieuthitot.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sieuthitot.business.Product;
import com.sieuthitot.business.UserInfo;
import com.sieuthitot.data.ProductDB;
import com.sieuthitot.data.UserInfoDB;

@SuppressWarnings("serial")
@WebServlet("/initWebapp")
public class InitWebapp extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		loadProducts(request, response);
		checkCookie(request, response);

		String url = "/index.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * Load all the products on database
	 * 
	 * @param request
	 * @param response
	 */
	private void loadProducts(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) session.getAttribute("products");

		if (products == null) {
			try {
				products = ProductDB.getAll();
				session.setAttribute("products", products);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Check if user has login through cookie
	 * 
	 * @param request
	 * @param response
	 */
	private void checkCookie(HttpServletRequest request, HttpServletResponse response) {
		String cookieEmailName = "email";
		String cookieEmailValue = "";

		Cookie[] cookies = request.getCookies();
		if (cookies != null) { // just in case cookies are null when first request are made
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieEmailName)) {
					// get cookie email here
					cookieEmailValue = cookie.getValue();
					break;
				}
			}
		}

		if (!cookieEmailValue.equals("")) {
			// get user and set session
			try {
				UserInfo userInfo = UserInfoDB.get(cookieEmailValue);
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", userInfo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}









