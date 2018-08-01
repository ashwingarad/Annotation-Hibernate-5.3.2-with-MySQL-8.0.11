package com.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * @Embeddable annotation is used to specify the Pancard class will be used as a
 *             component. The Pancard class cannot have a primary key of its
 *             own, it uses the enclosing class primary key.
 */

@Entity
@Embeddable
public class Pancard {

	@Column(name = "pan_num", nullable = false)
	private String pan_num;

	public String getPan_num() {
		return pan_num;
	}

	public void setPan_num(String pan_num) {
		this.pan_num = pan_num;
	}

}
