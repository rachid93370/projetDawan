package fr.dawan.projet1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDAO<T> {

	protected EntityManager em;

	private Class<T> classEntity;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public GenericDAO(EntityManager em, Class<T> classEntity) {
		super();
		this.em = em;
		this.classEntity = classEntity;
	}

	public List<T> findAll() {

		return em.createQuery("SELECT e FROM " + classEntity.getName() + " e", classEntity).getResultList();
	}

	public T findById(long id) {

		return em.find(classEntity, id);
	}

	public void remove(long id) throws Exception{

		T entity = em.find(classEntity, id);

		if (entity == null)
			return;

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.remove(entity);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
	}
	
	public long count() {
		return em.createQuery("SELECT COUNT(e) FROM " + classEntity.getName() + " e", Long.class).getSingleResult();
	}
	
	public void saveOrUpdate(T entity) throws Exception {
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
	}
}