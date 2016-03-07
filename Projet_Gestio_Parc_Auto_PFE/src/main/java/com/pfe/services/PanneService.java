package com.pfe.services;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.pfe.dao.HibernateUtil;
import com.pfe.dao.PanneHome;
import com.pfe.persistance.Panne;

public class PanneService {
	 private PanneHome dao = new PanneHome();
	public void AjouterPanne(Panne panne) {
			
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				dao.persist(panne);
				tx.commit();
			} catch (RuntimeException ce) {
				if (tx != null)
					tx.rollback();
				ce.printStackTrace();
			}
		}

		public void supprimerPanne(Panne p) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				dao.delete(p);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
		}

		public Panne modifierPanne(Panne p) {
			Panne pm = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				pm = dao.merge(p);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return pm;
		}

		public Panne recherchePanneParId(Integer id) {
			Panne p = null;
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();

				p = dao.findById(id);
				tx.commit();

			} catch (RuntimeException ex) {

				if (tx != null)
					tx.rollback();
				ex.printStackTrace();
			}
			return p;

		}

		public List<Panne> rechercheTousPanne() {
			List<Panne> liste = null;
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
