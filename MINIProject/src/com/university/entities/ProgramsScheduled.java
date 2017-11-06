package com.university.entities;

import java.sql.Date;

/**
 * @author GroupNo.5
 * If a Program is there then when the program will be operating
 * like same program can be scheduled in different year
 * i.e. just like semester if we have programming in the 2010 the same 
 * course may be scheduled for 2011 if the university continues
 * to fund it.
 *
 */
public class ProgramsScheduled extends ProgramsOffered{
	
	private String scheduledProgrammeId;
	private String location;
	private Date startDate;
	private Date endDate;
	private int sessionsPerWeek;
	
	
	public ProgramsScheduled(String scheduledProgrammeId, String programName,
			String location, Date startDate, Date endDate, int sessionsPerWeek) {
		super();
		this.scheduledProgrammeId = scheduledProgrammeId;
		this.programName = programName;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sessionsPerWeek = sessionsPerWeek;
	}
	
	public ProgramsScheduled() {
		super();
	}


	public String getScheduledProgrammeId() {
		return scheduledProgrammeId;
	}


	public void setScheduledProgrammeId(String scheduledProgrammeId) {
		this.scheduledProgrammeId = scheduledProgrammeId;
	}


	public String getProgramName() {
		return programName;
	}


	public void setProgramName(String programName) {
		this.programName = programName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getSessionsPerWeek() {
		return sessionsPerWeek;
	}


	public void setSessionsPerWeek(int sessionsPerWeek) {
		this.sessionsPerWeek = sessionsPerWeek;
	}


	@Override
	public String toString() {
		return "ProgramScheduled [scheduledProgrammeId=" + scheduledProgrammeId
				+ ", programName=" + programName + ", location=" + location
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", sessionsPerWeek=" + sessionsPerWeek + "]";
	}
	
	
}
