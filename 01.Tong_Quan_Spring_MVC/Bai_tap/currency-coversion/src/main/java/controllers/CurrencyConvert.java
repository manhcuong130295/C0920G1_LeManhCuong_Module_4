package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ConvertService;

@Controller
public class CurrencyConvert {
    @Autowired
    ConvertService convertService;

    @GetMapping("/")
    public String getForm(){
        return "form";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam String usd, Model model){
        model.addAttribute("result",this.convertService.convertUsdToVnd(Double.parseDouble(usd)));
        return "result";
    }
}
