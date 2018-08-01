package com.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "licence")
public class Licence {
	@Id
	@GenericGenerator(name = "customGenerator", strategy = "com.generator.MyGenerator")
	@GeneratedValue(generator = "customGenerator")
	private String licence_no;

	@Column
	private String name;

	@Column
	private Calendar validity;

	public String getLicence_no() {
		return licence_no;
	}

	public void setLicence_no(String licence_no) {
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
