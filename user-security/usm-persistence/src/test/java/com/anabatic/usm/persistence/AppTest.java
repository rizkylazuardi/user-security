package com.anabatic.usm.persistence;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anabatic.usm.persistence.config.ConfigurationDatabase;
import com.anabatic.usm.persistence.dao.CoreUserMapper;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
@ContextConfiguration("classpath:applicationContext-persistence-test.xml")
public class AppTest 
{	
	@Autowired
	ConfigurationDatabase confDb;
   
    @org.junit.Test
    public void testApp()
    {	
    	SqlSession sqlSession = confDb.dataConfig().getInstance().openSession();
    	CoreUserMapper mapper = sqlSession.getMapper(CoreUserMapper.class);
    	
    	int result = 0;
		try{
			result = mapper.getCountUser();
		}catch(Exception e){
			e.printStackTrace();
		}
    	
        assertTrue( true );
    }
}
