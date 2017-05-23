package com.dxc.zurich.innovation.dao.service;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dxc.zurich.innovation.dao.AbstractDAO;
import com.dxc.zurich.innovation.dao.util.HibernateUtil;
import com.dxc.zurich.innovation.entity.AbstractEntity;

/**
 * 
 * @author Veerabhadra A K Kommaraju
 */
public abstract class AbstractDAOService implements AbstractDAO {

	private static final Logger logger = LoggerFactory.getLogger(AbstractDAOService.class);
	   
	public void create(AbstractEntity e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
		logger.info("Entity saved successfully, Entity="+e.getClass().getSimpleName());
	}
	
	public void update(AbstractEntity e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(e);
		session.getTransaction().commit();
		session.close();
		logger.info("Entity updated successfully, Entity Details="+e.getClass().getSimpleName());
	}

	@SuppressWarnings("unchecked")
	public List<AbstractEntity> list(String entity) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<AbstractEntity> list = session.createQuery("from "+entity).list();
		return list;
	}

	public <T> AbstractEntity getEntityById(int id, Class<T> entityClass) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		AbstractEntity e = (AbstractEntity) session.get(entityClass, new Integer(id));
		session.close();
		logger.info("Entity loaded successfully, Entity details="+e.getClass().getSimpleName());
		
		return e;
	}

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
	public List<AbstractEntity> executeQuery(String queryString) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		return session.createQuery(queryString).getResultList();
	}

}