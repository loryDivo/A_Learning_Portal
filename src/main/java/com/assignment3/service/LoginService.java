package com.assignment3.service;

public class LoginService {
	
	public static final int IS_ADMIN = 0;
	public static final int IS_USER = 1;
	public static final int WRONG_CREDENTIALS = 2;
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int authenticate(String username, String password) {
		if(username.equals("admin") && password.equals("admin")) {
			return IS_ADMIN;
		} else if(username.equals("user") && password.equals("user")) {
			return IS_USER;
		}
		
		return WRONG_CREDENTIALS;
	}
	
	public void logout() {
		//cancel the session of the authenticated user
	}
}
