package com.fro.entity;

//import java.sql.String;
//import java.util.List;

public class Announce implements java.io.Serializable{
	// 2014/5/25
	private String announce_id;
	private String context;
	private String author;
	private String time;
	private String headline;
	
	public Announce(){
		
	}
	
	public Announce(String announce_id, String context, String author , String time, 
			String headline){
		super();
		this.announce_id = announce_id;
		this.author = author;
		this.context = context;
		this.headline = headline;
		this.time = time;
	}

	public String getAnnounce_id() {
		return announce_id;
	}

	public void setAnnounce_id(String announce_id) {
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	
}