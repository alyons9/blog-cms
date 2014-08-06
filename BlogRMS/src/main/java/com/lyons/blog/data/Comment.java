package com.lyons.blog.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "COMMENT")
public class Comment {
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "body")
	private String body;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="topic_id")
	private Topic topic;
	public Comment(){}
	public Comment(int key, String body, User user, Topic topic) {
		super();
		this.id = key;
		this.body = body;
		this.user = user;
		this.topic = topic;
	}
	public int getKey() {
		return id;
	}
	public void setKey(int key) {
		this.id = key;
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
