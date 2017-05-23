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
@Table(name = "reviewer_category")
@SequenceGenerator(name = "reviewer_category_sequence", sequenceName = "reviewer_category_id_seq")
public class ReviewerCategory extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_TYPE = "DEFAULT_REVIEWER";
	
	private Integer id;
	private Reviewer reviewer;
	private ReviewCategory reviewCategory;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reviewer_category_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@JoinColumn(name = "reviewer", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}

	@JoinColumn(name = "reviewCategory", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	public ReviewCategory getReviewCategory() {
		return reviewCategory;
	}

	public void setReviewCategory(ReviewCategory reviewCategory) {
		this.reviewCategory = reviewCategory;
	}
}