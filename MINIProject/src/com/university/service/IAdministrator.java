package com.university.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.university.entities.Application;
import com.university.entities.ProgramScheduled;
import com.university.entities.ProgramsOffered;

public interface IAdministrator {
	/*
	 * Add a new program to the curriculum
	 */
	void insertProgram(ProgramsOffered programsOffered);
	void deleteProgram(ProgramsOffered programsOffered);
	void updateProgram(ProgramsOffered programsOffered);
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
	ArrayList<ProgramsOffered> getAllProgram();
	
	/*
	 * This Functionality lets administrator to see all the scheduled programs created 
	 * whether the scheduled program is currently active or not or deleted that does not affect.
	 * we have to list all
	 */
	ArrayList<ProgramScheduled> getAllSceduledProgram();
	
	/*
	 * View list of applications Accepted/Rejected/Confirmed for a particular Scheduled Program 
	 * parameter 
	 * 			Scheduled Program
	 */
	ArrayList<Application> allApplication(ProgramScheduled programScheduled);
	
	/*
	 * View information of Programs Scheduled to Commence in a given time period
	 */
	ArrayList<ProgramScheduled> getAllProgramInPeriod(LocalDate start, LocalDate end);
}
