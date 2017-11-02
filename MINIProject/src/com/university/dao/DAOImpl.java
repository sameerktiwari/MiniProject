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
import com.university.entities.ProgramsOffered;
import com.university.entities.ProgramsScheduled;
import com.university.exception.UniversityException;
import com.university.utility.DBUtil;

public class DAOImpl{
	
	public List<ProgramsScheduled> getProgrammes() throws Exception{
		List<ProgramsScheduled> ps=new ArrayList<>();
			Connection conn=DBUtil.createConnection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from programs_scheduled");
			while(rs.next()){
				String pId=rs.getString(1);
				String pName=rs.getString(2);
				String pLoc=rs.getString(3);
				Date sdate=rs.getDate(4);
				Date edate=rs.getDate(5);
				int sessions=rs.getInt(6);
				ps.add(new ProgramsScheduled(pId, pName, pLoc, sdate, edate, sessions));
			}
			DBUtil.closeConnection();
			return ps;
	}
	
	
	public String getStatus(int app_id) throws Exception{
			Connection conn=DBUtil.createConnection();
			String app="select status from application where application_id=?";
			PreparedStatement pseq=conn.prepareStatement(app);
			pseq.setInt(1,app_id);
			ResultSet rs=pseq.executeQuery();
			String status="";
			if(rs.next())
				status=rs.getString(1);
			else
				throw new UniversityException("Invalid Application ID");
			DBUtil.closeConnection();
			return status;
	}
	
	public int submit(Application applicant) throws Exception{
			Date dob1=Date.valueOf(applicant.getDateOfBirth());
			Connection conn=DBUtil.createConnection();
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
			DBUtil.closeConnection();
			return app_id;
	}
	
	public List<Application> getApplications(String pId) throws Exception{
			Connection conn=DBUtil.createConnection();
			String app="select * from application where scheduled_program_id=?";
			PreparedStatement pseq=conn.prepareStatement(app);
			pseq.setString(1,pId);
			ResultSet rs=pseq.executeQuery();
			List<Application> applicants=new ArrayList<>();
			while(rs.next()){
				applicants.add(new Application(rs.getInt(1),rs.getString(2),rs.getDate(3)+"",rs.getString(4),
						rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
			DBUtil.closeConnection();
			return applicants;
			
	}
	
	public boolean validate(String loginId,String pwd,String role) throws Exception{
			Connection conn=DBUtil.createConnection();
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
			DBUtil.closeConnection();
			throw new UniversityException("Invalid LoginId/Password for the role provided");
	}

	public void updateStatus(String appId,String status) throws Exception{
		Connection conn=DBUtil.createConnection();
		String app="update application set status=? where application_id=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,status);
		pstmt.setString(2,appId);
		int res=pstmt.executeUpdate();
		DBUtil.closeConnection();
		if(res==0)
			throw new UniversityException("Invalid Application ID");
	}

	public void setInterview(String appId, Date intDate) throws Exception{
		Connection conn=DBUtil.createConnection();
		String app="update application set Date_Of_Interview=? where application_id=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setDate(1,intDate);
		pstmt.setString(2,appId);
		int res=pstmt.executeUpdate();
		DBUtil.closeConnection();
		if(res==0)
			throw new UniversityException("Invalid Application ID");
	}

	public int statusConfirm(String apId, String confirm) throws Exception{
		Connection conn=DBUtil.createConnection();
		String app="update application set status=? where application_id=? and date_of_interview is NOT NULL";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,confirm);
		pstmt.setString(2,apId);
		int updt=pstmt.executeUpdate();
		DBUtil.closeConnection();
		if(updt==0)
			throw new UniversityException("Invalid Application ID");
		return updt;
	}

	
	public void addParticipant(String apId) throws Exception{
		Connection conn=DBUtil.createConnection();
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
		DBUtil.closeConnection();
	}

	public void deleteProgram(ProgramsOffered pgrm)  throws Exception{
		Connection conn=DBUtil.createConnection();
		String app="delete from programs_offered where programName=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,pgrm.getProgramName());
		pstmt.execute();
		DBUtil.closeConnection();
	}

	public void addProgram(ProgramsOffered pgrm) throws Exception{
		Connection conn=DBUtil.createConnection();
		String app="insert into programs_offered values(?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,pgrm.getProgramName());
		pstmt.setString(2,pgrm.getDescription());
		pstmt.setString(3,pgrm.getApplicantEligibilty());
		pstmt.setInt(4,pgrm.getDuration());
		pstmt.setString(5,pgrm.getDegree());
		pstmt.execute();
		DBUtil.closeConnection();
	}

	public void addProgramSchedule(ProgramsScheduled ps) throws Exception {
		Connection conn=DBUtil.createConnection();
		String app="insert into programs_scheduled values(?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,ps.getScheduledProgrammeId());
		pstmt.setString(2,ps.getProgramName());
		pstmt.setString(3,ps.getLocation());
		pstmt.setDate(4,ps.getStartDate());
		pstmt.setDate(5,ps.getEndDate());
		pstmt.setInt(6,ps.getSessionsPerWeek());
		pstmt.execute();
		DBUtil.closeConnection();
	}

	public void deleteProgramSchedule(ProgramsScheduled ps) throws Exception{
		Connection conn=DBUtil.createConnection();
		String app="delete from programs_scheduled where scheduled_program_id=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setString(1,ps.getScheduledProgrammeId());
		pstmt.execute();
		DBUtil.closeConnection();
	}

	public List<Application> getStatusApps(String status) throws Exception{
		Connection conn=DBUtil.createConnection();
		String app="select * from application where status=?";
		PreparedStatement pseq=conn.prepareStatement(app);
		pseq.setString(1,status);
		List<Application> applicants=new ArrayList<>();
		ResultSet rs=pseq.executeQuery();
		while(rs.next()){
			Application applicant=new Application();
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
			applicants.add(applicant);
		}
		DBUtil.closeConnection();
		return applicants;
	}

	public List<ProgramsScheduled> listPrograms(Date start, Date end) throws Exception{
		Connection conn=DBUtil.createConnection();
		String app="select * from programs_scheduled where start_date>=? and end_date<=?";
		PreparedStatement pstmt=conn.prepareStatement(app);
		pstmt.setDate(1,start);
		pstmt.setDate(2,end);
		List<ProgramsScheduled> ps=new ArrayList<>();
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			String pId=rs.getString(1);
			String pName=rs.getString(2);
			String pLoc=rs.getString(3);
			Date sdate=rs.getDate(4);
			Date edate=rs.getDate(5);
			int sessions=rs.getInt(6);
			ProgramsScheduled p=new ProgramsScheduled(pId, pName, pLoc,  sdate, edate, sessions);
			ps.add(p);
			}
		DBUtil.closeConnection();
		return ps;
	}

}
