package com.c0720g1.manhcuong.controller;

import com.c0720g1.manhcuong.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("employee",new Employee());
        return "create_employee";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee,Model model){
        model.addAttribute("employee",employee);
        return "employeeInfo";
    }
}
