package com.fro.order;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.SafeArray;
import com.jacob.com.Variant;

/*************************************************
Copyright (C), 2013, FRO Tech., Ltd.
File name: GuardControl // 文件名
Author: Chan Version: V1.0 Date: 2013-02-21 // 作者、版本及完成日期
Description: 门禁开门指令的生成，门禁状态获取，上传权限，删除权限，查询权限列表。
// 用于详细说明此程序文件完成的主要功能，与其他模块
// 或函数的接口，输出值、取值范围、含义及参数间的控
// 制、顺序、独立或依赖等关系

Others: 无// 其它内容的说明
Function List: // 主要函数列表，每条记录应包括函数名及功能简要说明
1. sendOrder
发送门禁开关指令
2、getStatus
获取门禁状态
History: // 修改历史记录列表，每条修改记录应包括修改日期、修改
// 者及修改内容简述
1. Date:
Author:
Modification:
2. ...
*************************************************/

public class GuardControl {
	
	private ActiveXComponent xl;
	private Dispatch dispatch;
	private String[] strin;
	private Socket socket;
	private InputStream socketReader;
	private OutputStream socketWriter;
	private String IP;
	private int port;
	private boolean flag_send;
	
	/*************************************************
	Function: GuardControl 
	Description: 构造函数
	*************************************************/
//	public GuardControl(){
//		 ComThread.InitSTA(); //初始化com的线程
//		 xl = new ActiveXComponent("ECardDerviceSDKMJ.pubOpterDerviceMJ");
//		 dispatch = xl.getObject();  
//		 strin = new String[101];
//		 formatArray(strin);
//		 flag_send = false;
//	}
	
	public GuardControl(String IP, int port){
		 ComThread.InitSTA(); //初始化com的线程
		 xl = new ActiveXComponent("ECardDerviceSDKMJ.pubOpterDerviceMJ");
		 dispatch = xl.getObject();  
		 strin = new String[101];
		 formatArray(strin);
		 this.IP = IP;
		 this.port = port;
		 flag_send = false;
	
	}
	
	/*************************************************
	Function: getSendFlag 
	Description: 获取sendOrder结果
	*************************************************/
	public boolean getSendFlag(){
		return flag_send;
	}
	
	/*************************************************
	Function: formatArray 
	Description: 初始化数组
	*************************************************/
	private void formatArray(String[] str){
		for(int i=0;i<str.length;i++){
			str[i] = "";
		}
	}

	/*************************************************
	Function: sendOrder 
	Description: 发送开门指令，不判断权限，直接发送开门指令
	Calls: 无
	Called By: 无
	Table Accessed: 无
	Table Updated: 无
	Input: jobNum,开门工号
	Output: 无
	Return: 无
	Others: 无
	*************************************************/
    public byte[] openOrder(String doorNum){
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		strin[0] = "01";
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","1A",doorNum,var);
    	order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
    }

	/*************************************************
	Function: getStatus 
	Description: 获取门禁状态
	Calls: 无
	Called By: 无
	Table Accessed: 无
	Table Updated: 无
	Input: 无
	Output: 无
	Return: 无
	Others: 无
	*************************************************/
    public String getStatus(){
    	return null;
    }
    
	/*************************************************
	Function: getLimit 
	Description: 获取门禁权限列表
	Calls: 无
	Called By: 无
	Table Accessed: 无
	Table Updated: 无
	Input: 无
	Output: 无
	Return: 无
	Others: 无
	*************************************************/
    public String getLimit(){
    	return null;
    }
    
	/*************************************************
	Function: addLimit 
	Description: 增加门禁权限
	Input: 
	doorNum 门序列号
	jobID 员工编号
	jobNum，权限工号
	timeNum 有效时间组
	password 密码
	name 员工姓名
	       
	Output: 无
	Return: 无
	*************************************************/
    public byte[] addLimit(String doorNum, String jobID, 
    		String jobNum, String timeNum, String password, String name){
    	
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		
		strin[0] = jobID;
		strin[1] = jobNum;
		strin[2] = "01";
		strin[3] = "2010-01-01";
		strin[4] = "2030-01-01";
		strin[5] = timeNum;
		strin[6] = password;
		strin[7] = name;
		strin[8] = "0";
		
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","1D",doorNum,var);
    	order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
    	
    }
    
	/*************************************************
	Function: delLimit 
	Description: 删除门禁权限
	Calls: 无
	Called By: 无
	Table Accessed: 无
	Table Updated: 无
	Input: jobNum，权限工号 ,doorNum,门禁序列号
	Output: 无
	Return: 无
	Others: 无
	*************************************************/
    public byte[] delLimit(String jobNum ,String doorNum){

    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		strin[0] = jobNum;
		strin[1] = "01";
		strin[2] = "0";
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","1E",doorNum,var);
    	order = stringToByte(variant.toString());
    	System.out.println(variant);
    	ComThread.Release();//释放组件资源
    	return order;
    
    }
    
	/*************************************************
	Function: delLimitAll 
	Description: 删除所有门禁权限
	Input: doorNum,门序列号
	Return: 对应指令
	*************************************************/
    public byte[] delLimitAll(String doorNum){
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","2A",doorNum,var);
    	order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
    }
    
	/*************************************************
	Function: reBoot 
	Description: 重启门禁
	Input: doorNum,门序列号
	Return: 对应指令
	*************************************************/
    public byte[] reBoot(String doorNum){
    	
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","10",doorNum,var);
    	order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
    	
    }
    
	/*************************************************
	Function: uploadTimingOfOpenDoor 
	Description: 上传定时开门时间
	Input: 周一到周日，每天三个时段，每个时段分别定义开始和结束时间，格式24小时"hh:mm"，例如"08:01"
	       str数组长度为 42 以上
	Output: 无
	Return: 定时开门时间指令
	Others: 无
	*************************************************/
    public byte[] uploadTimingOfOpenDoor(String doorNum, String[] str){
    	
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		strin[0] = "01";
		for(int i=0;i<str.length;i++){
			strin[i+1] = str[i];
		}
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","12",doorNum,var);
    	order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
    	
    }
    
	/*************************************************
	Function: uploadBaseTime 
	Description: 上传基础时间段
	Input: str数组长度16，各字段描述、取值范围如下，
	1、基础时间组编号： 2~99
	2、各时段是否限制进出各一次： 0不限制1限制
	3、时段1开始时间：如:”08:01”
	4、时段1结束时间：如:”08:01”
	5、时段2开始时间：如:”08:01”
	6、时段2结束时间：如:”08:01”
	7、时段3开始时间：如:”08:01”
	8、时段3结束时间：如:”08:01”
	9、前三组时段内通行方式：0(密码开门)1(刷卡开门)2(刷卡加密码开门)3(刷卡或密码开门)
	10、时段4开始时间：如:”08:01”
	11、时段4结束时间：如:”08:01”
	12、时段5开始时间：如:”08:01”
	13、时段5结束时间：如:”08:01”
	14、时段6开始时间：如:”08:01”
	15、时段6结束时间：如:”08:01”
	16、后三组时段内通行方式：0(密码开门)1(刷卡开门)2(刷卡加密码开门)3(刷卡或密码开门)

	Output: 无
	Return: 定时开门时间指令
	Others: 无
	*************************************************/
    public byte[] uploadBaseTime(String doorNum, String[] str){
    	
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		for(int i=0;i<str.length;i++){
			strin[i] = str[i];
		}
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","14",doorNum,var);
    	order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
    	
    }
    
	/*************************************************
	Function: uploadTimeGroup 
	Description: 上传时间组
	Input: str数组长度8，各字段描述、取值范围如下，
	1、时间组编号： 2~99
	2、周日基础时间段编号： 2~99
	3、周一基础时间段编号： 2~99
	4、周二基础时间段编号： 2~99
	5、周三基础时间段编号： 2~99
	6、周四基础时间段编号： 2~99
	7、周五基础时间段编号： 2~99
	8、周六基础时间段编号： 2~99

	Output: 无
	Return: 定时开门时间指令
	Others: 无
	*************************************************/
    public byte[] uploadTimeGroup(String doorNum, String[] str){
    	
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		for(int i=0;i<str.length;i++){
			strin[i] = str[i];
		}
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","13",doorNum,var);
    	order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
    	
    }
    
	/*************************************************
	Function: synchronizationTime 
	Description: 同步时间
	Input: 
	Output: 无
	Return: 同步时间指令
	Others: 无
	*************************************************/
    public byte[] synchronizationTime(String doorNum){
    	
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","19",doorNum,var);
    	order = stringToByte(variant.toString());
    	System.out.println(variant);
    	ComThread.Release();//释放组件资源
    	return order;
    	
    }
    
	/*************************************************
	Function: stringToByte 
	Description: String类型转化为byte[]类型，不考虑10进制到16进制的运算。
	                                  例如，"16"转化为"0x16";
	Input: in,需转换的数据
	Output: 无
	Return: 转换结果byte[]
	Others: 无
	*************************************************/
    public byte[] stringToByte(String in) {
    	
    	byte[] b = new byte[in.length()/2];
    	int j=0;
    	String strin[] = truncateString(in);
    	
    	in = "";
    	for (int i=0; i<strin.length; i++){
    		in = in + strin[i];
    	}
    	StringBuffer buf = new StringBuffer(2);
    	for (int i=0; i<in.length(); i++, j++) {
    	buf.insert(0, in.charAt(i));
    	buf.insert(1, in.charAt(i+1));
    	int t = Integer.parseInt(buf.toString(),16);
    	b[j] = (byte)t;
    	i++;
    	buf.delete(0,2);
    	}
    	return b;
    	
    }
    
	/*************************************************
	Function: byteToString 
	Description: byte[]类型转化为String类型，不考虑10进制到16进制的运算。
	                                  例如，"0x16"转化为"16";
	Input: in,需转换的数据
	Output: 无
	Return: 转换结果String
	Others: 无
	*************************************************/
    public String byteToString(byte[] in) {
    	
    	String b = "";
    	for(int i=0;i<in.length;i++){
        	b += Integer.toHexString(((in[i]) & 0x000000FF) | 0xFFFFFF00).substring(6);
    	}
    	return b;
    	
    }
    
	/*************************************************
	Function: truncateString 
	Description: 等长截取字符串，2个字符组成一个新的字符串
	Input: in,需截取的数据
	Output: 无
	Return: 转换结果String[]
	Others: 无
	*************************************************/
	public String[] truncateString(String in) {
		
		String[] str = new String[in.length()/2]; 
		for(int i=0;i<in.length()/2;i++){
			str[i] = in.substring(i*2, i*2+2);
		}
		return str;
		
	}
	
	/*************************************************
	Function: sendOrder 
	Description: 向目标IP发送指令
	Input: in,发送的指令
	Output: 改变flag_send值
	*************************************************/
	public void sendOrder(byte[] in){
		flag_send=false;
		try {
			socket = new Socket(IP,port);
			socketReader = socket.getInputStream();
			socketWriter = socket.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int flag = 0;
		 try{
			 Thread.sleep(1000);
			 socketWriter.write(in);
			 socketWriter.flush();
			 //刷新输出流，使Server马上收到该字符串
			 
			 while(socketReader.available()==0&&flag<100){
				 Thread.sleep(100);
				 flag ++;
			 }
			 byte[] readline2 = new byte[socketReader.available()];
			 if(readline2.length>10){
				 flag_send = true;
			 }
		 }catch(Exception e){
			 e.printStackTrace();
			 try{
				 socket.close(); //关闭Socket
				 socketWriter.close();
				 socketReader.close();
			 }catch (Exception e1) {
			}
		 }
	}
	
	/*************************************************
	Function: formatTime 
	Description: 格式化定时开门时间组，注意传入数组最后一个需补一个时间段，例如0,00:00,00:00，否则将丢失最后一个时间段
	Input: in,发送的指令
	Output: 改变flag_send值
	*************************************************/
	public String[] formatTime(String[][] str){
		String[] resut = new String[42];
		for(int i=0;i<resut.length;i++){
			resut[i] = "00:00";
		}
		String starttime = "";
		String endtime = "";
		int flag = 0;
		SimpleDateFormat dfs = new SimpleDateFormat("HH:mm");
		try {		
			for(int i=0;i<str.length-1;i++){
				if(str[i][0].equals("1") && flag<6){
					if(starttime.equals("")){
						starttime = str[i][1];
					}
					java.util.Date begin = dfs.parse(str[i][2]);
					java.util.Date end = dfs.parse(str[i+1][1]);
					long between=(end.getTime()-begin.getTime())/60000;	
					if(!str[i][0].equals(str[i+1][0])){//不同一天情况
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}else if(between>30){
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}
				}
				else if(str[i][0].equals("2") && flag<12){
					for(int j=flag;j<6;j++){
						resut[flag] = "00:00";
						flag = 6;
					}
					if(starttime.equals("")){
						starttime = str[i][1];
					}
					java.util.Date begin = dfs.parse(str[i][2]);
					java.util.Date end = dfs.parse(str[i+1][1]);
					long between=(end.getTime()-begin.getTime())/60000;	
					if(!str[i][0].equals(str[i+1][0])){//不同一天情况
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}else if(between>30){
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}
				}
				else if(str[i][0].equals("3") && flag<18){
					for(int j=flag;j<12;j++){
						resut[flag] = "00:00";
						flag = 12;
					}
					if(starttime.equals("")){
						starttime = str[i][1];
					}
					java.util.Date begin = dfs.parse(str[i][2]);
					java.util.Date end = dfs.parse(str[i+1][1]);
					long between=(end.getTime()-begin.getTime())/60000;	
					if(!str[i][0].equals(str[i+1][0])){//不同一天情况
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}else if(between>30){
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}
				}
				else if(str[i][0].equals("4") && flag<24){
					for(int j=flag;j<18;j++){
						resut[flag] = "00:00";
						flag = 18;
					}
					if(starttime.equals("")){
						starttime = str[i][1];
					}
					java.util.Date begin = dfs.parse(str[i][2]);
					java.util.Date end = dfs.parse(str[i+1][1]);
					long between=(end.getTime()-begin.getTime())/60000;	
					if(!str[i][0].equals(str[i+1][0])){//不同一天情况
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}else if(between>30){
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}
				}
				else if(str[i][0].equals("5") && flag<30){
					for(int j=flag;j<24;j++){
						resut[flag] = "00:00";
						flag = 24;
					}
					if(starttime.equals("")){
						starttime = str[i][1];
					}
					java.util.Date begin = dfs.parse(str[i][2]);
					java.util.Date end = dfs.parse(str[i+1][1]);
					long between=(end.getTime()-begin.getTime())/60000;	
					if(!str[i][0].equals(str[i+1][0])){//不同一天情况
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}else if(between>30){
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}
				}
				else if(str[i][0].equals("6") && flag<36){
					for(int j=flag;j<30;j++){
						resut[flag] = "00:00";
						flag = 30;
					}
					if(starttime.equals("")){
						starttime = str[i][1];
					}
					java.util.Date begin = dfs.parse(str[i][2]);
					java.util.Date end = dfs.parse(str[i+1][1]);
					long between=(end.getTime()-begin.getTime())/60000;	
					if(!str[i][0].equals(str[i+1][0])){//不同一天情况
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}else if(between>30){
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}
				}
				else if(str[i][0].equals("7") && flag<42){
					for(int j=flag;j<36;j++){
						resut[flag] = "00:00";
						flag = 36;
					}
					if(starttime.equals("")){
						starttime = str[i][1];
					}
					java.util.Date begin = dfs.parse(str[i][2]);
					java.util.Date end = dfs.parse(str[i+1][1]);
					long between=(end.getTime()-begin.getTime())/60000;	
					if(!str[i][0].equals(str[i+1][0])){//不同一天情况
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}else if(between>30){
						resut[flag] = starttime;
						resut[flag+1] = str[i][2];
						starttime = "";
						flag = flag + 2;
					}
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resut;
	}
	
	/*************************************************
	Function: emergencyOrder 
	Description: 紧急开关门指令
	Input: doorNum,门禁序列号
	Output: 无
	Return: 紧急开关门指令
	Others: 无
	*************************************************/
	public byte[] emergencyOrder(String doorNum) {
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		strin[0] = "01";
		strin[1] = "1";
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","39",doorNum,var);
    	order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
	} 
	
	/*************************************************
	Function: cancelEmergencyOrder 
	Description: 取消紧急开关门指令
	Input: doorNum,门禁序列号
	Output: 无
	Return: 取消紧急开关门指令
	Others: 无
	*************************************************/
	public byte[] cancelEmergencyOrder(String doorNum) {
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		strin[0] = "01";
		strin[1] = "3";
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","39",doorNum,var);
    	order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
	} 
	
	
	/*************************************************
	Function: initialize 
	Description: 初始化门禁
	Input: doorNum,门序列号
	Return: 对应指令
	*************************************************/
    public byte[] initialize(String doorNum){
    	
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","1F",doorNum,var);
    	order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
    	
    }
	
	
	
	/*************************************************
	Function: doorStatus 
	Description: 查询门禁状态
	Input: doorNum,门禁序列号
	Output: 无
	Return: 门禁状态结果
	Others: 无
	*************************************************/
	public String doorStatus(String doorNum) {
    	String order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","18",doorNum,var);//获取设备相关信息
    	order = variant.toString();
    	byte[] temp = stringToByte(variant.toString());
		flag_send=false;
		try {
			socket = new Socket(IP,port);
			socketReader = socket.getInputStream();
			socketWriter = socket.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return doorNum+"|lose";
		} catch (IOException e) {
			e.printStackTrace();
			return doorNum+"|lose";
		}
		int flag = 0;
		 try{
			 Thread.sleep(1000);
			 socketWriter.write(temp);
			 socketWriter.flush();
			 temp = null;
			 //刷新输出流，使Server马上收到该字符串
			 
			 while(socketReader.available()==0&&flag<100){
				 Thread.sleep(50);
				 flag ++;
			 }
			 byte[] readline2 = new byte[socketReader.available()];
			 socketReader.read(readline2);
			 if(readline2.length>10){
				 flag_send = true;
				 temp = readline2;
			 }
			 order = byteToString(temp);
			 Variant recordMax = Dispatch.call(dispatch,"MJGetCountRecordsFromRunInfo",order);//获取设备最大记录信息
		     formatArray(strin);
			 sa = new SafeArray(Variant.VariantString,101);
			 var = new Variant();
			 strin[0] = recordMax.toString();
			 sa.fromStringArray(strin);
			 var.putSafeArrayRef(sa);// Passing arrays trackback address  
			 variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","20",doorNum,var);//获取设备相关信息
		     order = variant.toString();
		     temp = stringToByte(order);
			 socketWriter.write(temp);
			 socketWriter.flush();//刷新输出流，使Server马上收到该字符串
			 temp = null;
			 flag = 0;//重置flag计算超时时间
			 while(socketReader.available()==0&&flag<100){
				 Thread.sleep(50);
				 flag ++;
			 }
			 readline2 = new byte[socketReader.available()];
			 socketReader.read(readline2);
			 if(readline2.length>10){
				 flag_send = true;
				 temp = readline2;
			 }
			 order = byteToString(temp);
			 Variant status = Dispatch.call(dispatch,"MJGetRecordStatusRunInfo34OR26",order,"0");//获取设备最大记录信息
			 order = status.toString();
		 }catch(Exception e){
			 try{
				 socket.close(); //关闭Socket
				 socketWriter.close();
				 socketReader.close();
			 }catch (Exception e1) {
			}
		 }finally{
			 try{
				 socket.close(); //关闭Socket
				 socketWriter.close();
				 socketReader.close();
			 }catch (Exception e1) {
			}
		 }
		 //根据最后结果判断状态
		 if(order.equals("0000")){
			 order = doorNum+"|off";
		 }else if(order.equals("0001")){
			 order = doorNum+"|on";
		 }else{
			 order = doorNum+"|lose";
		 }
		 ComThread.Release();//释放组件资源
    	return order;
	} 
	
	/************************************************
	获取最后一条信息  并且进行解析
	ParseSingleRecord(0):卡号或门编号
	ParseSingleRecord(1):通过标志位
	ParseSingleRecord(5)：通过类型,1:正常刷卡(不管通过未通过),2:报警(包括电脑开门、按钮开门、以及其他的扩展报警)
	
	********************************/
	public String[] getCardNo(String doorNum) {
		String[] str=new String[3];
    	String order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","18",doorNum,var);//获取设备相关信息
    	order = variant.toString();
    	byte[] temp = stringToByte(variant.toString());
		flag_send=false;
		try {
			socket = new Socket(IP,port);
			socketReader = socket.getInputStream();
			socketWriter = socket.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return str=new String[1];
		} catch (IOException e) {
			e.printStackTrace();
			return str=new String[1];
		}
		int flag = 0;
		 try{
			 Thread.sleep(1000);
			 socketWriter.write(temp);
			 socketWriter.flush();
			 temp = null;
			 //刷新输出流，使Server马上收到该字符串
			 
			 while(socketReader.available()==0&&flag<100){
				 Thread.sleep(50);
				 flag ++;
			 }
			 byte[] readline2 = new byte[socketReader.available()];
			 socketReader.read(readline2);
			 if(readline2.length>10){
				 flag_send = true;
				 temp = readline2;
			 }
			 order = byteToString(temp);
			 Variant recordMax = Dispatch.call(dispatch,"MJGetCountRecordsFromRunInfo",order);//获取设备最大记录信息
		     formatArray(strin);
			 sa = new SafeArray(Variant.VariantString,101);
			 var = new Variant();
			 strin[0] = recordMax.toString();
			 sa.fromStringArray(strin);
			 var.putSafeArrayRef(sa);// Passing arrays trackback address  
			 variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","20",doorNum,var);//获取设备相关信息
		     order = variant.toString();
		     temp = stringToByte(order);
			 socketWriter.write(temp);
			 socketWriter.flush();//刷新输出流，使Server马上收到该字符串
			 temp = null;
			 flag = 0;//重置flag计算超时时间
			 while(socketReader.available()==0&&flag<100){
				 Thread.sleep(50);
				 flag ++;
			 }
			 readline2 = new byte[socketReader.available()];
			 socketReader.read(readline2);
			 if(readline2.length>10){
				 flag_send = true;
				 temp = readline2;
			 }
			 order = byteToString(temp);
			 Variant status = Dispatch.call(dispatch,"MJGetRecordRunInfo34OR26",order,"0");//获取  最大条记录的详细信息
			 String numberStr=status.toString();
			 System.out.println("返回的"+numberStr+"----------------------------");
			 
			 String startStr=numberStr.substring(0, 7);
			 if(!startStr.equals("0000000")){
				 str[0]=numberStr.substring(0, 8);
				 str[1]=numberStr.substring(8,9);
				 str[2]=numberStr.substring(10, 14)+"-"+numberStr.substring(14,16)+"-"+numberStr.substring(16, 18)+" "+numberStr.substring(18, 20)+":"+numberStr.substring(20, 22)+":"+numberStr.substring(22, 24);
				 System.out.println(str[0]);
				 System.out.println(str[2]+"---------------------");
			 }else{
				 System.out.println("密码或是远程开门……");
					 str=new String[1];
					str[0]="密码或是远程开门……";
					return str;
			 }
			 
			 
			 
		 }catch(Exception e){
			 try{
				 socket.close(); //关闭Socket
				 socketWriter.close();
				 socketReader.close();
			 }catch (Exception e1) {
			}
		 }finally{
			 try{
				 socket.close(); //关闭Socket
				 socketWriter.close();
				 socketReader.close();
			 }catch (Exception e1) {
			}
		 }
		 
		 ComThread.Release();//释放组件资源
    	return str;
	} 
	
	
	
	
	
	
	
	
	
	
	/*************************************************
	Function: modifyPassword 
	Description: 修改门禁密码
	Input: doorNum,门禁序列号；password，密码
	Output: 无
	Return: 指令
	Others: 无
	*************************************************/
	public byte[] modifyPassword(String doorNum,String password){
    	byte[] order = null;
    	formatArray(strin);
		SafeArray sa = new SafeArray(Variant.VariantString,101);
		Variant var = new Variant();
		strin[0] = password;
		sa.fromStringArray(strin);
		var.putSafeArrayRef(sa);// Passing arrays trackback address  
		Variant variant = Dispatch.call(dispatch,"CreateBstrFuncDataByArray","25",doorNum,var);
    	System.out.println(variant.toString());
		order = stringToByte(variant.toString());
    	ComThread.Release();//释放组件资源
    	return order;
	}
	
	
	/**********test**********/
	public static void main(String[] args) {
		
//		System.out.println(System.getProperty("java.library.path"));
//		String[] str = new String[42];
//		for(int i=0;i<42;i++){
//			str[i] = "00:00";
//		}
//		str[0] = "08:00";
//		str[1] = "12:00";
//		GuardControl gc = new GuardControl("192.168.0.11",4001);
//		byte[] b = gc.uploadTimingOfOpenDoor("0144596",str);
//		gc.sendOrder(b);
//		System.out.println("OK");
//		System.out.println(gc.getSendFlag());
		/*********时间测试*****************
		SimpleDateFormat dfs = new SimpleDateFormat("HH:mm");
		try {
			java.util.Date begin=dfs.parse("11:30");
			java.util.Date end = dfs.parse("10:31");
			long between=(end.getTime()-begin.getTime())/60000;
			System.out.println(between);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[][] strd = new String[][]{{"1","08:00","09:00"},{"1","09:10","10:00"},{"1","13:10","15:00"},{"2","13:10","15:00"},{"3","13:10","15:00"},{"3","16:10","19:00"},{"0","00:00","00:00"},{"0","00:00","00:00"},{"0","00:00","00:00"},{"0","00:00","00:00"},{"0","00:00","00:00"}};
		GuardControl gc = new GuardControl();
		String[] result = gc.formatTime(strd);
		System.out.println("OK");
		***************************************/
		
		GuardControl doorC = new GuardControl("192.168.0.111",4001);
	//	System.out.println(gc.modifyPassword("0151917","123456"));
	//	doorC.sendOrder(doorC.addLimit("0151917", "2392482622", "2392482622", "1","000000","dd"));
		//doorC.getCardNo("0147886");

		
//		gc.sendOrder(gc.cancelEmergencyOrder("0151917"));
	//	System.out.println(gc.flag_send);
//		String str = gc.doorStatus("0144596");
//		System.out.println(str);
		doorC.sendOrder(doorC.cancelEmergencyOrder("0147886"));

	}
}
