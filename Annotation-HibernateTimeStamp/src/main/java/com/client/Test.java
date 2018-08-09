package com.client;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.config.HibernateUtil;
import com.model.Employee;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		Session session = HibernateUtil.getSession();

		Employee employee = new Employee();
		employee.setName("Ashwin");
		employee.setSalary(35100);

		session.save(employee);
		session.beginTransaction().commit();

		if (session.getTransaction().getStatus() == TransactionStatus.COMMITTED) {
			System.out.println("Saved");
		}

		session.close();

		Thread.sleep(5000);

		Session session2 = HibernateUtil.getSession();
		Employee employee2 = session2.get(Employee.class, 1L);
		employee2.setSalary(65000);
		session2.beginTransaction();
		session2.persist(employee2);
		session2.getTransaction().commit();

		if (session2.getTransaction().getStatus() == TransactionStatus.COMMITTED) {
			System.out.println("Updated");
		}
		session2.close();
		HibernateUtil.closeFactory();

	}
}
