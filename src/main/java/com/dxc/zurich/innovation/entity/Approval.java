package com.dxc.zurich.innovation.entity;

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
@Table(name = "approvals")
@SequenceGenerator(name = "approval_sequence", sequenceName = "approval_id_seq")
public class Approval extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NEED_INFO = "NEED_INFO";
	public static final String GOOD_IDEA = "GOOD_IDEA";
	public static final String NOT_BAD = "NOT_BAD";
	public static final String DUPLICATE = "DUPLICATE";
	public static final String NOT_APPROVED = "NOT_APPROVED";
	public static final String USER_RESUBMIT = "USER_RESUBMIT";
	
	private Integer id = null;
	private Approver approver = null;
	private Idea idea = null;
	private String status = null;
	
	@Lob
	@Column( length = 100000 )
	private String comments = null;
	
	private Long approvalDateMillis = null;
	private String approvalDate = null;
	private Long resubmitDateMillis = null;
	private String resubmitDate = null;
	
	public Long getResubmitDateMillis() {
		return resubmitDateMillis;
	}

	public void setResubmitDateMillis(Long resubmitDateMillis) {
		this.resubmitDateMillis = resubmitDateMillis;
	}

	public String getResubmitDate() {
		return resubmitDate;
	}

	public void setResubmitDate(String resubmitDate) {
		this.resubmitDate = resubmitDate;
	}

	public Long getApprovalDateMillis() {
		return approvalDateMillis;
	}

	public void setApprovalDateMillis(Long approvalDateMillis) {
		this.approvalDateMillis = approvalDateMillis;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "approval_sequence")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JoinColumn(name = "approver", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Approver getApprover() {
		return approver;
	}

	public void setApprover(Approver approver) {
		this.approver = approver;
	}

	@JoinColumn(name = "idea", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}