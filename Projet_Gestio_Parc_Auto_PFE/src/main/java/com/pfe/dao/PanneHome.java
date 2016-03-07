package com.pfe.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import com.pfe.persistance.Panne;

public class PanneHome {
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

	public void persist(Panne p) {
		try {
			sessionFactory.getCurrentSession().persist(p);
		} catch (RuntimeException re) {
			throw re;
		}
	}
//	public void add(Panne p) {
//		try {
//			sessionFactory.getCurrentSession().persist(p);
//		} catch (RuntimeException re) {
//			throw re;
//		}
//	}
	public void delete(Panne p) {
		try {
			sessionFactory.getCurrentSession().delete(p);
		} catch (RuntimeException re) {
			throw re;
		}
	}


	public Panne merge(Panne p) {
		try {
			Panne result = (Panne) sessionFactory.getCurrentSession()
					.merge(p);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
 
	public Panne findById(Integer id) {
		try {
			Panne instance = (Panne) sessionFactory.getCurrentSession()
					.get(Panne.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}
 
	@SuppressWarnings("unchecked")
	public List<Panne> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Panne.class);
		return crit.list();

	}

}
