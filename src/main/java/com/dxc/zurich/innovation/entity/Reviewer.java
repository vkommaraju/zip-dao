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
@Table(name = "reviewers")
@SequenceGenerator(name = "reviewer_sequence", sequenceName = "reviewer_id_seq")
public class Reviewer extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_TYPE = "DEFAULT_REVIEWER";
	
	private Integer id;
	private String username;
	private String name;
	private String password;
	private Event event;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reviewer_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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