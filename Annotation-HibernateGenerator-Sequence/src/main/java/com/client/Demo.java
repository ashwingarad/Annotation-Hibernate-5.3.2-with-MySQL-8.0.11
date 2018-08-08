package com.client;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.config.HibernateUtil;
import com.model.Licence;

public class Demo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();

		Licence licence = new Licence();
		licence.setName("ABC");
		licence.setValidity(Calendar.getInstance());

		session.beginTransaction();
		session.persist(licence);
		session.getTransaction().commit();

		if (session.getTransaction().getStatus() == TransactionStatus.COMMITTED) {
			System.out.println("Saved");
		}
		session.close();
		HibernateUtil.closeFactory();
	}

}
