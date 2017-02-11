package com.budthapa;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;



@RunWith(SpringRunner.class)
@WebAppConfiguration
public class StatusTest {
	@Test
	public void testStatus(){
		Long value = 7L;
		assertNotNull("Value should not be null", value);
	}
	
}
