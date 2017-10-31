package com.university.service;

import java.util.Map;

import com.university.entities.Application;
import com.university.entities.ProgramScheduled;
public interface IComittee {
	/*
	 * He/She must be able to view all the applicant data based on Scheduled
	 * program id
	 */
	Map<Integer, Application> viewApplication(ProgramScheduled programScheduled);

}
