package com.ipz.bybook.service;

import com.ipz.bybook.domain.Discount;
import com.ipz.bybook.dto.CreateDiscountForm;

import java.util.List;

public interface DiscountService {

    Discount create(CreateDiscountForm createDiscountForm);

    Discount update(Long id, CreateDiscountForm createDiscountForm);

    Discount findById(Long id);

    List<Discount> findAll();

    String deleteById(Long id);
}
