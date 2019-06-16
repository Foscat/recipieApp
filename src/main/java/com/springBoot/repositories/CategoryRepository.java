package com.springBoot.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

	Optional<Category> findByDescription(String description);
//    Optional<Category> findByDescription(String description);
}
