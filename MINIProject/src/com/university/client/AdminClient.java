package com.university.client;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import com.university.dao.DAOImpl;
import com.university.entities.ProgramsOffered;
import com.university.entities.ProgramsScheduled;

public class AdminClient {
	private static DAOImpl dao=new DAOImpl();
	public static void showAdminClient() throws Exception{
		Scanner in=new Scanner(System.in);
		System.out.println("\t1 Update Programmes offered");
		System.out.println("\t2 Add a Programme");
		System.out.println("\t3 Delete a Programme");
		System.out.println("\t4 Add a Programme Schedule");
		System.out.println("\t5 Delete a Programme Schedule");
		System.out.println("\t6 Generate Report");
		System.out.println("Enter your Choice:");
		int choice=in.nextInt();
		switch(choice){
		case 1: 	System.out.println("Enter Programme name");
					String pName=in.nextLine();
					pName=in.nextLine();
					System.out.println("Enter Programme Desciption");
					String pDesc=in.nextLine();
					System.out.println("Enter Applicant Eligibility");
					String pElig=in.nextLine();
					System.out.println("Enter Programme Duration");
					int pDur=in.nextInt();
					System.out.println("Enter Degree Certificate Offered");
					String pDegree=in.nextLine();
					pDegree=in.nextLine();
					ProgramsOffered pgrm=new ProgramsOffered(pName, pDesc, pElig, pDur, pDegree);
					dao.deleteProgram(pgrm);
					dao.addProgram(pgrm);
					break;
					
		case 2:		System.out.println("Enter Programme name");
					String pName1=in.nextLine();
					pName1=in.nextLine();
					System.out.println("Enter Programme Desciption");
					String pDesc1=in.nextLine();
					System.out.println("Enter Applicant Eligibility");
					String pElig1=in.nextLine();
					System.out.println("Enter Programme Duration");
					int pDur1=in.nextInt();
					System.out.println("Enter Degree Certificate Offered");
					String pDegree1=in.nextLine();
					pDegree=in.nextLine();
					ProgramsOffered pgrm1=new ProgramsOffered(pName1, pDesc1, pElig1, pDur1, pDegree1);
					dao.addProgram(pgrm1);
					break;	
					
		case 3:		System.out.println("Enter Programme name");
					String pName2=in.nextLine();
					pName2=in.nextLine();
					ProgramsOffered p=new ProgramsOffered();
					p.setProgramName(pName2);
					dao.deleteProgram(p);
					break;		
					
		case 4:		System.out.println("Enter Program ID");
					String psId=in.nextLine();
					psId=in.nextLine();
					System.out.println("Enter Programme name");
					String psName=in.nextLine();
					System.out.println("Enter Programme Location");
					String psLoc=in.nextLine();
					System.out.println("Enter Programme start date");
					Date psStart=Date.valueOf(LocalDate.parse(in.nextLine()));
					System.out.println("Enter Programme end date");
					Date psEnd=Date.valueOf(LocalDate.parse(in.nextLine()));
					System.out.println("Enter Sessions per week");
					int psSessions=in.nextInt();
					ProgramsScheduled ps=new ProgramsScheduled(psId, psName, psLoc, psStart, psEnd, psSessions);
					dao.addProgramSchedule(ps);
					break;
					
		case 5:		System.out.println("Enter Scheduled Program ID");
					String psId1=in.nextLine();
					psId1=in.nextLine();
					ProgramsScheduled ps1=new ProgramsScheduled();
					ps1.setScheduledProgrammeId(psId1);
					dao.deleteProgramSchedule(ps1);
					break;
					
		case 6:		System.out.println("\t1 List of Applicants Confirmed");
					System.out.println("\t2 List of Applicants Accepted");
					System.out.println("\t3 List of Applicants Rejected");
					System.out.println("\t4 List of Programmes within a given time");
					System.out.println("Enter your Choice:");
					int choice1=in.nextInt();
					switch(choice1){
					case 1:	dao.getStatusApps("Confirmed");
							break;
					case 2:	dao.getStatusApps("Accepted");
							break;
					case 3:	dao.getStatusApps("Rejected");
							break;
					case 4:	System.out.println("Enter start date(yyyy-mm-dd)");
							in.nextLine();
							Date start=Date.valueOf(LocalDate.parse(in.nextLine()));
							System.out.println("Enter end date(yyyy-mm-dd)");
							Date end=Date.valueOf(LocalDate.parse(in.nextLine()));
							dao.listPrograms(start,end);
							break;		
					}
					break;			
		}
	}
}
