package com.ipz.bybook.service.impl;

import com.ipz.bybook.domain.Category;
import com.ipz.bybook.domain.Product;
import com.ipz.bybook.dto.CreateCategoryForm;
import com.ipz.bybook.repository.CategoryRepository;
import com.ipz.bybook.repository.ProductRepository;
import com.ipz.bybook.service.CategoryService;
import com.ipz.bybook.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ProductService productService;

    private final ProductRepository productRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductService productService, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public Category create(CreateCategoryForm createCategoryForm) {
        return categoryRepository.save(Category.builder()
                .name(createCategoryForm.getName())
                .build()
        );
    }

    @Override
    public Category update(Long id, CreateCategoryForm createCategoryForm) {
        Category categoryFromDb = findCategoryByIdOrThrowException(id);
        Category updatedCategory = categoryFromDb.toBuilder()
                .name(createCategoryForm.getName())
                .build();
        return categoryRepository.save(updatedCategory);
    }

    @Override
    public Category findById(Long id) {
        return findCategoryByIdOrThrowException(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllUsedForProductByProductId(Long productId) {
        Product product = productService.findById(productId);
        return categoryRepository.findAll().stream().filter(category -> product.getCategoriesIds().contains(category.getId())).collect(Collectors.toList());
    }

    @Override
    public List<Category> findAllNotUsedForProductByProductId(Long productId) {
        Product product = productService.findById(productId);
        return categoryRepository.findAll().stream().filter(category -> !product.getCategoriesIds().contains(category.getId())).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        Category category = findCategoryByIdOrThrowException(id);
        categoryRepository.deleteById(category.getId());
    }

    private Category findCategoryByIdOrThrowException(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));
    }


}
