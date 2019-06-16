package com.springBoot.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.springBoot.domain.Recipie;
import com.springBoot.repositories.RecipieRepository;
import com.springBoot.services.RecipieServiceImpliment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RecipeServiceTest {

    RecipieServiceImpliment recipieServiceImpliment;

    @Mock
    RecipieRepository recipieRepository;

    @Before
    public void setUpTest() throws Exception {

        MockitoAnnotations.initMocks(this);

        recipieServiceImpliment = new RecipieServiceImpliment(recipieRepository);
        
    }

    @Test
    public void getRecipeByIdTest() {
        
        Recipie recipie = new Recipie();

        recipie.setId(1L);

        Optional<Recipie> recipieOptional = Optional.of(recipie);

        when(recipieRepository.findById(anyLong())).thenReturn(recipieOptional);

        // Recipie recipieReturned = recipieServiceImpliment.

        
    }

    @Test
    public void getRecipiesTest() throws Exception {

        Recipie recipie = new Recipie();
        HashSet recipiesData = new HashSet<>();
        recipiesData.add(recipie);

        when(recipieRepository.findAll()).thenReturn(recipiesData);

        Set<Recipie> recipies = recipieServiceImpliment.getRecipies();

        assertEquals(recipies.size(), 1);
        verify(recipieRepository, times(1)).findAll();
        
    }

}
