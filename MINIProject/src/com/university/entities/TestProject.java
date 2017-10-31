package com.university.entities;
import java.sql.*;
import java.util.Scanner;

public class TestProject {
	public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	try {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	System.out.println("Welcome to UNIVERSITY ADMISSION SYSTEM");	// TODO Auto-generated method stub
	System.out.println("Login as:");
	System.out.println("\t1 Applicant");
	System.out.println("\t2 MAC");
	System.out.println("\t3 Admin");
	
	System.out.println("Enter your Choice:");
	int choice=in.nextInt();
	switch(choice){
		case 1:	System.out.println("\t1 View Programs");
				System.out.println("\t2 Apply Here");
				System.out.println("\t3 View Status");
				System.out.println("Enter your Choice:");
				int choice1=in.nextInt();
				switch(choice1){
				case 1:	try {
					getProgrammes();
					} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					break;
				case 2: try {
						System.out.println("Enter your Full name");
						String fullName=in.nextLine();
						fullName=in.nextLine();
						System.out.println(fullName);
						System.out.println("Enter Date of Birth(yyyy-mm-dd)");
						String dob=in.next();
						Date dob1=Date.valueOf(dob);
						System.out.println(dob1);
						System.out.println("Enter your highest qualification");
						String hqual=in.nextLine();
						hqual=in.nextLine();
						System.out.println(hqual);
						System.out.println("Enter marks obtained");
						int marks=in.nextInt();
						System.out.println(marks);
						System.out.println("Enter your goals");
						String goals=in.nextLine();
						goals=in.nextLine();
						System.out.println(goals);
						System.out.println("Enter your email id");
						String emailId=in.nextLine();
						System.out.println(emailId);
						System.out.println("Enter Scheduled program id");
						String pid=in.next();
						System.out.println(pid);
						Application newApp=new Application(fullName,dob,hqual,marks,goals,emailId,pid);
						newApp.submit();
						System.out.println("Application Id: "+newApp.genId());
						} catch (Exception e) {
						e.printStackTrace();
						}
						break;	
				
				case 3: try {
							System.out.println("Enter your Application ID");
							int app_id=in.nextInt();
							getStatus(app_id);
							} catch (Exception e) {
							e.printStackTrace();
							}
							break;	
				}
				break;
		case 2:	System.out.println("\t1 View Applications");
				System.out.println("\t2 Accept/Reject Application");
				System.out.println("\t3 Participant Confirmation");
				System.out.println("Enter your Choice:");
				int choice2=in.nextInt();
				switch(choice2){
				case 1: 		
				}
		
		}
	in.close();
	}
	public static void getProgrammes() throws Exception{
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
	
	public static void getStatus(int app_id) throws Exception{
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
	public static void getApplications() throws Exception{
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

}
