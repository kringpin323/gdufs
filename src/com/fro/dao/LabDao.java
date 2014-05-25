package com.fro.dao;

import java.util.List;

import com.fro.entity.DeviceInfo;
import com.fro.entity.LabInfo;
import com.fro.entity.SessionParameter;
import com.fro.entity.UserInfo;
import com.fro.utils.CommonEntity;

public interface LabDao {

	List<DeviceInfo> getDIsByDT(String str);

	List<SessionParameter> getSPByDI(Integer deviceId);

	DeviceInfo getByDeviceId(int deviceId);

	void addLabInfo(LabInfo labInfo);

	List<LabInfo> getLabInfos();

	LabInfo getLabInfosByID(String labID);

	void sureModifyLabInfo(LabInfo labInfo);

	List<DeviceInfo> getDIsByDT(String str, String labId);

	DeviceInfo getByDeviceId(String string, String labId);

	List<LabInfo> getLabInfosRight(String userIdRight);

	String getDoorNumByLabId(String labId);

	List<CommonEntity> getCommonEntityBySql(String sql);

	boolean isUserGroup(String userIdRight);

	List<DeviceInfo> getgetDeviceInfoByLabId(String string, String labId);

	String getRfidByLabId(String labId);

	UserInfo getUserInfoByRfid(String rfid);

	boolean isUserGroup2(String userId);

}
