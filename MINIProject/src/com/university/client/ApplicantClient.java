package com.university.client;

import java.sql.Date;
import java.util.Scanner;

import com.university.dao.DAOImpl;
import com.university.entities.Application;

public class ApplicantClient {
	private static DAOImpl dao=new DAOImpl();
	public static void showApplicantClient() throws Exception{
		Scanner in=new Scanner(System.in);
		System.out.println("\t1 View Programs");
		System.out.println("\t2 Apply Here");
		System.out.println("\t3 View Status");
		System.out.println("Enter your Choice:");
		int choice1=in.nextInt();
		switch(choice1){
		case 1:	try {
			dao.getProgrammes();
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
				dao.submit(newApp);
				System.out.println("Application Id: "+newApp.genId());
				} catch (Exception e) {
				e.printStackTrace();
				}
				break;	
		
		case 3: try {
					System.out.println("Enter your Application ID");
					int app_id=in.nextInt();
					dao.getStatus(app_id);
					} catch (Exception e) {
					e.printStackTrace();
					}
					break;	
		}
		
	}
}
