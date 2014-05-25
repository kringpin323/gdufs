package com.fro.entity;

import java.sql.Timestamp;

/**
 * SessionLog entity. @author MyEclipse Persistence Tools
 */

public class SessionLog implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private Integer deviceId;
	private String sessionValue;
	private Timestamp operateTime;
	private String operation;

	// Constructors

	/** default constructor */
	public SessionLog() {
	}

	/** minimal constructor */
	public SessionLog(Integer recordId, Integer deviceId, String sessionValue,
			Timestamp operateTime) {
		this.recordId = recordId;
		this.deviceId = deviceId;
		this.sessionValue = sessionValue;
		this.operateTime = operateTime;
	}

	/** full constructor */
	public SessionLog(Integer recordId, Integer deviceId, String sessionValue,
			Timestamp operateTime, String operation) {
		this.recordId = recordId;
		this.deviceId = deviceId;
		this.sessionValue = sessionValue;
		this.operateTime = operateTime;
		this.operation = operation;
	}

	// Property accessors

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getSessionValue() {
		return this.sessionValue;
	}

	public void setSessionValue(String sessionValue) {
		this.sessionValue = sessionValue;
	}

	public Timestamp getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}