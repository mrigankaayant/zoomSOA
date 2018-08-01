package com.ayantsoft.zoom.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import com.ayantsoft.zoom.dao.ProfileDao;
import com.ayantsoft.zoom.pojo.Profile;
import com.ayantsoft.zoom.service.ProfileService;
@Service
public class ProfileServiceImpl implements ProfileService,Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6201966116313705578L;

	@Autowired
	private ProfileDao profileDao;

	@Override
	public Profile findUser(String userName, String password) {
		return profileDao.find(userName, password);
	}

	@Override
	public void addProfile(Profile profile) {
		profileDao.addProfile(profile);
	}

	@Override
	public List<Profile> findAllUser() {
		return profileDao.list();
	}

	@Override
	public void removeProfile(String profileId) {
		profileDao.removeProfile(profileId);
	}

}
