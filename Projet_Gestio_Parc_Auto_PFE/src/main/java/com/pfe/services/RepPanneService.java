package com.pfe.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pfe.dao.HibernateUtil;
import com.pfe.dao.RepPanneHome;
import com.pfe.persistance.Panne;
import com.pfe.persistance.RepPanne;

;
public class RepPanneService {

	private RepPanneHome dao = new RepPanneHome();

	public List<RepPanne> rechercheRep_PanParPanne(Integer idpanne) {
		List<RepPanne> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByPanne(idpanne);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
	}
//	public List<Panne> ChargerListe() {
//		List<Panne> liste = null;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
//		try {
//
//			tx = session.beginTransaction();
//
//			liste = dao.a
//			tx.commit();
//
//		} catch (RuntimeException ex) {
//
//			if (tx != null)
//				tx.rollback();
//			ex.printStackTrace();
//		}
//		return (liste);
//	}

	public List<RepPanne> rechercheTousPanne() {
		List<RepPanne> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			liste = dao.findAll();
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);

	}
}
