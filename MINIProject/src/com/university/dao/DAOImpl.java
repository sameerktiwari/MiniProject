package com.university.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.university.entities.Application;

public class DAOImpl {
	
	public void getProgrammes() throws Exception{
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from programs_offered");
		System.out.println("ProgramName Description Applicant_Eligibility Duration Degree_certificate_offered");
		while(rs.next()){
			String pName=rs.getString(1);
			String pDesc=rs.getString(2);
			String pElig=rs.getString(3);
			int pDur=rs.getInt(4);
			String pDegree=rs.getString(5);
			System.out.println(pName+" "+pDesc+" "+pElig+" "+pDur+" "+pDegree);
			}
		conn.close();
	}
	
	public void getStatus(int app_id) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="select status from application where application_id=?";
		PreparedStatement pseq=conn.prepareStatement(app);
		pseq.setInt(1,app_id);
		ResultSet rs=pseq.executeQuery();
		String status="";
		if(rs.next())
			status=rs.getString(1);
		System.out.println("Application ID: "+app_id+"\nApplication Status: "+status);
		conn.close();
	}
	public void getApplications() throws Exception{
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from application");
		Application app;
		System.out.println("ApplicationID Full_name Date_of_birth Highest_qualification Marks_obtained Goals EmailID Scheduled_Program_ID Status Date_of_interview");
		while(rs.next()){
			app=new Application(rs.getInt(1),rs.getString(2),rs.getDate(3)+"",rs.getString(4),
					rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));/*
			int app_id=rs.getInt(1);
			String aName=rs.getString(2);
			Date aDob=Date.valueOf(rs.getString(3));
			String aHqual=rs.getString(4);
			
			String aElig=rs.getString(3);
			int pDur=rs.getInt(4);
			String pDegree=rs.getString(5);*/
			//System.out.println(app.applicationId+" "+app.getFullName()+" "+app.getDateOfBirth()+" "+pDur+" "+pDegree);
			}
		conn.close();
	}
	public void submit(Application applicant) throws Exception{
		Date dob1=Date.valueOf(applicant.getDateOfBirth());
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
		pstmt.setString(2,applicant.getFullName());
		pstmt.setDate(3,dob1);
		pstmt.setString(4,applicant.getHighestQualification());
		pstmt.setInt(5,applicant.getMarksObtained());
		pstmt.setString(6,applicant.getGoals());
		pstmt.setString(7,applicant.getEmail());
		pstmt.setString(8,applicant.getScheduledProgramId());
		pstmt.execute();
		String genappid="select app_id.currval from dual";
		PreparedStatement gen=conn.prepareStatement(genappid);
		ResultSet rs1=gen.executeQuery();
		if(rs1.next())
			app_id=rs1.getInt(1);
		System.out.println("Application Submitted Successfully");
		conn.close();
	}
}
