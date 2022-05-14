package com.ipz.bybook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDiscountForm {

    private String name;

    private double percentOfDiscount;

}
