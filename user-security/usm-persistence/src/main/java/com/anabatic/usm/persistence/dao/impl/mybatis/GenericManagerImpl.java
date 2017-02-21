package com.anabatic.usm.persistence.dao.impl.mybatis;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.anabatic.usm.persistence.config.ConfigurationDatabase;
import com.anabatic.usm.persistence.dao.GenericMapper;
import com.anabatic.usm.persistence.util.GenericObjectUtil;




public class GenericManagerImpl<PK extends Serializable,M extends GenericMapper<T, PK>	 , T>  {
	
	@Autowired
	ConfigurationDatabase confDB;
	
	protected SqlSession sqlSession = null;  
	
	protected Class<M> clazz =  null;
	protected M dao  = null;
	
	public GenericManagerImpl(Class<M> clazz){
		this.clazz = clazz;
	}	
	
	public void openDB() {
		sqlSession = confDB.dataConfig().getInstance().openSession();
		this.dao = this.sqlSession.getMapper(clazz);
	}

	public void closeDB() {
		sqlSession.close();
	}

	public void commitDB() {
		sqlSession.commit();
	}

	public void rollbackDB() {
		sqlSession.rollback();	
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(T object) {
		this.openDB();
		try {
			object = (T) GenericObjectUtil.setGenericObjectValue(object);
			return dao.findAll(object);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.closeDB();
		}
		
	}

	@SuppressWarnings("unchecked")
	public void insert(T record) {
		this.openDB();
		try {
			record = (T) GenericObjectUtil.setGenericObjectValue(record);
			dao.insert(record);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeDB();
		}
		
	}

	@SuppressWarnings("unchecked")
	public T get(T object) {
		this.openDB();
		try {
			object = (T) GenericObjectUtil.setGenericObjectValue(object);
			return dao.get(object);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			this.closeDB();
		}
		
	}

	@SuppressWarnings("unchecked")
	public void delete(T object) {
		this.openDB();
		try {
			object = (T) GenericObjectUtil.setGenericObjectValue(object);
			dao.delete(object);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeDB();
		}
		
	}
}
