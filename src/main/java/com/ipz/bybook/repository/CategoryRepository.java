package com.ipz.bybook.repository;

import com.ipz.bybook.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findById(Long id);

    List<Category> findAll();

}
