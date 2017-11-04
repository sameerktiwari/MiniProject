package com.university.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.university.entities.Application;
import com.university.exception.UniversityException;



public class DAOImplTest {

	private DAOImpl dao;
	@Before
	public void setUp() throws Exception {
		dao=new DAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSubmit() throws UniversityException {
	
		Application newApp=new Application(1026,"Akash","1994-03-30","BTech",100,"akash@gmail.com","research","1001");
		assertEquals(1026,dao.submit(newApp));
	}

	@Test
	public void testGetApplications() {
		
	}

	@Test
	public void testValidate() throws UniversityException {
		assertTrue(dao.validate("akash","akash", "mac"));
	}

}
