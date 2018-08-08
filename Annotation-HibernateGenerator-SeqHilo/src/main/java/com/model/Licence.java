package com.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "licence")
public class Licence {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilo_sequence_generator")
	@GenericGenerator(name = "hilo_sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
	parameters = {
			@Parameter(name = "sequence_name", value = "hilo_seqeunce"),
			@Parameter(name = "initial_value", value = "1"), 
			@Parameter(name = "increment_size", value = "3"),
			@Parameter(name = "optimizer", value = "hilo") })
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
