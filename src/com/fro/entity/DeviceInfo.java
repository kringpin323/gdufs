package com.fro.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractDeviceInfo entity provides the base persistence definition of the
 * DeviceInfo entity. @author MyEclipse Persistence Tools
 */

public class DeviceInfo implements java.io.Serializable {

	// Fields

	private Integer deviceId;
	private String deviceName;
	private String deviceType;
	private String labId;
	private String deviceIp;
	private Integer port;
	private String position;
	private String status;
	private Date createDate;
	private String createBy;
	private LabInfo shiyan;
	// Constructors

	public LabInfo getShiyan() {
		return shiyan;
	}

	public void setShiyan(LabInfo shiyan) {
		this.shiyan = shiyan;
	}

	/** default constructor */
	public DeviceInfo() {
	}

	/** minimal constructor */
	public DeviceInfo(String status) {
		this.status = status;
	}



	public DeviceInfo(Integer deviceId, String deviceName, String deviceType,
			String labId, String deviceIp, Integer port, String position,
			String status, Date createDate, String createBy, LabInfo shiyan) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.labId = labId;
		this.deviceIp = deviceIp;
		this.port = port;
		this.position = position;
		this.status = status;
		this.createDate = createDate;
		this.createBy = createBy;
		this.shiyan = shiyan;
	}

	public String getLabId() {
		return labId;
	}

	public void setLabId(String labId) {
		this.labId = labId;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}





	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
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

	// Property accessors


}