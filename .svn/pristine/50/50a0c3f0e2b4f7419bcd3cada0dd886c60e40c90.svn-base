package com.fro.entity;

/**
 * LabRightId entity. @author MyEclipse Persistence Tools
 */

public class LabRightId implements java.io.Serializable {

	// Fields

	private String labId;
	private String userId;
	private String groupId;

	// Constructors

	/** default constructor */
	public LabRightId() {
	}

	/** full constructor */
	public LabRightId(String labId, String userId, String groupId) {
		this.labId = labId;
		this.userId = userId;
		this.groupId = groupId;
	}

	// Property accessors

	public String getLabId() {
		return this.labId;
	}

	public void setLabId(String labId) {
		this.labId = labId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LabRightId))
			return false;
		LabRightId castOther = (LabRightId) other;

		return ((this.getLabId() == castOther.getLabId()) || (this.getLabId() != null
				&& castOther.getLabId() != null && this.getLabId().equals(
				castOther.getLabId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null
						&& castOther.getUserId() != null && this.getUserId()
						.equals(castOther.getUserId())))
				&& ((this.getGroupId() == castOther.getGroupId()) || (this
						.getGroupId() != null
						&& castOther.getGroupId() != null && this.getGroupId()
						.equals(castOther.getGroupId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLabId() == null ? 0 : this.getLabId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getGroupId() == null ? 0 : this.getGroupId().hashCode());
		return result;
	}

}