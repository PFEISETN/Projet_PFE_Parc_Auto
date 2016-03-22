package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;

import com.pfe.persistance.Modele;

public class ModeleHome {

	
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	public void persist(Modele m) {
		try {
			sessionFactory.getCurrentSession().persist(m);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public void delete(Modele m) {
		try {
			sessionFactory.getCurrentSession().delete(m);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Modele merge(Modele m) {
		try {
			Modele result = (Modele) sessionFactory.getCurrentSession()
					.merge(m);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Modele findById(Integer id) {
		try {
			Modele instance = (Modele) sessionFactory.getCurrentSession()
					.get(Modele.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Modele> findAll() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Modele.class);
			return crit.list();

		}
		@SuppressWarnings("unchecked")
		public List<Modele> findAllWithJoin() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(
					Modele.class)
					.setFetchMode("marque", FetchMode.JOIN);
			return crit.list();
		}
}