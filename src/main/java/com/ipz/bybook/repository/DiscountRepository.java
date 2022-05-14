package com.ipz.bybook.repository;

import com.ipz.bybook.domain.Discount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DiscountRepository extends CrudRepository<Discount, Long> {

    Optional<Discount> findById(long id);

    List<Discount> findAll();

}
