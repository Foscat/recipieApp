package com.springBoot.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Recipie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    /**
     * @Lob annotation means:
     * Specifies that a persistent property or field 
     * should be persisted as a large object to a database-supported large object type.
     */

	@Lob
	private String directions;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipie")
	private Set<Ingredient> ingredients = new HashSet<>();
	
    @Lob
    private Byte[] image;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
	@JoinTable(name = "recipie_category", joinColumns = @JoinColumn(name = "recipie_id"), 
		inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();


	public Recipie(String description, Integer prepTime, Integer cookTime, 
			Integer servings, String source, String url, String directions,
			Set<Ingredient> ingredient, Byte[] image,Difficulty difficulty,
			Notes notes, Set<Category> categories){
				this.description = description;
				this.prepTime = prepTime;
				this.cookTime = cookTime;
				this.servings = servings;
				this.source = source;
				this.url = url;
				this.directions = directions;
				this.ingredients = ingredient;
				this.image = image;
				this.difficulty = difficulty;
				this.notes = notes;
				this.categories = categories;

	}
	

	public Recipie() {
		// TODO Auto-generated constructor stub
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
  // Prep Time
	public Integer getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
  // Cook Time
	public Integer getCookTime() {
		return cookTime;
	}
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}
  // Servings
	public Integer getServings() {
		return servings;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}
  // Source
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
  // Url
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
  // Directions	
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
  // Image
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
  // Difficulty
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
  // Notes
	public Notes getNotes() {
		return notes;
	}
	public void setNotes(Notes notes) {
		this.notes = notes;
	}
  // Categories
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
  // Ingredients
	public Recipie addIngredient(Ingredient ingredient){
		ingredient.setRecipie(this);
		this.ingredients.add(ingredient);
		return this;
	}
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredient) {
		this.ingredients = ingredient;
	}

}
