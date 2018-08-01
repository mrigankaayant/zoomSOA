package com.ayantsoft.zoom.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ayantsoft.zoom.dao.MeetingDao;
import com.ayantsoft.zoom.pojo.Meeting;
import com.ayantsoft.zoom.pojo.Profile;

@Repository
public class MeetingDaoImpl implements Serializable,MeetingDao {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 7333166111440487183L;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Meeting> list(String batchId) {
		List<Meeting> meetingList = null;
		Query query = new Query();
		query.addCriteria(Criteria.where("batchId").is(batchId));
		meetingList = mongoTemplate.find(query,Meeting.class);
		return meetingList;
	}

	@Override
	public List<Meeting> listAllMeeting() {
		List<Meeting> list = null;
		list = mongoTemplate.findAll(Meeting.class);
		return list;
	}

}
