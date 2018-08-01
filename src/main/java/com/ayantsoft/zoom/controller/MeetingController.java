package com.ayantsoft.zoom.controller;

import java.io.Serializable;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayantsoft.zoom.pojo.Meeting;
import com.ayantsoft.zoom.pojo.Profile;
import com.ayantsoft.zoom.service.MeetingService;
import com.ayantsoft.zoom.service.ProfileService;

@RestController
public class MeetingController implements Serializable {

	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 6631256935563000724L;

	@Autowired
	private MeetingService meetingService;

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/zoom/meetings/{batchId:.+}", method = RequestMethod.GET)
	public ResponseEntity<?> listMeeting(@PathVariable String batchId){
		List<Meeting> meetings = null;
		HttpStatus httpStatus = null; 
		try{
			
			Decoder decoder = Base64.getDecoder();
			byte[] b = decoder.decode(batchId);
			String val = new String(b); 
			
			meetings = meetingService.findMeetingByBatchId(val);
			if(meetings == null || meetings.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Meeting>>(meetings, httpStatus);
	}
	
	
	@RequestMapping(value = "/zoom/meetings", method = RequestMethod.GET)
	public ResponseEntity<?> listAllMeetings(){
		List<Meeting> meetings = null;
		HttpStatus httpStatus = null; 
		try{
			meetings = meetingService.listAllMeeting();
			if(meetings == null || meetings.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Meeting>>(meetings, httpStatus);
	}


	@RequestMapping(value = "/zoom/profile/{userName}/{password:.+}", method = RequestMethod.GET)
	public ResponseEntity<?> findUser(@PathVariable String userName,@PathVariable String password){
		Profile profile = null;
		HttpStatus httpStatus = null; 
		try{
			
			Decoder decoder = Base64.getDecoder();
			byte[] b = decoder.decode(password);
			String val = new String(b); 
			
			profile = profileService.findUser(userName,val);
			if(profile == null){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Profile>(profile, httpStatus);
	}



	@RequestMapping(value = "/zoom/profile", method = RequestMethod.POST)
	public ResponseEntity<?> addProfile(@RequestBody Profile profile){
		HttpStatus httpStatus = null; 
		try{
			
			if(profile.getEmail() != null){
				profile.setUserName(profile.getEmail());
			}
			if(profile.getBatchId() != null && profile.getName() != null){
				profile.setBatchId(profile.getBatchId().trim().toUpperCase());
				profile.setPassword(profile.getName().replaceAll(" ", "_")+profile.getBatchId().trim().toUpperCase());
			}
			profileService.addProfile(profile);
			httpStatus = HttpStatus.CREATED;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Profile>(profile, httpStatus);
	}
	
	
	
	
	@RequestMapping(value = "/zoom/profiles", method = RequestMethod.GET)
	public ResponseEntity<?> listUsers(){
		List<Profile> profiles = null;
		HttpStatus httpStatus = null; 
		try{
			profiles = profileService.findAllUser();
			if(profiles == null || profiles.isEmpty()){
				httpStatus = HttpStatus.NO_CONTENT;
			}else{
				httpStatus = HttpStatus.OK;
			}
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Profile>>(profiles, httpStatus);
	}
	
	
	
	@RequestMapping(value = "/zoom/profileDelete/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> deleteProfile(@PathVariable String id){
		
		HttpStatus httpStatus = null;
		List<Profile> profiles = null;
		try{
			profileService.removeProfile(id);
			profiles = profileService.findAllUser();
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			e.printStackTrace();
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Profile>>(profiles,httpStatus);
	}	
	

}
