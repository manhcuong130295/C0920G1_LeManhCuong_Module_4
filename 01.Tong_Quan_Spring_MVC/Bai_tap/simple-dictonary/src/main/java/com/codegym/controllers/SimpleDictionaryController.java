package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codegym.services.SimpleDictionary;
import com.codegym.services.SimpleDictionaryImpl;

@Controller
public class SimpleDictionaryController {
    private SimpleDictionary dictionaryService = new SimpleDictionaryImpl();

    @GetMapping("")
    public String formSearch() {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam String searchWord, Model model) {
        String result=dictionaryService.search(searchWord);
        model.addAttribute("searchWord",searchWord);
        model.addAttribute("result",result);
        return "result";
    }
}
