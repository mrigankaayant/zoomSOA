package com.ayantsoft.zoom.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ayantsoft.zoom.dao.ProfileDao;
import com.ayantsoft.zoom.pojo.Profile;

@Repository
public class ProfileDaoImpl implements ProfileDao,Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7406970563726258130L;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	@Override
	public Profile find(String userName, String password) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName).and("password").is(password));
		Profile profile = mongoTemplate.findOne(query,Profile.class);
		return profile;
	}


	@Override
	public void addProfile(Profile profile) {
		mongoTemplate.save(profile,"profile");  
	}


	@Override
	public List<Profile> list() {
		List<Profile> list = null;
		list = mongoTemplate.findAll(Profile.class);
		return list;
	}
	
	@Override
	public void removeProfile(String profileId) {
		try{
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(profileId));
			mongoTemplate.remove(query, Profile.class, "profile");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
