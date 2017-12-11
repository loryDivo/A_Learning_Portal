package com.assignment3.service;

public class LoginService {
	
	public static final int IS_ADMIN = 0;
	public static final int IS_USER = 1;
	public static final int WRONG_CREDENTIALS = 2;
	
	private String username;
	private String password;
	
	public LoginService(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	
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
	
	public int authenticate() {
		if(getUsername().equals("admin") && getPassword().equals("admin")) {
			return IS_ADMIN;
		} else if(getUsername().equals("user") && getPassword().equals("user")) {
			return IS_USER;
		}
		
		return WRONG_CREDENTIALS;
	}
}
