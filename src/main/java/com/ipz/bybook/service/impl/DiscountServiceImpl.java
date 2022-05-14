package com.ipz.bybook.service.impl;

import com.ipz.bybook.domain.Discount;
import com.ipz.bybook.domain.Product;
import com.ipz.bybook.dto.CreateDiscountForm;
import com.ipz.bybook.repository.DiscountRepository;
import com.ipz.bybook.repository.ProductRepository;
import com.ipz.bybook.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    private final ProductRepository productRepository;

    @Autowired
    public DiscountServiceImpl(DiscountRepository discountRepository, ProductRepository productRepository) {
        this.discountRepository = discountRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Discount create(CreateDiscountForm createDiscountForm) {
        Discount discount = Discount.builder()
                .name(createDiscountForm.getName())
                .percentOfDiscount(createDiscountForm.getPercentOfDiscount())
                .build();

        return discountRepository.save(discount);
    }

    @Override
    public Discount update(Long id, CreateDiscountForm createDiscountForm) {
        Discount discountFromDb = findDiscountByIdOrThrowException(id);

        Discount updatedDiscount = discountFromDb.toBuilder()
                .name(createDiscountForm.getName())
                .percentOfDiscount(createDiscountForm.getPercentOfDiscount())
                .build();

        Discount savedDiscount = discountRepository.save(updatedDiscount);

        List<Product> products = productRepository.findAllByDiscountId(savedDiscount.getId());

        if (!products.isEmpty()) {
            List<Product> updatedProducts = products.stream().map(product ->
                 product = product.toBuilder()
                        .priceWithDiscount((product.getPrice() * (100 - savedDiscount.getPercentOfDiscount())) / 100)
                        .build()
            ).collect(Collectors.toList());
            productRepository.saveAll(updatedProducts);
        }
        return savedDiscount;
    }

    @Override
    public Discount findById(Long id) {
        return findDiscountByIdOrThrowException(id);
    }

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        if (productRepository.existsByDiscountId(id)) {
            return "Не можливо видалити знижку, що використовується!";
        }
        discountRepository.deleteById(findDiscountByIdOrThrowException(id).getId());
        return "Успішно видалено!";
    }

    private Discount findDiscountByIdOrThrowException(Long id) {
        return discountRepository.findById(id).orElseThrow(() -> new RuntimeException("Discount not found!"));
    }

}
