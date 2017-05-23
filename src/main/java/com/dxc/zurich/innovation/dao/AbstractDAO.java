package com.dxc.zurich.innovation.dao;

import java.util.List;

import com.dxc.zurich.innovation.entity.AbstractEntity;

/**
 * Common DAO for all Entities.
 * 
 * @author Veerabhadra A K Kommaraju
 */
public interface AbstractDAO {
	/**
	 * Creates an Entity.
	 * 
	 * @param entity
	 */
	public void create(AbstractEntity entity);
	
	/**
	 * Updates an entity.
	 * 
	 * @param entity
	 */
	public void update(AbstractEntity entity);
	
	/**
	 * Lists all entities.
	 * 
	 * @param entity
	 * @return List<AbstractEntity>
	 */
	public List<AbstractEntity> list(String entity);
	
	/**
	 * Returns entity by Id.
	 * 
	 * @param id
	 * @param entityClass
	 * @return AbstractEntity
	 */
	public <T> AbstractEntity getEntityById(int id, Class<T> entityClass);
	
	/**
	 * Removes an entity.
	 * 
	 * @param id
	 * @param entityClass
	 */
	public <T> void remove(int id, Class<T> entityClass);
	
	/**
	 * Executes a given query and returns results.
	 * 
	 * @param query
	 * @return List<AbstractEntity>
	 */
	public List<AbstractEntity> executeQuery(String query);
}