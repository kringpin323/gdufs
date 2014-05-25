package com.fro.entity;

import java.sql.Timestamp;

/**
 * MajorInfo entity. @author MyEclipse Persistence Tools
 */

public class MajorInfo implements java.io.Serializable {

	// Fields

	private String major;
	private Timestamp createDate;
	private String createBy;

	// Constructors

	/** default constructor */
	public MajorInfo() {
	}

	/** full constructor */
	public MajorInfo(Timestamp createDate, String createBy) {
		this.createDate = createDate;
		this.createBy = createBy;
	}

	// Property accessors

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

}