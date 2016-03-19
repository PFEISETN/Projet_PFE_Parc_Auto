package com.pfe.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.pfe.dao.HibernateUtil;
import com.pfe.persistance.Compte;
import com.pfe.persistance.Personnel;
public class CompteHome {
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
	/*** Ajouter ***/
	// ////////////////////////////////////////////////////////////////////////////////////////
	public void persist(Compte compte) {
		try {
			sessionFactory.getCurrentSession().persist(compte);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	// ////////////////////////////////////////////////////////////////////////
		// ////////////////////////////////////////////////////////////////////////
		/*** Recherche ***/
		// ////////////////////////////////////////////////////////////////////////
	public Compte findByUtilisateurAndPassword(String l , String m) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Compte.class).add(Restrictions.and(Restrictions.eq("login", l),(Restrictions.eq("mot_de_passe",m))));
		return (Compte) crit.uniqueResult();

	}
	public Compte findById(Integer id) {
		try {
			Compte instance = (Compte) sessionFactory.getCurrentSession()
					.get(Compte.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

		 @SuppressWarnings("unchecked")
			public List<Compte> findAll() {
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(
						Compte.class);
				return crit.list();

			}
			
}
