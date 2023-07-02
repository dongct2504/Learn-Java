package dong.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;

import dong.business.Cart;
import dong.business.LineItem;
import dong.business.Product;
import dong.data.ProductIO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/cart" })
public class CartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			action = "shop"; // default action
		}

		String url = "/index.jsp";
		if (action.equals("index")) {
			url = "/index.jsp";
		} else if (action.equals("shop")) {
			addItem(request, response);

			url = "/index.jsp";
		} else if (action.equals("cart")) {
			String productCode = request.getParameter("productCode");
			if (productCode != null) {
				addItem(request, response);
			}

			url = "/cart.jsp";
		} else if (action.equals("checkout")) {

			url = "/checkout.jsp";
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		String productCode = request.getParameter("productCode");
		String quantityString = request.getParameter("quantity"); // if don't have, return null

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}

		// if the user enters a negative or invalid quantity,
		// the quantity is automatically reset to 1.
		int quantity;
		try {
			quantity = Integer.parseInt(quantityString);
			if (quantity < 0) {
				quantity = 1;
			}
		} catch (NumberFormatException nfe) {
			quantity = 1;
		}

		String path = getServletContext().getRealPath("/WEB-INF/products.txt");
		Product product = ProductIO.getProduct(productCode, path);

		LineItem lineItem = new LineItem();
		lineItem.setProduct(product);
		lineItem.setQuantity(quantity);
		lineItem.setDateTimePurchase(LocalDateTime.now());
		if (quantity > 0) {
			cart.addItem(lineItem);
		} else if (quantity == 0) {
			cart.removeItem(lineItem);
		}

		session.setAttribute("cart", cart);
	}

}
