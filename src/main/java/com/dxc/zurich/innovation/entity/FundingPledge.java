package com.dxc.zurich.innovation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "fundingpledges")
@SequenceGenerator(name = "fundingpledge_sequence", sequenceName = "fundingpledge_id_seq")
public class FundingPledge extends AbstractEntity {
	
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private String pledgeDate;
	private long pledgeDateMillis;
	private User user;
	private Idea idea;
	
	@Lob
	@Column( length = 100000 )
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPledgeDate() {
		return pledgeDate;
	}

	public void setPledgeDate(String pledgeDate) {
		this.pledgeDate = pledgeDate;
	}

	public long getPledgeDateMillis() {
		return pledgeDateMillis;
	}

	public void setPledgeDateMillis(long pledgeDateMillis) {
		this.pledgeDateMillis = pledgeDateMillis;
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
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "fundingpledge_sequence")
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
}