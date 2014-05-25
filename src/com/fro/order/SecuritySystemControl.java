package com.fro.order;
/**
Copyright (C), 2013, FRO Tech., Ltd.
File name: ByteStringConvert 
Author: Chan Version: V1.0 Date: 2013-03-13 // 作者、版本及完成日期
Description: 安防主机指令解析。

Others: 无// 其它内容的说明
Function List: // 主要函数列表，每条记录应包括函数名及功能简要说明
1. onOrder
布防指令
2、offOrder
撤防指令
3、checkOrder
查询状态指令
4、getStatus
解析返回数据
5、getStr
byte转String

History: // 修改历史记录列表，每条修改记录应包括修改日期、修改
// 者及修改内容简述
1. Date:
Author:
Modification:
2. ...
*/
public class SecuritySystemControl {

	/*************************************************
	Function: onOrder 
	Description: 布防
	Return: 布防指令
	*************************************************/
	public byte[] onOrder(){
		byte[] order = {0x58, 0x44, 0x02, 0x41};
		return order;
	}
	
	/*************************************************
	Function: offOrder 
	Description: 撤防
	Return: 撤防指令
	*************************************************/
	public byte[] offOrder(){
		byte[] order = {0x58, 0x44, 0x02, 0x44};
		return order;
	}
	
	/*************************************************
	Function: checkOrder 
	Description: 查询状态
	Return: 查询状态指令
	*************************************************/
	public byte[] checkOrder(){
		byte[] order = {0x58, 0x44, 0x02, 0x49};
		return order;
	}
	
	/*************************************************
	Function: getStatus 
	Description: 返回状态
	Return: 返回状态
	*************************************************/
	public String getStatus(byte[] b){

		int length_ = b.length;
		System.out.println(length_);
		String result = "";
		String str = "";
		String temp = "";
		for (int i = 0; i < length_ - 3; i++) {
			temp = getStr(b[i]) + getStr(b[i + 1]);
			System.out.println(temp);
			if (temp.equalsIgnoreCase("5844")) {//判断安防主机状态
				if (length_ - i > 3) {
					str = getStr(b[i+3]);
					if(str.equals("41")){//安防主机已布防
						result += "securitySystem|on,";
					}
					else if(str.equals("44")){//安防主机已撤防
						result += "securitySystem|off,";
					}
					i = i + 4;
				}
			} else if (temp.equalsIgnoreCase("5a4a")) {//判断传感器状态
				if (length_ - i > 5) {
					result += "sensor|" + Integer.toString(b[i + 3],10)+",";
					i = i + 6;
				}else if (length_==4 ) {
					str = getStr(b[i+3]);
					if(str.equals("41")){//安防主机已布防
						result += "securitySystem|on,";
					}
					else if(str.equals("44")){//安防主机已撤防
						result += "securitySystem|off,";
					}
					i = i + 4;
				}
			}
		}
		return result.substring(0, result.length()-1);
	}
	
	/*************************************************
	Function: getStr 
	Description: byte转string
	Return: string
	*************************************************/
	private String getStr(byte retval1) {
		String str = null;
		str = (Integer.toHexString(((retval1) & 0x000000FF) | 0xFFFFFF00)
				.substring(6));
		return str;
	}
	
	/**************test***********/
	public static void main(String[] args) {
		SecuritySystemControl ssc = new SecuritySystemControl();
		byte[] b = {0x58, 0x44, 0x02, 0x41, 0x00, 0x5a, 0x4a, 0x04, 0x1e, 0x01, 0x09, 0x00, 0x5a, 0x4a, 0x04, 0x07, 0x01, 0x09};
		System.out.println(ssc.getStatus(b));
	}
}
