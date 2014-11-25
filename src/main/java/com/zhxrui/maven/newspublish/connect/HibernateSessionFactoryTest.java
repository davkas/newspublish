package com.zhxrui.maven.newspublish.connect;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

public class HibernateSessionFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSession() {
		Session session = HibernateSessionFactory.getSession();
		if(session==null)
			System.out.println("为空");
		assertNull(session);
		fail("Not yet implemented");
	}

	@Test
	public void testCloseSession() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConfiguration() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSessionFactory() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetConfigFile() {
		fail("Not yet implemented");
	}

}
