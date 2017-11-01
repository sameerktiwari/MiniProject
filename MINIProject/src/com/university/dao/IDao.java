package com.university.dao;

import java.sql.Date;

import com.university.entities.Application;

public interface IDao {

	public abstract void getProgrammes() throws Exception;

	public abstract void getStatus(int app_id) throws Exception;

	public abstract void submit(Application applicant) throws Exception;

	public abstract void getApplications(String pId) throws Exception;

	public abstract boolean validateMAC(String loginId, String pwd)
			throws Exception;

	public abstract void updateStatus(String appId, String status)
			throws Exception;

	public abstract void setInterview(String appId, Date intDate)
			throws Exception;

	public abstract int statusConfirm(String apId, String confirm)
			throws Exception;

	public abstract void addParticipant(String apId) throws Exception;

}