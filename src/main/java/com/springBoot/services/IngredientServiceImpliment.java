package com.springBoot.services;

import java.util.Optional;

import com.springBoot.domain.Ingredient;
import com.springBoot.domain.Recipie;
import com.springBoot.repositories.RecipieRepository;
import com.springBoot.repositories.UnitOfMeasureRepository;

import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpliment implements IngredientService {

    private final RecipieRepository recipieRepository;

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IngredientServiceImpliment(RecipieRepository recipieRepository, UnitOfMeasureRepository unitOfMeasureRepository){
        this.recipieRepository = recipieRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

	@Override
	public void deleteById(Long recipeId, Long idToDelete) {

        System.out.println("Deleting ingrediant with id of " + recipeId);
		
        Optional<Recipie> recipieOptional = recipieRepository.findById(recipeId);
        
        if(recipieOptional.isPresent()){
            Recipie recipie = recipieOptional.get();

            System.out.println("Found ricepie");

            Optional<Ingredient> ingredientOptional = recipie
                .getIngredients().stream()
                .filter(ingredient -> ingredient.getId()
                .equals(idToDelete))
                .findFirst();

            if(ingredientOptional.isPresent()){
                System.out.println("found ingrediant");

                Ingredient ingredientToDelete = ingredientOptional.get();
                ingredientToDelete.setRecipie(null);
                recipie.getIngredients().remove(ingredientOptional.get());
                recipieRepository.save(recipie);

            }
        }else {
            System.out.println("Recipie id not found " + recipeId);
        }

		
	}

	// @Override
	// public Ingredient findByRecipeIdAndIngredientId(Long recipieId, Long ingredientId) {

    //     Optional<Recipie> recipieOptional = recipieRepository.findById(recipieId);
        
    //     if(!recipieOptional.isPresent()){
    //         System.out.println("Recipie with id of " + recipieId + " not found.");
    //     }

    //     Recipie recipie = recipieOptional.get();

    //     Optional<Ingredient> ingrediantOptional = recipie.getIngredients().stream()
    //         .filter(ingrediant -> ingrediant.getId().equals(ingredientId))
    //         .map( ingrediant -> in)

	// 	// return null;
	// }


}
