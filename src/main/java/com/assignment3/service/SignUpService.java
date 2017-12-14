package com.assignment3.service;

import java.util.Random;

import com.assignment3.miscellaneous.Emailer;
import com.assignment3.miscellaneous.JPALogic;
import com.assignment3.models.User;

public class SignUpService {
	
	private static final String subject = "Conferma Registrazione";
	
	public static boolean isUniqueUsername(String username) {
		return (JPALogic.getInstance().jpaRead("SELECT username FROM User WHERE username="+ "\'" + username + "\'", 
				String.class).getResultList().isEmpty());
		//return true;
	}
	public static boolean isStrongPassword(String password) {
		return true;
	}
	
	public static boolean isValidEmail(String email) {
		return true;
	}
	
	public static boolean isUniqueEmail(String email) {
		return (JPALogic.getInstance().jpaRead("SELECT email " + " FROM User WHERE email = "+"\'" + email + "\'", 
				String.class).getResultList()).isEmpty();
		//return true;
	}
	
	public static boolean sendEmail(User user) {
		String aCode = generateActivationCode();
		String body = "Grazie per esserti registrato. Ti chiediamo di premere sul seguente link per attivare il tuo account: [completeUrl]+" + aCode;
		return Emailer.getInstance().send(user.getEmail(), subject, body);
	}
	
	private static String generateActivationCode() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		return sb.toString();
	}
	
	public static void createNewUser(String username, String password, String name, String last_name, String email) {
		User user = new User(username, password, name, last_name, email);
		JPALogic.getInstance().jpaCreate(user);
	}
}
