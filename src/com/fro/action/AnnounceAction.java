package com.fro.action;

import com.fro.entity.Announce;
import com.fro.entity.UserInfo;

import java.util.List;
//import java.io.PrintWriter;
import com.fro.service.impl.AnnounceServiceImpl;
import com.fro.service.AnnounceService;

import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


public class AnnounceAction extends BaseAction{
	private String announce_id;
	private Announce announce=new Announce();
	public Announce getAnnounce() {
		return announce;
	}

	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}

	public AnnounceService getAnnounceServiceImpl() {
		return announceServiceImpl;
	}

	public void setAnnounceServiceImpl(AnnounceService announceServiceImpl) {
		this.announceServiceImpl = announceServiceImpl;
	}

	private List<Announce> AnnounceList;
	private AnnounceService announceServiceImpl = new AnnounceServiceImpl();
	
	public void setAnnounce_id(String announce_id){
		this.announce_id = announce_id;
	}
	
	public String getAnnounce_id(){
		return announce_id;
	}
	
	public List<Announce> getAnnounceList()
	{
		return AnnounceList;
	}
	
	public void setAnnounceList(List<Announce> AnnounceList){
		this.AnnounceList = AnnounceList;
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
		
		System.out.println("AnnounceAction.checkAnnounce("+announce_id+")");
		announce = announceServiceImpl.checkAnnounce(announce_id);
		System.out.println("AnnounceAction.checkAnnounce.finish!");
		
		if(announce != null)
			return "checkSuccess";
		else
			return "checkNull";
		
	}
	
public String addAnnounce() throws Exception{
		
	response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		announces.setAnnounce_id(new Integer(12));
//		announce.setAuthor("kingpin");
//		Date temDate = new Date();
		//new Date().getTime();
		//announce.setTime(new Timestamp(new Date().getTime()));
		System.out.println(announce.getAuthor()+";"+announce.getContext()+";"+announce.getHeadline());
		HttpSession  httpSession=request.getSession();
		System.out.println(httpSession.getAttribute("ui"));
		UserInfo userInfo=(UserInfo)httpSession.getAttribute("ui");
		announce.setAuthor(userInfo.getUserName());
		boolean resultBool = announceServiceImpl.addAnnounce(announce);
		if(resultBool == true)
		{
			try{
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print(1);
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
			return null;
		}
		else
			return "addFail";

	}
}
