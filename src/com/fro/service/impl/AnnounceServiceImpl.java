package com.fro.service.impl;

import com.fro.dao.impl.AnnounceDaoImpl;
import com.fro.dao.AnnounceDao;
import com.fro.service.AnnounceService;
import com.fro.entity.announce;

public class AnnounceServiceImpl implements AnnounceService{
	AnnounceDao announceDao = new AnnounceDaoImpl();
	
	public boolean addAnnounce(announce announces){
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
