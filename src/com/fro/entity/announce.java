package com.fro.entity;

import java.sql.Timestamp;
//import java.util.List;

public class announce implements java.io.Serializable{
	
	private String announce_id;
	private String context;
	private String author;
	private Timestamp time;
	private String headline;
	
	public announce(){
		
	}
	
	public announce(String announce_id, String context, String author , Timestamp time, 
			String headline){
		super();
		this.announce_id = announce_id;
		this.author = author;
		this.context = context;
		this.headline = headline;
		this.time = time;
	}

	public String getAnnonce_id() {
		return announce_id;
	}

	public void setAnnonce_id(String announce_id) {
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
	
	
}
