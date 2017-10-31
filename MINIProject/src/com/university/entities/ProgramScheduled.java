package com.university.entities;

import java.sql.Date;

public class ProgramScheduled {
	
	private int scheduledProgrammeId;
	private String programName;
	private String location;
	private Date startDate;
	private Date endDate;
	private int sessionsPerWeek;
	
	
	public ProgramScheduled(int scheduledProgrammeId, String programName,
			String location, Date startDate, Date endDate, int sessionsPerWeek) {
		super();
		this.scheduledProgrammeId = scheduledProgrammeId;
		this.programName = programName;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sessionsPerWeek = sessionsPerWeek;
	}


	public int getScheduledProgrammeId() {
		return scheduledProgrammeId;
	}


	public void setScheduledProgrammeId(int scheduledProgrammeId) {
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
