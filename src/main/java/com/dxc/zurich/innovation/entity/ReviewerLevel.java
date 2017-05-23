package com.dxc.zurich.innovation.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "reviewer_levels")
@SequenceGenerator(name = "reviewer_level_sequence", sequenceName = "reviewer_level_id_seq")
public class ReviewerLevel extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Reviewer reviewer;
	private Integer level;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reviewer_level_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JoinColumn(name = "reviewer", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Reviewer getReviewer() {
		 return reviewer;
	}
	
	public void setReviewer(Reviewer reviewer) {
		 this.reviewer = reviewer;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}