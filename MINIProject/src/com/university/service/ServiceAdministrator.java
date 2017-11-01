package com.university.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.university.entities.Application;

import com.university.entities.ProgramsOffered;

public class ServiceAdministrator implements IAdministrator {

	public ServiceAdministrator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertProgram(ProgramsOffered programsOffered) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProgram(ProgramsOffered programsOffered) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProgram(ProgramsOffered programsOffered) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addscheduleProgram(ProgramScheduled programScheduled) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteScheduleProgram(ProgramScheduled programScheduled) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<ProgramsOffered> getAllProgram() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProgramScheduled> getAllSceduledProgram() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Application> allApplication(
			ProgramScheduled programScheduled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProgramScheduled> getAllProgramInPeriod(LocalDate start,
			LocalDate end) {
		// TODO Auto-generated method stub
		return null;
	}

}
