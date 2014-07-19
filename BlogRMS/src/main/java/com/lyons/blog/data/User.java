package com.lyons.blog.data;

public class User {
	private int key;
	private String firstName;
	private String lastName;
	private String email;
	public User(int key, String firstName, String lastName, String email) {
		super();
		this.key = key;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
