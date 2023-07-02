package com.dong.util;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class MailUtilGmail {

	public static void sendMail(String to, String from, String subject,
			String body, boolean bodyIsHtml) throws MessagingException {

		// 1 - Get a mail session
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtps.gmail.com");
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.auth", "false");
		props.put("mail.smtps.quitwait", "false");
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
		//		Transport transport = session.getTransport();
		//		transport.connect("testmailworking.com", "01646245557");
		Transport.send(message);
	}

}
