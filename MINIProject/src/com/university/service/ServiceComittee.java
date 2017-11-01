package com.university.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.lang.reflect.*;

import javax.management.ReflectionException;

import com.university.dao.DAOImpl;
import com.university.dao.IDao;
import com.university.entities.Application;

public class ServiceComittee implements IComittee {
	IDao database;

	public ServiceComittee() {
		// TODO Auto-generated constructor stub
		database = new DAOImpl();
	}

	@Override
	public Map<Integer, Application> viewApplication(String applicationId) {
		// TODO Auto-generated method stub
		try {
			database.getApplications(applicationId);
		} catch (Exception e) {
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
	public static String padRight(String s, int n) {
		//String.format("%10s", "foo").replace(' ', '*');
	     return String.format("%" + n + "s", s);  
	}

	public static String padLeft(String s, int n) {
	   // return String.format("%1$" + n + "s", s); 
	    return String.format("%" + n + "s", s);  
	}
	/**
	 * This method uses reflection package
	 */
	public static void showApplicationList(ArrayList<Application> listApp)
			throws IllegalArgumentException, IllegalAccessException {
		Field[] appClassField = inspect(Application.class);
		StringBuilder line = new StringBuilder("************************** ");
		int paddinfLength = appClassField.length;
		for (int i = 0; i < paddinfLength; i++) {
			System.out.print(line);
		}
		System.out.println();
		for (Field itrField : appClassField) {				
			System.out.print(padLeft(itrField.getName(),25 )+ " |" );
		}
		System.out.println();
		for (Application it : listApp) {
			System.out.println();
			
			for (Field itrField : appClassField) {				
				System.out.print(padLeft(String.valueOf(itrField.get(it)),25) + " |");
			}
			System.out.println();
		}
	}

	static <T> Field[] inspect(Class<T> klazz) {
		Field[] fields = klazz.getDeclaredFields();
		System.out.printf("%d fields:%n", fields.length);

		for (Field field : fields) {
			/**
			 * By default we can't acces private attribute using this
			 * but we can access them using set accessible true
			 */
			field.setAccessible(true);
		}
		return fields;
	}

}
