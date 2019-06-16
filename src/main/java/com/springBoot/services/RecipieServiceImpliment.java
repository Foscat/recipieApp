package com.springBoot.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.springBoot.repositories.RecipieRepository;

import org.springframework.stereotype.Service;
import com.springBoot.domain.Recipie;


@Service
public class RecipieServiceImpliment implements RecipieService {

    private final RecipieRepository recipieRepository;

    public RecipieServiceImpliment(RecipieRepository recipieRepository){
        this.recipieRepository = recipieRepository;
    }

    @Override
    public Set<Recipie> getRecipies(){

        Set<Recipie> recipieSet = new HashSet<>();

        recipieRepository.findAll().iterator().forEachRemaining(recipieSet::add);

        return recipieSet;
    }
    
    @Override
    public Recipie findById(Long id) {
    	
        Optional<Recipie> recipieOptional = recipieRepository.findById(id);
        
        if (!recipieOptional.isPresent()) {

            throw new RuntimeException("Recipie not found");
            
        }

        return recipieOptional.get();

    }

	@Override
	public void deleteById(Long idToDelete) {
        
        recipieRepository.deleteById(idToDelete);
		
	}


}
