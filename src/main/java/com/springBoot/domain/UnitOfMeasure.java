package com.springBoot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String description;
	

	public UnitOfMeasure(){

	}

	public UnitOfMeasure(String description){
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
    
}
