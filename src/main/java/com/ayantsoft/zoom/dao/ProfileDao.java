package com.ayantsoft.zoom.dao;

import java.util.List;

import com.ayantsoft.zoom.pojo.Profile;

public interface ProfileDao {
	
	public Profile find(String userName,String password);
	public void addProfile(Profile profile);
	public List<Profile> list();
	public void removeProfile(String profileId);

}
