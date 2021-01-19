package com.codegym.controller;

import com.codegym.entity.Province;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/province")
@Controller
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;

    @GetMapping("")
    public String listProvince(Model model) {
        model.addAttribute("provinceList", this.provinceService.findAll());
        return "listProvince";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("province", new Province());
        return "createProvince";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Province province) {
        this.provinceService.save(province);
        return "redirect:/province/";
    }

    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("province", this.provinceService.findById(id));
        return "editProvince";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        this.provinceService.remove(id);
        return "redirect:/province/";
    }
}
