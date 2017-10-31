package com.university.client;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import com.university.dao.DAOImpl;

public class MACClient {
	private static DAOImpl dao=new DAOImpl();
	public static void showMACClient() throws Exception{
		Scanner in=new Scanner(System.in);
		System.out.println("\t1 View Applications");
		System.out.println("\t2 Accept/Reject Application");
		System.out.println("\t3 Participant Confirmation");
		System.out.println("Enter your Choice:");
		int choice=in.nextInt();
		switch(choice){
		case 1: 	System.out.println("Enter Application ID");
					String pId=in.nextLine();
					pId=in.nextLine();
					dao.getApplications(pId);
					break;
					
		case 2:		System.out.println("Enter Application ID");
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
					else{
						dao.updateStatus(appId,"Rejected");
					}
					break;			
		}
	}
}
