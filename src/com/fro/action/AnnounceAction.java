package com.fro.action;

import com.fro.entity.Announce;
import java.util.List;
//import java.io.PrintWriter;
import com.fro.service.impl.AnnounceServiceImpl;
import com.fro.service.AnnounceService;
import java.sql.Timestamp;
import java.util.Date;


public class AnnounceAction extends BaseAction{
	private String announce_id;
	private Announce announces;
	private List<Announce> AnnounceList;
	private AnnounceService announceServiceImpl = new AnnounceServiceImpl();
	
	public List<Announce> getAnnounceList()
	{
		return AnnounceList;
	}
	
	public void setAnnounceList(List<Announce> AnnounceList){
		this.AnnounceList = AnnounceList;
	}
	
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
	
	public String readAnnounce(){
		
		AnnounceList = announceServiceImpl.readAnnounce();
		if(AnnounceList == null){
			System.out.println("AnnounceList == null");
		}else{
			session.put("AnnounceList", AnnounceList);
			System.out.println("非空，只是页面标签读取错误");
		}
		
		return "readAnnounce";
	}
	
	public String checkAnnounce(){
		
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("AnnounceAction.checkAnnounce('announce_id')");
		announces = announceServiceImpl.checkAnnounce(announce_id);
		System.out.println("AnnounceAction.checkAnnounce.finish!");
		
		if(announces != null)
			return "checkSuccess";
		else
			return "checkNull";
		
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
