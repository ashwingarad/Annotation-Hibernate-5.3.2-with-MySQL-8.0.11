package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Annotations are used for mapping java bean with the table of database. xml
 * mapping file is not required. If no Column annotation is specified, the
 * default values apply. It consider class data member as default column name.
 * If column name and data members name is the same then there is not required to
 * specify 'name' attribute inside the @Column annotation.
 */

@Entity // Specifies that the class is an entity.
@Table(name = "employee") // Specifies the primary table for the annotated entity.
public class Employee {

	@Id // To define primary key of table.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // to specify column auto increment type
	private Long id;

	@Column(name = "name") // Specifies the mapped column for a persistent property or field.
	private String name;

	@Column(name = "salary")
	private Integer salary;

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

}
