package com.anabatic.usm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.anabatic.usm.service.api.UserService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    @Autowired
    UserService service;
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
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
