package com.codegym.controller;

import com.codegym.entity.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("userObj", new User());
        return "create";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid @ModelAttribute(name = "userObj") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        this.userService.save(user);
        return "detail";
    }
}
