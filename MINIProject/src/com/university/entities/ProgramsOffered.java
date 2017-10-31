package com.university.entities;

public class ProgramsOffered 
{
	private String programName;
	private String description;
	private String applicantEligibilty;
	private String duration;
	private String degree;
	
	
	public ProgramsOffered(String programName, String description,
			String applicantEligibilty, String duration, String degree) {
		super();
		this.programName = programName;
		this.description = description;
		this.applicantEligibilty = applicantEligibilty;
		this.duration = duration;
		this.degree = degree;
	}


	public String getProgramName() {
		return programName;
	}


	public void setProgramName(String programName) {
		this.programName = programName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getApplicantEligibilty() {
		return applicantEligibilty;
	}


	public void setApplicantEligibilty(String applicantEligibilty) {
		this.applicantEligibilty = applicantEligibilty;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	@Override
	public String toString() {
		return "ProgramsOffered [programName=" + programName + ", description="
				+ description + ", applicantEligibilty=" + applicantEligibilty
				+ ", duration=" + duration + ", degree=" + degree + "]";
	}
	
	
	
}
