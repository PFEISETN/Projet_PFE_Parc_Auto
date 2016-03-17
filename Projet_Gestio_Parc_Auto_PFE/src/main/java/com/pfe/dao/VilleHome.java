package com.pfe.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.pfe.persistance.Ville;

public class VilleHome {
private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {

			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	// Méthode d'ajout d'une ville
	public void persist(Ville v) {
		try {
			sessionFactory.getCurrentSession().persist(v);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// Méthode de suppression d'une ville
	public void delete(Ville v) {
		try {
			sessionFactory.getCurrentSession().delete(v);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// Métode de modification d'une ville
	public Ville merge(Ville v) {
		try {
			Ville result = (Ville) sessionFactory.getCurrentSession().merge(v);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// Méthode de recherche d'une ville par un clé primaire
	public Ville findById(Integer id) {
		try {
			Ville instance = (Ville) sessionFactory.getCurrentSession().get(
					Ville.class, id);

			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	//Méthode retourne la liste de tous les villes 
	@SuppressWarnings("unchecked")
	public List<Ville> findAll() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Ville.class);
		return crit.list();

	}
	
	//Méthode retourne la liste de tous les villes avec jointure
	//avec personne 
	@SuppressWarnings("unchecked")
	public List<Ville> findAllWithJoin() {
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Ville.class)
				.setFetchMode("personnel", FetchMode.JOIN);
				
		return crit.list();

	}
	
	//Méthode de recherche des villes leur nom
	@SuppressWarnings("unchecked")
	public List<Ville> findByName(String nom){
		Criteria crit = sessionFactory.getCurrentSession()
				.createCriteria(Ville.class)
				.add(Restrictions.like("nom_ville", nom));
		return crit.list();
	}

}