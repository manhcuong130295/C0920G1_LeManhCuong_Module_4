package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api-blog")
public class BlogRestController {
    @Autowired
    BlogService blogService;

    @GetMapping("/list")
    public ResponseEntity<List<Blog>> listBlog() {
        List<Blog> blogList = this.blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerStudent(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        this.blogService.save(blog);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api-blog/detail/{id}").buildAndExpand(blog.getIdBlog()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> getDetailStudent(@PathVariable Integer id) {
        Blog blog = this.blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id) {
        Blog blog = this.blogService.findById(id);

        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        blog.setTitleBlog(blog.getTitleBlog());
        blog.setWriteDate(blog.getWriteDate());
        blog.setContent(blog.getContent());
        blog.setAuthor(blog.getAuthor());
        blog.setCategory(blog.getCategory());
        this.blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable int id) {
        Blog blog = this.blogService.findById(id);
        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        this.blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/blog-search")
    public ResponseEntity<Page<Blog>> searchByName(@PageableDefault(value = 3) Pageable pageable, @RequestParam String keyword) {
        List<Blog> blogList = this.blogService.findAllByTitleBlogContaining(keyword, pageable).toList();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<>(HttpStatus.OK);
    }

}
