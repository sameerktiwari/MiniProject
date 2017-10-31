package com.university.service;

import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;

import com.university.entities.Application;
import com.university.entities.ProgramScheduled;

public interface IParticipant {
	/*
	 * This option provides the applicant with information related to programs
	 * scheduled by the university, this screen has option to Apply for Program.
	 */
	ArrayList<ProgramScheduled> viewScheduledProgram();

	/*
	 * Allows an applicant to fill in and submit application form for a
	 * scheduled program, an applicant ID is auto generated at DB level
	 */
	void apply(ProgramScheduled programScheduled);

	/*
	 * An applicant should be able to view the status of application by entering
	 * the Applicantion_id
	 */
	Application viewApplication(String application_Id);

	/*
	 * View information of Programs Scheduled to Commence in a given time period
	 */
	ArrayList<ProgramScheduled> getAllProgramInPeriod(LocalDate start,
			LocalDate end);
}
