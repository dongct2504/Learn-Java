package dong.learn;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dong.business.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/testELandJSTL"})
public class ELBeanMapServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		Map<String, String> person = new HashMap<>(); // but why doesn't Map<Integer, String> work?
		person.put("D", "Dong");
		person.put("T", "Tay");
		person.put("N", "Nam");
		person.put("B", "Bac");
		request.setAttribute("person", person);
		
		User user = new User("Dong handsome", "dong@gmail.com");
		request.setAttribute("user", user);
		
		List<String> lists = new ArrayList<>();
		lists.add("Dong");
		lists.add("Tay");
		lists.add("Nam");
		lists.add("Bac");
		lists.add("Dai");
		request.setAttribute("lists", lists);
		
		String url = "/test_el_bean_map.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}










