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
@Table(name = "comments")
@SequenceGenerator(name = "comment_sequence", sequenceName = "comment_id_seq")
public class Comment extends AbstractEntity {
	
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private String commentDate;
	private long commentDateMillis;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String comment;
	
	private User user;
	private Approver approver;
	private String status;
	
	@Lob
	@Column( length = 100000 )
	private String rejectReason;
	
	private long approvalDateMillis;
	private String approvalDate;
	private Idea idea;
	
	public static final String NEW = "NEW";
	public static final String APPROVED = "APPROVED";
	public static final String REJECTED = "REJECTED";
	
	@JoinColumn(name = "idea", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

	public String getCommentDate() {
		return commentDate;
	}
	
	public long getCommentDateMillis() {
		return commentDateMillis;
	}

	public void setCommentDateMillis(long commentDateMillis) {
		this.commentDateMillis = commentDateMillis;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public long getApprovalDateMillis() {
		return approvalDateMillis;
	}

	public void setApprovalDateMillis(long approvalDateMillis) {
		this.approvalDateMillis = approvalDateMillis;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "comment_sequence")
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
	
	@JoinColumn(name = "approver", referencedColumnName = "id")
	@ManyToOne
	public Approver getApprover() {
		return approver;
	}

	public void setApprover(Approver approver) {
		this.approver = approver;
	}
}