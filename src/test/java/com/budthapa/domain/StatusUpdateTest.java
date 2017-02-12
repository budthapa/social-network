/**
 * 
 */
package com.budthapa.domain;

/**
 * @author budthapa
 * Feb 12, 2017
 * 
 */

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.budthapa.dao.StatusUpdateDao;
import com.budthapa.domain.StatusUpdate;



@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
public class StatusUpdateTest {
	/*
	@Test
	public void testStatus(){
		Long value = 7L;
		assertNotNull("Value should not be null", value);
	}
	*/
	@Autowired
	@Qualifier("StatusUpdateDao")
	
	private StatusUpdateDao statusUpdateDao;
	
	@Test
	public void testSave(){
		StatusUpdate status=new StatusUpdate("This is a test status update");
		statusUpdateDao.save(status);
		/*
		assertNotNull("Non-null",status.getId());
		assertNotNull("Non-null",status.getAdded());
		
		StatusUpdate retrieve=statusUpdateDao.findOne(status.getId());
		assertEquals("Matching status update", status, retrieve);
		*/
	}
	
	
	
}

