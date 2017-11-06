package com.university.client;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.university.entities.Application;
import com.university.entities.ProgramsOffered;
import com.university.entities.ProgramsScheduled;
import com.university.exception.UniversityException;
import com.university.service.IUniversityService;
import com.university.service.UniveristyServiceImpl;

public class AdminClient {
	private static IUniversityService service=new UniveristyServiceImpl();
	public static void showAdminClient(){
		Scanner in=new Scanner(System.in);
		while(true){
		System.out.println("\t1 Update Programmes offered");
		System.out.println("\t2 Add a Programme");
		System.out.println("\t3 Delete a Programme");
		System.out.println("\t4 Add a Programme Schedule");
		System.out.println("\t5 Delete a Programme Schedule");
		System.out.println("\t6 Generate Report");
		System.out.println("\t7 Exit");
		System.out.println("Enter your Choice:");
		int choice=in.nextInt();
		
		switch(choice){
		case 1: 	try{
					System.out.println("Enter Programme name");
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
					service.deleteProgram(pgrm);
					service.addProgram(pgrm);
					} catch(UniversityException ue){
						System.out.println("Error Occured: "+ue.getMessage());
					}
					break;
					
		case 2:		try{
					System.out.println("Enter Programme name");
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
					pDegree1=in.nextLine();
					ProgramsOffered pgrm1=new ProgramsOffered(pName1, pDesc1, pElig1, pDur1, pDegree1);
					service.addProgram(pgrm1);
					} catch(UniversityException ue){
						System.out.println("Error Occured: "+ue.getMessage());
					}
					break;	
					
		case 3:		try{
					System.out.println("Enter Programme name");
					String pName2=in.nextLine();
					pName2=in.nextLine();
					ProgramsOffered p=new ProgramsOffered();
					p.setProgramName(pName2);
					service.deleteProgram(p);
					} catch(UniversityException ue){
						System.out.println("Error Occured: "+ue.getMessage());
					}
					break;		
					
		case 4:		try{
					System.out.println("Enter Program ID");
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
					service.addProgramSchedule(ps);
					} catch(UniversityException ue){
						System.out.println("Error Occured: "+ue.getMessage());
					}
					break;
					
		case 5:		try{
					System.out.println("Enter Scheduled Program ID");
					String psId1=in.nextLine();
					psId1=in.nextLine();
					ProgramsScheduled ps1=new ProgramsScheduled();
					ps1.setScheduledProgrammeId(psId1);
					service.deleteProgramSchedule(ps1);} 
					catch(UniversityException ue){
						System.out.println("Error Occured: "+ue.getMessage());
					}
					break;
					
		case 6:		try{
					System.out.println("\t1 List of Applicants Confirmed");
					System.out.println("\t2 List of Applicants Accepted");
					System.out.println("\t3 List of Applicants Rejected");
					System.out.println("\t4 List of Programmes within a given time");
					System.out.println("\t5 Exit");
					System.out.println("Enter your Choice:");
					int choice1=in.nextInt();
					switch(choice1){
					case 1:	List<Application> appsConfirmed=service.getStatusApps("Confirmed");
							if(appsConfirmed.isEmpty())
								throw new UniversityException("No applicants confirmed");
							//System.out.println("ApplicationID Full_name Date_of_birth Highest_qualification Marks_obtained Goals EmailID Scheduled_Program_ID Status Date_of_interview");
							System.out.format("%25s%25s%25s%25s%25s%25s%25s%25s\n","ApplicationID","Full_name","Date_of_birth","Highest_qualification","Marks_obtained","Goals","EmailID","Scheduled_Program_ID","Status","Date_of_interview");
							for(Application applicant: appsConfirmed){
								System.out.format("%25s%25s%25s%25s%25s%25s%25s%25s\n",applicant.getApplicationId(),applicant.getFullName(),applicant.getDateOfBirth(),applicant.getHighestQualification(),applicant.getMarksObtained(),applicant.getGoals(),applicant.getEmail(),applicant.getScheduledProgramId(),applicant.getStatus(),applicant.getDateOfInterview());
							}
							break;
					case 2:	List<Application> appsAccepted=service.getStatusApps("Accepted");
							if(appsAccepted.isEmpty())
								throw new UniversityException("No applications accepted");
							//System.out.println("ApplicationID Full_name Date_of_birth Highest_qualification Marks_obtained Goals EmailID Scheduled_Program_ID Status Date_of_interview");
							System.out.format("%25s%25s%25s%25s%25s%25s%25s%25s\n","ApplicationID","Full_name","Date_of_birth","Highest_qualification","Marks_obtained","Goals","EmailID","Scheduled_Program_ID","Status","Date_of_interview");
							for(Application applicant: appsAccepted){
								System.out.format("%25s%25s%25s%25s%25s%25s%25s%25s\n",applicant.getApplicationId(),applicant.getFullName(),applicant.getDateOfBirth(),applicant.getHighestQualification(),applicant.getMarksObtained(),applicant.getGoals(),applicant.getEmail(),applicant.getScheduledProgramId(),applicant.getStatus(),applicant.getDateOfInterview());
							}
							break;
					case 3:	List<Application> appsRejected=service.getStatusApps("Rejected");
							if(appsRejected.isEmpty())
									throw new UniversityException("No applications rejected");
							//System.out.println("ApplicationID Full_name Date_of_birth Highest_qualification Marks_obtained Goals EmailID Scheduled_Program_ID Status Date_of_interview");
							System.out.format("%25s%25s%25s%25s%25s%25s%25s%25s\n","ApplicationID","Full_name","Date_of_birth","Highest_qualification","Marks_obtained","Goals","EmailID","Scheduled_Program_ID","Status","Date_of_interview");
							
							for(Application applicant: appsRejected){
								System.out.format("%25s%25s%25s%25s%25s%25s%25s%25s\n",applicant.getApplicationId(),applicant.getFullName(),applicant.getDateOfBirth(),applicant.getHighestQualification(),applicant.getMarksObtained(),applicant.getGoals(),applicant.getEmail(),applicant.getScheduledProgramId(),applicant.getStatus(),applicant.getDateOfInterview());
							}
							break;
					case 4:	System.out.println("Enter start date(yyyy-mm-dd)");
							in.nextLine();
							Date start=Date.valueOf(LocalDate.parse(in.nextLine()));
							System.out.println("Enter end date(yyyy-mm-dd)");
							Date end=Date.valueOf(LocalDate.parse(in.nextLine()));
							List<ProgramsScheduled> psList=service.listPrograms(start,end);
							if(psList.isEmpty())
								throw new UniversityException("No Programmes scheduled in given time period");
							//System.out.println("Scheduled_program_ID ProgramName Location Start_date End_date Sessions_per_week");
							System.out.format("%25s%25s%25s%25s%25s%25s\n","Scheduled_program_ID","ProgramName","Location","Start_date","End_date","Sessions_per_week");
							for(ProgramsScheduled psd: psList){
								System.out.format("%25s%25s%25s%25s%25s%25s\n",psd.getScheduledProgrammeId(),psd.getProgramName(),psd.getLocation(),psd.getStartDate(),psd.getEndDate(),psd.getSessionsPerWeek());
								//System.out.println(psd.getScheduledProgrammeId()+" "+psd.getProgramName()+" "+psd.getLocation()+" "+psd.getStartDate()+" "+psd.getEndDate()+" "+psd.getSessionsPerWeek());
							}
							break;
							
					case 5: break;		
							
					default:System.out.println("Error Occured: Enter valid choice");			
					}
					} catch(UniversityException ue){
						System.out.println("Error Occured: "+ue.getMessage());
					}
					break;
					
		case 7:	return;			
					
		default:System.out.println("Error Occured: Enter valid choice");			
		}
		}
	}
}
