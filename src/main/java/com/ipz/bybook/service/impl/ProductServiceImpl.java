package com.ipz.bybook.service.impl;

import com.ipz.bybook.domain.Product;
import com.ipz.bybook.domain.User;
import com.ipz.bybook.dto.CreateProductForm;
import com.ipz.bybook.repository.ProductRepository;
import com.ipz.bybook.repository.UserRepository;
import com.ipz.bybook.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(CreateProductForm createProductForm) {
        Product product = Product.builder()
                .name(createProductForm.getName())
                .authorName(createProductForm.getAuthorName())
                .description(createProductForm.getDescription())
                .price(createProductForm.getPrice())
                .imageUrl(createProductForm.getImageUrl())
                //.isAvailable(createProductForm.isAvailable())
                .isAvailable(true)
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product update(CreateProductForm createProductForm, Long id) {
        Product productFromDB = findProductByIdOrThrowException(id);
        Product updatedProduct = productFromDB.toBuilder()
                .name(createProductForm.getName())
                .authorName(createProductForm.getAuthorName())
                .description(createProductForm.getDescription())
                .price(createProductForm.getPrice())
                .imageUrl(createProductForm.getImageUrl())
                //.isAvailable(createProductForm.isAvailable())
                .build();
        return productRepository.save(updatedProduct);
    }

    @Override
    public Product findById(Long id) {
        return findProductByIdOrThrowException(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    private Product findProductByIdOrThrowException(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
    }

}
