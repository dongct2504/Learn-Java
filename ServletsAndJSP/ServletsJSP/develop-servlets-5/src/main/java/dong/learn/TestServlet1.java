package dong.learn;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
public class TestServlet1 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("name", name);
		request.setAttribute("id", id);
		
		getServletContext().getRequestDispatcher("/TestServlet2").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}

}




