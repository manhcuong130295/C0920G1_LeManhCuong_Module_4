package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @Autowired
    BlogService blogService;

    @GetMapping
    public String listCustomer(Model model, @PageableDefault(size = 5) Pageable pageable,
                               @RequestParam Optional<String> keyword) {
        String keyWordAfterSearch="";

        if (!keyword.isPresent()) {
            model.addAttribute("blogList", this.blogService.findAll(pageable));
        } else {
            keyWordAfterSearch = keyword.get();
            model.addAttribute("blogList", this.blogService.findAllByTitleBlogContaining(keyWordAfterSearch, pageable));
        }

        model.addAttribute("keywordAfterCheck", keyWordAfterSearch);
        return "list";
    }
    @GetMapping("/sort")
    public String sort(Model model, @PageableDefault(size = 3) Pageable pageable){
        model.addAttribute("blogList",blogService.findAllAndOrderByWriteDate(pageable));
        return "list";
    }
    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/save")
    public String createNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        this.blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable int id, Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "edit";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        this.blogService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("blogDetail",this.blogService.findById(id));
        return "detail";
    }
    @GetMapping("/{id}/category/search")
    public String categorySearch(@PathVariable int id, @PageableDefault(size = 5) Pageable pageable, Model model){
        model.addAttribute("blogList",this.blogService.findAllByCategory_Id(id,pageable));
        return "list";
    }

}
