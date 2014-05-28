package com.fro.dao;


import com.fro.entity.Announce;
import com.fro.utils.HibernateUtils;
import com.fro.exception.ForeginSchooleException;

import java.util.List;

import org.hibernate.Session;

import com.fro.dao.AnnounceDao;

public interface AnnounceDao {
	
	public boolean addAnnounce(Announce announces) throws Exception;
	
	public Announce checkAnnounce(String announce_id) throws Exception;
	
	public List<Announce> readAnnounce() throws Exception;
	
	public List<Announce> readAnnounce(int page) throws Exception;

	
}
