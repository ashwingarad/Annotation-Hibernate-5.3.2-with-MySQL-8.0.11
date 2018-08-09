package com.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.config.HibernateUtil;
import com.model.Employee;
import com.model.Pancard;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();

		Employee employee = new Employee();
		employee.setName("ABC");
		employee.setSalary(45621);

		Pancard pancard = new Pancard();
		pancard.setPan_num("AHG537D");
		pancard.setEmployee(employee);

		employee.setPancard(pancard);

		Transaction tx = session.beginTransaction();
		session.persist(employee);
		tx.commit();

		if (tx.getStatus() == TransactionStatus.COMMITTED) {
			System.out.println("Saved");
		}
		session.close();
		HibernateUtil.closeFactory();
	}

}
