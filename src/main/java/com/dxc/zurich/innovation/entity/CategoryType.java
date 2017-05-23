package com.dxc.zurich.innovation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categorytypes")
@SequenceGenerator(name = "categorytype_sequence", sequenceName = "categorytype_id_seq")
public class CategoryType extends AbstractEntity {
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private List<Category> categories;
	private String typeName;
	private Event event;
	
	@JoinColumn(name = "event", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	public Event getEvent() {
		 return event;
	}
	
	public void setEvent(Event event) {
		 this.event = event;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "categorytype_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryType")
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategory(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategory(Category category) {
		this.getCategories().add(category);
		category.setCategoryType(this);
	}
}