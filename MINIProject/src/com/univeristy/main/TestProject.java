package com.univeristy.main;
import java.sql.*;
import java.util.Scanner;

import com.university.client.AdminClient;
import com.university.client.ApplicantClient;
import com.university.client.MACClient;
import com.university.dao.DAOImpl;
import com.university.dao.IDao;
import com.university.entities.Application;
import com.university.exception.UniversityException;

public class TestProject {
	public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	DAOImpl dao=new DAOImpl();
	try {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		while(true){
		System.out.println("Welcome to UNIVERSITY ADMISSION SYSTEM");	// TODO Auto-generated method stub
		System.out.println("Login as:");
		System.out.println("\t1 Applicant");
		System.out.println("\t2 MAC");
		System.out.println("\t3 Admin");
		
		System.out.println("Enter your Choice:");
		int choice=in.nextInt();
		switch(choice){
			case 1:	try {
						ApplicantClient.showApplicantClient();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Error Occured: "+e.getMessage());
					}
					break;
			case 2:	try {
						System.out.println("Enter LoginID");
						String loginId=in.nextLine();
						loginId=in.nextLine();
						System.out.println("Enter Password");
						String pwd=in.nextLine();
						if(dao.validate(loginId, pwd,"mac"))
							MACClient.showMACClient();
					} catch (Exception e) {
						System.out.println("Error Occured: "+e.getMessage());
					}
					break;
			
			case 3:	try {
						System.out.println("Enter LoginID");
						String loginId=in.nextLine();
						loginId=in.nextLine();
						System.out.println("Enter Password");
						String pwd=in.nextLine();
						if(dao.validate(loginId, pwd,"admin"))
							AdminClient.showAdminClient();
					} catch (Exception e) {
					e.printStackTrace();
					}
					break;		
			}
		}
	}
}
