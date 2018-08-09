package com.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.config.HibernateUtil;
import com.model.Author;
import com.model.Book;

public class Operations {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();

		Author a1 = new Author();
		a1.setAname("Ashwin");

		Author a2 = new Author();
		a2.setAname("Mahesh");

		Author a3 = new Author();
		a3.setAname("Rahul");

		Author a4 = new Author();
		a4.setAname("Ashnil");

		List<Author> authorList1 = new ArrayList<>();
		authorList1.add(a1);
		authorList1.add(a2);

		List<Author> authorList2 = new ArrayList<>();
		authorList2.add(a3);
		authorList2.add(a4);

		Book b1 = new Book();
		b1.setBname("Java");
		b1.setPrice(600);

		Book b2 = new Book();
		b2.setBname("Dotnet");
		b2.setPrice(450);

		Book b3 = new Book();
		b3.setBname("Accountancy");
		b3.setPrice(300);

		Book b4 = new Book();
		b4.setBname("Python");
		b4.setPrice(250);

		List<Book> bookList1 = new ArrayList<>();
		bookList1.add(b1);
		bookList1.add(b2);
		bookList1.add(b3);

		List<Book> bookList2 = new ArrayList<>();
		bookList2.add(b1);
		bookList2.add(b4);

		a1.setBookList(bookList1);
		a2.setBookList(bookList1);
		a3.setBookList(bookList2);
		a4.setBookList(bookList2);

		b1.setAuthorList(authorList1);
		b2.setAuthorList(authorList2);

		session.save(a1);
		session.save(a2);
		session.save(a3);
		session.save(a4);

		session.beginTransaction().commit();
		if (session.getTransaction().getStatus() == TransactionStatus.COMMITTED) {
			System.out.println("Saved");
		}
		session.close();
		HibernateUtil.closeFactory();
	}

}
