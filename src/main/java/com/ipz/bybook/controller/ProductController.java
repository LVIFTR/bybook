package com.ipz.bybook.controller;

import com.ipz.bybook.domain.User;
import com.ipz.bybook.dto.CreateProductForm;
import com.ipz.bybook.service.CategoryService;
import com.ipz.bybook.service.DiscountService;
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

    private final DiscountService discountService;

    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService,
                             DiscountService discountService,
                             CategoryService categoryService
    ) {
        this.productService = productService;
        this.discountService = discountService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getAll(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("products", productService.findAll());
        return "products/products";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("usedCategories", categoryService.findAllUsedForProductByProductId(id));
        return "products/product";
    }

    @GetMapping("/new")
    public String newProduct(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("discounts", discountService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "products/new";
    }

    @PostMapping("/new")
    public String saveProduct(CreateProductForm createProductForm, @AuthenticationPrincipal User user, Model model) {
        try {
            productService.create(createProductForm);
        } catch (RuntimeException exception) {
            model.addAttribute("productCannotBeCreated", "Щось пішло не так!");
            model.addAttribute("discounts", discountService.findAll());
            return "products/new";
        }
        return "redirect:/products";
    }

    @GetMapping("/{id}/update")
    public String editProduct(@PathVariable Long id, @AuthenticationPrincipal User user, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("discounts", discountService.findAll());
        model.addAttribute("notUsedCategories", categoryService.findAllNotUsedForProductByProductId(id));
        model.addAttribute("usedCategories", categoryService.findAllUsedForProductByProductId(id));
        return "products/edit";
    }

    @PostMapping("/{id}/update")
    public String updateProduct(@PathVariable Long id, CreateProductForm createProductForm,
                                @AuthenticationPrincipal User user, Model model) {
        try {
            productService.update(createProductForm, id);
        } catch (RuntimeException exception) {
            model.addAttribute("productCannotBeUpdated", "Щось пішло не так!");
            model.addAttribute("product", productService.findById(id));
            return "products/edit";
        }
        return "redirect:/products/" + id;
    }


}
