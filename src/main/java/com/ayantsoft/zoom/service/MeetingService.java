package com.ayantsoft.zoom.service;

import java.util.List;

import com.ayantsoft.zoom.pojo.Meeting;

public interface MeetingService {
	
	List<Meeting> findMeetingByBatchId(String batchId);
	List<Meeting> listAllMeeting();

}
