package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Marque;


public class MarqueHome {
	

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Marque m) {
		try {
			sessionFactory.getCurrentSession().persist(m);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Marque m) {
		try {
			sessionFactory.getCurrentSession().delete(m);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Marque merge(Marque m) {
		try {
			Marque result = (Marque) sessionFactory.getCurrentSession()
					.merge(m);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Marque findById(Integer id) {
		try {
			Marque instance = (Marque) sessionFactory.getCurrentSession()
					.get(Marque.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Marque> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Marque.class);
			return crit.list();

		}
}
