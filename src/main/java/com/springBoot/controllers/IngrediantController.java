package com.springBoot.controllers;

import com.springBoot.services.IngredientService;
import com.springBoot.services.RecipieService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IngrediantController {

    private final IngredientService ingredientService;
    private final RecipieService recipieService;

    public IngrediantController(IngredientService ingredientService, RecipieService recipieService) {
        this.ingredientService = ingredientService;
        this.recipieService = recipieService;
        
    }

    @GetMapping("/recipie/{recipieId}/ingrediants")
    public String listIngrediants(@PathVariable String recipieId, Model model) {

        model.addAttribute("recipie", recipieService.findById(Long.valueOf(recipieId)));

        return "recipie/{recipieId}/ingrediants";
        
    }

    // @GetMapping("recipie/{recipieId}/ingredinet/{id}/show")
    // public String showRecipieIngrediant(@PathVariable String recipieId, @PathVariable String id, Model model){
    //     model.addAttribute("ingredient", "ingredientService.");
    // }

}
