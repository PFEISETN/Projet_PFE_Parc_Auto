package com.pfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.pfe.persistance.RepPanne;

public class RepPanneHome {
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
	@SuppressWarnings("unchecked")
	public List<RepPanne> findByPanne(Integer idp) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(RepPanne.class)
				.setFetchMode("panne", FetchMode.JOIN).createCriteria("panne")
				.add(Restrictions.eq("numeroPanne", idp));
		return crit.list();
	}
	@SuppressWarnings("unchecked")
	public List<RepPanne> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				RepPanne.class);
		return crit.list();

	}

}
