package com.university.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.university.entities.Application;
import com.university.entities.ProgramsOffered;
import com.university.entities.ProgramsScheduled;
import com.university.exception.UniversityException;

public class DAOImpl{
	
	/* (non-Javadoc)
	 * @see com.university.dao.IDao#getProgrammes()
	 */
	
	public void getProgrammes() throws Exception{
		int count=0;
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from programs_scheduled");
			while(rs.next()){
				if(count==0){
					System.out.println("Scheduled_program_ID ProgramName Location Start_date End_date Sessions_per_week");
					count=1;
				}
				String pId=rs.getString(1);
				String pName=rs.getString(2);
				String pLoc=rs.getString(3);
				Date sdate=rs.getDate(4);
				Date edate=rs.getDate(5);
				int sessions=rs.getInt(6);
				System.out.println(pId+" "+pName+" "+pLoc+" "+sdate+" "+edate+" "+sessions);
			}
			conn.close();
			if(count==0)
				throw new UniversityException("No Programmes avaialable");
	}
	
	/* (non-Javadoc)
	 * @see com.university.dao.IDao#getStatus(int)
	 */
	
	public void getStatus(int app_id) throws Exception{
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
			String app="select status from application where application_id=?";
			PreparedStatement pseq=conn.prepareStatement(app);
			pseq.setInt(1,app_id);
			ResultSet rs=pseq.executeQuery();
			String status="";
			if(rs.next())
				status=rs.getString(1);
			else
				throw new UniversityException("Invalid Application ID");
			System.out.println("Application ID: "+app_id+"\nApplication Status: "+status);
			conn.close();
	}
	/* (non-Javadoc)
	 * @see com.university.dao.IDao#submit(com.university.entities.Application)
	 */
	
	public int submit(Application applicant) throws Exception{
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
			System.out.println("Application Submitted Successfully");
			conn.close();
			return app_id;
	}
	
	/* (non-Javadoc)
	 * @see com.university.dao.IDao#getApplications(java.lang.String)
	 */
	
	public void getApplications(String pId) throws Exception{
		int count=0;
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
			String app="select * from application where scheduled_program_id=?";
			PreparedStatement pseq=conn.prepareStatement(app);
			pseq.setString(1,pId);
			ResultSet rs=pseq.executeQuery();
			Application applicant;
			while(rs.next()){
				if(count==0){
				System.out.println("ApplicationID Full_name Date_of_birth Highest_qualification Marks_obtained Goals EmailID Scheduled_Program_ID Status Date_of_interview");
				count=1;
				}
				applicant=new Application(rs.getInt(1),rs.getString(2),rs.getDate(3)+"",rs.getString(4),
						rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
				System.out.println(applicant.getApplicationId()+" "+applicant.getFullName()
						+" "+applicant.getDateOfBirth()+" "+applicant.getHighestQualification()
						+" "+applicant.getMarksObtained()+" "+applicant.getGoals()
						+" "+applicant.getScheduledProgramId()+" "+applicant.getDateOfInterview());
			}
			conn.close();
			if(count==0)
				throw new UniversityException("No Applications avaialable");
	}
	/* (non-Javadoc)
	 * @see com.university.dao.IDao#validateMAC(java.lang.String, java.lang.String)
	 */
	
	public boolean validate(String loginId,String pwd,String role) throws Exception{
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
			String app="select * from users where login_id=? and password=? and role=?";
			PreparedStatement pstmt=conn.prepareStatement(app);
			pstmt.setString(1,loginId);
			pstmt.setString(2,pwd);
			pstmt.setString(3,role);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				conn.close();
				return true;
			}
			conn.close();
			throw new UniversityException("Invalid LoginId/Password for the role provided");
	}

	/* (non-Javadoc)
	 * @see com.university.dao.IDao#updateStatus(java.lang.String, java.lang.String)
	 */
	
	public void updateStatus(String appId,String status) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="update application set status=? where application_id=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,status);
		pstmt.setString(2,appId);
		int res=pstmt.executeUpdate();
		conn.close();
		if(res==0)
			throw new UniversityException("Invalid Application ID");
	}

	/* (non-Javadoc)
	 * @see com.university.dao.IDao#setInterview(java.lang.String, java.sql.Date)
	 */
	
	public void setInterview(String appId, Date intDate) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="update application set Date_Of_Interview=? where application_id=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setDate(1,intDate);
		pstmt.setString(2,appId);
		int res=pstmt.executeUpdate();
		conn.close();
		if(res==0)
			throw new UniversityException("Invalid Application ID");
	}

	/* (non-Javadoc)
	 * @see com.university.dao.IDao#statusConfirm(java.lang.String, java.lang.String)
	 */
	
	public int statusConfirm(String apId, String confirm) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="update application set status=? where application_id=? and date_of_interview is NOT NULL";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,confirm);
		pstmt.setString(2,apId);
		int updt=pstmt.executeUpdate();
		conn.close();
		if(updt==0)
			throw new UniversityException("Invalid Application ID");
		return updt;
	}

	/* (non-Javadoc)
	 * @see com.university.dao.IDao#addParticipant(java.lang.String)
	 */
	
	public void addParticipant(String apId) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="select * from application where application_id=?";
		PreparedStatement pseq=conn.prepareStatement(app);
		pseq.setString(1,apId);
		ResultSet rs=pseq.executeQuery();
		Application applicant=new Application();
		if(rs.next()){
			applicant.setApplicationId(rs.getInt(1));
			applicant.setFullName(rs.getString(2));
			applicant.setDateOfBirth(rs.getDate(3)+"");
			applicant.setHighestQualification(rs.getString(4));
			applicant.setMarksObtained(rs.getInt(5));
			applicant.setGoals(rs.getString(6));
			applicant.setEmail(rs.getString(7));
			applicant.setScheduledProgramId(rs.getString(8));
			applicant.setStatus(rs.getString(9));
			applicant.setDateOfInterview(rs.getDate(10));
		}
		String app1="insert into participant values(?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(app1);
		pstmt.setString(1,"1");
		pstmt.setString(2,applicant.getEmail());
		pstmt.setInt(3,applicant.getApplicationId());
		pstmt.setString(4,applicant.getScheduledProgramId());
		pstmt.execute();
		System.out.println("Participant added successfully");
		conn.close();
	}

	public void deleteProgram(ProgramsOffered pgrm)  throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="delete from programs_offered where programName=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,pgrm.getProgramName());
		pstmt.execute();
		conn.close();
	}

	public void addProgram(ProgramsOffered pgrm) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="insert into programs_offered values(?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,pgrm.getProgramName());
		pstmt.setString(2,pgrm.getDescription());
		pstmt.setString(3,pgrm.getApplicantEligibilty());
		pstmt.setInt(4,pgrm.getDuration());
		pstmt.setString(5,pgrm.getDegree());
		pstmt.execute();
	}

	public void addProgramSchedule(ProgramsScheduled ps) throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="insert into programs_scheduled values(?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,ps.getScheduledProgrammeId());
		pstmt.setString(2,ps.getProgramName());
		pstmt.setString(3,ps.getLocation());
		pstmt.setDate(4,ps.getStartDate());
		pstmt.setDate(5,ps.getEndDate());
		pstmt.setInt(6,ps.getSessionsPerWeek());
		pstmt.execute();
	}

	public void deleteProgramSchedule(ProgramsScheduled ps) throws Exception{
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="delete from programs_scheduled where scheduled_program_id=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,ps.getScheduledProgrammeId());
		pstmt.execute();
		conn.close();
	}

	public void getStatusApps(String status) throws Exception{
		int count=0;
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="select * from application where status=?";
		PreparedStatement pseq=conn.prepareStatement(app);
		pseq.setString(1,status);
		ResultSet rs=pseq.executeQuery();
		Application applicant=new Application();
		while(rs.next()){
			if(count==0){
				System.out.println("ApplicationID Full_name Date_of_birth Highest_qualification Marks_obtained Goals EmailID Scheduled_Program_ID Status Date_of_interview");
				count=1;
			}
			applicant.setApplicationId(rs.getInt(1));
			applicant.setFullName(rs.getString(2));
			applicant.setDateOfBirth(rs.getDate(3)+"");
			applicant.setHighestQualification(rs.getString(4));
			applicant.setMarksObtained(rs.getInt(5));
			applicant.setGoals(rs.getString(6));
			applicant.setEmail(rs.getString(7));
			applicant.setScheduledProgramId(rs.getString(8));
			applicant.setStatus(rs.getString(9));
			applicant.setDateOfInterview(rs.getDate(10));
			System.out.println(applicant.getApplicationId()+" "+applicant.getFullName()
					+" "+applicant.getDateOfBirth()+" "+applicant.getHighestQualification()
					+" "+applicant.getMarksObtained()+" "+applicant.getGoals()+" "+applicant.getEmail()
					+" "+applicant.getScheduledProgramId()+" "+applicant.getStatus()+" "+applicant.getDateOfInterview()+" ");
		}
		conn.close();
		if(count==0)
			throw new UniversityException("No applications with status: "+status);
	}

	public void listPrograms(Date start, Date end) throws Exception{
		int count=0;
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Capgemini123");
		String app="select * from programs_scheduled where start_date>=? and end_date<=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setDate(1,start);
		pstmt.setDate(2,end);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			if(count==0){
				System.out.println("Scheduled_program_ID ProgramName Location Start_date End_date Sessions_per_week");
				count=1;
			}
			String pId=rs.getString(1);
			String pName=rs.getString(2);
			String pLoc=rs.getString(3);
			Date sdate=rs.getDate(4);
			Date edate=rs.getDate(5);
			int sessions=rs.getInt(6);
			System.out.println(pId+" "+pName+" "+pLoc+" "+sdate+" "+edate+" "+sessions);
			}
		conn.close();
		if(count==0)
			throw new UniversityException("No program available in given timeline");
	}

}
