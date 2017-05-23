package com.csc.innovation.dao.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csc.innovation.dao.util.HibernateUtil;
import com.csc.innovation.entity.AbstractEntity;
import com.dxc.innovation.dao.AbstractDAO;

/**
 * 
 * @author Veerabhadra A K Kommaraju
 */
public abstract class AbstractDAOService implements AbstractDAO {
	private static final Logger logger = LoggerFactory.getLogger(AbstractDAOService.class);
	   
	@Override
	public void create(AbstractEntity e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
		logger.info("Entity saved successfully, Entity="+e.getClass().getSimpleName());
	}
	
	@Override
	public void update(AbstractEntity e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
		session.close();
		logger.info("Entity updated successfully, Entity Details="+e.getClass().getSimpleName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> list(String entity) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<AbstractEntity> list = session.createQuery("from "+entity).list();
		return list;
	}

	@Override
	public <T> AbstractEntity getEntityById(int id, Class<T> entityClass) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		AbstractEntity e = (AbstractEntity) session.get(entityClass, new Integer(id));
		session.close();
		logger.info("Entity loaded successfully, Entity details="+e.getClass().getSimpleName());
		
		return e;
	}

	@Override
	public <T> void remove(int id, Class<T> entityClass) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		AbstractEntity e = (AbstractEntity) session.get(entityClass, new Integer(id));
		if(null != e) {
			session.delete(e);
		}
		session.getTransaction().commit();
		session.close();
		logger.info("Entity deleted successfully, Entity details="+e.getClass().getSimpleName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractEntity> executeQuery(String queryString) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		return session.createQuery(queryString).getResultList();
	}
}