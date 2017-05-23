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
@Table(name = "ratings")
@SequenceGenerator(name = "rating_sequence", sequenceName = "rating_id_seq")
public class Rating extends AbstractEntity {
	
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private String ratingDate;
	private long ratingDateMillis;
	private User user;
	private Idea idea;
	private ReviewCategory reviewCategory;
	private int rating;
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRatingDate() {
		return ratingDate;
	}

	public void setRatingDate(String ratingDate) {
		this.ratingDate = ratingDate;
	}

	public long getRatingDateMillis() {
		return ratingDateMillis;
	}

	public void setRatingDateMillis(long ratingDateMillis) {
		this.ratingDateMillis = ratingDateMillis;
	}

	@JoinColumn(name = "idea", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "rating_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JoinColumn(name = "user", referencedColumnName = "id")
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JoinColumn(name = "criteria", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public ReviewCategory getReviewCategory() {
		return reviewCategory;
	}

	public void setReviewCategory(ReviewCategory reviewCategory) {
		this.reviewCategory = reviewCategory;
	}
}