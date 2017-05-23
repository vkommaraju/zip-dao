package com.dxc.zurich.innovation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "exports")
@SequenceGenerator(name = "export_sequence", sequenceName = "export_id_seq")
public class Export extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String fileSize;
	private String path;
	private String eventId;
	private Date dateExported;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "export_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFileSize() {
		return fileSize;
	}
	
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Date getDateExported() {
		return dateExported;
	}

	public void setDateExported(Date dateExported) {
		this.dateExported = dateExported;
	}
}