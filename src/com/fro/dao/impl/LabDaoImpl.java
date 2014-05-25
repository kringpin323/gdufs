package com.fro.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.fro.dao.LabDao;
import com.fro.entity.DeviceInfo;
import com.fro.entity.LabInfo;
import com.fro.entity.SessionParameter;
import com.fro.entity.SessionParameterPK;
import com.fro.entity.UserInfo;
import com.fro.utils.CommonEntity;
import com.fro.utils.HibernateUtils;

public class LabDaoImpl implements LabDao {

	public List<DeviceInfo> getDIsByDT(String str) {
		String hql="from DeviceInfo where DeviceType=?";
		Session session=HibernateUtils.getSession();
		Query query=session.createQuery(hql).setString(0, str);
		List<DeviceInfo> dis=query.list();
		HibernateUtils.close();
		return dis;
	}

	public List<SessionParameter> getSPByDI(Integer deviceId) {
		String hql="select * from session_parameter where DeviceID="+deviceId;
		
		
		Session session=HibernateUtils.getSession();
	
		List<SessionParameter> sps = new ArrayList<SessionParameter>();
		
		Connection conn = session.connection(); 
        //创建调用存储过程的预定义SQL语句 
    
    
                //创建过程执行器 
                CallableStatement cstmt;
				try {
					cstmt = conn.prepareCall(hql);
					 ResultSet rs= cstmt.executeQuery();
					 while(rs.next()){
						 SessionParameter sp=new SessionParameter();
						 sp.setCreateBy(rs.getString("CreateBy"));
						 sp.setCreateDate(rs.getDate("CreateDate"));
						 sp.setLabId(rs.getString("LabID"));
						 sp.setPosition(rs.getString("Position"));
						 sp.setSessionName(rs.getString("SessionName").trim());
						 sp.setSessionType(rs.getString("SessionType"));
						 sp.setStatus(rs.getString("Status").trim());
						 SessionParameterPK spk=new SessionParameterPK();
						 spk.setDeviceId(rs.getInt("DeviceID"));
						 spk.setSessionValue(rs.getString("SessionValue").trim());
						 sp.setSessionParameterPK(spk);
						 sps.add(sp);
					 }
					 
					 
				} catch (SQLException e) {
					e.printStackTrace();
				} 
                //设置入参和出参 
		HibernateUtils.close();
		
			return sps;
		
	}

	public DeviceInfo getByDeviceId(int deviceId) {
		
		String hql="from DeviceInfo where DeviceID=?";
		Session session=HibernateUtils.getSession();
		Query query=session.createQuery(hql).setInteger(0, deviceId);
		List<DeviceInfo> di=query.list();
		HibernateUtils.close();
		
		if(di.size()!=0){
			return di.get(0);
		}
		
		return null;
	}

	public void addLabInfo(LabInfo labInfo) {
		Session session=HibernateUtils.getSession();
		session.save(labInfo);
		session.beginTransaction().commit();
		HibernateUtils.close();
		
	}

	public List<LabInfo> getLabInfos() {
		List<LabInfo> labInfos=new ArrayList<LabInfo>();
		String hql="from LabInfo";
		Session session =HibernateUtils.getSession();
		labInfos=session.createQuery(hql).list();
		HibernateUtils.close();
		return labInfos;
		
	}
	
	
	/**
	 *  2 二期修改 根据用户ID  查找有实验室权限的的实验室信息
	 */
	
	public List<LabInfo> getLabInfosRight(String userId) {
		List<LabInfo> labInfos=new ArrayList<LabInfo>();

		Session session=HibernateUtils.getSession();

		Connection conn = session.connection(); 
        //创建调用存储过程的预定义SQL语句 
    
    
                //创建过程执行器 
                CallableStatement cstmt;
				try {
					cstmt = conn.prepareCall(" exec upd_GetLabRight '"+userId+"'");
					 ResultSet rs= cstmt.executeQuery();
					 while(rs.next()){
						 LabInfo l=new LabInfo();
						 l.setLabId(rs.getString("LabID"));
						 l.setLabDesc(rs.getString("LabDesc"));
						 labInfos.add(l);
					 }
					 
					 
				} catch (SQLException e) {
					e.printStackTrace();
				} 
                //设置入参和出参 
		HibernateUtils.close();
		return labInfos;
		
	}
	
	
	
	
	
	
	

	public void sureModifyLabInfo(LabInfo labInfo) {
		String hql="update LabInfo set LabDesc='"+labInfo.getLabDesc()+"',Status='"+labInfo.getStatus()+"' where labID='"+labInfo.getLabId()+"'";
		System.out.println(hql);
		Session session =HibernateUtils.getSession();
		session.createQuery(hql).executeUpdate();
		session.beginTransaction().commit();
		HibernateUtils.close();
		
	}

	public List<DeviceInfo> getDIsByDT(String str, String labId) {
		String hql="from DeviceInfo where DeviceType=? and LabID=?";
		Session session=HibernateUtils.getSession();
		Query query=session.createQuery(hql).setString(0, str).setString(1, labId);
		List<DeviceInfo> dis=query.list();
		HibernateUtils.close();
		return dis;
	}

	public DeviceInfo getByDeviceId(String string, String labId) {
		String hql="from DeviceInfo where DeviceType='"+string.trim()+"' and LabID='"+labId+"'";
		Session session=HibernateUtils.getSession();
		Query query=session.createQuery(hql);
		List<DeviceInfo> di=query.list();
		HibernateUtils.close();
		
		if(di.size()!=0){
			return di.get(0);
		}
		return null;
	}

	
	/**
	 * 二期添加的根据实验室ID查找LabInfo信息
	 * */
	
	public LabInfo getLabInfosByID(String labID) {
		String hql="from LabInfo where LabID=?";
		Session session =HibernateUtils.getSession();
		Query query = session.createQuery(hql).setString(0, labID);
		List<LabInfo> labInfos = query.list();
		HibernateUtils.close();
		
		if(labInfos.size()!=0){
			return labInfos.get(0);
		}
		return null;
		
	}

	public String getDoorNumByLabId(String labId) {
		String hql="from SessionParameter where LabID=? and sessionName='门襟'";
		Session session =HibernateUtils.getSession();
		Query query = session.createQuery(hql).setString(0, labId);
		List<SessionParameter> labInfos = query.list();
		HibernateUtils.close();
		
		if(labInfos.size()!=0){
			return labInfos.get(0).getSessionParameterPK().getSessionValue();
		}
		return null;
	}

	public List<CommonEntity> getCommonEntityBySql(String sql) {
		Session session=HibernateUtils.getSession();
	
		List<CommonEntity> ces = new ArrayList<CommonEntity>();
		
		Connection conn = session.connection(); 
                CallableStatement cstmt;
				try {
					cstmt = conn.prepareCall(sql);
					 ResultSet rs= cstmt.executeQuery();
					 while(rs.next()){
						 CommonEntity ce=new CommonEntity();
						 ce.cardIP=rs.getString("cardIP");
						 ce.cardPort=rs.getInt("cardPort");
						 ce.doorIP=rs.getString("doorIP");
						 ce.doorPort=rs.getInt("doorPort");
						 ce.labID=rs.getString("labID");
						 ce.sessionValue=rs.getString("SessionValue");
						 ces.add(ce);
					 }
					 
					 
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		HibernateUtils.close();
		return ces;
	}

	public boolean isUserGroup(String userIdRight) {
		String hql="from UserGroup where userGroupPK.groupId='common' and userGroupPK.userId=?";
		Session session =HibernateUtils.getSession();
		Query query = session.createQuery(hql).setString(0, userIdRight);
		List<LabInfo> labInfos = query.list();
		HibernateUtils.close();
		if(labInfos.size()!=0){
			return true;
		}
		
		return false;
	}

	public List<DeviceInfo> getgetDeviceInfoByLabId(String string, String labId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRfidByLabId(String labId) {
		Session session=HibernateUtils.getSession();
		Connection conn=session.connection();
		CallableStatement cstmt;
		try {
			cstmt = conn.prepareCall("exec dbo.dbo.upd_GetCurrentClass '"+labId+"'");
			ResultSet rs= cstmt.executeQuery(); 
		while(rs.next()){
			if(rs.getString("UserType").equals("1")){
				Date beginDate=rs.getDate("BeginTime");
				Date endDate=rs.getDate("EndTime");
				Date now =new Date("yyyy-MM-dd HH:MM:SS ");
				if(now.before(endDate)&&now.after(beginDate)){
					return rs.getString("UserID");
				}
				
			}
	
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserInfo getUserInfoByRfid(String rfid) {
		String hql="from UserInfo where rfid=?";
		Session session =HibernateUtils.getSession();
		Query query = session.createQuery(hql).setString(0, rfid);
		List<UserInfo> labInfos = query.list();
		HibernateUtils.close();
		for (UserInfo userInfo : labInfos) {
			return userInfo;
		}

		return null;
	}

	public boolean isUserGroup2(String userId) {
		String hql="from UserGroup where userGroupPK.groupId='admin' and userGroupPK.userId=?";
		Session session =HibernateUtils.getSession();
		Query query = session.createQuery(hql).setString(0, userId);
		List<LabInfo> labInfos = query.list();
		HibernateUtils.close();
		if(labInfos.size()!=0){
			return true;
		}
		
		return false;
	}
}
