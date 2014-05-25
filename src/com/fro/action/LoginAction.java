package com.fro.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fro.entity.UserGroup;
import com.fro.entity.UserGroupPK;
import com.fro.entity.UserInfo;
import com.fro.service.LoginService;
import com.fro.service.impl.LoginServiceImpl;
import com.fro.utils.HttpUtils;

public class LoginAction extends BaseAction{

	private String userid;
	private String password;
	
LoginService loginService=new LoginServiceImpl();

	public String login() throws Exception {
		
		
		UserInfo userInfo=loginService.login(userid);
		if(userInfo!=null){
				if(userInfo.getPassword().equals(password)){
					//通过userid在user_group表中查找groupid
			List<String>  rightids=loginService.getRightId(userid);
			session.put("userInfo", userInfo);
			HttpSession  httpSession=request.getSession();
			httpSession.setAttribute("ui", userInfo);
			session.put("rightids",rightids);
			
			return "main";
		 }	
		}
		
		session.put("Msg_error", "用户名或密码错误！！");
		return "login";
	}


	public String schoolLogin(){
		System.out.println("进入校园入口……");
		int k=1;
		String url="http://passport.mygdufs.com/Api/checkIsRight?studentNumber="+userid+"&password="+password+"";
		System.out.println(url);
		k=HttpUtils.getStatus(url);
		
		if(k==1){
			
			//需要再加一层判断  判断此卡号的老师在15分钟内是否有个人申请的课程 并且返回实验室ID
			String labId=loginService.getLabIDByExec(userid);
			if(labId!=null){
				System.out.println("登录成功！");
				UserInfo userInfo=loginService.login(userid);
				if(userInfo==null){
				//   2将这个用户添加到用户表中   1将这个用户添加到  common/数字广外组 中         3给这个临时用户添加临时的实验室权限
					userInfo=new UserInfo();
					userInfo.setUserId(userid); 
					userInfo.setPassword(password);
					userInfo.setUserName("临时用户");
					userInfo.setStatus("1");
					try {
						loginService.addUserInfo(userInfo);
						loginService.addGroupInfo(userid, "common");
						loginService.addLabRight(labId,userid);
					} catch (Exception e) {
						e.printStackTrace();
					}
		
				}
				
				
				List<String> rightids=new ArrayList<String>();
				try {
					rightids = loginService.getRightId(userid);
					session.put("rightids",rightids);
				} catch (Exception e) {
				}
				session.put("userInfo", userInfo);
				HttpSession  httpSession=request.getSession();
				httpSession.setAttribute("ui", userInfo);	
				return "main";
				
			}	
		}

		session.put("Msg_error", "用户名或密码错误！！");
		return "login";
	}
	


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}









	
	
	
}
