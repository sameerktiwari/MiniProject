package com.university.entities;
import java.sql.*;

public class Application {
	public int applicationId;
	private String fullName;
	private String dateOfBirth;
	private String highestQualification;
	private int marksObtained;
	private String email;
	private String goals;
	private String scheduledProgramId;
	public String status;
	public Date dateOfInterview;
	
	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public Date getDateOfInterview() {
		return dateOfInterview;
	}

	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}

	public Application(String fullName,String dateOfBirth,
			String highestQualification, int marksObtained,String goals, String email,
			String scheduledProgramId){
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.marksObtained = marksObtained;
		this.email = email;
		this.goals = goals;
		this.scheduledProgramId = scheduledProgramId;
	}
	
	public Application(int applicationId,String fullName,String dateOfBirth,
			String highestQualification, int marksObtained,String goals, String email,
			String scheduledProgramId){
		this.applicationId=applicationId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.marksObtained = marksObtained;
		this.email = email;
		this.goals = goals;
		this.scheduledProgramId = scheduledProgramId;
	}
	
	/**/
	
	public String getFullName() {
		return fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public String getEmail() {
		return email;
	}

	public String getGoals() {
		return goals;
	}

	public String getScheduledProgramId() {
		return scheduledProgramId;
	}

	public int genId(){
		return applicationId;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", fullName="
				+ fullName + ", dateOfBirth=" + dateOfBirth
				+ ", highestQualification=" + highestQualification
				+ ", marksObtained=" + marksObtained + ", email=" + email
				+ ", goals=" + goals + ", scheduledProgramId="
				+ scheduledProgramId + ", status=" + status
				+ ", dateOfInterview=" + dateOfInterview + "]";
	}
	
	
	
	
}
