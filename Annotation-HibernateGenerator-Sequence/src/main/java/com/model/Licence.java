package com.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "licence")
public class Licence {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long licence_no;

	@Column
	private String name;

	@Column
	private Calendar validity;

	public Long getLicence_no() {
		return licence_no;
	}

	public void setLicence_no(Long licence_no) {
		this.licence_no = licence_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getValidity() {
		return validity;
	}

	public void setValidity(Calendar validity) {
		this.validity = validity;
	}
}
