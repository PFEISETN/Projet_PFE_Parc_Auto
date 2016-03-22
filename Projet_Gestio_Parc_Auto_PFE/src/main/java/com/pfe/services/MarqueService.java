package com.pfe.services;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.pfe.dao.HibernateUtil;
import com.pfe.dao.MarqueHome;
import com.pfe.persistance.Marque;
public class MarqueService {
	private MarqueHome dao;
 
	public MarqueService() {
		
		dao = new MarqueHome();
	}
	public void ajouterMarque(Marque m) {
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
	
	public void supprimerMarque(Marque m) {
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
	public Marque modifierMarque(Marque m) {
		Marque mar = null;
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
	public Marque rechercheMarqueParId(Integer id) {
		Marque m = null;
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
	
	////////liste Marque/////////////
	public List<Marque> rechercheTousMarque() {
		List<Marque> liste = null;
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