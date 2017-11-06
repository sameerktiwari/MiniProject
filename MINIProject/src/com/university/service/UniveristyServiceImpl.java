package com.university.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import com.university.dao.DAOImpl;
import com.university.dao.IDAO;
import com.university.entities.Application;
import com.university.entities.ProgramsOffered;
import com.university.entities.ProgramsScheduled;
import com.university.exception.UniversityException;

public class UniveristyServiceImpl implements IUniversityService {
	private IDAO dao=new DAOImpl();
	
	@Override
	public List<ProgramsScheduled> getProgrammes() throws UniversityException {
		return dao.getProgrammes();
	}

	@Override
	public String getStatus(int app_id) throws UniversityException {
		return dao.getStatus(app_id);
	}

	@Override
	public int submit(Application applicant) throws UniversityException {
		return dao.submit(applicant);
	}

	@Override
	public List<Application> getApplications(String pId) throws UniversityException {
		return dao.getApplications(pId);
	}

	@Override
	public boolean validate(String loginId, String pwd, String role) throws UniversityException {
		return dao.validate(loginId, pwd, role);
	}

	@Override
	public void updateStatus(String appId, String status) throws UniversityException {
		dao.updateStatus(appId, status);
	}

	@Override
	public void setInterview(String appId, Date intDate) throws UniversityException {
		dao.setInterview(appId, intDate);
	}

	@Override
	public int statusConfirm(String apId, String confirm) throws UniversityException {
		return dao.statusConfirm(apId, confirm);
	}

	@Override
	public void addParticipant(String apId) throws UniversityException {
		dao.addParticipant(apId);
	}

	@Override
	public void deleteProgram(ProgramsOffered pgrm) throws UniversityException {
		dao.deleteProgram(pgrm);
	}

	@Override
	public void addProgram(ProgramsOffered pgrm) throws UniversityException {
		dao.addProgram(pgrm);
	}

	@Override
	public void addProgramSchedule(ProgramsScheduled ps) throws UniversityException {
		dao.addProgramSchedule(ps);
	}

	@Override
	public void deleteProgramSchedule(ProgramsScheduled ps) throws UniversityException {
		dao.deleteProgramSchedule(ps);
	}

	@Override
	public List<Application> getStatusApps(String status) throws UniversityException {
		return dao.getStatusApps(status);
	}

	@Override
	public List<ProgramsScheduled> listPrograms(Date start, Date end) throws UniversityException {
		return dao.listPrograms(start, end);
	}
	
	@Override
	public boolean validateDetails(Application applicant) throws UniversityException {


		String email="[A-Za-z0-9_.]{1,}[@][A-Za-z]{1,}[.]{1}[A-Za-z]{3}";
		String name="[A-Za-z ]{2,}";
		boolean status=true;
		
		if(Pattern.matches(email, applicant.getEmail())==false)
		 throw new UniversityException("Invalid mailid");
		
		if(LocalDate.parse(applicant.getDateOfBirth()).isAfter(LocalDate.now()))
			throw new UniversityException("Enter valid Date of Birth");
			
		if(Pattern.matches(name, applicant.getFullName())==false)
				throw new UniversityException("Enter only alphabets (Min 2 characters required)");
		
		if(applicant.getMarksObtained()>100)
			throw new UniversityException("Marks must be less than or equal to 100");
		return status;
	}

}
