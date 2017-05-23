package com.dxc.zurich.innovation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "forgot")
@SequenceGenerator(name = "forgot_sequence", sequenceName = "forgot_id_seq")
public class ForgotPassword extends AbstractEntity {
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private String username;
	private String status;
	private String eventId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "forgot_sequence")
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
}