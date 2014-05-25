package com.fro.action;

public class SystemOutAction extends BaseAction{

	private String IP;
	
	
	public String getIP() {
		return IP;
	}


	public void setIP(String iP) {
		IP = iP;
	}


	public String execute() throws Exception {
		
		if(session.get("userInfo")!=null){
			
			session.remove("userInfo");
		}
		
		IP=request.getSession().getServletContext().getInitParameter("IP");
		return "sysOut";
	}
	
}
