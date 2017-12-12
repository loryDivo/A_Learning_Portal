package com.assignment3.models;

import java.util.ArrayList;

public class Course {
	
	private String name;
	private int CFU;
	
	public Course(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCFU() {
		return CFU;
	}

	public void setCFU(int CFU) {
		this.CFU = CFU;
	}
	
	public static ArrayList<Course> getAll() {
		ArrayList<Course> ret = new ArrayList<Course>();
		for(int i = 0; i < 10; i++) {
			Course course = new Course("course"+i);
			course.setCFU(10);
			ret.add(course);
		}
		return ret;
	}

}
