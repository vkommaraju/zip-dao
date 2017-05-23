package com.dxc.zurich.innovation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "preferences")
@SequenceGenerator(name = "preference_sequence", sequenceName = "preference_id_seq")
public class Preference extends AbstractEntity {
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private int pageSize = 20;
	private String eventID;
	private int spotlightThreshold = 50;
	private String type;
	private String user;
	
	public static final String ADMIN_TYPE = "ADMIN";
	public static final String USER_TYPE = "USER";
	
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSpotlightThreshold() {
		return spotlightThreshold;
	}

	public void setSpotlightThreshold(int spotlightThreshold) {
		this.spotlightThreshold = spotlightThreshold;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "preference_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
}