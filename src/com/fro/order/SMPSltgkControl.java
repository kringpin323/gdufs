package com.fro.order;

/*************************************************
Copyright (C), 2013, FRO Tech., Ltd.
File name: SMPSltgkControl 
Author: Chan Version: V1.0 Date: 2013-02-21
Description: 龙腾高科专用电源开关控制，包括电源开关指令、状态查询指令。

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

public class SMPSltgkControl {
	
	/*************************************************
	Function: onOrder 
	Description: 打开指定电路指令
	Input: link,指定电路
	Return: 打开指令
	*************************************************/
	public byte[] onOrder(int link){
		byte[] b;
		switch(link){
			case 1 : b = new byte[]{0x55, 0x01, 0x01, 0x02, 0x00, 0x00, 0x00, 0x59};break;
			case 2 : b = new byte[]{0x55, 0x01, 0x01, 0x00, 0x02, 0x00, 0x00, 0x59};break;
			case 3 : b = new byte[]{0x55, 0x01, 0x01, 0x00, 0x00, 0x02, 0x00, 0x59};break;
			case 4 : b = new byte[]{0x55, 0x01, 0x01, 0x00, 0x00, 0x00, 0x02, 0x59};break;
			default: b = null;break;
		}
		return b;
	}
	
	/*************************************************
	Function: onOrderAll 
	Description: 生成打开所有电路指令
	Input: 无
	Return: 打开所有电路指令
	*************************************************/
	public byte[] onOrderAll(){
		byte[] b = {0x55, 0x01, 0x01, 0x02, 0x02, 0x02, 0x02, 0x5F};
		return b;
	}
	
	/*************************************************
	Function: offOrder 
	Description: 关闭指定电路指令
	Input: link,指定电路
	Return: 关闭指令
	*************************************************/
	public byte[] offOrder(int link){
		byte[] b;
		switch(link){
			case 1 : b = new byte[]{0x55, 0x01, 0x01, 0x01, 0x00, 0x00, 0x00, 0x58};break;
			case 2 : b = new byte[]{0x55, 0x01, 0x01, 0x00, 0x01, 0x00, 0x00, 0x58};break;
			case 3 : b = new byte[]{0x55, 0x01, 0x01, 0x00, 0x00, 0x01, 0x00, 0x58};break;
			case 4 : b = new byte[]{0x55, 0x01, 0x01, 0x00, 0x00, 0x00, 0x01, 0x58};break;
			default: b = null;break;
		}
		return b;
	}
	
	/*************************************************
	Function: offOrderAll 
	Description: 生成关闭所有电路指令
	Input: 无
	Return: 关闭所有电路指令
	*************************************************/
	public byte[] offOrderAll(){
		byte[] b = {0x55, 0x01, 0x01, 0x01, 0x01, 0x01, 0x01, 0x5B};
		return b;
	}
	
	/*************************************************
	Function: statusOrder 
	Description: 生成查询电路状态指令
	Input: 无
	Return: 查询电路状态指令
	*************************************************/
	public byte[] statusOrder(){
		byte[] b = new byte[]{0x55, 0x01, 0x01, 0x00, 0x00, 0x00, 0x00, 0x57};
		return b;
	}
	
	/*************************************************
	Function: statusOrder 
	Description: 电路状态数据解析
	Input: 无
	Return: 电路状态数据
	*************************************************/
	public String getStatusResult(byte[] b){
		String result = "";
		if(b.length == 8){
			for(int i=0;i<4;i++){
				if(Integer.toHexString(((b[i+3]) & 0x000000FF) | 0xFFFFFF00).substring(6).equals("01")){
					result = result + (i+1) + "|off,";
				}
				else if(Integer.toHexString(((b[i+3]) & 0x000000FF) | 0xFFFFFF00).substring(6).equals("02")){
					result = result + (i+1) + "|on,";
				}
			}
		}
		return result.substring(0, result.length()-1);
	}
	
    /***************test****************/	
	public static void main(String[] args) {
		byte[] b = new byte[]{0x55, 0x01, 0x01, 0x01, 0x02, 0x01, 0x02, 0x57};
		SMPSltgkControl smp = new SMPSltgkControl();
		System.out.println(smp.getStatusResult(b));
	}
}
