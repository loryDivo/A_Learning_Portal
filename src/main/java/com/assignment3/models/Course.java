package com.assignment3.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name="name")
	private String name;
	@Column(name="cfu")
	private Integer CFU;
	
	@ManyToMany(mappedBy = "courses")
	private List<User> users = new ArrayList<User>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Course() {}
	
	public Course(String name, Integer cfu) {
		setName(name);
		setCFU(cfu);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCFU() {
		return CFU;
	}

	public void setCFU(Integer CFU) {
		this.CFU = CFU;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Enterededededene ndden");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}	
	
