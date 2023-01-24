package com.Spring.RestAPI;

public class Course {
	private int id;
	private String name;
	private String Author;
	
	public Course(int id, String name, String Author) {	
		super();
		this.id = id;
		this.name = name;
		this.Author = Author;
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return Author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", Author=" + Author + "]";
	}
	
	
}
