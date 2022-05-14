package com.ipz.bybook.controller.admin;

import com.ipz.bybook.domain.User;
import com.ipz.bybook.dto.CreateDiscountForm;
import com.ipz.bybook.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/discounts")
public class DiscountAdminController {

    private final DiscountService discountService;

    @Autowired
    public DiscountAdminController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public String findAll(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("discounts", discountService.findAll());
        return "discount/discounts";
    }

    @GetMapping("/new")
    public String newDiscount(@AuthenticationPrincipal User user) {
        return "discount/new";
    }

    @PostMapping("/new")
    public String saveDiscount(CreateDiscountForm createDiscountForm, @AuthenticationPrincipal User user, Model model) {
        try {
            discountService.create(createDiscountForm);
        } catch (RuntimeException exception) {
            model.addAttribute("discountCannotBeCreated", "Щось пішло не так!");
            return "/discount/new";
        }
        return "redirect:/admin/discounts";
    }

    @GetMapping("/{id}/edit")
    public String editDiscount(@PathVariable Long id, @AuthenticationPrincipal User user, Model model) {
        model.addAttribute("discount", discountService.findById(id));
        return "discount/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateDiscount(@PathVariable Long id, CreateDiscountForm createDiscountForm,
                                 @AuthenticationPrincipal User user, Model model) {
        try {
            discountService.update(id, createDiscountForm);
        } catch (RuntimeException exception) {
            model.addAttribute("discountCannotBeUpdated", "Щось пішло не так!");
            model.addAttribute("discount", discountService.findById(id));
            return "/discount/edit";
        }
        return "redirect:/admin/discounts";
    }

    @PostMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id, @AuthenticationPrincipal User user, Model model) {
        String result = discountService.deleteById(id);
        if ("Успішно видалено!".equals(result)) {
            model.addAttribute("messageSuccess", result);
        } else {
            model.addAttribute("messageError", result);
        }
        return "redirect:/admin/discounts";
    }

}
