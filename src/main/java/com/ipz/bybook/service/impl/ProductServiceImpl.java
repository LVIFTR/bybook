package com.ipz.bybook.service.impl;

import com.ipz.bybook.domain.Discount;
import com.ipz.bybook.domain.Product;
import com.ipz.bybook.dto.CreateProductForm;
import com.ipz.bybook.repository.DiscountRepository;
import com.ipz.bybook.repository.ProductRepository;
import com.ipz.bybook.service.DiscountService;
import com.ipz.bybook.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final DiscountRepository discountRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, DiscountRepository discountRepository) {
        this.productRepository = productRepository;
        this.discountRepository = discountRepository;
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
                .categoriesIds(createProductForm.getCategoriesIds())
                .isAvailable(true)
                .build();

        Optional<Discount> discount = discountRepository.findById(createProductForm.getDiscountId());

        if (discount.isPresent()) {
            Discount dsc = discount.get();
            double newPrice = (createProductForm.getPrice() * (100 - dsc.getPercentOfDiscount())) / 100;
            product = product.toBuilder()
                    .priceWithDiscount(newPrice)
                    .discountId(dsc.getId())
                    .build();
        }

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
                .discountId(createProductForm.getDiscountId())
                .categoriesIds(createProductForm.getCategoriesIds())
                .build();

        Optional<Discount> discount = discountRepository.findById(createProductForm.getDiscountId());

        if (discount.isPresent()) {
            Discount dsc = discount.get();
            double newPrice = (createProductForm.getPrice() * (100 - dsc.getPercentOfDiscount())) / 100;
            updatedProduct = updatedProduct.toBuilder()
                    .priceWithDiscount(newPrice)
                    .discountId(dsc.getId())
                    .build();
        } else {
            updatedProduct = updatedProduct.toBuilder()
                    .priceWithDiscount(0)
                    .discountId(0)
                    .build();
        }

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
