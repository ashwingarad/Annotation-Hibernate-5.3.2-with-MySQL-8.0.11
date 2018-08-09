package com.client;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.config.HibernateUtil;
import com.model.Employee;

public class Test {

	public static Set<ConstraintViolation<Employee>> validate(Employee employee) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
		for (ConstraintViolation<Employee> constraintViolation : constraintViolations) {
			System.out.println(constraintViolation.getPropertyPath() + " -> " + constraintViolation.getMessage());
		}
		return constraintViolations;
	}

	public static void main(String[] args) throws InterruptedException {

		Employee employee = new Employee();
		employee.setName("Ashwin");
		employee.setSalary(35100);
		employee.setEmail("abc@gmail.com");
		employee.setWorking(true);

		Set violation = Test.validate(employee);

		if (violation.isEmpty()) {
			Session session = HibernateUtil.getSession();
			session.save(employee);
			session.beginTransaction().commit();

			if (session.getTransaction().getStatus() == TransactionStatus.COMMITTED) {
				System.out.println("Saved");
			}
			session.close();

			Thread.sleep(5000);

			Session session2 = HibernateUtil.getSession();
			Employee employee2 = session2.get(Employee.class, 1L);
			employee2.setSalary(49000);

			violation = Test.validate(employee2);

			if (violation.isEmpty()) {
				session2.beginTransaction();
				session2.persist(employee2);
				session2.getTransaction().commit();

				if (session2.getTransaction().getStatus() == TransactionStatus.COMMITTED) {
					System.out.println("Updated");
				}
			}

			session2.close();
			HibernateUtil.closeFactory();
		}
		
		System.out.println("The End.......");

	}
}
