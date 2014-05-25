package com.fro.action;

import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fro.dao.impl.LoginDaoImpl;
import com.fro.entity.DeviceInfo;
import com.fro.entity.LabInfo;
import com.fro.entity.SessionParameter;

public class CanAction extends BaseAction{
	private List<LabInfo> laList;
	private List<DeviceInfo> ccList;
	LoginDaoImpl ld = new LoginDaoImpl();
	private List<SessionParameter> ssList;
	private SessionParameter sp;
	private int id;
	private int page;
	private int jilu;
	private int yeshu;
	private String name;
	private int count;

	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getJilu() {
		return jilu;
	}


	public void setJilu(int jilu) {
		this.jilu = jilu;
	}


	public int getYeshu() {
		return yeshu;
	}


	public void setYeshu(int yeshu) {
		this.yeshu = yeshu;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public List<SessionParameter> getSsList() {
		return ssList;
	}


	public void setSsList(List<SessionParameter> ssList) {
		this.ssList = ssList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public SessionParameter getSp() {
		return sp;
	}


	public void setSp(SessionParameter sp) {
		this.sp = sp;
	}


	private DeviceInfo deviceInfo;
	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}


	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}



	public List<LabInfo> getLaList() {
		return laList;
	}


	public void setLaList(List<LabInfo> laList) {
		this.laList = laList;
	}





	public List<DeviceInfo> getCcList() {
		return ccList;
	}


	public void setCcList(List<DeviceInfo> ccList) {
		this.ccList = ccList;
	}


	//显示实验室名称和设备名称
	public String listshiyanshi()
	{
		try{
		
		this.ccList = this.ld.getDeviceInfo();
		this.laList = this.ld.getLabInfo();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "listshiyanshi";
	}


	//添加参数
	public String addCanshu()
	{
		try{
		PrintWriter out = response.getWriter();
		this.sp.setCreateDate(DateConvert.DateConvert());
		this.ld.addSessionParameter(this.sp);	
		out.print(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//参数值模糊查询
	public String mohuchaxun()
	{
		this.ssList = this.ld.canshumohuchaxun(this.id,this.page);

		this.jilu = this.ld.canshumohuchaxun(this.id);
		this.yeshu=jilu%10==0?jilu/10:jilu/10+1;
		return "mohuchaxun";
	}
	//删除参数
	public String DeleteCan()
	{
		this.ccList = this.ld.getDeviceInfo();
		this.laList = this.ld.getLabInfo();
		this.ld.deletecan(this.id,this.name);
		return "listshiyanshi";
	}
	//修改参数数据前查询
	public String Updateselect()
	{
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		SessionParameter s = new SessionParameter();
		s=this.ld.CaninsertSelect(this.id,this.name);
		try{
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			String str=s.getCanshu().getDeviceId()+","+s.getSessionParameterPK().getSessionValue()+","+s.getSessionName()+","+s.getSessionType()+","+s.getLabId()+","+s.getPosition()+","+s.getStatus()+","+s.getCreateBy();
			out.print(str);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//修改参数数据
	public String Update()
	{
		try {
		SessionParameter s = new SessionParameter();
		s=this.ld.CaninsertSelect(sp.getSessionParameterPK().getDeviceId(),sp.getSessionName());
		this.sp.setCreateDate(s.getCreateDate());
		this.ld.Update(this.sp);
		
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
