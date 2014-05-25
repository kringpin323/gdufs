package com.fro.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static Configuration cfg;
	private static SessionFactory sf;
	private static ThreadLocal<Session> threadLoad=new ThreadLocal<Session>();
	
	static{
		cfg=new Configuration().configure();
		sf=cfg.buildSessionFactory();	
	}
	
	
	public static Session getSession(){
		Session session=threadLoad.get();
		if(session==null){ 
			session=sf.openSession();
			threadLoad.set(session);
		}
		return session;
	}
	
	public static void close(){
		Session session=threadLoad.get();
		if(session!=null&&session.isOpen()){
			session.close();
			threadLoad.set(null);
		}
	
	} 
	
}
