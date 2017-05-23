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
@Table(name = "reviewer_rating")
@SequenceGenerator(name = "reviewer_rating_sequence", sequenceName = "reviewer_rating_id_seq")
public class ReviewerRating extends AbstractEntity {
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private String ratingDate;
	private long ratingDateMillis;
	private Reviewer reviewer;
	private Idea idea;
	private ReviewCategory reviewCategory;
	private int rating;
	private Event event;
	private Integer level;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reviewer_rating_sequence")
	public Integer getId() {
		return id;
	}
	
	public String getRatingDate() {
		return ratingDate;
	}
	
	public long getRatingDateMillis() {
		return ratingDateMillis;
	}
	
	@JoinColumn(name = "reviewer", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Reviewer getReviewer() {
		return reviewer;
	}
	
	@JoinColumn(name = "idea", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Idea getIdea() {
		return idea;
	}
	
	@JoinColumn(name = "reviewCategory", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public ReviewCategory getReviewCategory() {
		return reviewCategory;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setRatingDate(String ratingDate) {
		this.ratingDate = ratingDate;
	}
	
	public void setRatingDateMillis(long ratingDateMillis) {
		this.ratingDateMillis = ratingDateMillis;
	}
	
	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}
	
	public void setIdea(Idea idea) {
		this.idea = idea;
	}
	
	public void setReviewCategory(ReviewCategory reviewCategory) {
		this.reviewCategory = reviewCategory;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

	@JoinColumn(name = "event", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}