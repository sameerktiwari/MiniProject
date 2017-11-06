package com.university.entities;
import java.sql.*;

/**
 * @author GroupNo. 5
 * Application by a participant for a
 * scheduled program available by the university/
 * Every attribute needed for the application will be present here
 * and depending on the progress of the Application they will
 * get updated.
 *
 */
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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public void setScheduledProgramId(String scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}

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
	
	public Application(){
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

	public Application(int applicationId, String fullName, String dateOfBirth,
			String highestQualification, int marksObtained, String email,
			String goals, String scheduledProgramId, String status,
			Date dateOfInterview) {
		super();
		this.applicationId = applicationId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.marksObtained = marksObtained;
		this.email = email;
		this.goals = goals;
		this.scheduledProgramId = scheduledProgramId;
		this.status = status;
		this.dateOfInterview = dateOfInterview;
	}
	
	
	
	
}
