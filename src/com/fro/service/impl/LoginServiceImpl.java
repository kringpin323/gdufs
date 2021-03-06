package com.fro.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fro.dao.LoginDao;
import com.fro.dao.impl.LoginDaoImpl;
import com.fro.entity.ClassSchedule;
import com.fro.entity.DepartmentInfo;
import com.fro.entity.GroupInfo;
import com.fro.entity.LabInfo;
import com.fro.entity.LabRight;
import com.fro.entity.LabRightId;
import com.fro.entity.MajorInfo;
import com.fro.entity.UserGroup;
import com.fro.entity.UserInfo;
import com.fro.entity.UserRight;
import com.fro.order.GuardControl;
import com.fro.service.LoginService;
import com.fro.utils.ComputeWeek;
import com.fro.utils.GetCuardControl;

public class LoginServiceImpl implements LoginService {

	LoginDao loginDao=new LoginDaoImpl();
	
	public UserInfo login(String userId) {
			
		UserInfo userInfo=loginDao.findByUserId(userId);
		
 
		return userInfo;
	}

	public String getWeek() {
		Calendar c = Calendar.getInstance();
       int number=c.get(Calendar.DAY_OF_WEEK);
		
      switch (number-1) {
    	   case 0:
    	   return "星期日";
    	   case 1:
    	   return "星期一";
    	   case 2:
    	   return "星期二";
    	   case 3:
    	   return "星期三";
    	   case 4:
    	   return "星期四";
    	   case 5:
    	   return "星期五";
    	   case 6:
    	   return "星期六";
    	   default:
    	   break;
    	   }
    	
		return null;
	}

	public String findGroupid(String userId) {
		return loginDao.findGroupid(userId).getUserGroupPK().getGroupId();
	}

	public String findByGroupid(String groupid) {
		return loginDao.findByGroupid(groupid).getRightId();
	}

//	public void setLabStau(String u,String logmodel) {
//		
//		//查出普通管理员的用户
//
//		List<UserGroup> us=new ArrayList<UserGroup>();
//		us=loginDao.getAdminUserInfo("labAdmin");
//		for(int i=0;i<us.size();i++){
//			loginDao.setLabStau(us.get(i).getUserGroupPK().getUserId(),logmodel);
//
//		}
//		
//		if(logmodel.trim().equals("2")){
//		
//		//根据课表关闭所有的设备。
//		String beginDate=loginDao.getBeginDateByCurseClass();
//		if(!beginDate.equalsIgnoreCase("notNull")){
//			List<LabParameter> lp=new ArrayList<LabParameter>();
//			List<LabInfo> labIds=loginDao.getLabInfo();
//			for (LabInfo lab : labIds) {
//				LabParameter l=new LabParameter();
//				l.labID=lab.getLabId();
//				lp.add(l);
//			}
//			
//			
//			for (LabParameter labParameter : lp) {
//				
//				labParameter.operate="CLOSE";
//				labParameter.AutoNavigation();
//			}
//			
//		}
//		}
//		
//	}

	public void addUserInfo(UserInfo u)throws Exception{
	
			//添加门襟权限
					loginDao.addUserInfo(u);
//					/*
//					 * 先根据userId获取
//					 * doorNum 门序列号 0144596 
//					*	jobID 员工编号
//					*	jobNum，权限工号
//					*	timeNum 有效时间组 1
//					*	password 密码 000000
//					*	name 员工姓名
//					 */
//					/*
//					 * 获取门襟的IP 和port
//					 * 
//					 */
//					String doorNum="0144596";
//					String timeNum="1";
//					GuardControl doorC=GetCuardControl.getGuardControl();
//					doorC.sendOrder(doorC.addLimit(doorNum, u.getUserId(), u.getRfid(), timeNum,"000000",u.getUserName()));
		
		
	}

	public List<DepartmentInfo> getDepartment() {
		 List<DepartmentInfo> departmentInfos=loginDao.getDepartment();
		
		return departmentInfos;
	}

	public List<GroupInfo> getRight() {
	 List<GroupInfo> rightInfos=loginDao.getRight();
		
		return rightInfos;
	}

	public List<MajorInfo> getMajor() {
	List<MajorInfo> majors=loginDao.getMajor();
		
		return majors;
	}

	public List<UserInfo> findByCondition(UserInfo userInfo,int currentPage,int pageSize) {
	
		StringBuffer hql=new StringBuffer("from UserInfo where 1=1 ");
		if(!"".equals(userInfo.getRfid())){
			hql.append(" and RFID like'%"+ userInfo.getRfid()+"%'");
		}if(!"".equals(userInfo.getDepartment())){
			hql.append("  and Department='"+userInfo.getDepartment()+"'");
		}if(!"".equals(userInfo.getMajor())){
			hql.append("  and Major='"+userInfo.getMajor()+"'");
		}if(!"".equals(userInfo.getUserName())){
			hql.append("  and UserName like '"+userInfo.getUserName()+"%'");
		}if(!"".equals(userInfo.getUserId())){
			hql.append(" and userId like'%"+userInfo.getUserId()+"%'");
		}
		
		List<UserInfo> userInfos=loginDao.findByCondition(hql.toString(), currentPage,pageSize);
		return userInfos;
	}

	public int getTotalPage(UserInfo userInfo,int pageSize) {
		StringBuffer hql=new StringBuffer("select count(*) from UserInfo where 1=1 ");
		if(!"".equals(userInfo.getRfid())){
			hql.append(" and RFID like'%"+ userInfo.getRfid()+"%'");
		}if(!"".equals(userInfo.getDepartment())){
			hql.append("  and Department='"+userInfo.getDepartment()+"'");
		}if(!"".equals(userInfo.getMajor())){
			hql.append("  and Major='"+userInfo.getMajor()+"'");
		}if(!"".equals(userInfo.getUserName())){
			hql.append("  and UserName like'"+userInfo.getUserName()+"%'");
		}if(!"".equals(userInfo.getUserId())){
			hql.append(" and userId like'%"+userInfo.getUserId()+"%'");
		}
		
		int totalPage=loginDao.getTotalPage(hql.toString(),pageSize);
		return totalPage;
	}

	public int getRecodes(UserInfo userInfo) {
		StringBuffer hql=new StringBuffer("select count(*) from UserInfo where 1=1 ");
		if(!"".equals(userInfo.getRfid())){
			hql.append(" and RFID like'%"+ userInfo.getRfid()+"%'");
		}if(!"".equals(userInfo.getDepartment())){
			hql.append("  and Department='"+userInfo.getDepartment()+"'");
		}if(!"".equals(userInfo.getMajor())){
			hql.append("  and Major='"+userInfo.getMajor()+"'");
		}if(!"".equals(userInfo.getUserName())){
			hql.append("  and UserName like '"+userInfo.getUserName()+"%'");
		}if(!"".equals(userInfo.getUserId())){
			hql.append(" and userId like'%"+userInfo.getUserId()+"%'");
		}
		
		int recodes=loginDao.getRecodes(hql.toString());
		return recodes;
	}

	public int deleteByUserId(String userId) {
		//需要删除该用户的门襟权限
		
		int row=loginDao.stopByUserId(userId);
		
		UserInfo u=loginDao.findByUserId(userId);
		
		List<String> doorNums=loginDao.getDoorNumByRFID(u.getRfid());
		for (String doorNum : doorNums) {
			String labId=loginDao.getLabIdByDoorNum(doorNum.trim());
			GuardControl doorC=GetCuardControl.getGuardControl(labId);
			doorC.sendOrder(doorC.delLimit(u.getRfid(), doorNum));
		}
		
		
		return row;
	}

	public int deleteByChoose(String str) {
		String[] arr=str.split(",");
		
		int row=0;
		for(int i=0;i<arr.length;i++){
			
			// 需要添加删除用户就删除门襟的权限
			loginDao.deleteByUserId(arr[i]);
			loginDao.deleteGroupByUserId(arr[i]);
			loginDao.deleteUserRight(arr[i]);
			
			
			UserInfo u=loginDao.findByUserId(arr[i]);
			List<String> doorNums=loginDao.getDoorNumByRFID(u.getRfid());
			for (String doorNum : doorNums) {
				String labId=loginDao.getLabIdByDoorNum(doorNum.trim());
				GuardControl doorC=GetCuardControl.getGuardControl(labId);
				doorC.sendOrder(doorC.delLimit(u.getRfid(), doorNum));
			}
				
			
			

			row++;
		}
		
		return row;
	}

	public List<List<Object>> makeExcel(List<UserInfo> userInfos) {

		List<List<Object>> fileDate=new ArrayList<List<Object>>();
			for(int i=0;i<userInfos.size();i++){
				List<Object> object=new ArrayList<Object>();
				object.add(userInfos.get(i).getUserId());
				object.add("******");
				object.add(userInfos.get(i).getUserName());
				object.add(userInfos.get(i).getSex());
				object.add(userInfos.get(i).getLogMode());
				object.add(userInfos.get(i).getMobile());
				object.add(userInfos.get(i).getDepartment());
				object.add(userInfos.get(i).getMajor());
				object.add(userInfos.get(i).getClass_());
				object.add(userInfos.get(i).getRfid());
				object.add(userInfos.get(i).getStatus());
				object.add(userInfos.get(i).getCreateDate());
				object.add(userInfos.get(i).getCreateBy());

				fileDate.add(object);
			}
			return fileDate;
		
	
	}

	public List<String> makeExcelName() {
		List<String> list=new ArrayList<String>();
		list.add("用户编号");
		list.add("密码");
		list.add("姓名");
		list.add("性别");
		list.add("登录模式");
		list.add("手机");
		list.add("院系");
		list.add("专业");
		list.add("班级");
		list.add("卡号");
		list.add("状态");
		list.add("创建日期");
		list.add("创建人");
		
		
		return list;
		
	}

	public List<LabInfo> getLabInfo() {
		
		return loginDao.getLabInfo();
	}

	public int importUserInfo(List<UserInfo> userInfos) {
		int row=0;
		for (UserInfo userInfo : userInfos) {
			if("".equals(userInfo.getUserId())||"".equals(userInfo.getStatus())||"".equals(userInfo.getUserName())||compare(userInfo.getUserId())
)
				return 0;	
		}
		
	
		for (UserInfo userInfo : userInfos) {
			loginDao.addGroupInfo(userInfo.getUserId(), userInfo.getGroupId());
		}
		row=loginDao.addUserInfo(userInfos);
			
		
		return row;
	}

	private boolean compare(String userId) {
		//首先获得数据库中userInfo中所有的信息
	List<UserInfo>	us=loginDao.findAll();

	for (UserInfo userInfo : us) {
		if(userId.equals(userInfo.getUserId()))
			return true;
	}	
	
	
		return false;
	}

	public int updUserInfo(UserInfo userInfo) {
		
		UserInfo u=loginDao.findByUserId(userInfo.getUserId());
		if(u.getRfid().equals(userInfo.getRfid())){
	
		}else{
			//先删除之前的rfid的门襟权限 再添加更新后rfid的门襟权限。
			
			List<String> doorNums=loginDao.getDoorNumByRFID(u.getRfid());
			for (String doorNum : doorNums) {
				String labId=loginDao.getLabIdByDoorNum(doorNum);
				GuardControl doorC=GetCuardControl.getGuardControl(labId);
				doorC.sendOrder(doorC.delLimit(u.getRfid(), doorNum));
				doorC.sendOrder(doorC.addLimit(doorNum.trim(), userInfo.getUserId(), userInfo.getRfid(), "1","000000",userInfo.getUserName()));
			
			}
				
			
		}
		
		
		int row=loginDao.updUserInfo(userInfo);
		
		
		return row;
	}

	public List<String> getRightId(String userid) throws Exception {
		
		return loginDao.getRightId(userid);
	}

	public void addGroupInfo(String userId, String groupId) {
		loginDao.addGroupInfo(userId,groupId);
		
	}

	public List<UserInfo> getUserInfos() {
		
		return loginDao.getUserInfos();
	}

	public void RightSet(String userId, String[] checkbox) throws Exception {
		if(checkbox==null){
			
			return ;
		}
		
		
		List<String> rightIds=loginDao.getRightId(userId);
		
		List<String> check=new ArrayList<String>();
		for(int i=0;i<checkbox.length;i++){
			check.add(checkbox[i]);
		}
		List<String> ad=new ArrayList<String>();
		List<String> del=new ArrayList<String>();
		
		
		for (String r : rightIds) {
				if(!check.contains(r)){
					del.add(r);
				
			}
			
		}
		
		for (String c : check) {
				if(!rightIds.contains(c)){
					ad.add(c);
			}
		}
		
		
		//增加权限	
			loginDao.addUserRight(userId,ad);
		//删除权限
			loginDao.delUserRight(userId,del);
		
	}

	public List<UserInfo> toExcel(String str) {
		List<UserInfo> userInfos=new ArrayList<UserInfo>();
		String[] arr=str.split(",");
		for(int i=0;i<arr.length;i++){
		UserInfo u=	loginDao.findByUserId(arr[i]);
			userInfos.add(u);
		}
		
		
		return userInfos;
	}

	public List<ClassSchedule> findByCondition(ClassSchedule c,
			int currentPage, int pageSize) {
		
		StringBuffer hql=new StringBuffer("from ClassSchedule where 1=1 ");
		if(!"".equals(c.getLabId())){
			hql.append(" and LabID ='"+ c.getLabId()+"'");
		}if(null!=(c.getClasshourId())){
			hql.append("  and ClasshourID='"+c.getClasshourId()+"'");
		}if(null!=c.getBeginDate()){
			Date d=c.getBeginDate();
			
			
			
			ComputeWeek cw=new ComputeWeek();
			Date beginDate1=cw.addDate(d, -1);
			Date beginDate2=cw.addDate(d, 5);
			
			java.sql.Date beginDate11=new java.sql.Date(beginDate1.getTime());
			java.sql.Date beginDate22=new java.sql.Date(beginDate2.getTime());
			
			hql.append("  and BeginDate between '"+beginDate11+"' and '" + beginDate22+"'");
		}if(!"".equals(c.getCoursesName())){
			hql.append("  and CoursesName like '%"+c.getCoursesName()+"%'");
		}
		
		hql.append(" order by BeginDate ,ClasshourID ");
		System.out.println(hql.toString());
		List<ClassSchedule> css=loginDao.findByCondition1(hql.toString(), currentPage, pageSize);
		
		return css;
	}

	public int getRecodes2(ClassSchedule c) {
		StringBuffer hql=new StringBuffer("select count(*) from ClassSchedule where 1=1 ");
		if(!"".equals(c.getLabId())){
			hql.append(" and LabID ='"+ c.getLabId()+"'");
		}if(null!=(c.getClasshourId())){
			hql.append("  and ClasshourID='"+c.getClasshourId()+"'");
		}if(null!=c.getBeginDate()){

			Date d=c.getBeginDate();
			ComputeWeek cw=new ComputeWeek();
			Date beginDate1=cw.addDate(d, -1);
			Date beginDate2=cw.addDate(d, 5);
			
			java.sql.Date beginDate11=new java.sql.Date(beginDate1.getTime());
			java.sql.Date beginDate22=new java.sql.Date(beginDate2.getTime());
			
			hql.append("  and BeginDate between '"+beginDate11+"' and '" + beginDate22+"'");
		}if(!"".equals(c.getCoursesName())){
			hql.append("  and CoursesName like '%"+c.getCoursesName()+"%'");
		}

		int recodes=loginDao.getRecodes(hql.toString());
		
		return recodes;
	}

	public void addUserGroup(GroupInfo groupInfo) {
		loginDao.addUserGroup(groupInfo);
		
	}

	public List<GroupInfo> getGroupInfos() {
		
		return loginDao.getGroupInfos();
	}

	public void modifyGroupInfo(GroupInfo groupInfo) {
		loginDao.modifyGroupInfo(groupInfo);
		
	}

	public int deleteByChooseLabInfo(String str) {
		
	String[] arr=str.split(",");
		
		int row=0;
	for(int i=0;i<arr.length;i++){
			
			//删除用户组之前判断是否该组还有用户
		List<UserGroup> ugs=loginDao.getUserGrops(arr[i].trim());
		if(ugs.size()!=0){
			return 0;
		}
	}	
		
		for(int i=0;i<arr.length;i++){
		
		loginDao.deleteGroupInfo(arr[i].trim());
		//删除对应的组权限
		loginDao.deleteUserRight2(arr[i].trim());
		
		row++;
	}
		
		
		return row;
	}

	public List<String> getRightId2(String groupId) {
		
		List<UserRight> urs=loginDao.getUserRight(groupId);
		
		List<String> rights=new ArrayList<String>();
		for (UserRight userRight : urs) {
			rights.add(userRight.getRightId().trim());
		}
		
		
		return rights;
	}

	public void RightSet2(String groupId, String[] checkbox) {
		
		if(checkbox==null){
			
			return ;
		}
		
		List<String> rightIds=getRightId2(groupId);
		
		List<String> check=new ArrayList<String>();
		for(int i=0;i<checkbox.length;i++){
			check.add(checkbox[i]);
		}
		List<String> ad=new ArrayList<String>();
		List<String> del=new ArrayList<String>();
		
	
		
		
		for (String r : rightIds) {
				if(!check.contains(r)){
					del.add(r);
				
			}
			
		}
		
		for (String c : check) {
				if(!rightIds.contains(c)){
					ad.add(c);
			}
		}
		
		
		//增加权限	
			loginDao.addUserRight2(groupId,ad);
		//删除权限
			loginDao.delUserRight2(groupId,del);
		
	}

	public List<Object[]> getUserInfosByGroupId(String groupId) {
		
		return loginDao.getUserInfosByGroupId(groupId);
	}

	public void sureModifyGroup(String userId, String groupId, String str) {
		String[] arr=str.split(",");
		//看似是修改 其实是删除与添加
		for (String st : arr) {
			loginDao.addGroupInfo(userId.trim(), st.trim());
		}
		loginDao.deleteGroupInfo(userId.trim(),groupId);
		
		
		
	}

	public String getStauSet() {
		
		
		return loginDao.getStauSet();
	}

	public void openByUserId(String userId) {
		
		loginDao.openByUserId(userId);
		
	}

	public int updLabInfoRun(String labId, String modelSet) {
		String sql="update lab_info set NavigateMode='"+modelSet+"' where LabID='"+labId+"'";
		loginDao.updLabInfoRun(sql);
		return 0;
	}

	public void labRightSet(String labId, String strUserId, String strGroupId) {
		
		loginDao.deleteRight(labId);

		if(!strUserId.trim().equals("")){
			String[] users=strUserId.split(",");
			for (String string : users) {
				LabRight lr=new LabRight();
				LabRightId id=new LabRightId();
				id.setLabId(labId);
				id.setUserId(string.trim());
				id.setGroupId("******");
				lr.setId(id);
				loginDao.labRightSet(lr);
			}
		}
	
		if(!strGroupId.equals("")){
		String[] groups=strGroupId.split(",");
		for (String string : groups) {
			LabRight lr=new LabRight();
			LabRightId id=new LabRightId();
			id.setLabId(labId);
			id.setUserId("******");
			id.setGroupId(string.trim());
			lr.setId(id);
			loginDao.labRightSet(lr);
		}
		}
		
	}

	public String getRightByLabId(String labId) {
	String labList="";
		List<LabRight>  labRs=loginDao.getRightByLabId(labId);
		for (LabRight labRight : labRs) {
			if(labRight.getId().getGroupId().trim().equals("******")){
				labList+=labRight.getId().getUserId().trim()+",";
			}
			
			if(labRight.getId().getUserId().trim().equals("******")){
				labList+=labRight.getId().getGroupId().trim()+",";
				
			}	
		}

		return labList;
	}

	public List<LabInfo> getDoorNum() {
		
		return loginDao.getDoorNum("select i.LabDesc,p.SessionValue from lab_info  i,session_parameter p,device_info d where i.LabID=p.labID and d.DeviceID=p.DeviceID and d.DeviceType='门襟'");
	}

	public int deleteDoorNum(String doorNum, String doorRFID) {
		
		int row=0;
		try {
			String labId=loginDao.getLabIdByDoorNum(doorNum);
			GuardControl doorC=GetCuardControl.getGuardControl(labId);
			doorC.sendOrder(doorC.delLimit(doorRFID, doorNum));
			row=loginDao.deleteDoorNum( doorNum, doorRFID);
		} catch (Exception e) {
			return 15;
		}
		
		
		return row;
	}

	public int addDoorNum(String doorNum, String doorRFID, String userId) {
		
		int row=0;
		try {
			String labId=loginDao.getLabIdByDoorNum(doorNum);
			GuardControl doorC=GetCuardControl.getGuardControl(labId);
			UserInfo userInfo=loginDao.findByUserId(userId);
			doorC.sendOrder(doorC.addLimit(doorNum.trim(), userInfo.getUserId(), userInfo.getRfid(), "1","000000",userInfo.getUserName()));
			 row=loginDao.addDoorNum(doorNum, doorRFID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return row;
	}

	public void addLabRight(String labId, String userid) {
		loginDao.addLabRight(labId,userid);
		
	}

	public String getLabIDByExec(String userid) {
		
		return loginDao.getLabIDByExec(userid);
	}

	public void deleteBySql(String sql) {
		loginDao.deleteBySql(sql);
		
	}

	public void deleteByUserIdReal(String rfid) {
		loginDao.deleteByUserId(rfid);
		
	}


	

}
