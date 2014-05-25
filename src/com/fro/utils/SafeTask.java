package com.fro.utils;

import java.util.List;

import javax.servlet.ServletContext;

import com.fro.entity.DeviceInfo;
import com.fro.service.LabService;
import com.fro.service.impl.LabServiceImpl;

public class SafeTask extends Thread { 
	     private static boolean isRunning = false; 
	   private ServletContext context;
	  
		public SafeTask(ServletContext context) { 
	        this.context = context;    
	    } 
	    public void run() {  
	        if (!isRunning)  {    
	                isRunning = true;                
	                context.log("安防主机开始");       
	                isRunning = false;
	                doTask();
	                context.log("安防主机结束");  
	            } 
	        else 
	        { 
	            context.log("上次任务还未结束");
	        } 
	    } 
	    
	    private void doTask(){ 
	    	LabService lab=new LabServiceImpl();
	    	List<DeviceInfo> deviceInfos=lab.getDeviceInfo("安防");
	    	for (DeviceInfo deviceInfo : deviceInfos) {
	    		SecuritySystemTask sst=new SecuritySystemTask(deviceInfo.getDeviceId(), deviceInfo.getDeviceIp(), deviceInfo.getPort());
	    		sst.start();
	    	}
	    	
	    	
	    
	    	
	    	
	    	
	    	
	    }
	    
	    }