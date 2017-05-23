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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "events")
@SequenceGenerator(name = "event_sequence", sequenceName = "event_id_seq")
public class Event extends AbstractEntity {
	public static final int DEFAULT_SPOTLIGHT_THRESHOLD = 150;
	public static final float DEFAULT_SPOTLIGHT_AVERAGE = 4.0f;
	public static final int COMMENT_APPROVAL_ON = 1;
	public static final int COMMENT_APPROVAL_OFF = 0;
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private String eventName;
	private String createdDateText;
	private Date createdDate;
	private Date closedDate;
	private int spotlightThreshold;
	private float averageRating;
	private int commentApprovalFlag;

	@Lob
	@Column(length = 100000)
	private String closedReason;

	private String status;
	private String createdBy;
	private String year;
	private String sponsorOrg;
	private String admin;
	private String eventID;

	@Lob
	@Column(length = 100000)
	private String description;

	private String topBannerFile;
	private String middleBannerFile;
	private String leftBannerFile;

	@Lob
	@Column(length = 100000)
	private String leftColunText;

	@Lob
	@Column(length = 100000)
	private String middleSectionText;

	private String area_1_title;

	@Lob
	@Column(length = 100000)
	private String area_1_text;

	private String area_2_title;

	@Lob
	@Column(length = 100000)
	private String area_2_text;

	private String area_3_title;

	@Lob
	@Column(length = 100000)
	private String area_3_text;

	private String area_4_title;

	@Lob
	@Column(length = 100000)
	private String area_4_text;

	private String area_5_title;

	@Lob
	@Column(length = 100000)
	private String area_5_text;

	@Lob
	@Column(length = 100000)
	private String notes;

	private List<Idea> ideas;
	private List<User> users;
	private List<CategoryType> categoryTypes;
	private List<Approver> approvers;

	private String editedDateText;
	private Date editDate;
	private Integer minRating;
	private Integer maxRating;
	
	private EventInfo eventInfo = null;
	private String containerName = null;
	
	private Boolean restrictedMode = false;
	private Integer level = 0;
	
	public static final String ACTIVE = "ACTIVE";
	public static final String CLOSED = "CLOSED";

	public float getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
	
	public int getCommentApprovalFlag() {
		return commentApprovalFlag;
	}

	public void setCommentApprovalFlag(int commentApprovalFlag) {
		this.commentApprovalFlag = commentApprovalFlag;
	}

	public int getSpotlightThreshold() {
		return spotlightThreshold;
	}

	public void setSpotlightThreshold(int spotlightThreshold) {
		this.spotlightThreshold = spotlightThreshold;
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	public List<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}

	public void addIdea(Idea idea) {
		this.getIdeas().add(idea);
		idea.setEvent(this);
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	public List<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		this.getUsers().add(user);
		user.setEvent(this);
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	public List<Approver> getApprovers() {
		return approvers;
	}

	public void addApprover(Approver approver) {
		this.getApprovers().add(approver);
		approver.setEvent(this);
	}

	public void setApprovers(List<Approver> approvers) {
		this.approvers = approvers;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	public List<CategoryType> getCategoryTypes() {
		return categoryTypes;
	}

	public void addCategoryType(CategoryType categoryType) {
		this.getCategoryTypes().add(categoryType);
		categoryType.setEvent(this);
	}

	public void setCategoryTypes(List<CategoryType> categoryTypes) {
		this.categoryTypes = categoryTypes;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "event_sequence")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getCreatedDateText() {
		return createdDateText;
	}

	public void setCreatedDateText(String createdDateText) {
		this.createdDateText = createdDateText;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSponsorOrg() {
		return sponsorOrg;
	}

	public void setSponsorOrg(String sponsorOrg) {
		this.sponsorOrg = sponsorOrg;
	}

	public String getAdmin() {
		return admin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getClosedReason() {
		return closedReason;
	}

	public void setClosedReason(String closedReason) {
		this.closedReason = closedReason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTopBannerFile() {
		return topBannerFile;
	}

	public void setTopBannerFile(String topBannerFile) {
		this.topBannerFile = topBannerFile;
	}

	public String getMiddleBannerFile() {
		return middleBannerFile;
	}

	public void setMiddleBannerFile(String middleBannerFile) {
		this.middleBannerFile = middleBannerFile;
	}

	public String getLeftBannerFile() {
		return leftBannerFile;
	}

	public void setLeftBannerFile(String leftBannerFile) {
		this.leftBannerFile = leftBannerFile;
	}

	public String getLeftColunText() {
		return leftColunText;
	}

	public void setLeftColunText(String leftColunText) {
		this.leftColunText = leftColunText;
	}

	public String getMiddleSectionText() {
		return middleSectionText;
	}

	public void setMiddleSectionText(String middleSectionText) {
		this.middleSectionText = middleSectionText;
	}

	public String getArea_1_title() {
		return area_1_title;
	}

	public void setArea_1_title(String area_1_title) {
		this.area_1_title = area_1_title;
	}

	public String getArea_1_text() {
		return area_1_text;
	}

	public void setArea_1_text(String area_1_text) {
		this.area_1_text = area_1_text;
	}

	public String getArea_2_title() {
		return area_2_title;
	}

	public void setArea_2_title(String area_2_title) {
		this.area_2_title = area_2_title;
	}

	public String getArea_2_text() {
		return area_2_text;
	}

	public void setArea_2_text(String area_2_text) {
		this.area_2_text = area_2_text;
	}

	public String getArea_3_title() {
		return area_3_title;
	}

	public void setArea_3_title(String area_3_title) {
		this.area_3_title = area_3_title;
	}

	public String getArea_3_text() {
		return area_3_text;
	}

	public void setArea_3_text(String area_3_text) {
		this.area_3_text = area_3_text;
	}

	public String getArea_4_title() {
		return area_4_title;
	}

	public void setArea_4_title(String area_4_title) {
		this.area_4_title = area_4_title;
	}

	public String getArea_4_text() {
		return area_4_text;
	}

	public void setArea_4_text(String area_4_text) {
		this.area_4_text = area_4_text;
	}

	public String getArea_5_title() {
		return area_5_title;
	}

	public void setArea_5_title(String area_5_title) {
		this.area_5_title = area_5_title;
	}

	public String getArea_5_text() {
		return area_5_text;
	}

	public void setArea_5_text(String area_5_text) {
		this.area_5_text = area_5_text;
	}

	public Integer getMinRating() {
		return minRating;
	}

	public void setMinRating(Integer minRating) {
		this.minRating = minRating;
	}

	public Integer getMaxRating() {
		return maxRating;
	}

	public void setMaxRating(Integer maxRating) {
		this.maxRating = maxRating;
	}
	
	@JoinColumn(name = "eventinfo", referencedColumnName = "id")
	@OneToOne(fetch = FetchType.EAGER)
	public EventInfo getEventInfo() {
		return eventInfo;
	}

	public void setEventInfo(EventInfo eventInfo) {
		this.eventInfo = eventInfo;
	}

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public Boolean getRestrictedMode() {
		return restrictedMode;
	}

	public void setRestrictedMode(Boolean restrictedMode) {
		this.restrictedMode = restrictedMode;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}