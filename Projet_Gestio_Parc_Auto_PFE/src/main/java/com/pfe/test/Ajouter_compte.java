package com.pfe.test;
import org.hibernate.Session;

import com.pfe.dao.HibernateUtil;
import com.pfe.dao.ReparationHome;
import com.pfe.persistance.Reparation;
import com.pfe.*;
public class Ajouter_compte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReparationHome dao = new ReparationHome();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
           Reparation cmp = new Reparation();
           
           // cmp.setNumeroReparation(1);
            cmp.setDureReparation(3);
            dao.persist(cmp);
        session.getTransaction().commit(); 

	}
}
