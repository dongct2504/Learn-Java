package dong.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import dong.business.Product;
import dong.data.ProductIO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/loadProducts"})
public class ProductsServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("Get in");
		
		HttpSession session = request.getSession();
		
		String path = getServletContext().getRealPath("/WEB-INF/products.txt");
		List<Product> products = ProductIO.getAll(path);
		session.setAttribute("products", products);
		
		String url = "/index.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}










