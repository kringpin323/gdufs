package com.fro.order;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*************************************************
Copyright (C), 2013, FRO Tech., Ltd.
File name: GetTempratureNQJ // 文件名
Author: Chan Version: V1.0 Date: 2013-04-8 // 作者、版本及完成日期
Description: 温湿度传感器数据获取，包括socket连接建立，发送指令，解析数据功能。

Others: 无
Function List: 
1. getData
获取温湿度返回数据
2、reformat
格式化返回的数据
3、getForTemperature
将返回的结果byte[]转化为字符串
History: 无
// 者及修改内容简述
1. Date:
Author:
Modification:
2. ...
*************************************************/

public class GetTempratureNQJ{

	 private Socket socket;
	 private InputStream socketReader;
	 private OutputStream socketWriter;
	 
		/*************************************************
		Function: getData 
		Description: 分别发送温湿度获取指令，先发送温度、再发送温度，
		                                  然后根据返回结果，把数据连接，再按位数截取温湿度。
		Input: IP,Port
		Output: 无
		Return: 温度、湿度
		Others: 无
		*************************************************/
	 public String getData(String IP,String port){
		 String result = "";
			try {
				socket = new Socket(IP,Integer.parseInt(port));
				socketReader = socket.getInputStream();
				socketWriter = socket.getOutputStream();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 int flag = 0;
			 //温度指令
			 byte[] b = new byte[8]; 
			 b[0] =(byte)0x01;
			 b[1] =(byte)0x04;
			 b[2] =(byte)0x00;
			 b[3] =(byte)0x00;
			 b[4] =(byte)0x00;
			 b[5] =(byte)0x01;
			 b[6] =(byte)0x31;
			 b[7] =(byte)0xca;
			 
			 //温度指令
			 byte[] b2 = new byte[8]; 
			 b2[0] =(byte)0x01;
			 b2[1] =(byte)0x04;
			 b2[2] =(byte)0x00;
			 b2[3] =(byte)0x01;
			 b2[4] =(byte)0x00;
			 b2[5] =(byte)0x01;
			 b2[6] =(byte)0x60;
			 b2[7] =(byte)0x0a;
			 try{
			 socketWriter.write(b);
			 socketWriter.flush();
			 //刷新输出流，使Server马上收到该字符串
			 
			 while(socketReader.available()==0&&flag<100){
				 Thread.sleep(100);
				 flag ++;
			 };
			 flag = 0;
			 byte[] readline = new byte[socketReader.available()];
			 socketReader.read(readline);
			 byte [] bb = reformat(readline);
			 
			 socketWriter.write(b2);
			 socketWriter.flush();
			 //刷新输出流，使Server马上收到该字符串
			 
			 while(socketReader.available()==0&&flag<100){
				 Thread.sleep(100);
				 flag ++;
			 };
			 flag = 0;
			 byte[] readline2 = new byte[socketReader.available()];
			 socketReader.read(readline2);
			 byte [] bb2 = reformat(readline2);
			 
			 
			 if(bb.length>0&&bb2.length>0){
				 byte [] bb3 = new byte[]{bb[0],bb[1],bb[2],bb[3],bb[4],bb2[3],bb2[4],bb2[5],bb2[6]};
				 result = getForTemperature(bb3,3,4,1) + "," + getForTemperature(bb3,5,6,1);
			 }
			 else{
				 result = "连接失败,连接失败";
			 }
			 }catch(Exception e){
				 try{
					 socket.close(); //关闭Socket
					 socketWriter.close();
					 socketReader.close();
				 }catch (Exception e1) {
				}
			 }
			 
			 try{
				 socket.close(); //关闭Socket
				 socketWriter.close();
				 socketReader.close();
			 }catch (Exception e1) {}
			 
			 return result;
		}

		/*************************************************
		Function: reformat 
		Description: 格式化返回数据
		Input: 无
		Output: 无
		Return: 温度、湿度
		Others: 无
		*************************************************/
	public byte[] reformat(byte[] b){
		byte[] c = new byte[9];
		byte cc=(byte)0xff;
		if(b.length>9){
			for(int i=0;i<b.length;i++){
				if(!Integer.toHexString(((b[i]) & 0x000000FF) | 0xFFFFFF00).substring(6).equals(Integer.toHexString(((cc) & 0x000000FF) | 0xFFFFFF00).substring(6))&&b.length-i>=9){
					for(int j = 0;j<9;j++){
						c[j]=b[i+j];
						System.out.println(Integer.toHexString(((c[j]) & 0x000000FF) | 0xFFFFFF00).substring(6));

					}
					String str1="";
					for(int j=0;j<c.length-2;j++){
						str1=str1+(""+Integer.toHexString(((c[j]) & 0x000000FF) | 0xFFFFFF00).substring(6));
					}
					byte[] sbuf = CRC16M.getSendBuf(str1);
					str1=CRC16M.getBufHexStr(sbuf).substring(CRC16M.getBufHexStr(sbuf).length()-4, CRC16M.getBufHexStr(sbuf).length());
					String str2="";
					for(int j=0;j<2;j++){
						str2=str2+(""+Integer.toHexString(((c[c.length-2+j]) & 0x000000FF) | 0xFFFFFF00).substring(6));
					}
					if(str2.equalsIgnoreCase(str1)){
					break;
					}
				}
				
			}
		}else{
			c=b;
		}
		return c;
	}
	
	/*************************************************
	Function: getForTemperature 
	Description: 解析返回数据，并返回String类型结果
	Input: 无
	Output: 无
	Return: 温度、湿度
	Others: 无
	*************************************************/
	public String getForTemperature(byte[] retval2,int start,int end,int flag){//读取测量温度flag设置为1,读取预设温度flag设置为0
		byte[] retval1=reformat(retval2);
		String str=null;
	    str=(Integer.toHexString(((retval1[start]) & 0x000000FF) | 0xFFFFFF00).substring(6))+(Integer.toHexString(((retval1[end]) & 0x000000FF) | 0xFFFFFF00).substring(6));
		java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance();   
	    nf.setMinimumFractionDigits(2);
	    str=String.valueOf(nf.format(Integer.parseInt(str, 16)));
	    for(int i=0;i<str.length();i++){
	    	if(str.substring(i, i+1).equals(",")){
	    		str=str.substring(0, i)+str.substring(i+1,str.length());
	    	}
	    }
	    Double db=Double.parseDouble(str);
	    if(flag==1){
	    db=db/10;
	    }
	    if(flag==2){
	        db=db/100;
	        }
	    if(flag==3){
	    	db=db/1000;
	    }
	    str=String.valueOf(nf.format(db));
		return str;
	}
}
