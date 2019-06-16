package com.springBoot.services;

import java.util.Set;

import com.springBoot.domain.Recipie;

public interface RecipieService {

    Set<Recipie> getRecipies();

    Recipie findById(Long id);
    
    void deleteById(Long idToDelete);
}
