package com.dxc.zurich.innovation.entity;

import java.util.Date;
import java.util.UUID;

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
@Table(name = "implement_history")
@SequenceGenerator(name = "implement_history_sequence", sequenceName = "implement_id_seq")
public class ImplementHistory extends AbstractEntity {
	
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private String uid;
	private String ideaOwner;
	private String implementationOwner;
	private String signOffOwner;
	private Date dueDate;
	private ImplementStatus implementationStatus;
	private ImplementStatus signOffStatus;
	private String notes;
	private String comments;
	private Idea idea;
	
	@JoinColumn(name = "idea", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "implement_history_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@GeneratedValue(generator="system-uuid")
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		if(uid == null) {
			uid = UUID.randomUUID().toString();
		}
		this.uid = uid;
	}
	
	public String getIdeaOwner() {
		return ideaOwner;
	}

	public void setIdeaOwner(String ideaOwner) {
		this.ideaOwner = ideaOwner;
	}

	public String getImplementationOwner() {
		return implementationOwner;
	}

	public void setImplementationOwner(String implementationOwner) {
		this.implementationOwner = implementationOwner;
	}

	public String getSignOffOwner() {
		return signOffOwner;
	}

	public void setSignOffOwner(String signOffOwner) {
		this.signOffOwner = signOffOwner;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@JoinColumn(name = "implementstatus", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public ImplementStatus getImplementationStatus() {
		return implementationStatus;
	}

	public void setImplementationStatus(ImplementStatus implementationStatus) {
		this.implementationStatus = implementationStatus;
	}

	@JoinColumn(name = "signoffstatus", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public ImplementStatus getSignOffStatus() {
		return signOffStatus;
	}

	public void setSignOffStatus(ImplementStatus signOffStatus) {
		this.signOffStatus = signOffStatus;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}