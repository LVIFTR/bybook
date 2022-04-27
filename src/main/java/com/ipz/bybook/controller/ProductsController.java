package com.ipz.bybook.controller;

import com.ipz.bybook.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @GetMapping
    public String getAll(@AuthenticationPrincipal User user){
        return "products/products";
    }

}
