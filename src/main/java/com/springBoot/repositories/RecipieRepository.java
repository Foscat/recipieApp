package com.springBoot.repositories;


import org.springframework.data.repository.CrudRepository;

import com.springBoot.domain.Recipie;

public interface RecipieRepository extends CrudRepository<Recipie, Long> {
}
