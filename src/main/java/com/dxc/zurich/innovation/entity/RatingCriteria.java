package com.dxc.zurich.innovation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "rating_criteria")
@SequenceGenerator(name = "rating_criteria_sequence", sequenceName = "rating_criteria_id_seq")
public class RatingCriteria extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String criteria;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "rating_criteria_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
}