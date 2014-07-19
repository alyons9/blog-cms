package com.lyons.blog.data;

import java.util.Date;

public class Topic {
	private int key;
	private String name;
	private String header;
	private String body;
	private Date createdDate;
	public Topic(int key, String name, String header, String body,
			Date createdDate) {
		super();
		this.key = key;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}
