package com.fro.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fro.entity.ClassSchedule;
import com.fro.entity.ClasshourInfo;
import com.fro.utils.HibernateUtils;

public class PaiKeDao extends HibernateDaoSupport {
	//添加修改
	public void saveOrUpdate(Object obj) {
		super.getHibernateTemplate().save(obj);
	}
	//删除
	public void delete(Object obj) {
		super.getHibernateTemplate().delete(obj);
	}
    //根据主键查询对象,id可以是int,long,double都行
	public Object getObjectById(Class clazz, java.io.Serializable id) {
		Object obj = super.getHibernateTemplate().get(clazz, id);
		return obj;
	}

	//根据类对象查询所有
	public List getObjects(Class clazz) {
		List result = super.getHibernateTemplate().find(
				"from  " + clazz.getName());
		return result;
	}
	//根据 hql查询所有
	public List getObjectsByHQL(String hql) {
		List result = super.getHibernateTemplate().find(hql);
		return result;
	}
	//采用存储过程 通过实验室ID 和时间查询classSchedule
	public String[][] getClassSchedule(String labId,Date d,List<ClasshourInfo> chis){

		String[][] course=new String[chis.size()][8];
		
		 List<String> weeks=new ArrayList<String>();
      	 weeks.add("1");
      	 weeks.add("2");
      	 weeks.add("3");
      	 weeks.add("4");
      	 weeks.add("5");
      	 weeks.add("6");
      	 weeks.add("7");
      	 List<String> date=new ArrayList<String>();
      	for (int m=0;m<chis.size();m++) {
      		date.add(chis.get(m).getClasshourName());
      		String str=chis.get(m).getBeginDate()+"-"+chis.get(m).getEndDate();
      		course[m][0]=str;
      	}
		
		
		Session session=HibernateUtils.getSession();
		Connection conn = session.connection(); 
        //创建调用存储过程的预定义SQL语句 
        try { 
                //创建过程执行器 
                CallableStatement cstmt = conn.prepareCall("exec dbo.upd_GetClassSchedule '"+labId+"','"+d+"'"); 
                //设置入参和出参 

               ResultSet rs= cstmt.executeQuery(); 
                //获取输出参数值（两种方式都行） 
               
            
               
               
              while(rs.next()){
            	
            	
            	 for (int i=0;i<weeks.size();i++) {
            		
            		 
					for (int j=0;j<date.size();j++) {
					
					if((rs.getString("RunDay").trim().equals(weeks.get(i)))&&(rs.getString("ClasshourName").trim().equals(date.get(j)))){
						String m=rs.getString("CoursesName")+"<br>"+rs.getString("Major");
						String c=rs.getString("Class");
						if(c.equals("null")){
							m=m+rs.getString("UserID")+"<br>";
						}else{
							m=m+c+"<br>";
						}
						
						m=m+rs.getString("Teacher")+" <br>";
						
						if(rs.getString("UseType").trim().equals("1")){
							m=m+"个人";
						}else if(rs.getString("UseType").trim().equals("2")){
							m=m+"组";
						}else if(rs.getString("UseType").trim().equals("3")){
							m=m+"不限";
						}
						course[j][i+1]=m;
					
					}
					
					}
				} 
            	 
              }
                
        } catch (SQLException e) { 
                e.printStackTrace(); 
        } 
		
		
		
		return course;
	}
	public List<ClassSchedule> getAllClassSchedule() {
		Session session=HibernateUtils.getSession();
		List<ClassSchedule> css=session.createQuery("from ClassSchedule").list();
		HibernateUtils.close();
		
		return css;
	}
	public void addClassSchedule(ClassSchedule c) {
		
		Session session=HibernateUtils.getSession();
		session.save(c);
		session.beginTransaction().commit();
		HibernateUtils.close();
	}
	public String[][] getClassSchedule2(String labId, Date d,List<ClasshourInfo> chis) {
		String[][] course=new String[chis.size()][8];
		
		 List<String> weeks=new ArrayList<String>();
     	 weeks.add("1");
     	 weeks.add("2");
     	 weeks.add("3");
     	 weeks.add("4");
     	 weeks.add("5");
     	 weeks.add("6");
     	 weeks.add("7");
     	 List<String> date=new ArrayList<String>();
     	for (int m=0;m<chis.size();m++) {
     		date.add(chis.get(m).getClasshourName());
     		String str=chis.get(m).getBeginDate()+"-"+chis.get(m).getEndDate();
     		course[m][0]=str;
     	}
		
		
		Session session=HibernateUtils.getSession();
		Connection conn = session.connection(); 
       //创建调用存储过程的预定义SQL语句 
       try { 
               //创建过程执行器 
               CallableStatement cstmt = conn.prepareCall("exec dbo.upd_GetClassSchedule '"+labId+"','"+d+"'"); 
               //设置入参和出参 

              ResultSet rs= cstmt.executeQuery(); 
               //获取输出参数值（两种方式都行） 
              
           
              
              
             while(rs.next()){
           	
           	
           	 for (int i=0;i<weeks.size();i++) {
           		
           		 
					for (int j=0;j<date.size();j++) {
					
					if((rs.getString("RunDay").trim().equals(weeks.get(i)))&&(rs.getString("ClasshourName").trim().equals(date.get(j)))){
						String m=rs.getString("CoursesName")+"　"+rs.getString("Major");
						String c=rs.getString("Class");
						if(c.equals("null")){
							
						}else{
							m=m+c+"　";
						}
						
						m=m+rs.getString("Teacher")+"　";
						
						if(rs.getString("UseType").trim().equals("1")){
							m=m+"个人";
						}else if(rs.getString("UseType").trim().equals("2")){
							m=m+"组";
						}else if(rs.getString("UseType").trim().equals("3")){
							m=m+"不限";
						}
						course[j][i+1]=m;
					
					}
					
					}
				} 
           	 
             }
               
       } catch (SQLException e) { 
               e.printStackTrace(); 
       } 
		
		
		
		return course;
	}

	
	public int compareClassSchedule(List<ClassSchedule> css) throws Exception{
		Session session=HibernateUtils.getSession();
		Connection conn = session.connection(); 

		for (ClassSchedule c : css) {
			java.sql.Date beginDate=new java.sql.Date(c.getBeginDate().getTime());
			String sql="";
			if(c.getEndDate()==null||c.getEndDate().equals("null")){
				 sql="exec dbo.upd_IsCourseClash '"+c.getLabId()+"','"+beginDate+"','','"+c.getIsRepetitive()+"','"+c.getCycleType()+"','"+c.getCycle()+"','"+c.getClasshourId()+"','"+c.getUseType()+"'";
			}else{
				java.sql.Date endte=new java.sql.Date(c.getEndDate().getTime());
				 sql="exec dbo.upd_IsCourseClash '"+c.getLabId()+"','"+beginDate+"','"+endte+"','"+c.getIsRepetitive()+"','"+c.getCycleType()+"','"+c.getCycle()+"','"+c.getClasshourId()+"','"+c.getUseType()+"'";
			}
		
		      CallableStatement cstmt = conn.prepareCall(sql); 
            ResultSet rs= cstmt.executeQuery();
            if(rs.next()){
            int isCope=rs.getInt(1);
            if(isCope!=0){
            	return isCope;
            }
            }  
		}
		HibernateUtils.close();
		return 0;
	}
	
	public String[][] getOpenDoor(String labId, Date cdate) throws Exception{
		Session session=HibernateUtils.getSession();
		Connection conn = session.connection(); 
      CallableStatement cstmt = conn.prepareCall("exec dbo.upd_GetEntrGuardTime '"+labId+"','"+cdate+"'"); 
        ResultSet rs= cstmt.executeQuery();
        String[][] str = new String[100][3];
        int i=0;
        while(rs.next()){
        	str[i][0]=rs.getString("RunDay");
        	str[i][1]=rs.getString("BeginTime");
        	str[i][2]=rs.getString("EndTime");
        	i++;
        }
        String[][] str1=new String[i+1][3];
       for(int j=0;j<i;j++){
    	  str1[j]= str[j];   
       }
        str1[i][0]="0";
        str1[i][1]="00:00";
        str1[i][2]="00:00";
        
        HibernateUtils.close();
		return str1;
	}
	
	public List<ClasshourInfo>  getClasshourInfo(){
		Session session=HibernateUtils.getSession();
		List<ClasshourInfo> chis=session.createQuery("from ClasshourInfo").list();
		return chis;
	}
	public void deleteClasshourInfo(int parseInt) {
		String hql="delete from ClasshourInfo where ClasshourID="+parseInt;
		Session session=HibernateUtils.getSession();
		session.createQuery(hql).executeUpdate();
		session.beginTransaction().commit();
		HibernateUtils.close();

	}
	public void sureModify(ClasshourInfo ch) {
	String str=ch.getBeginDate()+"到"+ch.getEndDate();
	String hql="update ClasshourInfo set BeginTime='"+ch.getBeginDate()+"',EndTime='"+ch.getEndDate()+"',ClasshourName='"+str+"'where ClasshourID="+ch.getClasshourId();
	System.out.println(hql);
	Session session =HibernateUtils.getSession();
	session.createQuery(hql).executeUpdate();
	session.beginTransaction().commit();
	HibernateUtils.close();
	}
	public void deleteLabInfo(String string) {
		String hql="delete from LabInfo where LabID='"+string+"'";
		System.out.println(hql);
		Session session=HibernateUtils.getSession();
		session.createQuery(hql).executeUpdate();
		session.beginTransaction().commit();
		HibernateUtils.close();
		
	}
	
	
}
