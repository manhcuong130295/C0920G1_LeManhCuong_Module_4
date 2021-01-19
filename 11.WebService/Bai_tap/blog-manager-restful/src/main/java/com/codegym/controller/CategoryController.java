package com.codegym.controller;

import com.codegym.entity.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/category")
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping(" ")
    public String listCategory(Model model){
        model.addAttribute("categoryList",this.categoryService.findAll());
        return "listCategory";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("category",new Category());
        return "createCategory";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Category category){
        this.categoryService.save(category);
        return "redirect:/category/ ";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("category",this.categoryService.findById(id));
        return "editCategory";
    }
    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable int id){
        this.categoryService.remove(id);
        return "redirect:/category/ ";
    }
}
