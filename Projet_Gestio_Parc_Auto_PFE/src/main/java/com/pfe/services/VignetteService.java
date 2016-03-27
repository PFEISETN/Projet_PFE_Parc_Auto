package com.pfe.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.pfe.dao.HibernateUtil;
import com.pfe.dao.VignetteHome;
import com.pfe.persistance.Vignette;

public class VignetteService {

	
	 private VignetteHome dao;
	 
		public VignetteService() {
			dao = new VignetteHome();
		}
		public void ajouterVignette(Vignette v) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				dao.persist(v);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}
		
		public void supprimerVignette(Vignette vig) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				dao.delete(vig);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}

		public Vignette modifierVignette(Vignette vig) {
			Vignette ss = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				ss = dao.merge(vig);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return ss;
		}

		public Vignette rechercheVignetteParId(Integer id) {
			Vignette vig= null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				vig = dao.findById(id);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return vig;

		}
		
		////////liste Vignette/////////////
		public List<Vignette> rechercheTousVignette() {
			List<Vignette> liste = null;
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
