package com.fro.entity;

import java.sql.Timestamp;


public class LabInfo implements java.io.Serializable {

	// Fields

	private String labId;
	private String labDesc;
	private String navigateMode;
	private String status;
	private Timestamp createDate;
	private String createBy;
	
	public LabInfo() {
	}
	
	
	public String getLabId() {
		return labId;
	}
	public void setLabId(String labId) {
		this.labId = labId;
	}
	public String getLabDesc() {
		return labDesc;
	}
	public void setLabDesc(String labDesc) {
		this.labDesc = labDesc;
	}
	public String getNavigateMode() {
		return navigateMode;
	}
	public void setNavigateMode(String navigateMode) {
		this.navigateMode = navigateMode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	

}