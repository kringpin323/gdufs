package com.fro.utils;

import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.fro.dao.LoginDao;
import com.fro.dao.impl.LoginDaoImpl;
import com.fro.entity.LabInfo;
import com.fro.service.LoginService;
import com.fro.service.impl.LoginServiceImpl;

public class MyTask extends TimerTask { 
	     private boolean isRunning = false; 
	   private ServletContext context;
	  
		public MyTask(ServletContext context) { 
	        this.context = context;    
	    } 
	    public void run() {  
	        if (!isRunning)  {    
	                isRunning = true;                
	                context.log("开始执行任务");       
	                isRunning = false;
	                doTask();
	                context.log("任务执行结束");  
	            } 
	        else 
	        { 
	            context.log("上次任务还未结束");
	        } 
	    } 
	    
	    private void doTask(){ 
			
			//  每天晚上12：00自动进入自动导航模式
	    	
	    	// 2  二期更改  对所有实验室进行遍历  都将改为自动导航模式  2
			LoginDao loginDao=new LoginDaoImpl();
			List<LabInfo> labs=	loginDao.getLabInfo();
			LoginService loginService=new LoginServiceImpl();
			for (LabInfo l : labs) {
				loginService.updLabInfoRun(l.getLabId(),"2");
				
				//不管什么模式 都关闭所有的设备
				String beginDate=loginDao.getBeginDateByCurseClass(l.getLabId());
				if(!beginDate.equalsIgnoreCase("notNull")){
					
						LabParameter labParameter=new LabParameter();
						labParameter.labID=l.getLabId();					
						
						labParameter.operate="CLOSE";
						labParameter.AutoNavigation();
		
				}
				
		
			}
			
	    }
	    
	    }