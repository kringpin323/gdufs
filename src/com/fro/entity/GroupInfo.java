package com.fro.entity;

import java.sql.Timestamp;

/**
 * GroupInfo entity. @author MyEclipse Persistence Tools
 */

public class GroupInfo implements java.io.Serializable {

	// Fields

	private String groupId;
	private String groupName;
	private Timestamp createDate;
	private String createBy;

	// Constructors

	/** default constructor */
	public GroupInfo() {
	}


	public GroupInfo(String groupId, String groupName, Timestamp createDate,
			String createBy) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.createDate = createDate;
		this.createBy = createBy;
	}


	// Property accessors

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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