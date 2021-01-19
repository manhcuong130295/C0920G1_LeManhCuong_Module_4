package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = "productList")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("productList")
    public List<Product> cart() {
        return new ArrayList<>();
    }

    @GetMapping("")
    public String listProduct(Model model) {
        model.addAttribute("products", this.productService.findAll());
        return "list-product";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create-product";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product) {
        this.productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "detail-product";
    }

    @GetMapping("/cart/{id}")
    public String cart(@PathVariable int id, @SessionAttribute List<Product> productList,
                       HttpServletResponse response, @CookieValue(defaultValue = "") String cookieCartAbc) {

        if (cookieCartAbc.equals("")) {
            Cookie cookie = new Cookie("cookieCartAbc",String.valueOf(id));
            response.addCookie(cookie);

        }else {
            cookieCartAbc += "-"+String.valueOf(id);
            Cookie cookie = new Cookie("cookieCart", cookieCartAbc);
            response.addCookie(cookie);
        }
        Product product = this.productService.findById(id);
        int quantityAfterAddToCart = product.getQuantity() - 1;
        product.setQuantity(quantityAfterAddToCart);
        this.productService.save(product);
        int quantity = 0;
        quantity++;
        product.setQuantity(quantity);
        productList.add(product);
        return "cart-list";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id) {
        this.productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String listCart() {
        return "cart-list";
    }

    @GetMapping("/{id}/cart-delete")
    public String deleteProductOutCart(@PathVariable int id, @SessionAttribute List<Product> productList) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/clear-all-cart")
    public String clearAll(@SessionAttribute List<Product> productList) {
        productList.clear();
        return "redirect:/cart";
    }
}
