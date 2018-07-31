package com.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.config.HibernateUtil;
import com.model.Employee;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Employee e = new Employee();
		e.setName("Abraham Lincoln");
		e.setSalary(45621);

		Transaction tx = session.beginTransaction();
		session.persist(e);
		tx.commit();

		if (tx.getStatus() == TransactionStatus.COMMITTED) {
			System.out.println("Saved");
		}
		session.close();
		HibernateUtil.closeFactory();
	}

}
