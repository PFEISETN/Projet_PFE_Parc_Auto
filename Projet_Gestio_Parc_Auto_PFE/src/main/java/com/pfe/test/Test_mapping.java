package com.pfe.test;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.pfe.dao.HibernateUtil;
public class Test_mapping {
	public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	}

}
