package uy.com.project.dao;

import org.hibernate.Criteria;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uy.com.project.model.Project;

import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;
 

public abstract class AbstractDAO<T extends Object> implements Dao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> domainClass;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T save(T object) {
		getSession().save(object);
		return object;
	}

	@Override
	public T update(T object) {
		getSession().update(object);
		return object;
	}

	@Override
	public Project findObject(int id) {
		//return (T) getSession().createQuery("from " + getDomainClassName() + " where id=:id").uniqueResult();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Project.class);
        criteria.add(Restrictions.eq("id",id));
        return (Project) criteria.uniqueResult();
		//return null;
	}

	private String getDomainClassName() {
return getDomainClass().getName();
	}

	private Class<T> getDomainClass() {
		if (domainClass == null){
			ParameterizedType thisType = (ParameterizedType)getClass().getGenericSuperclass();
			this.domainClass = (Class<T>)thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	@Override
	public void delete(int id) {
		getSession().delete(findObject(id));
	} 

	@Override
	public List<T> listObjects() {
		return getSession().createQuery("from "+getDomainClassName()).list();
	}
}
