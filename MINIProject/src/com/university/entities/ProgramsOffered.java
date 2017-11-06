package com.university.entities;

/**
 * @author GroupNo.5
 * Programs which are on the guideline of 
 * University.Contains who are eligible 
 * the duration of the program and which degree 
 * will be given on the completion
 *
 */
public class ProgramsOffered 
{
	protected String programName;
	protected String description;
	protected String applicantEligibilty;
	protected int duration;
	protected String degree;
	
	
	public ProgramsOffered(String programName, String description,
			String applicantEligibilty, int duration, String degree) {
		super();
		this.programName = programName;
		this.description = description;
		this.applicantEligibilty = applicantEligibilty;
		this.duration = duration;
		this.degree = degree;
	}

	public ProgramsOffered() {
		super();
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


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
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
