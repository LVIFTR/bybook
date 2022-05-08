package com.ipz.bybook.controller;

import com.ipz.bybook.domain.User;
import com.ipz.bybook.dto.CreateProductForm;
import com.ipz.bybook.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAll(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("products", productService.findAll());
        return "products/products";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("product", productService.findById(id));
        return "products/product";
    }

    @GetMapping("/new")
    public String newProduct(@AuthenticationPrincipal User user) {
        return "products/new";
    }

    @PostMapping("/new")
    public String saveProduct(CreateProductForm createProductForm, @AuthenticationPrincipal User user, Model model) {
        try {
            productService.create(createProductForm);
        } catch (RuntimeException exception) {
            model.addAttribute("productCannotBeCreated", "Щось пішло не так!");
            return "products/new";
        }
        return "redirect:/products";
    }

}
