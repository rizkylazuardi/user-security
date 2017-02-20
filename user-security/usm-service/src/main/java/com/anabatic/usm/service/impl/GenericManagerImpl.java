package com.anabatic.usm.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.anabatic.usm.persistence.dao.GenericMapper;
import com.anabatic.usm.service.api.GenericManager;




public class GenericManagerImpl<PK extends Serializable,M extends GenericMapper<T, PK>	 , T>  implements GenericManager<T> {
	

    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * GenericDao instance, set by constructor of child classes
     */
    protected GenericMapper<T, PK> dao;


    public GenericManagerImpl() {
    }

    public GenericManagerImpl(GenericMapper<T, PK> genericDao) {
        this.dao = genericDao;
    }

	
	@SuppressWarnings("unchecked")
	public List<T> findAll(T object) {
		return dao.findAll(object);
	}

	@SuppressWarnings("unchecked")
	public void insert(T record) {
		dao.insert(record);
	}

	@SuppressWarnings("unchecked")
	public T get(T object) {
		return dao.get(object);
	}

	@SuppressWarnings("unchecked")
	public void delete(T object) {
		dao.delete(object);
	}
}
