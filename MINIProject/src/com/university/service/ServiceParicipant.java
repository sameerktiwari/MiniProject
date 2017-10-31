package com.university.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.university.entities.Application;
import com.university.entities.ProgramScheduled;

public class ServiceParicipant implements IParticipant {

	public ServiceParicipant() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<ProgramScheduled> viewScheduledProgram() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apply(ProgramScheduled programScheduled) {
		// TODO Auto-generated method stub

	}

	@Override
	public Application viewApplication(String application_Id) {
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
