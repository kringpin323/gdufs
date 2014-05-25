package com.fro.dao;


import com.fro.entity.announce;
import com.fro.utils.HibernateUtils;
//import com.fro.utils.HibernateUtils;
import com.fro.exception.ForeginSchooleException;

import java.util.List;

import org.hibernate.Session;

import com.fro.dao.AnnounceDao;

public interface AnnounceDao {
	
	public boolean addAnnounce(announce announces) throws Exception;

	
}
