package com.lyons.blog.data;

public class Comment {
	private int key;
	private String body;
	private User user;
	private Topic topic;
	public Comment(int key, String body, User user, Topic topic) {
		super();
		this.key = key;
		this.body = body;
		this.user = user;
		this.topic = topic;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
}
