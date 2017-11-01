package com.university.service;

import java.time.LocalDate;
import java.util.Map;

import com.university.dao.DAOImpl;
import com.university.entities.Application;

public class ServiceComittee implements IComittee {
	DAOImpl database;
	public ServiceComittee() {
		// TODO Auto-generated constructor stub
		database = new DAOImpl() ;
	}

	@Override
	public Map<Integer, Application> viewApplication(
			String applicationId) {
		// TODO Auto-generated method stub
		try{
			database.getApplications(applicationId);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void acceptApplication(Application application) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rejectApplication(Application application) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scheduleInterview(Application application, LocalDate date) {
		// TODO Auto-generated method stub

	}

}
