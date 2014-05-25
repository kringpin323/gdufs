package com.fro.action;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.fro.dao.impl.LoginDaoImpl;
import com.fro.entity.DeviceInfo;
import com.fro.entity.LabInfo;

public class SheBeiAction extends BaseAction{
	private List<LabInfo> LaList;
	private List<DeviceInfo> Dlist;
	private String name;
	private List Clist;
	private List Slist;
	private int page;
	private int jilu;
	private int yeshu;

	public List getSlist() {
		return Slist;
	}
	public void setSlist(List slist) {
		Slist = slist;
	}
	public int getYeshu() {
		return yeshu;
	}
	public void setYeshu(int yeshu) {
		this.yeshu = yeshu;
	}
	public int getJilu() {
		return jilu;
	}
	public void setJilu(int jilu) {
		this.jilu = jilu;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	DeviceInfo deviceInfo = new DeviceInfo();
	LoginDaoImpl ld = new LoginDaoImpl();
	public List getClist() {
		return Clist;
	}
	public void setClist(List clist) {
		Clist = clist;
	}

	private String labId;
	
	public String getLabId() {
		return labId;
	}
	public void setLabId(String labId) {
		this.labId = labId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private int deviceId;

	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}


	public List<DeviceInfo> getDlist() {
		return Dlist;
	}
	public void setDlist(List<DeviceInfo> dlist) {
		Dlist = dlist;
	}
	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	public List<LabInfo> getLaList() {
		return LaList;
	}
	public void setLaList(List<LabInfo> laList) {
		LaList = laList;
	}
	public String addLabinfo()
	{	
		try{
		this.LaList = this.ld.getLabInfo();
	}catch (Exception e) {
		e.printStackTrace();
	}
		return "list";
	}
	public String mohuchaxun()
	{
		this.jilu = this.ld.Recoder(name,labId);
		this.yeshu=jilu%10==0?jilu/10:jilu/10+1;
		this.Dlist = this.ld.Mohuchaxun(this.name,this.labId,this.page);
		return "mohu";
	}
	
	public String addShebei()
	{
		try{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		deviceInfo.setCreateDate(DateConvert.DateConvert());
		this.ld.addDeviceInfo(this.deviceInfo);
		this.LaList = this.ld.getLabInfo();
		out.print(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String Delete()
	{
		try{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		this.Slist = this.ld.deleteselect(this.deviceId);
		if(Slist.size()<=0)
		{
			this.ld.delete(this.deviceId);
			out.print(2);
		}else
		{
			
			out.print(1);
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String select()
	{
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		DeviceInfo d = new DeviceInfo();
		d=this.ld.updateSelect(this.deviceId);
		try{
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			String str=d.getDeviceId()+","+d.getDeviceName()+","+d.getDeviceType()+","+d.getDeviceIp()+","+d.getPort()+","+d.getShiyan().getLabId()+","+d.getPosition()+","+d.getStatus()+","+d.getCreateBy();
			out.print(str);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//Éè±¸ÐÞ¸Ä
	public String update()
	{
		try{
		DeviceInfo d = new DeviceInfo();
		d = this.ld.updateSelect(deviceInfo.getDeviceId());
		deviceInfo.setCreateDate(d.getCreateDate());
		this.ld.update(this.deviceInfo);
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.print(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
