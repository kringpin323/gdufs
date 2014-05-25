package com.fro.utils;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

public class AutoSocketSendOrder {

	public String IP;
	public int Port;
	public List<byte[]> order;
	public boolean send_flag;
	
	public AutoSocketSendOrder(String IP, int Port, List<byte[]> order){
		this.IP = IP;
		this.Port = Port;
		this.order = order;
		this.send_flag = false;

	}
	
	public void run(){
		
			InetAddress addremote = null;
			SocketAddress remoteAddr = null;
			Socket sk = null;
			DataOutputStream dos = null;
			try{
			addremote = InetAddress.getByName(IP);
			remoteAddr = new InetSocketAddress(addremote,Port);
			sk = new Socket();
			sk.connect(remoteAddr, 3000);
			dos = new DataOutputStream(new BufferedOutputStream(sk.getOutputStream()));
			Thread.sleep(1000);
			for (byte[] b : order) {
				dos.write(b, 0, b.length);
				dos.flush();
				Thread.sleep(1000);
			}
			send_flag = true;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
				dos.close();
				sk.close();
				}catch(Exception e){}
			}
			
	}
}
