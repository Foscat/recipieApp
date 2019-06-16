package com.springBoot.bootstrap;

import com.springBoot.domain.Category;
import com.springBoot.domain.Difficulty;
import com.springBoot.domain.Ingredient;
import com.springBoot.domain.Notes;
import com.springBoot.domain.Recipie;
import com.springBoot.domain.UnitOfMeasure;
import com.springBoot.repositories.CategoryRepository;
import com.springBoot.repositories.RecipieRepository;
import com.springBoot.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
    private final CategoryRepository categoryRepository;
    
    @Autowired
    private final RecipieRepository recipieRepository;
    
    @Autowired
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipieRepository recipieRepository, UnitOfMeasureRepository unitOfMeasureRepository){
        this.categoryRepository = categoryRepository;
        this.recipieRepository = recipieRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        recipieRepository.saveAll(getRecipies());
    }

    private List<Recipie> getRecipies(){
    	
        List<Recipie> recipies = new ArrayList<>(2);
        
        // Establish units of measurement

        // Each
        Optional<UnitOfMeasure> eachUOMOption = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUOMOption.isPresent()){
            throw new RuntimeException("Expected Unit of measurement not found");
        }

        // Tablespoon
        Optional<UnitOfMeasure> tableSpoonUOMOption = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUOMOption.isPresent()){
            throw new RuntimeException("Expected Unit of measurement not found");
        }

        // Teaspoon
        Optional<UnitOfMeasure> teaSpoonUOMOption = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonUOMOption.isPresent()){
            throw new RuntimeException("Expected Unit of measurement not found");
        }

        // Dash
        Optional<UnitOfMeasure> dashUOMOption = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUOMOption.isPresent()){
            throw new RuntimeException("Expected Unit of measurement not found");
        }
        
        // Pint
        Optional<UnitOfMeasure> pintUOMOption = unitOfMeasureRepository.findByDescription("Pint");

        if(!pintUOMOption.isPresent()){
            throw new RuntimeException("Expected Unit of measurement not found");
        }

        // Cup
        Optional<UnitOfMeasure> cupUOMOption = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupUOMOption.isPresent()){
            throw new RuntimeException("Expected Unit of measurement not found");
        }

        // Get optionals
        UnitOfMeasure eachUNM = eachUOMOption.get();
        UnitOfMeasure tableUNM = tableSpoonUOMOption.get();
        UnitOfMeasure teaUNM = teaSpoonUOMOption.get();
        UnitOfMeasure dashUNM = dashUOMOption.get();
        UnitOfMeasure pintUNM = pintUOMOption.get();
        UnitOfMeasure cupUNM = cupUOMOption.get();

        // Establish Categories
        Optional<Category> americanCategoryOption = categoryRepository.findByDescription("American");

        if(!americanCategoryOption.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> mexicanCategoryOption = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOption.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        // Get Categories
        Category americanCategory = americanCategoryOption.get();
        Category mexicanCategory = mexicanCategoryOption.get();

        // County Spread
        Recipie spreadRecipie = new Recipie();
        spreadRecipie.setDescription("Assortment of commissary items blended together for a glorious meal.");
        spreadRecipie.setPrepTime(5);
        spreadRecipie.setCookTime(4);
        spreadRecipie.setServings(1);
        spreadRecipie.setDifficulty(Difficulty.EASY);
        spreadRecipie.setDirections(
            "1 Get favorite flavor of Ramen Noodles. Remove from pack and place in sealable bowl. \n" +
            "2 Boil water and pour over noodles (be sure to cover noodles compleatly with water) and cover with lid. Leave alone for 4 minuites. \n" +
            "3 Get beef and cheese stick and cut each stick into pieces and put off to side. \n" +
            "4 Get doritos and break into pieces and put off to side as well. \n" +
            "5 Once noodle cook time has been met drain excess water. \n" + 
            "6 Add crushed doritos, cut up beef and cheese stick, and flavor packet to noodles. \n" + 
            "7 Mix well and add hot sauce if desired \n" +
            "8 Enjoy the food and freedom!"
        );
        Notes spreadNotes = new Notes();
        spreadNotes.setRecipieNotes(
            "For use in instutions or for the broke chef. All ingrediants can be aquired at a gas station. \n" +
            "This is a cuisine enjoyed by inmates all across the country every day. \n" + 
            "Can be made in a trash bag if no bowl is on hand."
        );
        spreadRecipie.setNotes(spreadNotes);

        
       spreadRecipie.addIngredient(new Ingredient("Ramen Noodles", new BigDecimal(1), eachUNM));
       spreadRecipie.addIngredient(new Ingredient("Beef & Cheese Stick", new BigDecimal(1), eachUNM));
       spreadRecipie.addIngredient(new Ingredient("Crushed Doritos", new BigDecimal(3), tableUNM));
       spreadRecipie.addIngredient(new Ingredient("Hot Sauce", new BigDecimal(2), dashUNM));
       spreadRecipie.getCategories().add(americanCategory);

        recipies.add(spreadRecipie);

        // Nachos
        Recipie nachoRecipie = new Recipie();
        nachoRecipie.setDescription("Simple food for simple fun.");
        nachoRecipie.setPrepTime(5);
        nachoRecipie.setCookTime(2);
        nachoRecipie.setServings(3);
        nachoRecipie.setDifficulty(Difficulty.MODERATE);
        nachoRecipie.setDirections(
            "1 Get corn chips and place on plate or tray. \n" +
            "2 Spread chips evenly over plate/tray \n" +
            "3 Sprinkle libral amount of grated cheese over chips. \n" +
            "4 For microwave cook for 45 seconds to 75 seconds depenging on volume of cheese. \n" +
            "5 Let it stand and cool for 1 minuite \n" + 
            "6 Turn on jerry springer and enjoy!"
        );
        Notes nachoNotes = new Notes();
        nachoNotes.setRecipieNotes(
            "For use in instutions or for the broke chef. All ingrediants can be aquired at a gas station. \n" +
            "This is a cuisine enjoyed by gamers and kids stuck at home everyday! \n" + 
            "Can be made a toster oven as well."
        );
        nachoRecipie.setNotes(nachoNotes);

        
       nachoRecipie.addIngredient(new Ingredient("Corn Chips", new BigDecimal(55), eachUNM));
       nachoRecipie.addIngredient(new Ingredient("Grated Cheese", new BigDecimal(1), cupUNM));
       nachoRecipie.getCategories().add(mexicanCategory);

        recipies.add(nachoRecipie);
        


        return recipies;
    }

}
