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
	
	/*public void submit() throws Exception{
		Date dob1=Date.valueOf(dateOfBirth);
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="insert into application (application_id,full_name,date_of_birth,highest_qualification,marks_obtained,goals,email_id,scheduled_program_id) "
				+ "values(?,?,?,?,?,?,?,?)";
		String appid="select app_id.nextval from dual";
		PreparedStatement pseq=conn.prepareStatement(appid);
		ResultSet rs=pseq.executeQuery();
		int app_id=0;
		if(rs.next())
			app_id=rs.getInt(1);
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setInt(1,app_id);
		pstmt.setString(2,fullName);
		pstmt.setDate(3,dob1);
		pstmt.setString(4,highestQualification);
		pstmt.setInt(5,marksObtained);
		pstmt.setString(6,goals);
		pstmt.setString(7,email);
		pstmt.setString(8,scheduledProgramId);
		pstmt.execute();
		String genappid="select app_id.currval from dual";
		PreparedStatement gen=conn.prepareStatement(genappid);
		ResultSet rs1=gen.executeQuery();
		if(rs1.next())
			app_id=rs1.getInt(1);
		this.applicationId=app_id;
		System.out.println("Application Submitted Successfully");
		conn.close();
	}*/
	
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
