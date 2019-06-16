package com.springBoot.domain;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;

	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure unitMeasure;

	@ManyToOne
	private Recipie recipie;

	public Ingredient(){
	}

	public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure){
		this.description = description;
		this.amount = amount;
		this.unitMeasure = unitOfMeasure;
	}
	
	public Ingredient(String description, BigDecimal amount, 
			UnitOfMeasure unitOfMeasure, Recipie recipie){
		this.description = description;
		this.amount = amount;
		this.unitMeasure = unitOfMeasure;
		this.recipie = recipie;
	}

//        Getters & Setters
      //Id
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
	  // Amount
		public BigDecimal getAmount() {
			return amount;
		}
		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}
	  // Unit of measure	
		public UnitOfMeasure getUnitMeasure() {
			return unitMeasure;
		}
		public void setUnitMeasure(UnitOfMeasure unitMeasure) {
			this.unitMeasure = unitMeasure;
		}
	  // Recipie	
		public Recipie getRecipie() {
			return recipie;
		}
		public void setRecipie(Recipie recipie) {
			this.recipie = recipie;
		}


}
