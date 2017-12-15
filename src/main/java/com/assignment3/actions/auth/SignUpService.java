package com.assignment3.actions.auth;

import java.util.Random;

import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.miscellaneous.Emailer;
import com.assignment3.models.User;
import com.assignment3.models.helpers.UserHelper;

public class SignUpService {
	
	private static final String subject = "Conferma Registrazione";

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
		String hashedPassword = UserHelper.getHashedPassword(password);
		User user = new User(username, hashedPassword, name, last_name, email);
		DatabaseUtil.getInstance().save(user);
	}
}
