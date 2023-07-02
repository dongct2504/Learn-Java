package dong.learn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/initParamTest" }, initParams = {
		@WebInitParam(name = "relativePathToFile", value = "/WEB-INF/EmainList.txt")
})
public class InitParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Code that gets an initialization parameter that's available to all servlets
		String custServEmail = getServletContext().getInitParameter("custServEmail");
		System.out.println(custServEmail);

		// Code that gets an initialization parameter that's available
		// to the current servlet only
		String relativePathToEmail = getServletConfig().getInitParameter("relativePathToFile");
		System.out.println(relativePathToEmail);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

