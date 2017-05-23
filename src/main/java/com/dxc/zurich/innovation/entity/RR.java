package com.dxc.zurich.innovation.entity;

public class RR {
	private Integer id;
	private String name;
	private String title;
	private String ratings;
	private Integer totalRatings;
	
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
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRatings() {
		return ratings;
	}
	
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public Integer getTotalRatings() {
		return totalRatings;
	}

	public void setTotalRatings(Integer totalRatings) {
		this.totalRatings = totalRatings;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object that) {
		if(that != null && this.id == ((RR)that).id) {
			return true;
		}
		
		return false;
	}
}