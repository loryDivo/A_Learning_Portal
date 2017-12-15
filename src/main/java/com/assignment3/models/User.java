package com.assignment3.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="admin")
	private boolean admin;
	@Column(name="name")
	private String name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="email")
	private String email;
	@Column(name="city")
	private String city;
	@Column(name="country")
	private String country;
	@Column(name="ban_until")
	private Date ban_until;

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
	public Date getBan_until() {
		return ban_until;
	}
	public void setBan_until(Date ban_until) {
		this.ban_until = ban_until;
	}
	
	
}
