package com.fro.order;


/*************************************************
Copyright (C), 2013, FRO Tech., Ltd.
File name: SMPSControl 
Author: Chan Version: V1.0 Date: 2013-02-21
Description: 电源开关控制，包括电源开关指令、查询面板按键锁定状态指令、
                                   面板按键锁定与解锁指令、状态查询指令。

Others: 无// 其它内容的说明
Function List: // 主要函数列表，每条记录应包括函数名及功能简要说明
1. onOrder
电源开指令
2、offOrder
电源关指令
History: // 修改历史记录列表，每条修改记录应包括修改日期、修改
// 者及修改内容简述
1. Date:
Author:
Modification:
2. ...
*************************************************/
public class SMPSControl {
	
	ByteStringConvert bsc = new ByteStringConvert();/*byte String 互转*/
	
	/*************************************************
	Function: onOrder 
	Description: 打开指定电路指令
	Input: link,指定电路
	Return: 打开指令
	*************************************************/
	public byte[] onOrder(int link){
		String order = "[001O" + link + "T0]";
		byte[] getorder = bsc.stringToByte(order);
		return getorder;
	}
	
	/*************************************************
	Function: onOrderAll 
	Description: 打开全部电路指令
	Input: 无
	Return: 打开全部电路指令
	*************************************************/
	public byte[] onOrderAll(){
		String order = "[001O12345678T0]";
		byte[] getorder = bsc.stringToByte(order);
		return getorder;
	}
	
	/*************************************************
	Function: offOrder 
	Description: 关闭指定电路指令
	Input: link,指定电路
	Return: 关闭指令
	*************************************************/
	public byte[] offOrder(int link){
		String order = "[001C" + link + "T0]";
		byte[] getorder = bsc.stringToByte(order);
		return getorder;
	}
	
	/*************************************************
	Function: offOrderAll 
	Description: 关闭全部电路指令
	Input: 无
	Return: 关闭全部电路指令
	*************************************************/
	public byte[] offOrderAll(){
		String order = "[001C12345678T0]";
		byte[] getorder = bsc.stringToByte(order);
		return getorder;
	}
	
	/*************************************************
	Function: statusOrder 
	Description: 生成查询电路状态指令
	Input: 无
	Return: 查询电路状态指令
	*************************************************/
	public byte[] statusOrder(){
		String order = "[001QCS]";
		byte[] getorder = bsc.stringToByte(order);
		return getorder;
	}
	
	/*************************************************
	Function: buttonstatusOrder 
	Description: 生成查询面板按钮状态指令
	Input: 无
	Return: 查询面板按钮状态指令
	*************************************************/
	public byte[] buttonstatusOrder(){
		String order = "[dddQKS]";
		byte[] getorder = bsc.stringToByte(order);
		return getorder;
	}
	
	/*************************************************
	Function: statusOrder 
	Description: 电路状态数据解析
	other:长度11，单个开或关，例如[001-T0-O1]
	         12，面板锁定与解锁，例如[ddd-LCKKEY]
	         14，电路开关状态查询，例如[ddd-ssssssss]
	         13，15，查询面板锁定或关闭状态
	         18，所有电路的开或关，例如[001-T0-C12345678]
	Input: byte
	Return: 电路状态数据
	*************************************************/
	public String getStatusResult(byte[] b){
	String	froData = new String(b);
	int n=0;
	for(int i=0;i<froData.length();i++){
		char m=froData.charAt(i);
		if(m=="[".toCharArray()[0]){
			n=i;
		}
		if(m=="]".toCharArray()[0]){
			froData = froData.substring(n, i+1);
			System.out.println(froData);
			System.out.println("ddddddddd");;
		}
		
	}
	
	
		String str = new String(froData);
		String result = "";
		if(str.length() == 11){
			if(str.substring(str.length()-3, str.length()-2).equalsIgnoreCase("C")){
				result = str.substring(str.length()-2, str.length()-1) + "|off,";
			}else if(str.substring(str.length()-3, str.length()-2).equalsIgnoreCase("O")){
				result = str.substring(str.length()-2, str.length()-1) + "|on,";
			}
		}else if(str.length() == 12){
			if(str.substring(str.length()-7, str.length()-1).equalsIgnoreCase("LCKKEY")){
				result = "button|off,";
			}else if(str.substring(str.length()-7, str.length()-1).equalsIgnoreCase("UNLKEY")){
				result = "button|on,";
			}
		}else if(str.length() == 14){
			for(int i=0;i<8;i++){
				if(str.substring(i+5,i+6).equalsIgnoreCase("C")){
					result = result + (i + 1) + "|off,";
				}else if(str.substring(i+5,i+6).equalsIgnoreCase("O")){
					result = result + (i + 1) + "|on,";
				}
			}
		}else if(str.length() == 18){
			if(str.substring(8, 9).equalsIgnoreCase("C")){
				for(int i=1;i<9;i++){
					result = result + i + "|off,";
				}
			}else if(str.substring(8, 9).equalsIgnoreCase("O")){
				for(int i=1;i<9;i++){
					result = result + i + "|on,";
				}
			}
		}else if(str.length() == 13){
			result = "button|off,";
		}else if(str.length() == 15){
			result = "button|on,";
		}
		return result.substring(0, result.length()-1);
	}
}
