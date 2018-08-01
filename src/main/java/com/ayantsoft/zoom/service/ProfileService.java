package com.ayantsoft.zoom.service;

import java.util.List;

import com.ayantsoft.zoom.pojo.Profile;

public interface ProfileService {
	
	public Profile findUser(String userName,String password);
	public void addProfile(Profile profile);
	public List<Profile> findAllUser();
	public void removeProfile(String profileId);

}
