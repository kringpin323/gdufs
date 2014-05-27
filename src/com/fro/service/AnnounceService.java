package com.fro.service;

import com.fro.entity.Announce;

public interface AnnounceService {
	public boolean addAnnounce(Announce announces);
	public Announce checkAnnounce (String announce_id);
}
