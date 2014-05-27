package com.fro.service.impl;

import com.fro.dao.impl.AnnounceDaoImpl;
import com.fro.dao.AnnounceDao;
import com.fro.service.AnnounceService;
import com.fro.entity.Announce;

public class AnnounceServiceImpl implements AnnounceService{
	AnnounceDao announceDao = new AnnounceDaoImpl();
	
	public Announce checkAnnounce(String announce_id){
		try{
			System.out.println("checkAnnounceService success");
			return announceDao.checkAnnounce(announce_id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
		}
		return null;
	}
	
	public boolean addAnnounce(Announce announces){
		try{
			announceDao.addAnnounce(announces);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return true;
		}
		
	}
}
