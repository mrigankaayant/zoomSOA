package com.ayantsoft.zoom.dao;

import java.util.List;

import com.ayantsoft.zoom.pojo.Meeting;

public interface MeetingDao {
	
	List<Meeting> list(String batchId);
	List<Meeting> listAllMeeting();

}
