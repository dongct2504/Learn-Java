package dong.learn;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class TestServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = (String) request.getAttribute("name");
		int id = (int) request.getAttribute("id");

		//		request.setAttribute("name", name);
		//		request.setAttribute("id", id);

		//		response.setContentType("text/html");
		//		PrintWriter out = response.getWriter();
		//		try {
		//			out.println("<h2>This is TestServlet2!!</h2>");
		//			out.println("<p>This is your name: " + name +
		//					" -- This is your id: " + id +
		//					"\n</p>");
		//		} finally {
		//			out.close();
		//		}

		getServletContext().getRequestDispatcher("/TestServlet3").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
