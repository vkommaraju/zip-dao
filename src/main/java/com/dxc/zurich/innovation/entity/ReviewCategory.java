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
@Table(name = "review_category")
@SequenceGenerator(name = "review_category_sequence", sequenceName = "review_category_id_seq")
public class ReviewCategory extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String category;
	private Event event;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "review_category_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
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