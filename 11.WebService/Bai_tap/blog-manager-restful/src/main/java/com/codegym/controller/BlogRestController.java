package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Blog> getDetailStudent(@PathVariable int id) {
        Blog blog = this.blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id,@RequestBody Blog blog) {
        Blog currentBlog = this.blogService.findById(id);

        if (currentBlog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        

        currentBlog.setTitleBlog(blog.getTitleBlog());
        currentBlog.setWriteDate(blog.getWriteDate());
        currentBlog.setContent(blog.getContent());
        currentBlog.setAuthor(blog.getAuthor());
        currentBlog.setCategory(blog.getCategory());
        System.out.println(currentBlog);
        this.blogService.save(currentBlog);
        return new ResponseEntity<>(currentBlog, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable Integer id){
        Blog blog=this.blogService.findById(id);
            if (blog == null) {
                System.out.println("Blog with id " + id + " not found");
                return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
            }
        this.blogService.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
