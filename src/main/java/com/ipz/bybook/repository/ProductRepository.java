package com.ipz.bybook.repository;

import com.ipz.bybook.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    boolean existsByDiscountId(Long id);

    List<Product> findAllByDiscountId(Long id);

}
