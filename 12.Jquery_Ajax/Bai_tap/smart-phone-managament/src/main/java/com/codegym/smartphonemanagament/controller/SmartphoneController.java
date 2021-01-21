package com.codegym.smartphonemanagament.controller;

import com.codegym.smartphonemanagament.entity.Smartphone;
import com.codegym.smartphonemanagament.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/smartphone")
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;

    @GetMapping("/create")
    public ModelAndView createSmartphonePage() {
        ModelAndView mav = new ModelAndView("phones/new-phone");
        mav.addObject("sPhone", new Smartphone());
        return mav;
    }

    @RequestMapping(value = "/createnewPhone", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void createSmartphone(@RequestBody Smartphone smartphone) {
        smartphoneService.save(smartphone);
    }
}
