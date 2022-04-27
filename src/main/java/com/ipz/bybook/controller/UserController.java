package com.ipz.bybook.controller;

import com.ipz.bybook.dto.CreateUserForm;
import com.ipz.bybook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String create(){
        return "user/new";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id) {
        userService.findById(id);
    @GetMapping("{id}")
    public String findById(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", userService.findById(user.getId()));
        return "user/user";
    }

    @PostMapping("/register")
    public String create(CreateUserForm createUserForm, Model model) {
        try{
            userService.create(createUserForm);
        } catch (RuntimeException exception) {
            model.addAttribute("userCannotBeCreated", "Щось пішло не так!");
            return "user/new";
        }
        return "redirect:/login";
    }

}
