package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String listProduct(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("success", "Add product successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirect) {
        productService.update(product);
        redirect.addFlashAttribute("success", "Edit product successfully!");
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id,RedirectAttributes redirect,Product product){
        product=productService.findById(id);
        productService.remove(product);
        redirect.addFlashAttribute("success", "Deleted!");
        return  "redirect:/";
    }
    @GetMapping("/{id}/detail")
    public String detailProduct(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "detail";
    }
}

