package com.university.client;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import com.university.entities.Application;
import com.university.service.ServiceComittee;

public class TestUI {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Application a1 = new Application("fullName"," dateOfBirth",
				" highestQualification", 50," goals", " email",
				" scheduledProgramId");
		a1.setApplicationId(1);
		Application a2 = new Application("myname"," death",
				" latest", 10," no goal", " dont haveit",
				" anyone");
		a2.setApplicationId(2);
		ArrayList<Application> appList = new ArrayList<Application>();
		appList.add(a1);
		appList.add(a2);
		ServiceComittee.showApplicationList(appList);
		
    }

}
