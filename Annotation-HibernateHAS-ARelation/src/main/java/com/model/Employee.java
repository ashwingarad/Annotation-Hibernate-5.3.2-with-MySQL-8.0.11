package com.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Composition - HAS-A Relation
 */
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private Integer salary;

	/**
	 * The @Embedded annotation is used to specify the 'pancard' entity should be
	 * stored in the 'Employee' table as a component.
	 */
	@Embedded
	private Pancard pancard;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Pancard getPancard() {
		return pancard;
	}

	public void setPancard(Pancard pancard) {
		this.pancard = pancard;
	}

}
