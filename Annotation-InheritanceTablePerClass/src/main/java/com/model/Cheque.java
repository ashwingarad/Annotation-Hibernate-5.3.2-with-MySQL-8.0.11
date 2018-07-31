package com.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "by cheque")
public class Cheque extends Payment {

	@Column
	private String cheque_type;

	public String getCheque_type() {
		return cheque_type;
	}

	public void setCheque_type(String cheque_type) {
		this.cheque_type = cheque_type;
	}

}
