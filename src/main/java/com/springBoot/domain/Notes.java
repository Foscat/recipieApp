package com.springBoot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;


@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipie recipie;

    /**
     * @Lob annotation means:
     * Specifies that a persistent property or field 
     * should be persisted as a large object to a database-supported large object type.
     */
    @Lob
	private String recipieNotes;

	public Notes(Recipie recipie, String notes){
		this.recipie = recipie;
		this.recipieNotes = notes;

	}

public Notes() {
		// TODO Auto-generated constructor stub
	}

	//  Getters & Setters
  // Id    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
  // Recipie
	public Recipie getRecipie() {
		return recipie;
	}
	public void setRecipie(Recipie recipie) {
		this.recipie = recipie;
	}
  // Recipie Notes
	public String getRecipieNotes() {
		return recipieNotes;
	}
	public void setRecipieNotes(String recipieNotes) {
		this.recipieNotes = recipieNotes;
	}

}
