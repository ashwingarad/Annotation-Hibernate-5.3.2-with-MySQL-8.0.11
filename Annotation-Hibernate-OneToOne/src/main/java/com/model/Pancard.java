package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Pancard {

	@Id
	@GeneratedValue
	private Long pid;

	@Column
	private String pan_num;

	@OneToOne
	//@JoinColumn(name = "pid", referencedColumnName = "id")
	@PrimaryKeyJoinColumn(name = "pid", referencedColumnName = "id")
	private Employee employee;

	public Long getId() {
		return pid;
	}

	public void setId(Long pid) {
		this.pid = pid;
	}

	public String getPan_num() {
		return pan_num;
	}

	public void setPan_num(String pan_num) {
		this.pan_num = pan_num;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
