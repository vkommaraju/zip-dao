package com.dxc.zurich.innovation.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ideas")
@SequenceGenerator(name = "idea_sequence", sequenceName = "idea_id_seq")
public class Idea extends AbstractEntity {
	
	public static final String APPROVED = "APPROVED";
	public static final String NEW = "NEW";
	public static final String DRAFT = "DRAFT";
	public static final String NOT_APPROVED = "NOT_APPROVED";
	public static final String NEED_MORE_INFO = "NEED_MORE_INFO";
	public static final String DUPLICATE = "DUPLICATE";
	public static final String DELETED = "DELETED";
	
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private User user;
	private Approver reviewer;
	private String coauthor;
	private String postDateString;
	private String year;
	private String title;
	private String category;
	private int totalRating;
	private int totalVisitors;
	private int totalViews;
	@Lob
	@Column( length = 100000 )
	private String description;
	
	private String document1Name;
	private String document2Name;
	private String document3Name;
	private boolean spotLight;
	private boolean deleteIdea;
	private List<Comment> comments;
	private Event event;
	private String status;
	private List<Rating> ratings;
	private List<FundingPledge> fundingPledges;
	@Lob
	@Column( length = 100000 )
	private String rejectReason;
	
	private String editedDateText;
	private Date editDate;
	
	private String spotlightDateText;
	private Date spotlightDate;
	
	private String approvedDateText;
	private Date approvedDate;
	private List<Category> categories;
	
	// Idea benefits
	private String currentStage;
	private String savings;
	private String proSavings;
	private String proSavingsRange;
	private String earnings;
	private String proEarnings;
	private String proEarningsRange;
	private String implCost;
	private String payback;
	private String roi;
	private String proRoi;
	private String proImplCost;
	private String proPayback;
	private String proRoiRange;
	private String proImplCostRange;
	private String proPaybackRange;
	private String reviewStatus;
	private String source;
	
	public int getTotalVisitors() {
		return totalVisitors;
	}

	public void setTotalVisitors(int totalVisitors) {
		this.totalVisitors = totalVisitors;
	}

	public int getTotalViews() {
		return totalViews;
	}

	public void setTotalViews(int totalViews) {
		this.totalViews = totalViews;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idea")
	public List<FundingPledge> getFundingPledges() {
		return fundingPledges;
	}

	public void setFundingPledges(List<FundingPledge> fundingPledges) {
		this.fundingPledges = fundingPledges;
	}

	public int getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(int totalRating) {
		this.totalRating = totalRating;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idea")
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public void addRating(Rating rating) {
		this.getRatings().add(rating);
		rating.setIdea(this);
	}
	
	@ManyToMany
	public List<Category> getCategories() {
		return categories;
	}
	
	public void addCategoryValue(Category category) {
	      if (!getCategories().contains(category)) {
	    	  getCategories().add(category);
	      }
	      if (!category.getIdeas().contains(this)) {
	    	  category.getIdeas().add(this);
	      }
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public String getSpotlightDateText() {
		return spotlightDateText;
	}

	public void setSpotlightDateText(String spotlightDateText) {
		this.spotlightDateText = spotlightDateText;
	}

	public Date getSpotlightDate() {
		return spotlightDate;
	}

	public void setSpotlightDate(Date spotlightDate) {
		this.spotlightDate = spotlightDate;
	}

	public String getApprovedDateText() {
		return approvedDateText;
	}

	public void setApprovedDateText(String approvedDateText) {
		this.approvedDateText = approvedDateText;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getEditedDateText() {
		return editedDateText;
	}

	public void setEditedDateText(String editedDateText) {
		this.editedDateText = editedDateText;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idea_sequence")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idea", targetEntity=Comment.class)
	public List<Comment> getComments() {
		return comments;
	}

	public void addComment(Comment comment) {
		this.getComments().add(comment);
		comment.setIdea(this);
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@JoinColumn(name = "event", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public Event getEvent() {
		 return event;
	}
	
	public void setEvent(Event event) {
		 this.event = event;
	}
	
	@JoinColumn(name = "user", referencedColumnName = "id")
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@JoinColumn(name = "reviewer", referencedColumnName = "id")
	@ManyToOne
	public Approver getReviewer() {
		return reviewer;
	}
	public void setReviewer(Approver reviewer) {
		this.reviewer = reviewer;
	}	
	
	public String getPostDateString() {
		return postDateString;
	}
	public void setPostDateString(String postDateString) {
		this.postDateString = postDateString;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDocument1Name() {
		return document1Name;
	}
	public void setDocument1Name(String document1Name) {
		this.document1Name = document1Name;
	}
	public String getDocument2Name() {
		return document2Name;
	}
	public void setDocument2Name(String document2Name) {
		this.document2Name = document2Name;
	}
	public String getDocument3Name() {
		return document3Name;
	}
	public void setDocument3Name(String document3Name) {
		this.document3Name = document3Name;
	}
	public boolean isSpotLight() {
		return spotLight;
	}
	public void setSpotLight(boolean spotLight) {
		this.spotLight = spotLight;
	}
	public String getCoauthor() {
		return coauthor;
	}
	public void setCoauthor(String coauthor) {
		this.coauthor = coauthor;
	}

	public boolean getDeleteIdea() {
		return deleteIdea;
	}

	public void setDeleteIdea(boolean delete) {
		this.deleteIdea = delete;
	}

	public String getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}
	
	public String getSavings() {
		return savings;
	}

	public void setSavings(String savings) {
		this.savings = savings;
	}

	public String getProSavings() {
		return proSavings;
	}

	public void setProSavings(String proSavings) {
		this.proSavings = proSavings;
	}

	public String getEarnings() {
		return earnings;
	}

	public void setEarnings(String earnings) {
		this.earnings = earnings;
	}

	public String getProEarnings() {
		return proEarnings;
	}

	public void setProEarnings(String proEarnings) {
		this.proEarnings = proEarnings;
	}

	public String getImplCost() {
		return implCost;
	}

	public void setImplCost(String implCost) {
		this.implCost = implCost;
	}

	public String getPayback() {
		return payback;
	}

	public void setPayback(String payback) {
		this.payback = payback;
	}

	public String getRoi() {
		return roi;
	}

	public void setRoi(String roi) {
		this.roi = roi;
	}

	public String getProRoi() {
		return proRoi;
	}

	public void setProRoi(String proRoi) {
		this.proRoi = proRoi;
	}

	public String getProImplCost() {
		return proImplCost;
	}

	public void setProImplCost(String proImplCost) {
		this.proImplCost = proImplCost;
	}

	public String getProPayback() {
		return proPayback;
	}

	public void setProPayback(String proPayback) {
		this.proPayback = proPayback;
	}

	public String getProSavingsRange() {
		return proSavingsRange;
	}

	public void setProSavingsRange(String proSavingsRange) {
		this.proSavingsRange = proSavingsRange;
	}

	public String getProEarningsRange() {
		return proEarningsRange;
	}

	public void setProEarningsRange(String proEarningsRange) {
		this.proEarningsRange = proEarningsRange;
	}

	public String getProRoiRange() {
		return proRoiRange;
	}

	public void setProRoiRange(String proRoiRange) {
		this.proRoiRange = proRoiRange;
	}

	public String getProImplCostRange() {
		return proImplCostRange;
	}

	public void setProImplCostRange(String proImplCostRange) {
		this.proImplCostRange = proImplCostRange;
	}

	public String getProPaybackRange() {
		return proPaybackRange;
	}

	public void setProPaybackRange(String proPaybackRange) {
		this.proPaybackRange = proPaybackRange;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}