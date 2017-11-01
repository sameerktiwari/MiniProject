package com.university.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.university.entities.Application;
import com.university.entities.ProgramsScheduled;
import com.university.entities.ProgramsOffered;

public interface IAdministrator {
	/**
	 * Add a new program to the curriculum
	 * @param programsOffered
	 */
	void insertProgram(ProgramsOffered programsOffered);
	/**
	 * Delete an existing program from the curriculum
	 * @param programsOffered
	 */
	void deleteProgram(ProgramsOffered programsOffered);
	/**
	 * Update a program to the curriculum
	 * @param programsOffered
	 */
	void updateProgram(ProgramsOffered programsOffered);
	/**
	 * Add a new program scheduled
	 * Parameters are 
	 * 				scheduled Date
	 * 				affected commitee
	 * @param programScheduled
	 */
	void addscheduleProgram(ProgramsScheduled programScheduled);
	/**
	 * Delete a program scheduled
	 * Parameters are 
	 * 				scheduled Date
	 * 				affected commitee
	 * @param programScheduled
	 */
	void deleteScheduleProgram(ProgramsScheduled programScheduled);
	/**
	 * Let administrator to see all the programs created 
	 * whether the program is currently active or not that does not affect.
	 * @return
	 */
	ArrayList<ProgramsOffered> getAllProgram();
	
	/**
	 * This Functionality lets administrator to see all the scheduled programs created 
	 * whether the scheduled program is currently active or not or deleted that does not affect.
	 * we have to list all
	 * @return
	 */
	ArrayList<ProgramsScheduled> getAllSceduledProgram();
	
	/**
	 * View list of applications Accepted/Rejected/Confirmed for a particular Scheduled Program 
	 * parameter 
	 * 			Scheduled Program
	 * @param programScheduled
	 * @return
	 */
	ArrayList<Application> allApplication(ProgramsScheduled programScheduled);
	
	/**
	 * View information of Programs Scheduled to Commence in a given time period
	 * @param start
	 * @param end
	 * @return
	 */
	ArrayList<ProgramsScheduled> getAllProgramInPeriod(LocalDate start, LocalDate end);
}
