package com.dxc.zurich.innovation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "user_sequence", sequenceName = "user_id_seq")
public class User extends AbstractEntity {
	public static final int DEFAULT_PAGE_SIZE = 25;
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private String username;
	private String name;
	private String password;
	private String email;
	private List<Idea> ideas;
	private Event event;
	private List<Role> roles;
	private List<Rating> ratings;
	private List<FundingPledge> fundingPledges;
	private int pageSize;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idea")
	public List<FundingPledge> getFundingPledges() {
		return fundingPledges;
	}
	
	public void setFundingPledges(List<FundingPledge> fundingPledges) {
		this.fundingPledges = fundingPledges;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JoinColumn(name = "event", referencedColumnName = "id")
	@ManyToOne
	public Event getEvent() {
		 return event;
	}
	
	public void setEvent(Event event) {
		 this.event = event;
	}
	
	@ManyToMany(mappedBy = "users") 
	public List<Role> getRoles() {
		return roles;
	}
	
	public void addRole(Role role) {
	    if (!getRoles().contains(role)) {
	        getRoles().add(role);
	    }
	    if (!role.getUsers().contains(this)) {
	    	role.getUsers().add(this);
	    }
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	public List<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}

	public void addIdea(Idea idea) {
		this.getIdeas().add(idea);
		idea.setUser(this);
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public void addRating(Rating rating) {
		this.getRatings().add(rating);
		rating.setUser(this);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}