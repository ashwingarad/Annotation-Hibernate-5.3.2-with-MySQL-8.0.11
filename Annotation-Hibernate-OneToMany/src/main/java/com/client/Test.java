package com.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.config.HibernateUtil;
import com.model.Department;
import com.model.Teacher;

public class Test {

	public static void main(String[] args) {

		Department department = new Department();
		department.setDept_name("Science");

		Teacher teacher = new Teacher();
		teacher.setEmp_name("ABC");
		teacher.setSalary(456321);
		teacher.setDepartment(department);

		Teacher teacher2 = new Teacher();
		teacher2.setEmp_name("PQR");
		teacher2.setSalary(325641);
		teacher2.setDepartment(department);

		Teacher teacher3 = new Teacher();
		teacher3.setEmp_name("XYZ");
		teacher3.setSalary(789654);
		teacher3.setDepartment(department);

		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList.add(teacher);
		teacherList.add(teacher2);
		teacherList.add(teacher3);

		department.setTeacherList(teacherList);

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.persist(teacher);
		tx.commit();

		if (tx.getStatus() == TransactionStatus.COMMITTED) {
			System.out.println("Saved");
		}

		session.close();
		HibernateUtil.closeFactory();

	}

}
