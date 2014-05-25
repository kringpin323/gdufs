package com.fro.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;

import com.fro.order.SecuritySystemControl;

/**
Copyright (C), 2013, FRO Tech., Ltd.
File name: SecuritySystemTask 
Author: Chan Version: V1.0 Date: 2013-05-11 // 作者、版本及完成日期
Description: 安防主机实时监控，Tomcat启动时启动。

History: 
1. Date:
Author:
Modification:
2. ...
*/
public class SecuritySystemTask extends Thread{
	
	private int DeviceID;
	private String IP;
	private int port;
	private Socket sk;
	private DataInputStream dis;
	private DataOutputStream dos;
	public boolean close;//关闭socket
	private boolean connect_flag;//判断连接是否存在
	private SecuritySystemControl ss;
	
	public SecuritySystemTask(int DeviceID, String IP, int port){
		this.DeviceID = DeviceID;
		this.IP = IP;
		this.port = port;
		this.close = false;
		this.ss = new SecuritySystemControl();
	}
	
	public void run(){

		while (!close) {
			try {
				InetAddress addremote = InetAddress.getByName(IP);
				SocketAddress remoteAddr = new InetSocketAddress(addremote,port);
				sk = new Socket();
				sk.connect(remoteAddr, 0);
				dis = new DataInputStream(new BufferedInputStream(sk.getInputStream()));
				dos = new DataOutputStream(new BufferedOutputStream(sk.getOutputStream()));
				connect_flag = false;
				while (!close) {
					byte[] tMark = null;
					/*
					 * 在线监听，如遇断线，立即重新发起连接
					 * */
					new Thread(new Runnable() {
						public void run() {
							while (!close) {
								try {
									Thread.sleep(3000);
									sk.sendUrgentData(0xFF);
								} catch (Exception e) {
									connect_flag = true;
									try {
										dis.close();
										sk.close();
										dos.close();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
									break;
								}
							}
						}
					}).start();
					int socket_check = 0;
					while (0 == dis.available() && socket_check<60) {
						if (!close) {
							try {
								Thread.sleep(50);
								if (connect_flag) {
									break;
								}
							} catch (InterruptedException e) {
							}
						}
					}
					if (connect_flag) {
						break;
					}
					tMark = new byte[dis.available()];
					dis.read(tMark);
					if(tMark.length>3){
						try{
						String result = ss.getStatus(tMark);
						String[] sp_result = result.split(",");
						for(int i=0;i<sp_result.length;i++){
							String[] get_result = sp_result[i].split("\\|");
							try{
								if(get_result[0].equals("sensor")){
									
									Timestamp d=new Timestamp(new Date().getTime());
									insertRecord(DeviceID, get_result[1], d);
								}
							}catch(Exception e){}
						}
						}catch(Exception e){}
					}
				}
			} catch (UnknownHostException e) {
				connect_flag = true;
			} catch (IOException e) {
			}
		}
	
	}
	
	/**
	 * 记录报警日志
	 * */
	public void insertRecord(int DeviceID, String SessionValue, Timestamp OperateTime){
		Session session =HibernateUtils.getSession();
		String sql="insert into dbo.session_log(DeviceID,SessionValue,OperateTime) values("+DeviceID+",'"+SessionValue+"','"+OperateTime+"')";
		System.out.println(sql);
		session.createSQLQuery(sql).executeUpdate();
		session.beginTransaction().commit();
		HibernateUtils.close();
	}
	
	
	/**
	 * test,使用方法
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecuritySystemTask ss = new SecuritySystemTask(11,"192.168.0.11",4001);
		ss.start();
	}

}
