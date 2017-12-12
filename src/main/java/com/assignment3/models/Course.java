package com.assignment3.models;

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

}
