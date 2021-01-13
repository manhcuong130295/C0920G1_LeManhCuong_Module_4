package com.codegym.controller;

import com.codegym.entity.PhoneNumber;
import com.codegym.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneNumberController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("")
    public String create(Model model) {
        model.addAttribute("phoneNumObj", new PhoneNumber());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute(name = "phoneNumObj") PhoneNumber phoneNumber, BindingResult bindingResult, Model model) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";

        }
//        model.addAttribute("phoneNum", phoneService.findAll());
//        model.addAttribute("phone", phoneNumber);
        this.phoneService.save(phoneNumber);

        return "create";


    }
}
