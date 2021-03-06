package com.univeristy.main;
import java.sql.*;
import java.util.Scanner;

import com.university.client.AdminClient;
import com.university.client.ApplicantClient;
import com.university.client.MACClient;
import com.university.dao.DAOImpl;
import com.university.exception.UniversityException;
import com.university.service.IUniversityService;
import com.university.service.UniveristyServiceImpl;

public class UniversityUI {
	public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	IUniversityService service=new UniveristyServiceImpl();
		while(true){
		System.out.println("Welcome to UNIVERSITY ADMISSION SYSTEM");	// TODO Auto-generated method stub
		System.out.println("Login as:");
		System.out.println("\t1 Applicant");
		System.out.println("\t2 MAC");
		System.out.println("\t3 Admin");
		System.out.println("\t4 Exit");
		System.out.println("Enter your Choice:");
		int choice=in.nextInt();
		switch(choice){
			case 1:	ApplicantClient.showApplicantClient();
					break;
			case 2:	try {
						System.out.println("Enter LoginID");
						String loginId=in.nextLine();
						loginId=in.nextLine();
						System.out.println("Enter Password");
						String pwd=in.nextLine();
						if(service.validate(loginId, pwd,"mac"))
							MACClient.showMACClient();
					} catch (UniversityException ue) {
						System.out.println("Error Occured: "+ue.getMessage());
					}
					break;
			
			case 3:	try {
						System.out.println("Enter LoginID");
						String loginId=in.nextLine();
						loginId=in.nextLine();
						System.out.println("Enter Password");
						String pwd=in.nextLine();
						if(service.validate(loginId, pwd,"admin"))
							AdminClient.showAdminClient();
					} catch (UniversityException ue) {
						System.out.println("Error Occured: "+ue.getMessage());
					}
					break;
					
			case 4:	System.out.println("Thank You");
					return;		
					
			default:System.out.println("Enter valid choice");		
			}
		}
	}
}
