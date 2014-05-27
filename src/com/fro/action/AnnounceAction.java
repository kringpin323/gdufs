package com.fro.action;

import com.fro.entity.Announce;
//import java.io.PrintWriter;
import com.fro.service.impl.AnnounceServiceImpl;
import com.fro.service.AnnounceService;
import java.sql.Timestamp;
import java.util.Date;

public class AnnounceAction extends BaseAction{

	private Announce announces;
	private AnnounceService announceServiceImpl = new AnnounceServiceImpl();
	
	public Announce getAnnounces()
	{
		return announces;
	}
	
	public void setAnnounces(Announce announces){
		this.announces = announces;
	}
	
	public String toAddAnnounce(){
		return "toAddAnnounce";
	}
	
	public String toDelAnnounce(){
		return "toDelAnnounce";
	}
	
	public String toCheckAnnounce(){
		return "toCheckAnnounce";
	}
	
	public String checkAnnounce(){
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("AnnounceAction.checkAnnounce('1')");
		announces = announceServiceImpl.checkAnnounce("1");
		System.out.println("AnnounceAction.checkAnnounce.finish!");
		
		if(announces != null)
			return "SUCCESS";
		else
			return "NULL";
		
	}
	
	public String addAnnounce() throws Exception{

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
		announces.setAnnounce_id("12");
		announces.setAuthor("kingpin");
//		Date temDate = new Date();
//		new Date().getTime()
		announces.setTime(new Timestamp(new Date().getTime()).toString());
		boolean resultBool = announceServiceImpl.addAnnounce(announces);
		if(resultBool == true)
			return "addSuccess";
		else
			return "addFail";
	}
}
