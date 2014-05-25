package com.fro.entity;

import java.sql.Timestamp;

/**
 * RightInfo entity. @author MyEclipse Persistence Tools
 */

public class RightInfo implements java.io.Serializable {

	// Fields

	private String rightId;
	private String rightName;
	private String rightDesc;
	private Timestamp createDate;
	private String createBy;

	// Constructors

	/** default constructor */
	public RightInfo() {
	}

	/** full constructor */
	public RightInfo(String rightName, String rightDesc, Timestamp createDate,
			String createBy) {
		this.rightName = rightName;
		this.rightDesc = rightDesc;
		this.createDate = createDate;
		this.createBy = createBy;
	}

	// Property accessors

	public String getRightId() {
		return this.rightId;
	}

	public void setRightId(String rightId) {
		this.rightId = rightId;
	}

	public String getRightName() {
		return this.rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public String getRightDesc() {
		return this.rightDesc;
	}

	public void setRightDesc(String rightDesc) {
		this.rightDesc = rightDesc;
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