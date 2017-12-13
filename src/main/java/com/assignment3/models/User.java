package com.assignment3.models;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	private boolean admin;
	private String name;
	private String last_name;
	private String email;
	private String city;
	private String country;

	private ArrayList<Course> courses = new ArrayList<Course>();
	
	public User() {}
	public User(String username, String password, String name, String last_name, String email) {
		setUsername(username);
		setPassword(password);
		setName(name);
		setLast_name(last_name);
		setEmail(email);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public ArrayList<Course> getCourses() {
		courses = new ArrayList<Course>();
		for(int i = 0; i < 10; i++) {
			Course course = new Course("course"+i);
			course.setCFU(10);
			courses.add(course);
		}
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
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

	public static ArrayList<User> getAll() {
		ArrayList<User> ret = new ArrayList<User>();
		for(int i = 0; i < 10; i++) {
			User user = new User("user"+i, "password"+i, "name"+i, "surname"+i, "email@email"+i+".it");
			ret.add(user);
		}
		return ret;
	}
	
}
