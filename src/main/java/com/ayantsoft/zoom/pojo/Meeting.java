package com.ayantsoft.zoom.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "meeting")
public class Meeting implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 6636795611689777237L;
	
	private Long meetingId;
	private String uuid;
	private Long meetingNumber;
	private String accountId;
	private String hostId;
	private String topic;
	private Integer duration;
	private String recordingId;
	private String recordingStart;
	private String recordingEnd;
	private String fileType;
	private Long fileSize;
	private String downloadUrl;
	private String serverUrl;
	private String status;
	private String batchId;
	
	
	public Long getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Long getMeetingNumber() {
		return meetingNumber;
	}
	public void setMeetingNumber(Long meetingNumber) {
		this.meetingNumber = meetingNumber;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getHostId() {
		return hostId;
	}
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getRecordingId() {
		return recordingId;
	}
	public void setRecordingId(String recordingId) {
		this.recordingId = recordingId;
	}
	public String getRecordingStart() {
		return recordingStart;
	}
	public void setRecordingStart(String recordingStart) {
		this.recordingStart = recordingStart;
	}
	public String getRecordingEnd() {
		return recordingEnd;
	}
	public void setRecordingEnd(String recordingEnd) {
		this.recordingEnd = recordingEnd;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}	

}
