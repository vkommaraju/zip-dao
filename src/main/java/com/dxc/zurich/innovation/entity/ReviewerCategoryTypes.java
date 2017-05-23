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
@Table(name = "reviewer_category_types")
@SequenceGenerator(name = "reviewer_category_types_sequence", sequenceName = "reviewer_category_id_seq")
public class ReviewerCategoryTypes extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_TYPE = "DEFAULT_REVIEWER";
	
	private Integer id;
	private Reviewer reviewer;
	private Category category;
	private Event event;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reviewer_category_types_sequence")
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

	@JoinColumn(name = "category", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@JoinColumn(name = "event", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Event getEvent() {
		 return event;
	}
	
	public void setEvent(Event event) {
		 this.event = event;
	}
}