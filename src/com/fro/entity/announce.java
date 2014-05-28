package com.fro.entity;

import java.sql.Timestamp;
//import java.util.List;

public class Announce implements java.io.Serializable{
	// 2014/5/25
	private Integer announce_id;
	private String context;
	private String author;
	private Timestamp time;
	private String headline;
	private String department;

	public Announce(){
		
	}
	
	public Announce(Integer announce_id, String context, String author , Timestamp time, 
			String headline){
		super();
		this.announce_id = announce_id;
		this.author = author;
		this.context = context;
		this.headline = headline;
		this.time = time;
	}
	
	public Integer getAnnounce_id() {
		return announce_id;
	}

	public void setAnnounce_id(Integer announce_id) {
		this.announce_id = announce_id;
	}
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
