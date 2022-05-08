package com.ipz.bybook.service;

import com.ipz.bybook.domain.Product;
import com.ipz.bybook.dto.CreateProductForm;

import java.util.List;

public interface ProductService {

    Product create(CreateProductForm createProductForm);

    Product update(CreateProductForm createProductForm, Long id);

    Product findById(Long id);

    List<Product> findAll();

}
