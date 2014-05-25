package com.fro.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractSessionParameter entity provides the base persistence definition of
 * the SessionParameter entity. @author MyEclipse Persistence Tools
 */

public class SessionParameterPK implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -288002855915204255L;
	private String sessionValue;
	private Integer deviceId;
	
	public String getSessionValue() {
		return sessionValue;
	}
	public void setSessionValue(String sessionValue) {
		this.sessionValue = sessionValue;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result
				+ ((sessionValue == null) ? 0 : sessionValue.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessionParameterPK other = (SessionParameterPK) obj;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (sessionValue == null) {
			if (other.sessionValue != null)
				return false;
		} else if (!sessionValue.equals(other.sessionValue))
			return false;
		return true;
	}





}