package com.ipz.bybook.controller.admin;

import com.ipz.bybook.domain.User;
import com.ipz.bybook.dto.CreateCategoryForm;
import com.ipz.bybook.dto.CreateDiscountForm;
import com.ipz.bybook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/categories")
public class CategoryAdminController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryAdminController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String findAll(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/categories";
    }

    @GetMapping("/new")
    public String newCategory(@AuthenticationPrincipal User user) {
        return "category/new";
    }

    @PostMapping("/new")
    public String saveCategory(CreateCategoryForm createCategoryForm, @AuthenticationPrincipal User user, Model model) {
        try {
            categoryService.create(createCategoryForm);
        } catch (RuntimeException exception) {
            model.addAttribute("categoryCannotBeCreated", "Щось пішло не так!");
            return "/category/new";
        }
        return "redirect:/admin/categories";
    }

    @GetMapping("/{id}/edit")
    public String editDiscount(@PathVariable Long id, @AuthenticationPrincipal User user, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateDiscount(@PathVariable Long id, CreateCategoryForm createCategoryForm,
                                 @AuthenticationPrincipal User user, Model model) {
        try {
            categoryService.update(id, createCategoryForm);
        } catch (RuntimeException exception) {
            model.addAttribute("categoryCannotBeUpdated", "Щось пішло не так!");
            model.addAttribute("category", categoryService.findById(id));
            return "/category/edit";
        }
        return "redirect:/admin/categories";
    }

    @PostMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id, @AuthenticationPrincipal User user, Model model) {
        categoryService.deleteById(id);
        return "redirect:/admin/categories";
    }

}
