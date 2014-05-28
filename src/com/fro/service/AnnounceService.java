package com.fro.service;

import com.fro.entity.Announce;
//import com.fro.service.impl.List;
import java.util.List;

public interface AnnounceService {
	public List<Announce> readAnnounce();
	public List<Announce> readAnnounce(int page);
	public boolean addAnnounce(Announce announces);
	public Announce checkAnnounce (String announce_id);
}
