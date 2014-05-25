package com.fro.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fro.dao.LoginDao;
import com.fro.dao.impl.LoginDaoImpl;
import com.fro.entity.DepartmentInfo;
import com.fro.entity.GroupInfo;
import com.fro.entity.LabInfo;
import com.fro.entity.MajorInfo;
import com.fro.entity.UserInfo;
import com.fro.service.LoginService;
import com.fro.service.impl.LoginServiceImpl;
import com.fro.utils.ExcelFileGenerator;
import com.fro.utils.LabParameter;
import com.fro.utils.ReadExcel;

public class SystemMangerAction extends BaseAction{

	private String modelSet;
	private String labId;
	private UserInfo userInfo;
	private List<DepartmentInfo> departmentInfos;
	private List<GroupInfo> rightInfos;
	private List<MajorInfo> majorInfos;
	private int currentPage;
	private int totalPage;
	private int recodes;
	private String userId;
	private String str;
	private String major;
	private List<LabInfo> labInfos;
	private String groupId;
	private List<UserInfo> userInfos;
	private  String[] checkbox;
	private String IP;
	private GroupInfo groupInfo;
	private List<GroupInfo> groupInfos;
	private List<Object[]> userObject;
	
	private String doorRFID;
	private String doorNum;

	
	
	private String strUserId;
	private String strGroupId;
	
	private File file;
	private String fileFileName;
	private String fileContentType;//文件类型
	
	LoginService loginService=new LoginServiceImpl();
	
	
	public String exception(){
		return "exception";
	}
	
	
	public String toRight(){
		// 2 二期修改
		
		userInfos=loginService.getUserInfos();
		groupInfos=loginService.getGroupInfos();
		labId=labId;
	
		return "labRight";
	}
	
	public String labRightSet(){
		loginService.labRightSet(labId,strUserId,strGroupId);

		return null;
	}
	
	
	public String getRightByLabId(){
		
		String labRight=loginService.getRightByLabId(labId);
		
		System.out.println(labRight);
		
		try {
			response.getWriter().print(labRight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public String toLabStauSet() throws Exception {
		labInfos=loginService.getLabInfo();
	
		return "toLabStauSet";
	}
	
	
	// 2 !!!!!!!!!!!
	public String labJson(){
		response.setContentType("text/html;charset=utf-8");
		labInfos=loginService.getLabInfo();
		
		JSONArray array=JSONArray.fromObject(labInfos);
		String str=array.toString();
		try {
			System.out.println(str);
			response.getWriter().print(str);
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	
	public String UserGroup(){
		
		return "UserGroup";
	}
	
	public String addUserGroup(){
		loginService.addUserGroup(groupInfo);
		
		
		return null;
	}
	
	
	public String groupUserList(){
		 userObject=loginService.getUserInfosByGroupId(groupId);
		
		return "groupUserList";
	}
	
	
	public String preview(){
		groupInfos=loginService.getGroupInfos();
	
		return "preview";
	}
	
	public String sureModify(){
		
		loginService.modifyGroupInfo(groupInfo);
		return null;
	}
	
	public String deleteByChoose2() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		int row =loginService.deleteByChooseLabInfo(str);
		PrintWriter out=response.getWriter();
		if(row==0){
			out.print("不能删除用户组,该用户组还有成员！");
			
		}else{
			out.print("成功删除记录!");
		}
		
		out.flush();
		
		
		return null;
	}
	
	public String labStauSet() throws Exception{
		
	
//		String userid=((UserInfo)session.get("userInfo")).getUserId();
//		loginService.setLabStau(userid,modelSet);
		
		// 二期进行修改！！！！！！！！！！！！！！！  根据labId 来修改不同实验的运行模式
		
		
		loginService.updLabInfoRun(labId,modelSet);
		
	//  并且 如果 modelSet 为 2（自动导航模式）   根据课表关闭所有的设备
		if(modelSet.equalsIgnoreCase("2")){

		LoginDao loginDao=new LoginDaoImpl();
		String beginDate=loginDao.getBeginDateByCurseClass(labId);
		if(!beginDate.equalsIgnoreCase("notNull")){
			
				LabParameter labParameter=new LabParameter();
				labParameter.labID=labId;					
				
				labParameter.operate="CLOSE";
				labParameter.AutoNavigation();

		}
		
		}
		
		
		return null;
	}

	
	public String getStauSet() throws IOException{
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out =response.getWriter();
		//获取实验室管理员的运行模式状态
		String statu=loginService.getStauSet();
		
		out.print(statu);
		out.flush();
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String toUserInfo() throws Exception{
		
		
	 IP = request.getSession().getServletContext().getInitParameter("IP");
	departmentInfos=loginService.getDepartment();
	rightInfos=loginService.getRight();
	majorInfos=loginService.getMajor();
	labInfos=loginService.getDoorNum();
	
		return "toUserInfo";
		
	}
	
	public String deleteDoorNum() throws IOException{
		response.setContentType("text/html;charset=utf-8");
		int row=loginService.deleteDoorNum(this.doorNum,this.doorRFID);
		PrintWriter out=response.getWriter();
		if(row==15){
			out.print("删除失败！");
			
		}else if(row==0){
			out.print("暂无此实验室的权限！");
		}else{
			out.print("删除"+row+"条记录成功！");
		}

		return null;
	}
	
	
	public String addDoorNum() throws IOException{
		
		response.setContentType("text/html;charset=utf-8");
		int row=loginService.addDoorNum(this.doorNum,this.doorRFID,userId);
		PrintWriter out=response.getWriter();
		if(row==0){
			out.print("添加失败！");
		}else{
			out.print("添加"+row+"条记录成功！");
		}
		
		return null;
	}
	
	
	
	public String addUserInfo() throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		userInfo.setStatus("1");
		
		try {
			loginService.addUserInfo(userInfo);
			loginService.addGroupInfo(userInfo.getUserId(),groupId);
		} catch (Exception e) {
			response.getWriter().print("exception");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public String openByUserId(){
		
		loginService.openByUserId(userId);
		
		return null;
	}
	
	
	
	public String toModiyGroup(){
		groupInfos=loginService.getGroupInfos();
		
		return "toModiyGroup";
	}
	
	public String sureModiyGroup(){
		
		loginService.sureModifyGroup(userId,groupId,str);
		
		return null;
	}
	
	
	
	public String findByCondition() throws Exception{
		if(currentPage==0){
			this.currentPage=1;
		}
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int pageSize=Integer.parseInt(request.getSession().getServletContext().getInitParameter("pageSize"));
		userInfos=loginService.findByCondition(userInfo,currentPage,pageSize);
		totalPage=loginService.getTotalPage(userInfo,pageSize);
		recodes=loginService.getRecodes(userInfo);
	
		
		
		
		return "findByCondition";
	}
	
	
	public String findByUserId() throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		UserInfo ui=loginService.login(userId);
	
		UserInfo u=new UserInfo();
		u.setClass_(ui.getClass_());
		u.setRfid(ui.getRfid());
		u.setDepartment(ui.getDepartment());
		u.setMajor(ui.getMajor());
		u.setMobile(ui.getMobile());
		u.setUserId(ui.getUserId());
		u.setUserName(ui.getUserName());
		u.setSex(ui.getSex());
		u.setPassword(ui.getPassword());
		
		JSONObject object=JSONObject.fromObject(u);
		String str=object.toString();
		out.print(str);
		
		out.flush();
		
		return null;
	}
	
	
	
	
	
	public String toExcel() throws Exception{
		
		
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		List<UserInfo> userInfos=loginService.toExcel(str);
		List<List<Object>> fileData=loginService.makeExcel(userInfos);
		List<String> fileName =loginService.makeExcelName(); 
		
		
		ExcelFileGenerator excel=new ExcelFileGenerator(fileName, fileData);
		
			excel.expordExcel(response.getOutputStream());
		
		
		return null;
	}
	
	
	
	
	public String deleteByUserId() throws Exception{
		//不是删除 而是停用用户操作
		loginService.deleteByUserId(userId);

		return null;
	}
	
	public String deleteByChoose() throws Exception{
	
		int row =loginService.deleteByChoose(str);
		PrintWriter out=response.getWriter();
		out.print(row);
		out.flush();
		
		return null;
	}
	
	
	public String toLabRecode() throws Exception{
		labInfos=loginService.getLabInfo();
		
		return "toLabRecode";
	}
	

	public String toImportUserInfo() throws Exception{
	
		return "toImportUserInfo";
	}
	
	public String importUserInfo() throws Exception{
		
		ServletContext sc=ServletActionContext.getServletContext();
		String path=sc.getRealPath("/upload");
		FileUtils.copyFile(file,new File(path,fileFileName));
		String real=path+'\\'+fileFileName;
		List<UserInfo> userInfos=ReadExcel.readExcel(real);

		int row=loginService.importUserInfo(userInfos);
		if(row==0){
			request.setAttribute("msg_row", "导入信息格式不准确或含有重复的记录");
		}else{
			request.setAttribute("msg_row", "成功插入"+row+"条数据");
		}
		
		
		return "importUserInfo";
	}


	
	public String updUserInfo() throws Exception{
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		int row=loginService.updUserInfo(userInfo);
		if(row==0){
			out.println("更新数据不成功");
		}else{
			
			out.println("更新数据成功");
		}
		out.flush();
		return null;
	}
	
	
	public String toAutoSet(){
		
		
		return "toAutoSet";
	}
	
	
	public String checkUserId() throws Exception{
		UserInfo userInfo=loginService.login(userId);
		if(userInfo==null){
			response.getWriter().print("0");
		}else{
			response.getWriter().print("1");	
		}
		
		response.getWriter().flush();
		
		
		return null;
	}
	
	
	public String toRightSet() throws Exception{
		
		return "toRightSet";
	}
	
	public String toGroupRightSet(){
		
		
		return "toGroupRightSet";
	}
	
	
	public String chaxunStas() throws Exception{
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<String> rightIds=loginService.getRightId(userId);
		
		JSONArray arr=JSONArray.fromObject(rightIds);
		String str =arr.toString();
		out.print(str);
		out.flush();
		out.close();
		return null;
	}
	
	public String chaxunStas2() throws Exception{
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		List<String> rightIds=loginService.getRightId2(groupId);
		
		JSONArray arr=JSONArray.fromObject(rightIds);
		String str =arr.toString();
		out.print(str);
		out.flush();
		out.close();
		
		
		return null;
	}
	
	
	
	public String RightSet() throws Exception{
		
		loginService.RightSet(userId,checkbox);
		
		
		return "RightSet";
	}

	public String RightSet2() throws Exception{
		
	loginService.RightSet2(groupId,checkbox);
	
	return "RightSet2";
}
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getModelSet() {
		return modelSet;
	}

	public void setModelSet(String modelSet) {
		this.modelSet = modelSet;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<DepartmentInfo> getDepartmentInfos() {
		return departmentInfos;
	}

	public void setDepartmentInfos(List<DepartmentInfo> departmentInfos) {
		this.departmentInfos = departmentInfos;
	}



	public List<GroupInfo> getRightInfos() {
		return rightInfos;
	}

	public void setRightInfos(List<GroupInfo> rightInfos) {
		this.rightInfos = rightInfos;
	}

	public List<MajorInfo> getMajorInfos() {
		return majorInfos;
	}

	public void setMajorInfos(List<MajorInfo> majorInfos) {
		this.majorInfos = majorInfos;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getRecodes() {
		return recodes;
	}

	public void setRecodes(int recodes) {
		this.recodes = recodes;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}



	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<LabInfo> getLabInfos() {
		return labInfos;
	}

	public void setLabInfos(List<LabInfo> labInfos) {
		this.labInfos = labInfos;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public GroupInfo getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(GroupInfo groupInfo) {
		this.groupInfo = groupInfo;
	}

	public List<GroupInfo> getGroupInfos() {
		return groupInfos;
	}

	public void setGroupInfos(List<GroupInfo> groupInfos) {
		this.groupInfos = groupInfos;
	}

	public List<Object[]> getUserObject() {
		return userObject;
	}

	public void setUserObject(List<Object[]> userObject) {
		this.userObject = userObject;
	}

	public String getLabId() {
		return labId;
	}

	public void setLabId(String labId) {
		this.labId = labId;
	}


	public String getStrUserId() {
		return strUserId;
	}


	public void setStrUserId(String strUserId) {
		this.strUserId = strUserId;
	}


	public String getStrGroupId() {
		return strGroupId;
	}


	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}


	public String getDoorRFID() {
		return doorRFID;
	}


	public void setDoorRFID(String doorRFID) {
		this.doorRFID = doorRFID;
	}


	public String getDoorNum() {
		return doorNum;
	}


	public void setDoorNum(String doorNum) {
		this.doorNum = doorNum;
	}

	


	



	
	
	
	
	
	
	
	

	

	
}
