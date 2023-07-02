package com.dong.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtilLocal {

	public static void sendMail(String to, String from, String subject,
			String body, boolean bodyIsHtml) throws MessagingException {

		// 1 - Get a mail session
		Properties props = new Properties();
		//		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "localhost");
		//		props.put("mail.smtp.port", "25");
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);

		// 2 - Create a message
		Message message = new MimeMessage(session);
		message.setSubject(subject);
		if (bodyIsHtml) {
			message.setContent(body, "text/html");
		} else {
			message.setText(body);
		}

		// 3 - Address the message
		Address fromAddress = new InternetAddress(from);
		Address toAddress = new InternetAddress(to);
		message.setFrom(fromAddress);
		message.setRecipient(Message.RecipientType.TO, toAddress);

		// 4 - Send the message
		Transport.send(message);
	}

}









