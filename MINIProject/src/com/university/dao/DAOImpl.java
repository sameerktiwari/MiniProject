package com.university.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.university.entities.Application;

public class DAOImpl {
	
	public void getProgrammes() throws Exception{
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from programs_scheduled");
		System.out.println("Scheduled_program_ID ProgramName Location Start_date End_date Sessions_per_week");
		while(rs.next()){
			String pId=rs.getString(1);
			String pName=rs.getString(2);
			String pLoc=rs.getString(2);
			Date sdate=rs.getDate(4);
			Date edate=rs.getDate(5);
			int sessions=rs.getInt(6);
			System.out.println(pId+" "+pName+" "+pLoc+" "+sdate+" "+edate+" "+sessions);
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
	
	public void getApplications(String pId) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="select * from application where scheduled_program_id=?";
		PreparedStatement pseq=conn.prepareStatement(app);
		pseq.setString(1,pId);
		ResultSet rs=pseq.executeQuery();
		Application applicant;
		System.out.println("ApplicationID Full_name Date_of_birth Highest_qualification Marks_obtained Goals EmailID Scheduled_Program_ID Status Date_of_interview");
		while(rs.next()){
			applicant=new Application(rs.getInt(1),rs.getString(2),rs.getDate(3)+"",rs.getString(4),
					rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
			System.out.println(applicant.getApplicationId()+" "+applicant.getFullName()
					+" "+applicant.getDateOfBirth()+" "+applicant.getHighestQualification()
					+" "+applicant.getMarksObtained()+" "+applicant.getGoals()
					+" "+applicant.getScheduledProgramId()+" "+applicant.getDateOfInterview());
		}
		conn.close();
	}
	
	public boolean validateMAC(String loginId,String pwd) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="select * from users where login_id=? and password=? and role=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,loginId);
		pstmt.setString(2,pwd);
		pstmt.setString(3,"mac");
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			conn.close();
			return true;
		}
		conn.close();
		return false;
	}

	public void updateStatus(String appId,String status) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="update application set status=? where application_id=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,status);
		pstmt.setString(2,appId);
		pstmt.execute();
		conn.close();
	}

	public void setInterview(String appId, Date intDate) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="update application set Date_Of_Interview=? where application_id=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setDate(1,intDate);
		pstmt.setString(2,appId);
		pstmt.execute();
		conn.close();
	}
}
