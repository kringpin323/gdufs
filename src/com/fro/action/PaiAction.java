package com.fro.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fro.dao.impl.LoginDaoImpl;
import com.fro.dao.impl.PaiKeDao;
import com.fro.entity.ClassInfo;
import com.fro.entity.ClassSchedule;
import com.fro.entity.ClasshourInfo;
import com.fro.entity.LabInfo;
import com.fro.entity.MajorInfo;
import com.fro.order.GuardControl;
import com.fro.service.LabService;
import com.fro.service.LoginService;
import com.fro.service.impl.LabServiceImpl;
import com.fro.service.impl.LoginServiceImpl;
import com.fro.utils.ComputeWeek;
import com.fro.utils.ExcelFileGenerator;
import com.fro.utils.GetCuardControl;
import com.fro.utils.ReadExcel;

public class PaiAction extends BaseAction {
	private List<LabInfo> laList;
	private List<ClasshourInfo> ccList;
	private List<ClassSchedule> css;
	LoginDaoImpl ld = new LoginDaoImpl();
	private int classhourId;
	private String coursesName;
	private String teacher;
	private String useType;
	private String labID;
	private Date cdate;
	private String isRepetitive;
	private String cycleType;
	private String cycle;
	private ClassSchedule c;
	private List<MajorInfo> majorInfos;
	private String major;
	private int week;
	private String IP;
	private int currentPage;
	private int totalPage;
	private int recodes;
	private int clsTimTbllD;
	private String startTime;
	private String endTime;
	private String str;
	private ClasshourInfo ch;
	private List<Integer> weeks=new ArrayList<Integer>();
	private String startD;

	
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	LabService lab=new LabServiceImpl();
	
	


	public String getStartD() {
		return startD;
	}
	public void setStartD(String startD) {
		this.startD = startD;
	}
	public ClasshourInfo getCh() {
		return ch;
	}
	public void setCh(ClasshourInfo ch) {
		this.ch = ch;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getClsTimTbllD() {
		return clsTimTbllD;
	}
	public void setClsTimTbllD(int clsTimTbllD) {
		this.clsTimTbllD = clsTimTbllD;
	}
	public int getRecodes() {
		return recodes;
	}
	public void setRecodes(int recodes) {
		this.recodes = recodes;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<ClassSchedule> getCss() {
		return css;
	}
	public void setCss(List<ClassSchedule> css) {
		this.css = css;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public List<MajorInfo> getMajorInfos() {
		return majorInfos;
	}
	public void setMajorInfos(List<MajorInfo> majorInfos) {
		this.majorInfos = majorInfos;
	}
	public ClassSchedule getC() {
		return c;
	}
	public void setC(ClassSchedule c) {
		this.c = c;
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
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getCoursesName() {
		return coursesName;
	}
	public void setCoursesName(String coursesName) {
		this.coursesName = coursesName;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getUseType() {
		return useType;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	public int getClasshourId() {
		return classhourId;
	}
	public void setClasshourId(int classhourId) {
		this.classhourId = classhourId;
	}

	private ClassSchedule classSchedule;

	public ClassSchedule getClassSchedule() {
		return classSchedule;
	}
	public void setClassSchedule(ClassSchedule classSchedule) {
		this.classSchedule = classSchedule;
	}
	public List<ClasshourInfo> getCcList() {
		return ccList;
	}
	public void setCcList(List<ClasshourInfo> ccList) {
		this.ccList = ccList;
	}

	public List<LabInfo> getLaList() {
		return laList;
	}
	public void setLaList(List<LabInfo> laList) {
		this.laList = laList;
	}
	
	
	public List<Integer> getWeeks() {
		return weeks;
	}
	public void setWeeks(List<Integer> weeks) {
		this.weeks = weeks;
	}
	public String getIsRepetitive() {
		return isRepetitive;
	}
	public void setIsRepetitive(String isRepetitive) {
		this.isRepetitive = isRepetitive;
	}
	public String getCycleType() {
		return cycleType;
	}
	public void setCycleType(String cycleType) {
		this.cycleType = cycleType;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getLabID() {
		return labID;
	}
	public void setLabID(String labID) {
		this.labID = labID;
	}
	
	
	public String toAddClasshour(){
		
		
		return "toAddClasshour";
	}
	
	
	public String sureModify() throws IOException{
		
		int row =lab.sureModify(ch);
		PrintWriter out=response.getWriter();
		out.print(row);
		out.flush();
		
		return null;
		
	}
	
	
	
	
	//自定义课时
	
	public String addClasshour(){
		ClasshourInfo chi=new ClasshourInfo();
		chi.setBeginDate(startTime);
		chi.setEndDate(endTime);
		String str=startTime+"到"+endTime;
		chi.setClasshourName(str);
		ld.addClasshourInfo(chi);
		
		
		return null;
	}
	
	//课时预览
	public String preview(){
		ccList=ld.getClasshourinfo();
		
		return "preview";
	}
	
	
	public String deleteByChoose() throws IOException{
		int row =lab.deleteByChoose(str);
		PrintWriter out=response.getWriter();
		out.print(row);
		out.flush();
		
		
		return null;
	}
	
	
	public String findByCondition() throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int pageSize=Integer.parseInt(request.getSession().getServletContext().getInitParameter("pageSize"));
		LoginService loginService=new LoginServiceImpl();
		css=loginService.findByCondition(c,currentPage,pageSize);
		
		ComputeWeek cw=new ComputeWeek();
		for (ClassSchedule cs: css) {
			cs.setCreateBy(cw.getWeekDay(cs.getBeginDate()));
		}
		
		
		
		recodes=loginService.getRecodes2(c);
		totalPage=recodes%pageSize==0?recodes/pageSize:recodes/pageSize+1;
		
		return "findByCondition";
	}
	
	
	public String del(){
		
		ld.deleteClassSchedule(clsTimTbllD);
		
		return null;
	}
	
	
	public String toPaiKe(){
		laList=ld.getLabInfo();
		majorInfos=ld.getMajor();
		this.ccList = this.ld.getClasshourinfo();
		this.laList =  this.ld.getLabInfo();
		
		int w=Integer.parseInt(request.getSession().getServletContext().getInitParameter("weeks"));
		
		for(int a=1;a<=w;a++){
			weeks.add(a);
		}
		 startD=request.getSession().getServletContext().getInitParameter("startDate");
	
		return "toPaiKe";
	}
	
	public String labTab() throws ParseException{
		LabService lab=new LabServiceImpl();
	 
		int w=Integer.parseInt(request.getSession().getServletContext().getInitParameter("weeks"));
		
		for(int a=1;a<=w;a++){
			weeks.add(a);
		}
		
		request.setAttribute("cdate", cdate);
		String[][]  courses=lab.getCourses(labID.trim(),cdate);
		request.setAttribute("courses", courses);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String d=request.getSession().getServletContext().getInitParameter("startDate");
		java.util.Date startDate=sdf.parse(d); 
		
		 week=ComputeWeek.computeWeek(startDate,cdate);
		week=week+1;
		
		IP = request.getSession().getServletContext().getInitParameter("IP");
		
		return "labTable";
	}
	
	public String classManager(){
		
		this.ccList = this.ld.getClasshourinfo();
		this.laList =  this.ld.getLabInfo();
		
		int w=Integer.parseInt(request.getSession().getServletContext().getInitParameter("weeks"));
		
		for(int a=1;a<=w;a++){
			weeks.add(a);
		}
		 startD=request.getSession().getServletContext().getInitParameter("startDate");
		
		return "classManager";
	}
	
	
	public String importTable() throws Exception{
		
		ServletContext sc=ServletActionContext.getServletContext();
		String path=sc.getRealPath("/upload");
		FileUtils.copyFile(file,new File(path,fileFileName));
		String real=path+'\\'+fileFileName;
		List<ClassSchedule> css=ReadExcel.readExcel2(real);
		
		int row=lab.addClassSchedule(css);
		if(row==0){
			request.setAttribute("msg_row","成功导入数据!");
		}else{
			request.setAttribute("msg_row","课程ID="+row+"的记录已经存在！");
		}
		
		listClass();
		
		return "list";
	}
	
	PaiKeDao p=new PaiKeDao();
	public String toExcel() throws IOException, Exception{
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		
		List<List<String>>  fileData=lab.getCourse2(labID.trim(),cdate);
		List<String> fileName =lab.makeExcelName(labID,cdate,week); 
		
		ExcelFileGenerator excel=new ExcelFileGenerator(fileName, fileData);
		excel.expordExcel(response.getOutputStream());

		return null;
	}
	
	
	public String listClass()
	{
		
		majorInfos=ld.getMajor();
		this.ccList = this.ld.getClasshourinfo();
		this.laList =  this.ld.getLabInfo();
		
		int w=Integer.parseInt(request.getSession().getServletContext().getInitParameter("weeks"));
		
		for(int a=1;a<=w;a++){
			weeks.add(a);
		}
		 startD=request.getSession().getServletContext().getInitParameter("startDate");
		
		
		
		return "list";
	}
	public String ad() throws Exception
	{	c.setLabId(labID.trim());
		c.setStatus("1");
		List<ClassSchedule> css=new ArrayList<ClassSchedule>();
		css.add(c);
		PaiKeDao p=new PaiKeDao();
		int b=p.compareClassSchedule(css);
		if(b==0){
		//添加一个课程时就给门襟发送一条指令 添加定时开门。
		ld.addClassSchedule(c);
//        if(c.getLabId().equalsIgnoreCase("C507")){
//        	GuardControl doorC=GetCuardControl.getGuardControl();  
//            java.sql.Date   cdate=new  java.sql.Date(c.getBeginDate().getTime()); 
//        	String[][] str=p.getOpenDoor(c.getLabId(), cdate);
//    		String[] str1 = doorC.formatTime(str);//****************************************
//    		doorC.sendOrder(doorC.uploadTimingOfOpenDoor("0144596", str1));
//        }
        response.getWriter().print("Y");
        
		}else{
			response.getWriter().print(b);
		}
		
		
		return null;
	
	}
	
	
	public String getClaByMajor() throws Exception{
		
		response.setCharacterEncoding("utf-8");
		List<ClassInfo> classInfos=ld.getClaByMajor(major);
		
		PrintWriter out=response.getWriter();
		String str="";
		for (ClassInfo classInfo : classInfos) {
			str=str+classInfo.getClass_()+",";
		}
		out.print(str);
		out.flush();
		
		return null;
	}
}
