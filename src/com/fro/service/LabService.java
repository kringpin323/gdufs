package com.fro.service;


import java.sql.Date;
import java.util.List;

import com.fro.entity.ClassSchedule;
import com.fro.entity.ClasshourInfo;
import com.fro.entity.DeviceInfo;
import com.fro.entity.LabInfo;
import com.fro.entity.SessionParameter;
import com.fro.entity.UserInfo;
import com.fro.utils.CommonEntity;

public interface LabService {

	List<List<SessionParameter>>  getSPs(String str);

	List<DeviceInfo> getDeviceInfo(String str);

	DeviceInfo getByDeviceId(int deviceId);

	String[][] getCourses(String labID, Date date);

	int addClassSchedule(List<ClassSchedule> css)throws Exception;

	List<String> makeExcelName(String labID,Date cdate,int week);

	List<List<String>> getCourse2(String trim, Date cdate);

	int deleteByChoose(String str);

	int sureModify(ClasshourInfo str);

	void addLabInfo(LabInfo labInfo);

	List<LabInfo> getLabInfos();

	int sureModifyLabInfo(LabInfo labInfo);

	int deleteByChooseLabInfo(String str);

	List<List<SessionParameter>> getSPs(String str, String labId);

	DeviceInfo getByDeviceId(String string, String labId);

	List<LabInfo> getLabInfosRight(String userIdRight);

	List<DeviceInfo> getDIsByDT(String string, String labId);

	String getDoorNumByLabId(String labId);

	List<CommonEntity> getCommonEntityBySql(String string);

	boolean isUserGroup(String userIdRight);

	DeviceInfo getDeviceInfoByLabId(String string, String labId);

	String getRfidByLabId(String labId);

	UserInfo getUserInfoByRfid(String rfid);

	boolean isUserGroup2(String userId);




}
