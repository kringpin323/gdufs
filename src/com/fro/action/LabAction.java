 package com.fro.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fro.dao.impl.LoginDaoImpl;
import com.fro.entity.DeviceInfo;
import com.fro.entity.LabInfo;
import com.fro.entity.SessionParameter;
import com.fro.entity.SessionParameterPK;
import com.fro.entity.UserInfo;
import com.fro.order.GetTempratureNQJ;
import com.fro.order.GuardControl;
import com.fro.order.SMPSControl;
import com.fro.order.SMPSltgkControl;
import com.fro.order.SecuritySystemControl;
import com.fro.service.LabService;
import com.fro.service.impl.LabServiceImpl;
import com.fro.socket.SocketOperates;
import com.fro.utils.LabParameter;

public class LabAction extends BaseAction{
private List<List<SessionParameter>>  sps;




private DataOutputStream dos = null;
private DataInputStream dis = null;

private int link;
private String linkStr;
private String action;
private int deviceId;
private LabInfo labInfo;
private List<LabInfo> labInfos;
private String str;
private String labId;
private String pwd;
private List<List<String>> alarmLists;
private String sessionN;
private String alarmTime;
private String alarmTimeEnd;
private SessionParameter sessionParameter;
private List<SessionParameter> spss;


private int newsID;
private String news;
private String color;


public int getNewsID() {
	return newsID;
}


public void setNewsID(int newsID) {
	this.newsID = newsID;
}


public String getNews() {
	return news;
}


public void setNews(String news) {
	this.news = news;
}


public String getColor() {
	return color;
}


public void setColor(String color) {
	this.color = color;
}


public SessionParameter getSessionParameter() {
	return sessionParameter;
}


public void setSessionParameter(SessionParameter sessionParameter) {
	this.sessionParameter = sessionParameter;
}

private int currentPage;
private int totalPage;
private int recodes;

	public LabInfo getLabInfo() {
	return labInfo;
}

	
	public String waite(){
		
		
		return "waite";
	}
	
	public String addData(){
		
		System.out.println(newsID+"--"+news+"--"+color);
		return null;
	}
	
	
	
	public String noRight(){
		
		
		return "noRight";
	}
	

	public String toUpdDoorPwd(){
		
		labInfos=ld.getLabInfo();
		
		return "toUpdDoorPwd";
	}
	
/**
 * 密码修改
 * @return
 * @throws IOException
 */
	
	public String updDoorPwd() throws IOException{
		DeviceInfo di=lab.getByDeviceId("门襟", labId);

		so.getConnect(di.getDeviceIp(), di.getPort(),3000);
		dos = new DataOutputStream(new BufferedOutputStream(so.getClient().getOutputStream()));
		GuardControl smpsc = new GuardControl(di.getDeviceIp(), di.getPort());
		byte[] b = null;
		String doorNum=	lab.getDoorNumByLabId(labId);
		b=smpsc.modifyPassword(doorNum.trim(), pwd.trim());
		dos.write(b,0,b.length);
		dos.flush();
		dos.close();
		so.getClient().close();
		
		return null;
	}
	
	
/**
 * 门襟初始化
 * @param labInfo
 * @throws IOException 
 */
	public String initializeDoor() throws IOException{
		DeviceInfo di=lab.getByDeviceId("门襟", labId);

		so.getConnect(di.getDeviceIp(), di.getPort(),3000);
		dos = new DataOutputStream(new BufferedOutputStream(so.getClient().getOutputStream()));
		GuardControl smpsc = new GuardControl(di.getDeviceIp(), di.getPort());
		byte[] b = null;
		String doorNum=	lab.getDoorNumByLabId(labId);
		b=smpsc.initialize(doorNum.trim());
		dos.write(b,0,b.length);
		dos.flush();
		dos.close();
		so.getClient().close();
	
		return null;
	}
	
	
	/**
	 * 重启
	 * @param labInfo
	 * @throws IOException 
	 */
	public String reBoot() throws IOException{
		DeviceInfo di=lab.getByDeviceId("门襟", labId);

		so.getConnect(di.getDeviceIp(), di.getPort(),3000);
		dos = new DataOutputStream(new BufferedOutputStream(so.getClient().getOutputStream()));
		GuardControl smpsc = new GuardControl(di.getDeviceIp(), di.getPort());
		byte[] b = null;
		String doorNum=	lab.getDoorNumByLabId(labId);
		b=smpsc.reBoot(doorNum.trim());
		dos.write(b,0,b.length);
		dos.flush();
		dos.close();
		so.getClient().close();
	
		return null;
		
		
		
	}
	
	
	
public void setLabInfo(LabInfo labInfo) {
	this.labInfo = labInfo;
}

	LabService lab=new LabServiceImpl();
	SocketOperates so=new SocketOperates();
	
	
	public String getTemp() throws Exception{
		
		response.setCharacterEncoding("utf-8");
		String str="温湿度";
		GetTempratureNQJ temp=new GetTempratureNQJ();
		
		//  2   温湿度	二期整改  滚动所有实验室的 温湿度数据	
	List<DeviceInfo> deviceInfo=lab.getDeviceInfo(str);
	
	String scopText="";
	
	for (DeviceInfo di : deviceInfo) {
		
		String s=temp.getData(di.getDeviceIp(),di.getPort().toString().trim());
		
		String[] arr=s.split(","); 
		scopText+="实验室["+  di.getLabId() +"] 温度:"+arr[0]+"°C,湿度:"+arr[1]+"%    ";	
		
	}

	response.getWriter().print(scopText);
		
		
		return null;
	}
	
	
	public String safeControl(){
		String userIdRight=((UserInfo)session.get("userInfo")).getUserId();
		labInfos=ld.getLabInfosRight(userIdRight);

		if(labInfos.size()==0){
			return "noRight";
		}
		return "safeControl";
	}
	
	public String safeList(){
		
		sps=lab.getSPs(str,labId);

		return "safeList";
	}
	
	

	
	
	
	
	public String startSafeControl() throws Exception{
		
		System.out.println("安防");
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out=response.getWriter();
		DeviceInfo di=lab.getByDeviceId(deviceId);
		so.getConnect(di.getDeviceIp(), di.getPort(),3000);
		
		dos = new DataOutputStream(new BufferedOutputStream(so.getClient().getOutputStream()));
		byte[] b = null;
		SecuritySystemControl  ssc=new SecuritySystemControl();
		if(action.equalsIgnoreCase("on")){
		b = ssc.onOrder();
		}
		else if(action.equalsIgnoreCase("off")){
			b=ssc.offOrder();
		}else if(action.equalsIgnoreCase("chaxun")){
			b=ssc.checkOrder();
		}
		Thread.sleep(1000);
		dos.write(b,0,b.length);
		dos.flush();
		
		
		dis = new DataInputStream(new BufferedInputStream(so.getClient().getInputStream()));
		int control_flag = 0;
		while(dis.available()==0){
			control_flag ++;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		byte[] result=null;
		try{
			 result = new byte[dis.available()];
			}
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			dis.read(result);
		} catch (IOException e) {
			e.printStackTrace();
 		}
		String str = ssc.getStatus(result);
		
		dis.close();
		dos.close();
		so.getClient().close();
		out.print(str);
		
		return null;
	}
	
	public String alarmList() throws Exception{
		
		int pageSize=Integer.parseInt(request.getSession().getServletContext().getInitParameter("pageSize"));
		
		alarmLists=ld.getAlarmList(deviceId,sessionN,alarmTime,alarmTimeEnd,pageSize,currentPage);
		recodes=ld.getRecodes(deviceId,sessionN,alarmTime,alarmTimeEnd);
		totalPage=recodes%pageSize==0?recodes/pageSize:recodes/pageSize+1;
		
		return "alarmLists";
	}
	
	
	
	LoginDaoImpl ld = new LoginDaoImpl();
	
	public String lightControl(){
		String userIdRight=((UserInfo)session.get("userInfo")).getUserId();
	labInfos=ld.getLabInfosRight(userIdRight);
	
	if(labInfos.size()==0){
		return "noRight";
	}
	
		return "lightControl";
	}
	
	public String lightList(){
		
		sps=lab.getSPs(str,labId);
		
		return "lightList";
	}
	
	
	
	public String startLightControl() throws Exception{
		System.out.println("灯光");
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		PrintWriter out=response.getWriter();
		DeviceInfo di=lab.getByDeviceId(deviceId);
		so.getConnect(di.getDeviceIp(), di.getPort(),3000);
		
		dos = new DataOutputStream(new BufferedOutputStream(so.getClient().getOutputStream()));
		byte[] b = null;
		SMPSControl smpsc = new SMPSControl();
		if(action.equalsIgnoreCase("on")){
		b = smpsc.onOrder(link);
		}
		else if(action.equalsIgnoreCase("off")){
			b=smpsc.offOrder(link);
		}else if(action.equalsIgnoreCase("onAll")){
			b=smpsc.onOrderAll();
		}else if(action.equalsIgnoreCase("offAll")){
			b=smpsc.offOrderAll();
		}else if(action.equalsIgnoreCase("chaxun")){
			b=smpsc.statusOrder();
		}
		Thread.sleep(1000);
		dos.write(b,0,b.length);
		dos.flush();
		
		dis = new DataInputStream(new BufferedInputStream(so.getClient().getInputStream()));
		while(dis.available()==0){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		byte[] result = new byte[dis.available()];
		dis.read(result);
		String str = smpsc.getStatusResult(result);
		dis.close();
		dos.close();
		so.closeSock();
		out.print(str);
		
		return null;
	}
	
	public String switchControl(){
		String userIdRight=((UserInfo)session.get("userInfo")).getUserId();
		labInfos=ld.getLabInfosRight(userIdRight);
		
		if(labInfos.size()==0){
			return "noRight";
		}
		
		return "switchControl";
	}
	
	public String startSwitchControl() throws Exception{
		System.out.println("继电器");
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out=response.getWriter();
		DeviceInfo di=lab.getByDeviceId(deviceId);
		so.getConnect(di.getDeviceIp(), di.getPort(),30000);
		dos = new DataOutputStream(new BufferedOutputStream(so.getClient().getOutputStream()));
		byte[] b = null;
		String str="";
	
		//2 期修改
		if(labId.trim().equals("C507")){
			//实验室c507 电源调用方法
			SMPSltgkControl ssc=new SMPSltgkControl();
			if(action.equalsIgnoreCase("on")){
			b = ssc.onOrder(link);
			}
			else if(action.equalsIgnoreCase("off")){
				b=ssc.offOrder(link);
			}else if(action .equalsIgnoreCase("onAll")){
				b=ssc.onOrderAll();
			}else if(action.equalsIgnoreCase("offAll")){
				b=ssc.offOrderAll();
			}else if(action.equalsIgnoreCase("chaxun")){
				b=ssc.statusOrder();
			}
			Thread.sleep(1000);
			dos.write(b,0,b.length);
			dos.flush();
			
			dis = new DataInputStream(new BufferedInputStream(so.getClient().getInputStream()));
			while(dis.available()==0){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			byte[] result = new byte[dis.available()];
			dis.read(result);
			 str = ssc.getStatusResult(result);
		}else{
			
			SMPSControl ssc=new SMPSControl();
			if(action.equalsIgnoreCase("on")){
			b = ssc.onOrder(link);
			}
			else if(action.equalsIgnoreCase("off")){
				b=ssc.offOrder(link);
			}else if(action .equalsIgnoreCase("onAll")){
				b=ssc.onOrderAll();
			}else if(action.equalsIgnoreCase("offAll")){
				b=ssc.offOrderAll();
			}else if(action.equalsIgnoreCase("chaxun")){
				b=ssc.statusOrder();
			}
			Thread.sleep(1000);
			dos.write(b,0,b.length);
			dos.flush();
			
			dis = new DataInputStream(new BufferedInputStream(so.getClient().getInputStream()));
			while(dis.available()==0){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			byte[] result = new byte[dis.available()];
			dis.read(result);
			 str = ssc.getStatusResult(result);			
		}
		
		
	
		
		
		dis.close();
		dos.close();
		so.getClient().close();
		out.print(str);
		
		
		return null;
	}
	
	
	public String airConditioner(){
		String userIdRight=((UserInfo)session.get("userInfo")).getUserId();
		labInfos=ld.getLabInfosRight(userIdRight);
		if(labInfos.size()==0){
			return "noRight";
		}
		return "airConditioner";
	}
	
	public String startConditionerControl() throws Exception{
		System.out.println("空调");
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out=response.getWriter();
		DeviceInfo di=lab.getByDeviceId(deviceId);
		so.getConnect(di.getDeviceIp(), di.getPort(),3000);
		
		dos = new DataOutputStream(new BufferedOutputStream(so.getClient().getOutputStream()));
		byte[] b = null;
		SMPSControl smpsc = new SMPSControl();
		if(action.equalsIgnoreCase("on")){
		b = smpsc.onOrder(link);
		}
		else if(action.equalsIgnoreCase("off")){
			b=smpsc.offOrder(link);
		}else if(action.equalsIgnoreCase("onAll")){
			b=smpsc.onOrderAll();
		}else if(action.equalsIgnoreCase("offAll")){
			b=smpsc.offOrderAll();
		}else if(action.equalsIgnoreCase("chaxun")){
			b=smpsc.statusOrder();
		}
		Thread.sleep(1000);
		dos.write(b,0,b.length);
		dos.flush();
		
		dis = new DataInputStream(new BufferedInputStream(so.getClient().getInputStream()));
		while(dis.available()==0){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		byte[] result = new byte[dis.available()];
		dis.read(result);
		String str = smpsc.getStatusResult(result);
		dis.close();
		dos.close();
		so.getClient().close();
		
		out.print(str);

		return null;
	}
	
	
	
	public String doorContorl(){
		String userIdRight=((UserInfo)session.get("userInfo")).getUserId();
		labInfos=ld.getLabInfosRight(userIdRight);
		if(labInfos.size()==0){
			return "noRight";
		}
		return "doorContorl";
	}

	public String toSafeDoor(){
		String userIdRight=((UserInfo)session.get("userInfo")).getUserId();
		labInfos=ld.getLabInfosRight(userIdRight);
		if(labInfos.size()==0){
			return "noRight";
		}
		return "toSafeDoor";
	}
	
	public String doorList2(){

		sps=lab.getSPs(str,labId);
		if(sps!=null){
			sessionParameter=sps.get(0).get(0);
			}else{
				sessionParameter=null;
			}
		
		return "doorList2";
	}
	
	
	public String doorList(){

		sps=lab.getSPs(str,labId);
		
		if(sps!=null){
		sessionParameter=sps.get(0).get(0);
		}else{
			sessionParameter=null;
		}
		
		return "doorList";
	}
	
	public String startDoorControl() throws Exception{
		
	// 2 二期进行修改   动态获取相应实验室的灯光IP 与 Port 发送门襟状态后的指令给 灯光
		System.out.println("门襟");
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out=response.getWriter();
		DeviceInfo di=lab.getByDeviceId(deviceId);
		so.getConnect(di.getDeviceIp(), di.getPort(),3000);
		dos = new DataOutputStream(new BufferedOutputStream(so.getClient().getOutputStream()));
		byte[] b = null;
		
		
		//开门比较特殊    需要判断 是否数字广外用户进行开门
		if(action.equalsIgnoreCase("on")||action.equalsIgnoreCase("instancy")){
			
			String userIdRight=((UserInfo)session.get("userInfo")).getUserId();
			boolean flag=lab.isUserGroup(userIdRight);
			if(flag){
				//执行开灯  开电  等等一系列操作
				LabParameter lp=new LabParameter();
				lp.labID=labId;
				lp.operate="OPEN";
				lp.AutoNavigation();	
			}
		}
		
		
		
		
		
		if(labId.equals("C507")){
			
			if(action.equalsIgnoreCase("on")){
				GuardControl smpsc = new GuardControl(di.getDeviceIp(), di.getPort());
				b=smpsc.emergencyOrder(linkStr);
			Thread.sleep(1000);
			dos.write(b,0,b.length);
			dos.flush();
			
			
			SocketOperates so1=new SocketOperates();
			
			//获取灯光的  IP 与 Port
			DeviceInfo diM=lab.getByDeviceId(deviceId);
			DeviceInfo diD=lab.getByDeviceId("灯光",diM.getLabId());
			
			so1.getConnect(diD.getDeviceIp(), diD.getPort(),30000);
			
			
		DataOutputStream dos1 = new DataOutputStream(new BufferedOutputStream(so1.getClient().getOutputStream()));
			
			SMPSControl smpsc2 = new SMPSControl();
			b=smpsc2.onOrder(7);
			Thread.sleep(1000);
			dos1.write(b,0,b.length);
			dos1.flush();
			b=smpsc2.onOrder(8);
			Thread.sleep(1000);
			dos1.write(b,0,b.length);
			dos1.flush();

			

			dis = new DataInputStream(new BufferedInputStream(so1.getClient().getInputStream()));
			while(dis.available()==0){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			byte[] result = new byte[dis.available()];
			dis.read(result);
			dos1.close();
			so1.getClient().close();
			dis.close();
			dos.close();
			so.getClient().close();
			SMPSControl smpsc21 = new SMPSControl();
			String str = smpsc21.getStatusResult(result);
			
			out.print(str);
			
			}
			else if(action.equalsIgnoreCase("off")){
				GuardControl smpsc = new GuardControl(di.getDeviceIp(), di.getPort());
				b=smpsc.cancelEmergencyOrder(linkStr);
				
				Thread.sleep(1000);
				dos.write(b,0,b.length);
				dos.flush();
				//取消第7第8路的指示灯
				
				SocketOperates so1=new SocketOperates();	
				
				
				DeviceInfo diM=lab.getByDeviceId(deviceId);
				DeviceInfo diD=lab.getByDeviceId("灯光",diM.getLabId());
				so1.getConnect(diD.getDeviceIp(), diD.getPort(),30000);
				
			DataOutputStream dos1 = new DataOutputStream(new BufferedOutputStream(so1.getClient().getOutputStream()));
				
				SMPSControl smpsc2 = new SMPSControl();
				b=smpsc2.offOrder(7);
				Thread.sleep(1000);
				dos1.write(b,0,b.length);
				dos1.flush();
				b=smpsc2.offOrder(8);
				Thread.sleep(1000);
				dos1.write(b,0,b.length);
				dos1.flush();
				

				dis = new DataInputStream(new BufferedInputStream(so1.getClient().getInputStream()));
				while(dis.available()==0){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				byte[] result = new byte[dis.available()];
				dis.read(result);
				dis.close();
				dos.close();
				so.getClient().close();
				dos1.close();
				so1.getClient().close();
				
				SMPSControl smpsc21 = new SMPSControl();
				String str = smpsc21.getStatusResult(result);
				
				out.print(str);
				
			}else if(action.equalsIgnoreCase("instancy")){
				//紧急开门的方法
				GuardControl smpsc = new GuardControl(di.getDeviceIp(), di.getPort());
				b=smpsc.emergencyOrder(linkStr);
				
				Thread.sleep(1000);
				dos.write(b,0,b.length);
				dos.flush();
				
				dis = new DataInputStream(new BufferedInputStream(so.getClient().getInputStream()));
				while(dis.available()==0){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				byte[] result = new byte[dis.available()];
				dis.read(result);
				dis.close();
				dos.close();
				so.getClient().close();
				
				out.print("success");
				
			}else if(action.equalsIgnoreCase("cancel")){
				//取消紧急开门方法
				GuardControl smpsc = new GuardControl(di.getDeviceIp(), di.getPort());
				b=smpsc.cancelEmergencyOrder(linkStr);
				
				Thread.sleep(1000);
				System.out.println(new String(b));
				dos.write(b,0,b.length);
				dos.flush();
				
				dis = new DataInputStream(new BufferedInputStream(so.getClient().getInputStream()));
				while(dis.available()==0){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				byte[] result = new byte[dis.available()];
				dis.read(result);
				dis.close();
				dos.close();
				so.getClient().close();
				
				out.print("success");
				
			}else if(action.equalsIgnoreCase("chaxun")){
				
				SocketOperates so1=new SocketOperates();	
				so1.getConnect("192.168.0.104", 4001,30000);
			DataOutputStream dos1 = new DataOutputStream(new BufferedOutputStream(so1.getClient().getOutputStream()));
			//查询状态
				SMPSControl smpsc21 = new SMPSControl();
				b=smpsc21.statusOrder();
				
				Thread.sleep(1000);
				dos1.write(b,0,b.length);
				dos1.flush();
				
				dis = new DataInputStream(new BufferedInputStream(so1.getClient().getInputStream()));
				while(dis.available()==0){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				byte[] result = new byte[dis.available()];
				dis.read(result);
				dis.close();
				dos1.close();
				so1.getClient().close();

				String str = smpsc21.getStatusResult(result);
				out.print(str);
			}
			
			
		}else{
			
			if(action.equalsIgnoreCase("on")||action.equalsIgnoreCase("instancy")){
				
				//紧急开门的方法
				GuardControl smpsc = new GuardControl(di.getDeviceIp(), di.getPort());
				b=smpsc.emergencyOrder(linkStr);
				System.out.println(b);
				
				Thread.sleep(1000);
				dos.write(b,0,b.length);
				dos.flush();
				
				dis = new DataInputStream(new BufferedInputStream(so.getClient().getInputStream()));
				while(dis.available()==0){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						//e.printStackTrace();
					}
				}
				byte[] result = new byte[dis.available()];
				dis.read(result);
				dis.close();
				dos.close();
				so.getClient().close();
				
				out.print(linkStr+"|on");
				
			}else if(action.equalsIgnoreCase("off")||action.equalsIgnoreCase("cancel")){
				
				//取消紧急开门方法
				GuardControl smpsc = new GuardControl(di.getDeviceIp(), di.getPort());
				b=smpsc.cancelEmergencyOrder(linkStr);
				
				Thread.sleep(1000);
				System.out.println(new String(b));
				dos.write(b,0,b.length);
				dos.flush();
				
				dis = new DataInputStream(new BufferedInputStream(so.getClient().getInputStream()));
				while(dis.available()==0){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						//e.printStackTrace();
					}
				}
				byte[] result = new byte[dis.available()];
				dis.read(result);
				dis.close();
				dos.close();
				so.getClient().close();
				

				out.print(linkStr+"|off");
				
			}else if(action.equalsIgnoreCase("chaxun")){
				GuardControl smpsc = new GuardControl(di.getDeviceIp(), di.getPort());
				String str = smpsc.doorStatus(linkStr);
				out.print(str);
				
			}
			
			
			
			
		}
		
		
		
	
		
		

		return null;
		
	}
	
	
	public String spControl(){
		spss=new ArrayList<SessionParameter>();
		String userIdRight=((UserInfo)session.get("userInfo")).getUserId();
		labInfos=ld.getLabInfosRight(userIdRight);
		
		
		

		for (int i = 0; i < labInfos.size(); i++) {
			
			List<DeviceInfo> dis=lab.getDIsByDT("视屏",labInfos.get(i).getLabId());
			sps=lab.getSPs("视屏",labInfos.get(i).getLabId());
			
			if(sps!=null){
			List<SessionParameter> sp=sps.get(0);
			for (SessionParameter sessionParameter : sp) {	
				SessionParameterPK PK=new SessionParameterPK();
				PK.setSessionValue(dis.get(0).getDeviceIp()+":"+sessionParameter.getSessionParameterPK().getSessionValue());
				sessionParameter.setSessionParameterPK(PK);	
			}
			spss.addAll(sp);
			}
			
		}
		
		if(spss.size()==0){
			return "noRight";
		}
		
		
		return "spControl";
	}
	
	public String toLabManager(){
		
		
		return "toLabManager";
	}
	
	public String addLabInfo(){
		
		//2 添加实验室默认 为1 管理员模式
		labInfo.setNavigateMode("1");
		//2 
		
		labInfo.setCreateBy(((UserInfo)session.get("userInfo")).getUserId());
		labInfo.setCreateDate(new Timestamp(new Date().getTime()));
		
		lab.addLabInfo(labInfo);
		
		
		return null;
	}
	public String preview(){
		
		labInfos=lab.getLabInfos();
		
		return "preview";
	}
	
	public String sureModify() throws IOException{
		
		int row =lab.sureModifyLabInfo(labInfo);
		PrintWriter out=response.getWriter();
		out.print(row);
		out.flush();
		
		
		return null;
	}
	
	public String deleteByChoose() throws IOException{
		int row =lab.deleteByChooseLabInfo(str);
		PrintWriter out=response.getWriter();
		out.print(row);
		out.flush();
		
		return null;
	}
	
	
	public List<List<SessionParameter>> getSps() {
		return sps;
	}


	public void setSps(List<List<SessionParameter>> sps) {
		this.sps = sps;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}


	public List<LabInfo> getLabInfos() {
		return labInfos;
	}


	public void setLabInfos(List<LabInfo> labInfos) {
		this.labInfos = labInfos;
	}


	public String getStr() {
		return str;
	}


	public void setStr(String str) {
		this.str = str;
	}


	public String getLabId() {
		return labId;
	}


	public void setLabId(String labId) {
		this.labId = labId;
	}


	public List<List<String>> getAlarmLists() {
		return alarmLists;
	}


	public void setAlarmLists(List<List<String>> alarmLists) {
		this.alarmLists = alarmLists;
	}


	public String getSessionN() {
		return sessionN;
	}


	public void setSessionN(String sessionN) {
		this.sessionN = sessionN;
	}


	public String getAlarmTime() {
		return alarmTime;
	}


	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}


	public String getAlarmTimeEnd() {
		return alarmTimeEnd;
	}


	public void setAlarmTimeEnd(String alarmTimeEnd) {
		this.alarmTimeEnd = alarmTimeEnd;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getRecodes() {
		return recodes;
	}


	public void setRecodes(int recodes) {
		this.recodes = recodes;
	}


	public String getLinkStr() {
		return linkStr;
	}


	public void setLinkStr(String linkStr) {
		this.linkStr = linkStr;
	}


	public List<SessionParameter> getSpss() {
		return spss;
	}


	public void setSpss(List<SessionParameter> spss) {
		this.spss = spss;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}





	
	
	
}
