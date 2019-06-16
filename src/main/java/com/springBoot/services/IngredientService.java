package com.springBoot.services;

import com.springBoot.domain.Ingredient;

public interface IngredientService {

	// Ingredient findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

	void deleteById(Long recipieId, Long idToDelete);
}
