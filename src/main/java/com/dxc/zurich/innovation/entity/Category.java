package com.dxc.zurich.innovation.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "categories")
@SequenceGenerator(name = "category_sequence", sequenceName = "category_id_seq")
public class Category  extends AbstractEntity {
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private List<Idea> ideas;
	private CategoryType categoryType;
	private String value;
	
	private Category parentCategory;

	private Set<Category> subCats;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "category_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JoinColumn(name = "categorytype", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	public CategoryType getCategoryType() {
		 return categoryType;
	}
	
	public void setCategoryType(CategoryType categoryType) {
		 this.categoryType = categoryType;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_category_id")
	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	
	@OneToMany(mappedBy="parentCategory")
	public Set<Category> getSubCats() {
		return subCats;
	}

	public void setSubCats(Set<Category> subCats) {
		this.subCats = subCats;
	}

	@ManyToMany(mappedBy = "categories") 
	public List<Idea> getIdeas() {
		return ideas;
	}
	
	
	public void addIdea(Idea idea) {
	    if (!getIdeas().contains(idea)) {
	    	getIdeas().add(idea);
	    }
	    if (!idea.getCategories().contains(this)) {
	    	idea.getCategories().add(this);
	    }
	}
	
	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}
}