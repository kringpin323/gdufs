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

public class Hand_terminal {
	public boolean close = false;
	private boolean flag;
	public Socket soc;
	public boolean allowcheck = true;
	public DataOutputStream dos;
	public DataInputStream dis;
	public CommonEntity commonEntity;

	public void connect_handTerminal(String IP, int port) {
		while (!close) {
			try {
				Thread.sleep(500);
				InetAddress addremote = InetAddress.getByName(IP);
				SocketAddress remoteAddr = new InetSocketAddress(addremote, port);
				try {
					soc = new Socket();
					soc.connect(remoteAddr, 5000);
					flag = false;
					byte[] retval1 = new byte[0];
					try {
						dos = new DataOutputStream(new BufferedOutputStream(soc
								.getOutputStream()));
						dis = new DataInputStream(new BufferedInputStream(
								soc.getInputStream()));
						
						new Thread(new Runnable() {
							public void run() {
								while (!close) {
									try {
										Thread.sleep(10000);
										if(allowcheck){
											byte[] b = {0x00,0x00};
											dos.write(b,0,b.length);
											dos.flush();
//										soc.sendUrgentData(0xFF);
										}
									} catch (Exception e) {
										flag = true;
										break;
									}
								}
								System.out.println("断开");
							}
						}).start();
						
						
						while (!close) {
							try {
								while (0 == dis.available()) {
									if (!close) {
										try {
											Thread.sleep(50);
											if (flag) {
												break;
											}
										} catch (InterruptedException e) {
										}
									}
								}
								if (flag) {
									break;
								}
								try {
									retval1 = new byte[dis.available()];
								} catch (IOException e) {
									break;
								}
								try {
									dis.read(retval1);
								} catch (IOException e) {
									break;
								}
						//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!判断此卡号是否拥有权限
								System.out.println("读取到的卡号为"+new String(retval1));
								String cardNo=new String(retval1);
								
								
							} catch (Exception e1) {
								e1.printStackTrace();
								break;
							}
						}
						dos.close();
						soc.close();// 关闭socket和输入输出流
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					flag = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
	}

	
	

}
