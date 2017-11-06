package com.university.entities;
/**
 * @author GroupNo.5
 * Encapsulated view of application in the form 
 * of participant 
 *
 */
public class Participant {
	private int rollNo;
	private String emailId;
	private int applicantId;
	private int scheduledProgramId;
	
	
	public Participant(int rollNo, String emailId, int applicantId,
			int scheduledProgramId) {
		super();
		this.rollNo = rollNo;
		this.emailId = emailId;
		this.applicantId = applicantId;
		this.scheduledProgramId = scheduledProgramId;
	}


	public int getRollNo() {
		return rollNo;
	}


	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public int getApplicantId() {
		return applicantId;
	}


	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}


	public int getScheduledProgramId() {
		return scheduledProgramId;
	}


	public void setScheduledProgramId(int scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}


	@Override
	public String toString() {
		return "Participant [rollNo=" + rollNo + ", emailId=" + emailId
				+ ", applicantId=" + applicantId + ", scheduledProgramId="
				+ scheduledProgramId + "]";
	}
	
	
	
	
}
