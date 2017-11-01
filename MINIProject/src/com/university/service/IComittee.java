package com.university.service;

import java.time.LocalDate;
import java.util.Map;

import com.university.entities.Application;

public interface IComittee {
	/**
	 * He/She must be able to view all the applicant data based on Scheduled
	 * program id	 
	 * @param applicationId
	 * @return
	 */
	Map<Integer, Application> viewApplication(String applicationId);

	/**
	 * He/She must be able to view the participants for a specific scheduled
	 * program and Accept/Reject the application, update the application status
	 * accordingly. Status can be changed to ‘Confirmed’ only after, the
	 * previous status was ‘accepted’ and the date of interview is present,
	 * dated previous to or same as today’s date. If the applicant is accepted
	 * for the program, an interview date should be entered. If the applicant’s
	 * interview is conducted, the status should be changed to either Confirmed
	 * or Rejected.
	 * @param application
	 */
	void acceptApplication(Application application);

	void rejectApplication(Application application);

	void scheduleInterview(Application application, LocalDate date);

}
