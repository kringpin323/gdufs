package com.fro.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractSessionParameter entity provides the base persistence definition of
 * the SessionParameter entity. @author MyEclipse Persistence Tools
 */

public class SessionParameter implements java.io.Serializable {

	// Fields

	private SessionParameterPK sessionParameterPK;
	private String sessionName;
	private String sessionType;
	private String labId;
	private String position;
	private String status;
	private Date createDate;
	private String createBy;
	private DeviceInfo canshu;

	// Constructors

	public DeviceInfo getCanshu() {
		return canshu;
	}



	public void setCanshu(DeviceInfo canshu) {
		this.canshu = canshu;
	}



	/** default constructor */
	public SessionParameter() {
	}









	public SessionParameter(SessionParameterPK sessionParameterPK,
			String sessionName, String sessionType, String labId,
			String position, String status, Date createDate, String createBy,
			DeviceInfo canshu) {
		super();
		this.sessionParameterPK = sessionParameterPK;
		this.sessionName = sessionName;
		this.sessionType = sessionType;
		this.labId = labId;
		this.position = position;
		this.status = status;
		this.createDate = createDate;
		this.createBy = createBy;
		this.canshu = canshu;
	}



	public SessionParameterPK getSessionParameterPK() {
		return sessionParameterPK;
	}



	public void setSessionParameterPK(SessionParameterPK sessionParameterPK) {
		this.sessionParameterPK = sessionParameterPK;
	}



	public String getSessionName() {
		return sessionName;
	}



	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}



	public String getSessionType() {
		return sessionType;
	}



	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}



	public String getLabId() {
		return labId;
	}



	public void setLabId(String labId) {
		this.labId = labId;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public String getCreateBy() {
		return createBy;
	}



	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}




}