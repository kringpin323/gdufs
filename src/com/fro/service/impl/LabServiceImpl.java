package com.fro.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fro.dao.LabDao;
import com.fro.dao.impl.LabDaoImpl;
import com.fro.dao.impl.PaiKeDao;
import com.fro.entity.ClassSchedule;
import com.fro.entity.ClasshourInfo;
import com.fro.entity.DeviceInfo;
import com.fro.entity.LabInfo;
import com.fro.entity.SessionParameter;
import com.fro.entity.UserInfo;
import com.fro.order.GuardControl;
import com.fro.service.LabService;
import com.fro.utils.CommonEntity;
import com.fro.utils.GetCuardControl;

public class LabServiceImpl implements LabService {

	LabDao lab=new LabDaoImpl();
	public List<List<SessionParameter>> getSPs(String str) {
		
		List<DeviceInfo> dis=lab.getDIsByDT(str);
		
		if(dis.size()!=0){
		List<List<SessionParameter>> sps=new ArrayList<List<SessionParameter>>();
		for (DeviceInfo deviceInfo : dis) {
			List<SessionParameter> sp=lab.getSPByDI(deviceInfo.getDeviceId());
			sps.add(sp);
		}
		return sps;
		}	
		
		
		return null;
	}
	public List<DeviceInfo> getDeviceInfo(String str) {
		
		return lab.getDIsByDT(str);
	}
	public DeviceInfo getByDeviceId(int deviceId) {
		
		return lab.getByDeviceId(deviceId);
	}
	public String[][] getCourses(String labID, Date date) {
		PaiKeDao pd=new PaiKeDao();
		List<ClasshourInfo> chis=pd.getClasshourInfo();
		String[][] courses=pd.getClassSchedule(labID, date,chis);
		
		return courses;
	}
	PaiKeDao p=new PaiKeDao();
	public int addClassSchedule(List<ClassSchedule> css) throws Exception {
		//调用存储过程判断课时是否有冲突
		int b=p.compareClassSchedule(css);
		if(b==0){
			for (ClassSchedule c : css) {
				p.addClassSchedule(c);
				
//			    if(c.getLabId().equalsIgnoreCase("C507")){
//		        	GuardControl doorC=GetCuardControl.getGuardControl("C507");  
//		            java.sql.Date   cdate=new  java.sql.Date(c.getBeginDate().getTime()); 
//		        	String[][] str=p.getOpenDoor(c.getLabId(), cdate);
//		    		String[] str1 = doorC.formatTime(str);
//		    		doorC.sendOrder(doorC.uploadTimingOfOpenDoor("0144596", str1));
//		        }
				
			}
			return 0;
		}
		
		return b;
	}
	public List<String> makeExcelName(String labID,Date cdate,int week) {
		List<String> list=new ArrayList<String>();
		list.add("实验室"+labID+","+cdate+",第"+week+"周");
		list.add("日");
		list.add("一");
		list.add("二");
		list.add("三");
		list.add("四");
		list.add("五");
		list.add("六");

		return list;
	}
	public List<List<String>> getCourse2(String trim, Date cdate) {
		PaiKeDao pd=new PaiKeDao();
		List<ClasshourInfo> chis=pd.getClasshourInfo();
		String[][] courses=pd.getClassSchedule2(trim, cdate,chis);
		
		List<List<String>> css=new ArrayList<List<String>>();
		
		for(int i=0;i<courses.length;i++){
			String[] str=courses[i];
			List<String> ls=new ArrayList<String>();
			for(int j=0;j<str.length;j++){
				ls.add(str[j]);
			}
			css.add(ls);
		}
		
		return css;
	}
	public int deleteByChoose(String str) {
			String[] arr=str.split(",");
			
			int row=0;
			for(int i=0;i<arr.length;i++){
			p.deleteClasshourInfo(Integer.parseInt(arr[i]));
			row++;
		}
			return row;
		}
	public int sureModify(ClasshourInfo str) {
		p.sureModify(str);
	
		return 1;
	}
	public void addLabInfo(LabInfo labInfo) {
		
		lab.addLabInfo(labInfo);
	}
	public List<LabInfo> getLabInfos() {
		List<LabInfo> labInfos=lab.getLabInfos();
		return labInfos;
	}
	public int sureModifyLabInfo(LabInfo labInfo) {
		lab.sureModifyLabInfo(labInfo);
		
		return 1;
	}
	public int deleteByChooseLabInfo(String str) {
		String[] arr=str.split(",");
		
		int row=0;
		for(int i=0;i<arr.length;i++){
		p.deleteLabInfo(arr[i]);
		row++;
	}
		return row;
	}
	public List<List<SessionParameter>> getSPs(String str, String labId) {
		List<DeviceInfo> dis=lab.getDIsByDT(str,labId);
		
		if(dis.size()!=0){
		List<List<SessionParameter>> sps=new ArrayList<List<SessionParameter>>();
		for (DeviceInfo deviceInfo : dis) {
			List<SessionParameter> sp=lab.getSPByDI(deviceInfo.getDeviceId());
			sps.add(sp);
		}
		return sps;
		}	
		
		return null;
	}
	public DeviceInfo getByDeviceId(String string, String labId) {
		
		return lab.getByDeviceId(string,labId);
	}
	public List<LabInfo> getLabInfosRight(String userIdRight) {
		
		return lab.getLabInfosRight(userIdRight);
	}
	public List<DeviceInfo> getDIsByDT(String str, String labId) {
		
		return lab.getDIsByDT(str, labId);
	}
	
	public String getDoorNumByLabId(String labId) {
		
		return lab.getDoorNumByLabId(labId);
	}
	public List<CommonEntity> getCommonEntityBySql(String sql) {
		
		return lab.getCommonEntityBySql(sql);
	}
	public boolean isUserGroup(String userIdRight) {
		
		return lab.isUserGroup(userIdRight);
	}
	public DeviceInfo getDeviceInfoByLabId(String string, String labId) {
		
		return lab.getByDeviceId(string, labId);
	}
	public String getRfidByLabId(String labId) {
		
		return lab.getRfidByLabId(labId);
	}
	public UserInfo getUserInfoByRfid(String rfid) {
		
		return lab.getUserInfoByRfid(rfid);
	}
	public boolean isUserGroup2(String userId) {
		
		return lab.isUserGroup2(userId);
	}

	


}
