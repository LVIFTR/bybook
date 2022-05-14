package com.ipz.bybook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductForm {

    private String name;

    private String authorName;

    private String imageUrl;

    private String description;

    private long discountId;

    private double price;

    private boolean isAvailable;

    List<Long> categoriesIds;

}
