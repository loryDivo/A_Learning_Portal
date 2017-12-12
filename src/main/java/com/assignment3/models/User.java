package com.assignment3.models;

public class User {
	
	private Integer id;
	private String username;
	private String password;
	private boolean admin;
	private String name;
	private String last_name;
	private String email;
	private String city;
	private String country;
	
	public User(String username, String password, String name, String last_name, String email) {
		setUsername(username);
		setPassword(password);
		setName(name);
		setLast_name(last_name);
		setEmail(email);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Integer save() {
		return 2;
	}
	
	public static User findByid(int id) {
		User user = new User("username", "password", "name", "last name", "email@email.com");
		if(id == 1) user.setAdmin(true);
		else user.setAdmin(false);
		
		return user;
	}

	
}
