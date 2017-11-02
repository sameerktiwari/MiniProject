package com.university.client;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.university.dao.DAOImpl;
import com.university.entities.Application;
import com.university.exception.UniversityException;

public class MACClient {
	private static DAOImpl dao=new DAOImpl();
	public static void showMACClient(){
		while(true){
		Scanner in=new Scanner(System.in);
		System.out.println("\t1 View Applications");
		System.out.println("\t2 Accept/Reject Application");
		System.out.println("\t3 Participant Confirmation");
		System.out.println("\t4 Exit");
		System.out.println("Enter your Choice:");
		int choice=in.nextInt();
		
		switch(choice){
		case 1: 	try{
					System.out.println("Enter Scheduled Programme ID");
					String pId=in.nextLine();
					pId=in.nextLine();
					List<Application> apps=dao.getApplications(pId);
					if(apps.isEmpty())
						throw new UniversityException("No Applications avaialable");
					System.out.println("ApplicationID Full_name Date_of_birth Highest_qualification Marks_obtained Goals EmailID Scheduled_Program_ID Status Date_of_interview");
					for(Application applicant: apps){
						System.out.println(applicant.getApplicationId()+" "+applicant.getFullName()
								+" "+applicant.getDateOfBirth()+" "+applicant.getHighestQualification()
								+" "+applicant.getMarksObtained()+" "+applicant.getGoals()
								+" "+applicant.getScheduledProgramId()+" "+applicant.getDateOfInterview());
					}
					} catch(UniversityException ue){
							System.out.println("Error Occured: "+ue.getMessage());
					}
					break;
					
		case 2:		try{
					System.out.println("Enter Application ID");
					String appId=in.nextLine();
					appId=in.nextLine();
					System.out.println("Accept (Y/N)");
					String accept=in.nextLine();
					if(accept.equals("Y")||(accept.equals("y")))
					{
						dao.updateStatus(appId,"Accepted");
						System.out.println("Enter Date of Interview(yyyy-mm-dd)");
						String interviewDate=in.nextLine();
						Date intDate=Date.valueOf(LocalDate.parse(interviewDate));
						dao.setInterview(appId,intDate);
						System.out.println("Interview Scheduled");
					}
					else if(accept.equals("N")||(accept.equals("n"))){
						dao.updateStatus(appId,"Rejected");
						System.out.println("Application rejected");
					}
					else
						throw new UniversityException("Enter valid choice");
					} catch(UniversityException ue){
						System.out.println("Error Occured: "+ue.getMessage());
					}	catch(Exception ue){
						System.out.println("Error Occured: Enter valid data");
					}
					break;	
					
		case 3:		try{
					System.out.println("Enter Application ID");
					String apId=in.nextLine();
					apId=in.nextLine();
					System.out.println("Confirm (Y/N)");
					String confirm=in.nextLine();
					if(confirm.equals("Y")||(confirm.equals("y")))
					{
						if(dao.statusConfirm(apId,"Confirmed")>0){
							dao.addParticipant(apId);
							System.out.println("Application Confirmed");
							System.out.println("Participant added successfully");
						}
					}
					else{
						dao.statusConfirm(apId,"Rejected");
						System.out.println("Application rejected");
					}
					} catch(UniversityException ue){
						System.out.println("Error Occured: "+ue.getMessage());
					}
					break;	
					
		case 4:	return;			
					
		default:System.out.println("Error Occured: Enter valid choice");			
		}
	}
	}
}
