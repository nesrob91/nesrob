package mx.com.elektra.msd.qb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.elektra.msd.qb.dao.TestDao;

@Service
public class TestService {

	@Autowired
	TestDao testDao;
	
	public String getTest() {
		String testDB  = testDao.getTest();
		/*
		 * Logica de negocio
		 */
		return testDB;
	}
}
