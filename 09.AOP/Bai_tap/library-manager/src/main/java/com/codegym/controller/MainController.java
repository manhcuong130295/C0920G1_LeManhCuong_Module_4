package com.codegym.controller;

import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private BookService bookService;
    @GetMapping("")
    public String homePage(Model model){
        model.addAttribute("listBook",bookService.findAll());
        return "index";
    }
}
