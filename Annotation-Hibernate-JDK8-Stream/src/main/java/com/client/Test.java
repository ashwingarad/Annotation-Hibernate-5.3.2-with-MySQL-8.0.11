package com.client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.config.HibernateUtil;
import com.model.Student;

public class Test {
	private static Session session;
	private static List<Student> studentList;

	public void add() {
		Student student = new Student();
		student.setName("ABC");
		student.setMark(456);

		Student student1 = new Student();
		student1.setName("PQR");
		student1.setMark(546);

		Student student2 = new Student();
		student2.setName("XYZ");
		student2.setMark(564);

		Student student3 = new Student();
		student3.setName("LMN");
		student3.setMark(645);

		Student student4 = new Student();
		student4.setName("JKL");
		student4.setMark(546);

		session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.persist(student);
		session.persist(student1);
		session.persist(student2);
		session.persist(student3);
		session.persist(student4);
		tx.commit();

		if (tx.getStatus() == TransactionStatus.COMMITTED) {
			System.out.println("Saved");
		}
		session.close();
	}

	public void generateList() {
		session = HibernateUtil.getSession();
		studentList = session.createQuery("SELECT s FROM Student s", Student.class).list();
		session.close();
	}

	public void usingForEach() {
		System.out.println("\n----------------------- using forEach --------------------------");

		studentList.stream().forEach(s -> System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getMark()));
	}

	public void usingMap() {
		System.out.println("\n--------------------------- map ----------------------------");

		studentList.stream().map(s -> s.getName() + "\t" + s.getMark()).forEach(System.out::println);
	}

	public void usingFilter() {
		System.out.println("\n--------------------------- Filter ----------------------------");

		System.out.println("Display student details whose mark is > 500");

		studentList.stream().filter(s -> s.getMark() > 500)
				.forEach(s -> System.out.println(s.getName() + "\t" + s.getMark()));
	}

	public void usingParallelStream() {

		/**
		 * Stream API also simplifies multithreading by providing the parallelStream()
		 * method that runs operations over stream’s elements in parallel mode. The code
		 * below allows to run method doWork() in parallel for every element of the
		 * stream. Parallel Streams can be used in case of aggregate functions. Parallel
		 * Streams quickly iterate over the large-sized collections. Parallel Streams
		 * can be used if developers have performance implications with the Sequential
		 * Streams. If the environment is not multi-threaded, then Parallel Stream
		 * creates thread and can affect the new requests coming in
		 */

		System.out.println("\n--------------------------- parallelStream ----------------------------");

		studentList.parallelStream().forEach(s -> doWork(s));
	}

	private void doWork(Student s) {
		System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getMark());
	}

	private void count() {
		System.out.println("\n---------------------------------------\n");
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(10);
		list.add(50);

		list.forEach(l -> System.out.print(l + "\t"));

		System.out.println("\nDistinct count : " + list.stream().distinct().count());
		System.out.println("Total Count : " + list.stream().count());

		Stream<Integer> stream = list.stream().sorted();
		System.out.println("------Sorted order--------");
		stream.forEach(System.out::println);
		/**
		 * The distinct() method represents an intermediate operation, which creates a
		 * new stream of unique elements of the previous stream. And the count() method
		 * is a terminal operation, which returns stream’s size.
		 */
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.add();
		t.generateList();
		t.usingForEach();
		t.usingMap();
		t.usingFilter();
		t.usingParallelStream();
		t.count();
		HibernateUtil.closeFactory();

		/**
		 * java.util.stream – which contains classes for processing sequences of
		 * elements. The central API class is the Stream<T>. The following section will
		 * demonstrate how streams can be created using the existing data-provider
		 * sources. A stream() default method is added to the Collection interface and
		 * allows creating a Stream<T> using any collection as an element source.
		 * 
		 */
	}
}
