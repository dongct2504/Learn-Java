package com.sieuthitot.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sieuthitot.business.Cart;
import com.sieuthitot.business.Invoice;
import com.sieuthitot.business.LineItem;
import com.sieuthitot.business.Product;
import com.sieuthitot.business.UserInfo;
import com.sieuthitot.data.InvoiceDB;
import com.sieuthitot.data.ProductDB;

@SuppressWarnings("serial")
@WebServlet("/catalogController")
public class CatalogController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			action = "viewHomePage";
		}

		String url = "/index.jsp";
		if (action.equals("viewHomePage")) {
			url = "/index.jsp";
		} else if (action.equals("showProduct")) {
			url = showProduct(request, response);
		} else if (action.equals("buy")) {
			url = buy(request, response);
		} else if (action.equals("addToCart")) {
			url = addToCart(request, response);
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
		if (action.equals("updateItem")) {
			url = updateItem(request, response);
		} else if (action.equals("removeItem")) {
			url = removeItem(request, response);
		} else if (action.equals("checkout")) {
			url = checkout(request, response);
		} else if (action.equals("completeOrder")) {
			url = completeOrder(request, response);
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * Get the product from the productCode in the request and set that product as
	 * an attribute in the request object
	 * 
	 * @param request
	 * @param response
	 * @return the product page URL
	 */
	private String showProduct(HttpServletRequest request, HttpServletResponse response) {
		String productCode = request.getParameter("productCode");

		try {
			Product product = ProductDB.get(productCode);
			request.setAttribute("product", product);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "/catalog/product/";
	}

	private String buy(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		Cart cart = (Cart) session.getAttribute("cart");

		String url = "/index.jsp";
		if (userInfo == null) {
			url = "/user_profile/login_user.jsp";
			return url;
		}

		LocalDate date = LocalDate.now();

		String productCode = request.getParameter("productCode");
		try {
			Product product = ProductDB.get(productCode);

			LineItem lineItem = new LineItem();
			lineItem.setProduct(product);

			Invoice invoice = new Invoice();
			invoice.setUser(userInfo);
			invoice.setInvoiceDate(date);
			invoice.setItems(List.of(lineItem));

			session.setAttribute("invoice", invoice);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		url = "/cart/invoice.jsp";
		return url;
	}

	private String addToCart(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		String url = "/index.jsp";
		if (userInfo == null) {
			url = "/user_profile/login_user.jsp";
			return url;
		}

		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}
		String productCode = request.getParameter("productCode");
		try {
			Product product = ProductDB.get(productCode);
			// this almost will never happen, but just in case
			if (product != null) {
				LineItem lineItem = new LineItem();
				lineItem.setProduct(product);
				cart.addItem(lineItem);
			}
			session.setAttribute("cart", cart);
			url = "/cart";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return url;
	}
	
	private String updateItem(HttpServletRequest request, HttpServletResponse response) {
		String productCode = request.getParameter("productCode");
		int quantity;
		try {
			quantity = Integer.parseInt(request.getParameter("quantity"));
			if (quantity < 0) {
				quantity = 1;
			}
		} catch (NumberFormatException e) {
			quantity = 1;
		}
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		try {
			Product product = ProductDB.get(productCode);
			if (product != null && cart != null) {
				LineItem lineItem = new LineItem();
				lineItem.setProduct(product);
				lineItem.setQuantity(quantity);
				if (quantity > 0) {
					cart.addItem(lineItem);
				} else {
					cart.removeItem(lineItem);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String url = "/cart";
		return url;
	}

	private String removeItem(HttpServletRequest request, HttpServletResponse response) {
		String productCode = request.getParameter("productCode");

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		try {
			Product product = ProductDB.get(productCode);
			if (product != null && cart != null) {
				LineItem lineItem = new LineItem();
				lineItem.setProduct(product);
				cart.removeItem(lineItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String url = "/cart";
		return url;
	}

	private String checkout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		Cart cart = (Cart) session.getAttribute("cart");

		LocalDate date = LocalDate.now();

		Invoice invoice = new Invoice();
		invoice.setUser(userInfo);
		invoice.setInvoiceDate(date);
		invoice.setItems(cart.getItems());

		session.setAttribute("invoice", invoice);

		String url = "/cart/invoice.jsp";
		return url;
	}
	
	private String completeOrder(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Invoice invoice = (Invoice) session.getAttribute("invoice");
		
		try {
			InvoiceDB.insert(invoice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.removeAttribute("invoice");
		session.removeAttribute("cart");
		
		String url = "/cart/thanks.jsp";
		return url;
	}

}










