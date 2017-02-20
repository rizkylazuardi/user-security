package com.anabatic.usm.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anabatic.usm.service.api.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-service-test.xml",
		"classpath:applicationContext-persistence-test.xml"})
public class AppTest {
	
    @Autowired
    UserService service;
    

    @Test
    public void testApp()
    {
    	
    	try {
    		service.openDB();
    		int user = service.getCountUser();
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(e.getMessage(), true);
		}finally{
			service.closeDB();
		}
    	
    	
        assertTrue( true );
    }
}
