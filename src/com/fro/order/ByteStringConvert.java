package com.fro.order;
/**
Copyright (C), 2013, FRO Tech., Ltd.
File name: ByteStringConvert 
Author: Chan Version: V1.0 Date: 2013-02-21 // 作者、版本及完成日期
Description: byte类型和String类型互换,ASCII码。

Others: 无// 其它内容的说明
Function List: // 主要函数列表，每条记录应包括函数名及功能简要说明
1. byteToString
byte转换成String
2、stringToByte
String 转换成 byte

History: // 修改历史记录列表，每条修改记录应包括修改日期、修改
// 者及修改内容简述
1. Date:
Author:
Modification:
2. ...
*/
public class ByteStringConvert {

	public String byteToString(byte[] b){
		return new String(b);
	}
	
	public byte[] stringToByte(String s){
		return s.getBytes();
	}
}
