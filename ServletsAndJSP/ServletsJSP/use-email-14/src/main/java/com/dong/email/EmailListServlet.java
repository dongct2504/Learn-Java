package com.dong.email;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dong.business.User;
import com.dong.util.MailUtilGmail;
import com.dong.util.MailUtilLocal;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/email" })
public class EmailListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action == null) {
			action = "join";
		}
		
		String url = "/index.jsp";
		if (action.equals("join")) {
			url = "/index.jsp";
		} else if (action.equals("add")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			User user = new User(name, email);
			// UserDB.insert(user);
			request.setAttribute("user", user);
			
			// send email
			String to = email;
			String from = "hmail1@testmailworking.com";
			String subject = "Thanks for sign in";
			String body = "Dear " + name + ",\n\n" +
					"Thanks for joining this stupid email list\n" + 
					"Leave a sign!!";
			boolean isBodyHtml = false;
			
			try {
				MailUtilGmail.sendMail(to, from, subject, body, isBodyHtml);
			} catch (MessagingException e) {
				String errorMessage = "ERROR: unable to send message " + 
						"Check Tomcat logs for details.<br>";
				request.setAttribute("errorMessage", errorMessage);
				this.log("unable to send email. \n" + 
						"Here is the email you tried to send: \n" + 
						"=======================================\n" + 
						"TO: " + email + "\n" +
						"FROM: " + from + "\n" +
						"SUBJECT: " + subject + "\n" +
						"\n" +
						body + "\n\n");
			}
			
			url = "/thanks.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}








