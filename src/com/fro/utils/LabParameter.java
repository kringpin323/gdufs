package  com.fro.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fro.entity.DeviceInfo;
import com.fro.entity.SessionParameter;
import com.fro.entity.UserInfo;
import com.fro.order.GuardControl;
import com.fro.order.SMPSControl;
import com.fro.order.SMPSltgkControl;
import com.fro.order.SecuritySystemControl;
import com.fro.service.LabService;
import com.fro.service.LoginService;
import com.fro.service.impl.LabServiceImpl;
import com.fro.service.impl.LoginServiceImpl;

public class LabParameter {

	private static Log log=LogFactory.getLog(LabParameter.class);
	
	public String labID;
	//二期增加属性
	public String NavigateMode;
	
	public String operateTime;
	
	
	
	public String operate;
	
	//伍江 加
	public String rfid;
	public String endTime;
	
	public GuardControl doorC;
	public boolean isBetweent=false;
	
	public List<AutoSocketSendOrder> ass;
	
	private List<List<SessionParameter>>  sps;
	LabService lab=new LabServiceImpl();
	
	public void AutoNavigation(){
		ass = new ArrayList<AutoSocketSendOrder>();
		SMPSControl smpsc = new SMPSControl();
		List<byte[]> orderList;
		List<SessionParameter> sp;
		AutoSocketSendOrder as;
		DeviceInfo di;
		if(operate.equals("OPEN")||operate.equals("CLOSE")){
			try{
			sps=lab.getSPs("灯光",labID);
			orderList=new ArrayList<byte[]>();
			sp=sps.get(0);
			di=lab.getByDeviceId(sp.get(0).getSessionParameterPK().getDeviceId());
			for (SessionParameter sessionParameter : sp) {
				if(operate.equals("OPEN")){
					orderList.add(smpsc.onOrder(Integer.parseInt(sessionParameter.getSessionParameterPK().getSessionValue().trim())));
					
				}else{
					orderList.add(smpsc.offOrder(Integer.parseInt(sessionParameter.getSessionParameterPK().getSessionValue().trim())));
				}
			}
		
			as= new AutoSocketSendOrder(di.getDeviceIp(), di.getPort(), orderList);
			 ass.add(as);
			System.out.println(ass.size());
	
			}catch(Exception e){e.printStackTrace();}
			
			try{
			sps=lab.getSPs("空调",labID);
			sp=sps.get(0);
			di=lab.getByDeviceId(sp.get(0).getSessionParameterPK().getDeviceId());
			orderList=new ArrayList<byte[]>();
			for (SessionParameter sessionParameter : sp) {
				if(operate.equals("OPEN")){
					orderList.add(smpsc.onOrder(Integer.parseInt(sessionParameter.getSessionParameterPK().getSessionValue().trim())));
				}else{
					orderList.add(smpsc.offOrder(Integer.parseInt(sessionParameter.getSessionParameterPK().getSessionValue().trim())));
				}
			}
			as = new AutoSocketSendOrder(di.getDeviceIp(), di.getPort(), orderList);
			
			ass.add(as);
			}catch(Exception e){}
			
			try{
			sps=lab.getSPs("门襟",labID);
			orderList=new ArrayList<byte[]>();
			sp=sps.get(0);
			di=lab.getByDeviceId(sp.get(0).getSessionParameterPK().getDeviceId());
			ArrayList<byte[]>	orderLists=new ArrayList<byte[]>();
			for (SessionParameter sessionParameter : sp) {
				if(labID.equalsIgnoreCase("C507")){
					if(operate.equals("OPEN")){
						orderList.add(smpsc.onOrder(7));
						orderList.add(smpsc.onOrder(8));
						GuardControl smpsc2 = new GuardControl(di.getDeviceIp(), di.getPort());
					
					// 2  二期改动	
						orderLists.add(smpsc2.emergencyOrder(sessionParameter.getSessionParameterPK().getSessionValue().trim()));

					}else{
						//并取消第7 8路指示灯
						orderList.add(smpsc.offOrder(7));
						orderList.add(smpsc.offOrder(8));
						//关门时间到了后 取消紧急关门  
						GuardControl sm = new GuardControl(di.getDeviceIp(), di.getPort());
					
						// 2二期改动
						orderLists.add(sm.cancelEmergencyOrder(sessionParameter.getSessionParameterPK().getSessionValue().trim()));
						
					}
				}else{
					if(operate.equals("OPEN")){
						GuardControl smpsc2 = new GuardControl(di.getDeviceIp(), di.getPort());
					
					// 2  二期改动	
						orderLists.add(smpsc2.emergencyOrder(sessionParameter.getSessionParameterPK().getSessionValue().trim()));

					}else{
						//关门时间到了后 取消紧急关门  
						GuardControl sm = new GuardControl(di.getDeviceIp(), di.getPort());
					
						// 2二期改动
						orderLists.add(sm.cancelEmergencyOrder(sessionParameter.getSessionParameterPK().getSessionValue().trim()));
						
					}
				}
			}
			as=new AutoSocketSendOrder(di.getDeviceIp(), di.getPort(),orderLists);
			ass.add(as);
			
			// 2 二期修改   门襟发送的是灯光IP  获取灯光的IP  与 Port  即可
			
			
			DeviceInfo diM=lab.getByDeviceId(sp.get(0).getSessionParameterPK().getDeviceId());
			DeviceInfo diD=lab.getByDeviceId("灯光",diM.getLabId());
			as = new AutoSocketSendOrder(diD.getDeviceIp(), diD.getPort(), orderList);
			
			
			ass.add(as);
			}catch(Exception e){}
			
			try{
			sps=lab.getSPs("安防",labID);
			SecuritySystemControl ssc = new SecuritySystemControl();
			orderList=new ArrayList<byte[]>();
			sp=sps.get(0);
			di=lab.getByDeviceId(sp.get(0).getSessionParameterPK().getDeviceId());
			if(operate.equals("OPEN")){
				orderList.add(ssc.offOrder());
			}else{
				orderList.add(ssc.onOrder());
			}
			as = new AutoSocketSendOrder(di.getDeviceIp(), di.getPort(), orderList);
			ass.add(as);
			}catch(Exception e){}
			
			try{
			sps=lab.getSPs("继电器",labID);
			orderList=new ArrayList<byte[]>();
			SMPSltgkControl smpsltgc = new SMPSltgkControl();
			sp=sps.get(0);
			di=lab.getByDeviceId(sp.get(0).getSessionParameterPK().getDeviceId());
			for (SessionParameter sessionParameter : sp) {
				if(labID.equalsIgnoreCase("C507")){
					if(operate.equals("OPEN")){
						orderList.add(smpsltgc.offOrder(Integer.parseInt(sessionParameter.getSessionParameterPK().getSessionValue().trim())));
					}else{
						orderList.add(smpsltgc.onOrder(Integer.parseInt(sessionParameter.getSessionParameterPK().getSessionValue().trim())));
					}
					}else{
					if(operate.equals("OPEN")){
						orderList.add(smpsc.onOrder(Integer.parseInt(sessionParameter.getSessionParameterPK().getSessionValue().trim())));
					}else{
						orderList.add(smpsc.offOrder(Integer.parseInt(sessionParameter.getSessionParameterPK().getSessionValue().trim())));
					}
				}
			}
			as = new AutoSocketSendOrder(di.getDeviceIp(), di.getPort(), orderList);
			ass.add(as);
			}catch(Exception e){}
			int i = 0;
			while(i<30){
				i++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			for (AutoSocketSendOrder aso : ass) {
				if(!aso.send_flag){
					aso.run();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
			}
		}else if(operate.equals("CANCEL")){
			log.info("任务被取消");
		}else if(operate.equals("TIMER")){
			log.info("执行上传门襟权限------------------------------");
			//给相应的门襟上传用户卡号权限
			doorC=GetCuardControl.getGuardControl(labID);
			final String doorNum=lab.getDoorNumByLabId(labID);
			doorC.sendOrder(doorC.addLimit(doorNum.trim(), rfid, rfid, "1","000000",rfid));	
		
			
			//启动监听器来监听门襟的记录  并且解析门襟的最后一条记录进行匹配
			new Thread(new Runnable() {
				public void run() {
					boolean runFlag=true;
					String[] str;
					
					
					
					while(runFlag){
						log.info("循环监测是否有人刷卡-----------------"+doorNum);
						doorC=GetCuardControl.getGuardControl(labID);
						str=doorC.getCardNo(doorNum);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e2) {
						}
						boolean  isCommon=false;
						if(str.length!=1){
							isBetweent=false;
							try {
								java.util.Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(operateTime);
								java.util.Date betweenTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str[2]);
								java.util.Date end =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
								long between1=(start.getTime()-betweenTime.getTime())/60000;
								long between2=(end.getTime()-betweenTime.getTime())/60000;
								
								//还需要判断是否是管理员  1.先根据rfid查找userId   2再根据userId  判断是否是管理员组
								UserInfo u=lab.getUserInfoByRfid(str[0].trim());
								if(u!=null){
									isCommon=lab.isUserGroup2(u.getUserId());
									System.out.println("管理员操作^^^^^^^"+isCommon);
								}
	
								if(between1<0&&between2>0){
									isBetweent=true;
								}
								
							} catch (ParseException e) {
								e.printStackTrace();
							}
							
						}
						log.info(isBetweent);
						if((str.length!=1&&str[0].trim().equals(rfid.trim())&&str[1].trim().equals("8")&&isBetweent)||(isCommon&&isBetweent)){
							doWork(labID, "OPEN");
							runFlag=false; 
							log.info("刷卡有效，执行打开设备操作……立即关闭此线程");
//							ComThread.Release();
						}
						
						//如果一直没有人成功刷卡  必须在课程结束后的相应的时间内关闭此线程
						try {
							java.util.Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
							java.util.Date now_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
							long between=(end.getTime()-now_time.getTime())/60000;
							if(between<0){
								runFlag=false;
								log.info("无人刷卡，结束时间到，关闭此线程");
//								ComThread.Release();
							}

						} catch (ParseException e1) {
							e1.printStackTrace();
						}	
						
						//每执行一次查询记录 休息2s
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
						}
					}
	
				}
			}).start();
			
			
			
			

		}else if(operate.equals("CTIMER")){
			log.info( "执行CTIMER-------------------------------");
			//取消相应门襟的权限以及 删除该临时用户
			GuardControl doorC=GetCuardControl.getGuardControl(labID);
			String doorNum=lab.getDoorNumByLabId(labID);
			doorC.sendOrder(doorC.delLimit(rfid, doorNum));
			log.info("删除权限OK！！！！！！！！！！！！！！！"+rfid);
			
			LoginService  loginService=new LoginServiceImpl();
			loginService.deleteByUserIdReal(rfid);
			loginService.deleteBySql("delete from user_group where UserID='"+rfid+"' and GroupID='common'");
			loginService.deleteBySql("delete from lab_right where UserID='"+rfid+"' and LabID='"+labID+"'");

		}else if(operate.equals("WARM")){
			log.info("执行预警操作-----------------------------");
			try{
				sps=lab.getSPs("灯光",labID);
				orderList=new ArrayList<byte[]>();
				List<byte[]> closeList=new ArrayList<byte[]>();
				sp=sps.get(0);
				di=lab.getByDeviceId(sp.get(0).getSessionParameterPK().getDeviceId());
				for (SessionParameter sessionParameter : sp) {	
				orderList.add(smpsc.onOrder(Integer.parseInt(sessionParameter.getSessionParameterPK().getSessionValue().trim())));	
				closeList.add(smpsc.offOrder(Integer.parseInt(sessionParameter.getSessionParameterPK().getSessionValue().trim())));	
				}
			
				as= new AutoSocketSendOrder(di.getDeviceIp(), di.getPort(), closeList);
				ass.add(as);
				for (AutoSocketSendOrder aso : ass) {
						aso.run();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}
				}
				
				//关闭所有灯光 休眠 几秒钟--------------------------------------------------
				Thread.sleep(3000);
				
				as= new AutoSocketSendOrder(di.getDeviceIp(), di.getPort(), orderList);
				ass.add(as);
				for (AutoSocketSendOrder aso : ass) {
						aso.run();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}
				}

		
				}catch(Exception e){e.printStackTrace();}
			
		}
	}
	
	
	/**
	 * 打卡信息有效时 进行设备操作
	 */
	private void doWork(String labID, String operate) {
		LabParameter lp = new LabParameter();
		lp.labID = labID;
		lp.operate = operate;
		lp.AutoNavigation();

	}
	
	public static void main(String[] args) {
		LabParameter lp = new LabParameter();
		lp.labID = "C504";
    	lp.NavigateMode = "2";
    	lp.operateTime = "2014-01-16 10:22:00";
    	lp.endTime="2014-01-16 10:59:00";
    	lp.operate = "TIMER";//个人申请者  上传权限
    	lp.rfid="21543925";//添加个人使用时的卡号
		lp.AutoNavigation();
	}
}
