package com.pfe.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.pfe.dao.HibernateUtil;
import com.pfe.persistance.Compte;
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
				Compte.class).add(Restrictions.and(Restrictions.eq("login", l),(Restrictions.eq("motDePasse",m))));
		return (Compte) crit.uniqueResult();

	}
		 @SuppressWarnings("unchecked")
			public List<Compte> findAll() {
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(
						Compte.class);
				return crit.list();

			}
			
}
