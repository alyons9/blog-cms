package com.lyons.blog.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "TOPIC")
public class Topic {
	@Id
	@Column(name = "id")
	private int key;
	@Column(name = "header")
	private String header;
	@Column(name = "body")
	private String body;
	@Column(name = "created_on")
	private Date createdDate;
	@OneToMany(mappedBy="topic")
//	@JoinTable(name = "COMMENT", joinColumns=@JoinColumn(name="ID"))
	private List<Comment> comments;
	public Topic(){}
	public Topic(int key, String header, String body,
			Date createdDate) {
		super();
		this.key = key;
		this.header = header;
		this.body = body;
		this.createdDate = createdDate;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
