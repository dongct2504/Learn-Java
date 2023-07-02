package com.dong.email;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dong.business.UserInfoJPA;
import com.dong.data.UserInfoJPADB;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/emailList" })
public class EmailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get current action
		String action = request.getParameter("action");
		if (action == null) {
			action = "join"; // default action
		}

		String url = "/index.jsp";
		if (action.equals("join")) {
			url = "/index.jsp";
		} else if (action.equals("add")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");

			UserInfoJPA user = new UserInfoJPA();
			user.setName(name);
			user.setEmail(email);

			// validate the parameters
			String message = "";
			//			try {
			//				//				UserDB.insert(user);
			//				message = "";
			//				url = "/thanks.jsp";
			//			} catch (SQLIntegrityConstraintViolationException e) {
			//				e.printStackTrace();
			//				message = "This email address already exists<br>" +
			//						"Please enter another email address";
			//				url = "/index.jsp";
			//			} catch (SQLException e) {
			//				e.printStackTrace();
			//			}
			if (UserInfoJPADB.emailExists(email)) {
				message = "This email address already exists.<br>" + 
						"Please enter another email address.";
				url = "/index.jsp";
			} else {
				message = "";
				try {
					UserInfoJPADB.insert(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
				url = "/thanks.jsp";
			}
			
			// get all users
			List<UserInfoJPA> users = UserInfoJPADB.getAll();

			request.setAttribute("user", user);
			request.setAttribute("message", message);
			request.setAttribute("users", users);
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
