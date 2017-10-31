package com.university.service;

import java.time.LocalDate;

import com.university.entities.ProgramScheduled;
import com.university.entities.ProgramsOffered;

public interface IAdministrator {
	/*
	 * Add a new program to the curriculum
	 */
	void insertProgram(ProgramsOffered programsOffered);
	void deleteProgram();
	void updateProgram();
	/*
	 * Add a new program scheduled
	 * Parameters are 
	 * 				scheduled Date
	 * 				affected commitee
	 */
	void addscheduleProgram(ProgramScheduled programScheduled);
	void deleteScheduleProgram(ProgramScheduled programScheduled);
	/*
	 * Let administrator to see all the programs created 
	 * whether the program is currently active or not that does not affect.
	 * 
	 */
	void getAllProgram();
	
	/*
	 * This Functionality lets administrator to see all the scheduled programs created 
	 * whether the scheduled program is currently active or not or deleted that does not affect.
	 * we have to list all
	 */
	void getAllSceduledProgram();
	
	/*
	 * View list of applications Accepted/Rejected/Confirmed for a particular Scheduled Program 
	 * parameter 
	 * 			Scheduled Program
	 */
	void allApplication(ProgramScheduled programScheduled);
	
	/*
	 * View information of Programs Scheduled to Commence in a given time period
	 */
	void getAllProgramInPeriod(LocalDate start, LocalDate end);
}
