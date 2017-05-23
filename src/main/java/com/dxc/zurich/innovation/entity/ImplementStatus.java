package com.dxc.zurich.innovation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "implementstatus")
@SequenceGenerator(name = "implementstatus_sequence", sequenceName = "implementstatus_id_seq")
public class ImplementStatus extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "implementstatus_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}