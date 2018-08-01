package com.ayantsoft.zoom.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.zoom.dao.MeetingDao;
import com.ayantsoft.zoom.pojo.Meeting;
import com.ayantsoft.zoom.service.MeetingService;

@Service
public class MeetingServiceImpl implements Serializable,MeetingService {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -3434287572886787028L;
	
	@Autowired
	private MeetingDao meetingDao;

	@Override
	public List<Meeting> findMeetingByBatchId(String batchId) {
	
		return meetingDao.list(batchId);
	}

	@Override
	public List<Meeting> listAllMeeting() {
		return meetingDao.listAllMeeting();
	}
}
