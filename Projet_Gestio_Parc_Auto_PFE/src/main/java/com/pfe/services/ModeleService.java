package com.pfe.services;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.pfe.dao.HibernateUtil;
import com.pfe.dao.ModeleHome;
import com.pfe.persistance.Modele;
public class ModeleService {
	
	private ModeleHome dao;
 
	public ModeleService () {
		
		dao = new ModeleHome();
	}
	public void ajouterModele(Modele m) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.persist(m);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}
	
	public void supprimerModele(Modele m) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			dao.delete(m);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}
	public Modele modifierModele(Modele m) {
		Modele mar = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			mar = dao.merge(m);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return mar;
	}
	public Modele rechercheModeleParId(Integer id) {
		Modele m = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			m= dao.findById(id);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return m;
	}
	
	////////liste Modele/////////////
	public List<Modele> rechercheTousModele() {
		List<Modele> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAllWithJoin();
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
}