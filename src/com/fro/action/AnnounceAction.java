package com.fro.action;

import com.fro.entity.announce;
//import java.io.PrintWriter;
import com.fro.service.impl.AnnounceServiceImpl;
import java.sql.Timestamp;
import java.util.Date;

public class AnnounceAction extends BaseAction{

	private announce announces;
	private AnnounceServiceImpl announceServiceImpl = new AnnounceServiceImpl();
	
	public announce getAnnounces()
	{
		return announces;
	}
	
	public void setAnnounces(announce announces){
		this.announces = announces;
	}
	
	public String toAddAnnounce(){
		return "addAnnounce";
	}
	
	public String toDelAnnounce(){
		return "delAnnounce";
	}
	
	public String toCheckAnnounce(){
		return "checkAnnounce";
	}
	
	public String addAnnounce() throws Exception{

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
		announces.setAnnonce_id("12");
		announces.setAuthor("kingpin");
//		Date temDate = new Date();
//		new Date().getTime()
		announces.setTime(new Timestamp(new Date().getTime()));
		boolean resultBool = announceServiceImpl.addAnnounce(announces);
		if(resultBool == true)
			return "addSuccess";
		else
			return "addFail";
	}
}
