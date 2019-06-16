package com.springBoot.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
	private Set<Recipie> recipies;
	
	public Category(){

	}

	public Category(String description){
		this.description = description;
	}
    
//    Getters & Setters

  // Id  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
  // Description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
  // Recipies
	public Set<Recipie> getRecipies() {
		return recipies;
	}
	public void setRecipies(Set<Recipie> recipies) {
		this.recipies = recipies;
	}

    
}
