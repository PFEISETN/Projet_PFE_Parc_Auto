package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Vignette;

public class VignetteHome {

	
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Vignette v) {
		try {
			sessionFactory.getCurrentSession().persist(v);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Vignette  v) {
		try {
			sessionFactory.getCurrentSession().delete(v);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Vignette merge(Vignette v) {
		try {
			Vignette result = (Vignette) sessionFactory.getCurrentSession()
					.merge(v);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Vignette findById(Integer id) {
		try {
			Vignette instance = (Vignette) sessionFactory.getCurrentSession()
					.get(Vignette.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Vignette> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Vignette.class);
			return crit.list();

		}
}
