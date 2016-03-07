package com.pfe.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Reparation;
public class ReparationHome {
	private final SessionFactory sessionFactory = getSessionFactory();

	// ////////////////////////////////////////////////////////////////////////
	/*** Ouvrire une session ***/
	// ///////////////////////////////////////////////////////////////////////
	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	 public void persist(Reparation p) {
		try {
			sessionFactory.getCurrentSession().persist(p);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	 public void delete(Reparation p) {
		try {
			sessionFactory.getCurrentSession().delete(p);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// Métode de modification d'une personne
	public Reparation merge(Reparation p) {
		try {
			Reparation result = (Reparation) sessionFactory.getCurrentSession()
					.merge(p);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// Méthode de recherche d'une personne par un clé primaire
	public Reparation findById(Integer id) {
		try {
			Reparation instance = (Reparation) sessionFactory
					.getCurrentSession().get(Reparation.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// Méthode retourne la liste de tous les personnels
	@SuppressWarnings("unchecked")
	public List<Reparation> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Reparation.class);
		return crit.list();
	}

/*	@SuppressWarnings("unchecked")
	public List<Reparation> findAllWithJoin() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Reparation.class)
				.setFetchMode("ville", FetchMode.JOIN)
				.setFetchMode("societes", FetchMode.JOIN);
		return crit.list();

	}*/


}
