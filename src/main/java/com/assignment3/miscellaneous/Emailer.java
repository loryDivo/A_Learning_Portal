package com.assignment3.miscellaneous;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Emailer {
	
	private static final String from = "6f299b316f2297";
	private static final String password = "21a2330321afa3";

	private static Properties properties = new Properties();
	static {
		properties.put("mail.smtp.host", "smtp.mailtrap.io");
	    properties.put("mail.smtp.socketFactory.port", "25");
	    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    properties.put("mail.transport.protocol", "smtp");
	    properties.put("mail.smtp.socketFactory.fallback", "true");
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.port", "25");
	}
	
	public static Emailer instance;
	
	public static Emailer getInstance() {
		if(instance == null) {
			instance = new Emailer();
		}
		
		return instance;
	}
	
	public boolean send(String to, String subject, String body) {
		boolean ret = true;
		
		try {
	    		Session session = Session.getDefaultInstance(properties,  new javax.mail.Authenticator() {
	    			protected PasswordAuthentication getPasswordAuthentication() {
	                  return new PasswordAuthentication(from, password);
	    			}
	    		});
	    		Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	        message.setSubject(subject);
	        message.setText(body);
	        Transport.send(message);
	    } catch(Exception e) {
	    		ret = false;
	        e.printStackTrace();
	    }
		
		return ret;
	}
}
