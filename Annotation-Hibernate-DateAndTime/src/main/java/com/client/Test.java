package com.client;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.config.HibernateUtil;
import com.model.DateFunctinality;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();

		DateFunctinality dateFunctinality = new DateFunctinality();
		dateFunctinality.setLocalDate(LocalDate.now());
		dateFunctinality.setLocalDateTime(LocalDateTime.now());
		dateFunctinality.setDuration(Duration.ofDays(2));

		Transaction tx = session.beginTransaction();
		session.persist(dateFunctinality);
		tx.commit();
		if (tx.getStatus() == TransactionStatus.COMMITTED)
			System.out.println("Saved");

		TypedQuery<DateFunctinality> query = session.createQuery("FROM DateFunctinality n WHERE n.localDate = :date");
		query.setParameter("date", dateFunctinality.getLocalDate());
		DateFunctinality dateFunctinality2 = query.getSingleResult();

		System.out.println(dateFunctinality2.getId() + " " + dateFunctinality2.getLocalDateTime());
		session.close();

		HibernateUtil.closeFactory();
	}

}
