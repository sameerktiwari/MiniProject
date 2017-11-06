package com.university.service;

import java.sql.Date;
import java.util.List;

import com.university.entities.Application;
import com.university.entities.ProgramsOffered;
import com.university.entities.ProgramsScheduled;
import com.university.exception.UniversityException;

public interface IUniversityService {

	public List<ProgramsScheduled> getProgrammes() throws UniversityException;

	public String getStatus(int app_id) throws UniversityException;

	public int submit(Application applicant) throws UniversityException;

	public List<Application> getApplications(String pId) throws UniversityException;

	public boolean validate(String loginId,String pwd,String role) throws UniversityException;

	public void updateStatus(String appId,String status) throws UniversityException;

	public void setInterview(String appId, Date intDate) throws UniversityException;

	public int statusConfirm(String apId, String confirm) throws UniversityException;

	public void addParticipant(String apId) throws UniversityException;
	
	public void deleteProgram(ProgramsOffered pgrm)  throws UniversityException;
	
	public void addProgram(ProgramsOffered pgrm) throws UniversityException;
	
	public void addProgramSchedule(ProgramsScheduled ps) throws UniversityException;
	
	public void deleteProgramSchedule(ProgramsScheduled ps) throws UniversityException;
	
	public List<Application> getStatusApps(String status) throws UniversityException;
	
	public List<ProgramsScheduled> listPrograms(Date start, Date end) throws UniversityException;

	boolean validateDetails(Application applicant) throws UniversityException;
	
}
