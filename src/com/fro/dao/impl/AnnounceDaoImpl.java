package com.fro.dao.impl;

import com.fro.entity.announce;
import com.fro.utils.HibernateUtils;
import com.fro.exception.ForeginSchooleException;
import org.hibernate.Session;
import com.fro.dao.AnnounceDao;

public class AnnounceDaoImpl implements AnnounceDao{

	public boolean addAnnounce(announce announces) throws Exception{
		try{
			Session session = HibernateUtils.getSession();
			session.save(announces);
			session.beginTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			throw new ForeginSchooleException("Êý¾Ý²ãÒì³£");
		}finally{
			HibernateUtils.close();
		}
		
		
	}

}
