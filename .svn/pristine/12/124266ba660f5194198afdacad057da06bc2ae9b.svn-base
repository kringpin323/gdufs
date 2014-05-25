package com.fro.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fro.utils.MyTask;
import com.fro.utils.SafeTask;
import com.fro.utils.TimerTaskList;

public class ContextListener implements ServletContextListener {    

    private java.util.Timer timer = null; 
    
    public void contextInitialized(ServletContextEvent event) { 
      timer = new java.util.Timer(true); 
      event.getServletContext().log("启动定时器");        
      //定时执行任务 
      
      //启动安防主机监控
      new SafeTask(event.getServletContext()).start();
      //启动 自动导航模式
      new TimerTaskList().start();
      
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      Date date=new Date();
      String timeStr=sdf.format(date)+" 23:58:59";
      sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     try {
		java.util.Date cdate=sdf.parse(timeStr);
	
		timer.schedule(new MyTask(event.getServletContext()), cdate, 24*60*60*1000); 
		
		
	} catch (ParseException e) {
		e.printStackTrace();
	}
      
      
     
    } 

    public void contextDestroyed(ServletContextEvent event) { 
       timer.cancel(); 
        event.getServletContext().log("停止定时器"); 
    } 
} 

