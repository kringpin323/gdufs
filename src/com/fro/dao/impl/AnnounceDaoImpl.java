package com.fro.dao.impl;

import com.fro.entity.Announce;
import com.fro.utils.HibernateUtils;
import com.fro.exception.ForeginSchooleException;

import org.hibernate.Query;
import org.hibernate.Session;
import com.fro.dao.AnnounceDao;
import java.util.List;

public class AnnounceDaoImpl implements AnnounceDao{
	
	public List<Announce> readAnnounce() throws Exception{
		try{
			return readAnnounce(1);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("List<Announce> readAnnounce(): 异常");
		}
		return null;
	}
	
	public List<Announce> readAnnounce(int page) throws Exception{
		try{
			int pageCount=5;
			String hql = "from Announce";
			Session session = HibernateUtils.getSession();
			Query q = session.createQuery(hql);
			q.setFirstResult((page-1)*pageCount+1);
			q.setMaxResults(page*pageCount);
			List<Announce> tempAnn = q.list();
			return tempAnn;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("List<Announce> readAnnounce(int page): 异常");
		}
		return null;
	}
	public boolean addAnnounce(Announce announces) throws Exception{
		try{
			Session session = HibernateUtils.getSession();
			session.save(announces);
			session.beginTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			throw new ForeginSchooleException("数据层异常");
		}finally{
			HibernateUtils.close();
		}
		
		
	}
	
	public Announce checkAnnounce(String announce_id) throws Exception{
		try{
			Session session = HibernateUtils.getSession();
			String hql = "from Announce where announce_id=?";
			Query query = session.createQuery(hql).setString(0, announce_id);
			List<Announce> announcesList = query.list();
			
			if(announcesList.size()!=0){
				System.out.println("announcesList.size(): "+announcesList.size());
				return announcesList.get(0);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HibernateUtils.close();
		}
		return null;
	}

}
