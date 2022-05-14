package com.ipz.bybook.service;

import com.ipz.bybook.domain.Category;
import com.ipz.bybook.dto.CreateCategoryForm;

import java.util.List;

public interface CategoryService {

    Category create(CreateCategoryForm createCategoryForm);

    Category update(Long id, CreateCategoryForm createCategoryForm);

    Category findById(Long id);

    List<Category> findAll();

    List<Category> findAllUsedForProductByProductId(Long id);

    List<Category> findAllNotUsedForProductByProductId(Long id);

    void deleteById(Long id);
}
