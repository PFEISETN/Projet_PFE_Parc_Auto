package com.pfe.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.pfe.persistance.Personnel;
public class PersonnelHome {
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
	// Méthode d'ajout d'une personne
	public void persist(Personnel p) {
		try {
			sessionFactory.getCurrentSession().persist(p);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// Méthode de suppression d'une personne
	public void delete(Personnel p) {
		try {
			sessionFactory.getCurrentSession().delete(p);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// Métode de modification d'une personne
	public Personnel merge(Personnel p) {
		try {
			Personnel result = (Personnel) sessionFactory.getCurrentSession()
					.merge(p);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// Méthode de recherche d'une personne par un clé primaire
	public Personnel findById(Integer id) {
		try {
			Personnel instance = (Personnel) sessionFactory.getCurrentSession()
					.get(Personnel.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// Méthode retourne la liste de tous les personnels
	@SuppressWarnings("unchecked")
	public List<Personnel> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Personnel.class);
		return crit.list();

	}

	// Méthode retourne la liste de tous les personnes avec jointure
	// avec personne et societe
	@SuppressWarnings("unchecked")
	public List<Personnel> findAllWithJoin() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Personnel.class)
				.setFetchMode("ville", FetchMode.JOIN)
				.setFetchMode("societes", FetchMode.JOIN);
		return crit.list();

	}

	// Méthode de recherche des personnes pas leur nom
	@SuppressWarnings("unchecked")
	public List<Personnel> findByName(String nom) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Personnel.class)
				.add(Restrictions.like("nomPersonnel", nom));
		return crit.list();
	}

	//Méthode de recherche des personnes par la société où il travail 
	@SuppressWarnings("unchecked")
	public List<Personnel> findBySociete(Integer idSociete) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Personnel.class)
				.setFetchMode("societe", FetchMode.JOIN)
				.createCriteria("societe")
				.add(Restrictions.eq("idSociete", idSociete));
		return crit.list();
	}

	//Méthode de recherche des personnes selon leur ville
	@SuppressWarnings("unchecked")
	public List<Personnel> findByVille(Integer id) {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Personnel.class)
				.setFetchMode("ville", FetchMode.JOIN)
				.createCriteria("ville")
				.add(Restrictions.eq("idville", id));
		return crit.list();
	}


}
