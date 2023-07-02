package dong.cart;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

@SuppressWarnings("serial")
public class CartServlets extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String productCode = request.getParameter("productCode");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doPost(request, response);
	}
}












