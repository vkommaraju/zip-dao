package com.dxc.zurich.innovation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "visits")
@SequenceGenerator(name = "visit_sequence", sequenceName = "visit_id_seq")
public class Visit extends AbstractEntity {
	
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private Date visitDate;
	private String user;
	private int idea;
	private String event;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "visit_sequence")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public Date getVisitDate() {
		return visitDate;
	}
	
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	public int getIdea() {
		return idea;
	}
	
	public void setIdea(int idea) {
		this.idea = idea;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	}